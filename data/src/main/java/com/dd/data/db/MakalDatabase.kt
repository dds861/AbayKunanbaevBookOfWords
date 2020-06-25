package com.dd.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dd.data.db.dao.MakalDbDao
import com.dd.data.db.dao.CategoryDbDao
import com.dd.data.db.entities.CategoryDbData
import com.dd.data.db.entities.MakalDbData


@Database(
        entities = [
            CategoryDbData::class,
            MakalDbData::class
        ],
        version = 2,
        exportSchema = false
)
abstract class MakalDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDbDao
    abstract fun makalDao(): MakalDbDao
}