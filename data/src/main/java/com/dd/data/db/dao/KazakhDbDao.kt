package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.KazakhDbData


@Dao
interface KazakhDbDao : BaseDbDao<KazakhDbData> {

    @Query("SELECT * FROM ${KazakhDbData.TABLE_NAME_KAZAKH}")
    fun getKazakh(): List<KazakhDbData>

    @Query("SELECT * FROM ${KazakhDbData.TABLE_NAME_KAZAKH} " +
            "WHERE ROWID = :rowId")
    fun getKazakhById(rowId: Int): KazakhDbData
}