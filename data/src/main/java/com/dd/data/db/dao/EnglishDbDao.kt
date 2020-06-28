package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.EnglishDbData


@Dao
interface EnglishDbDao : BaseDbDao<EnglishDbData> {

    @Query("SELECT * FROM ${EnglishDbData.TABLE_NAME_ENGLISH}")
    fun getEnglish(): List<EnglishDbData>

    @Query("SELECT * FROM ${EnglishDbData.TABLE_NAME_ENGLISH} " +
            "WHERE ROWID = :rowId")
    fun getEnglishById(rowId: Int): EnglishDbData

}