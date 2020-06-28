package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.RussianDbData


@Dao
interface RussianDbDao : BaseDbDao<RussianDbData> {

    @Query("SELECT * FROM ${RussianDbData.TABLE_NAME_RUSSIAN}")
    fun getRussian(): List<RussianDbData>

    @Query("SELECT * FROM ${RussianDbData.TABLE_NAME_RUSSIAN} " +
            "WHERE ROWID = :rowId")
    fun getRussianById(rowId: Int): RussianDbData
}