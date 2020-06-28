package com.dd.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dd.data.db.dao.*
import com.dd.data.db.entities.*


@Database(
        entities = [
            LanguagesDbData::class,
            BlackWordDbData::class,
            EnglishDbData::class,
            DutchDbData::class,
            KazakhDbData::class,
            RussianDbData::class,
            PortugueseDbData::class
        ],
        version = 2,
        exportSchema = false
)
abstract class BlackWordsDatabase : RoomDatabase() {
    abstract fun languagesDao(): LanguagesDbDao
    abstract fun blackWordDao(): BlackWordDbDao
    abstract fun englishDao(): EnglishDbDao
    abstract fun dutchDao(): DutchDbDao
    abstract fun kazakhDao(): KazakhDbDao
    abstract fun russianDao(): RussianDbDao
    abstract fun portugueseDao(): PortugueseDbDao
}

