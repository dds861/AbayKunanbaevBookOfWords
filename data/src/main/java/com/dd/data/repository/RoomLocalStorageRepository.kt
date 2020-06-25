package com.dd.data.repository

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dd.data.BuildConfig
import com.dd.data.db.MakalDatabase
import com.dd.data.db.entities.toDomainModel
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.repository.LocalStorageRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SQLiteException
import net.sqlcipher.database.SupportFactory
import java.io.File
import java.io.IOException

class RoomLocalStorageRepository(
        private val context: Context
) : LocalStorageRepository {
    private val dbSecretKey = BuildConfig.DB_SECRET_KEY
    private val passphrase: ByteArray = SQLiteDatabase.getBytes(dbSecretKey.toCharArray())
    private val factory = SupportFactory(passphrase)
    val db: MakalDatabase by lazy {
        val build = Room.databaseBuilder(
                context.applicationContext,
                MakalDatabase::class.java,
                BuildConfig.DB_NAME)
        build.createFromAsset("database/quotes.db")
//        build.fallbackToDestructiveMigration()
        build.addMigrations(MIGRATION_1_2)
        build.fallbackToDestructiveMigration()
        build.build()
    }
    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    }

    init {
        encrypt(context.applicationContext, BuildConfig.DB_NAME, dbSecretKey)
    }

    @Throws(IOException::class)
    fun encrypt(ctxt: Context, dbName: String?, passphrase: String?) {
        try {
            val originalFile = ctxt.getDatabasePath(dbName)
            if (originalFile.exists()) {
                SQLiteDatabase.loadLibs(context)
                val newFile = File.createTempFile("sqlcipherutils", "tmp", ctxt.cacheDir)
                var db = SQLiteDatabase.openDatabase(originalFile.absolutePath, "", null, SQLiteDatabase.OPEN_READWRITE)
                db.rawExecSQL(String.format("ATTACH DATABASE '%s' AS encrypted KEY '%s';",
                        newFile.absolutePath, passphrase))
                db.rawExecSQL("SELECT sqlcipher_export('encrypted')")
                db.rawExecSQL("DETACH DATABASE encrypted;")
                val version = db.version
                db.close()
                db = SQLiteDatabase.openDatabase(newFile.absolutePath, passphrase, null, SQLiteDatabase.OPEN_READWRITE)
                db.version = version
                db.close()
                originalFile.delete()
                newFile.renameTo(originalFile)
            }
        } catch (e: SQLiteException) {
            println(e.message)
        }
    }

    override fun getAllCategories(request: RequestCategoryModel): ResponseCategoryModel {
        return db.categoryDao().getAllCategories().toDomainModel()
    }

    override fun getAllMakals(request: RequestMakalModel): ResponseMakalModel {
        return db.makalDao().getAllMakals().toDomainModel()
    }

    override fun getMakalsByCategoryId(request: RequestMakalModel): ResponseMakalModel {
        return db.makalDao().getMakalsByCategoryId(request.categoryId).toDomainModel()
    }

    override fun getMakalsByQueryText(request: RequestMakalModel): ResponseMakalModel {
        return db.makalDao().getMakalsByQueryText(request.queryText).toDomainModel()
    }

    override fun getRandomMakal(): ResponseMakalModel {
        return db.makalDao().getRandomMakal().toDomainModel()
    }
}