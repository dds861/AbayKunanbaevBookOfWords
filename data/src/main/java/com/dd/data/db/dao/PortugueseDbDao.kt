package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.PortugueseDbData


@Dao
interface PortugueseDbDao : BaseDbDao<PortugueseDbData> {

    @Query("SELECT * FROM ${PortugueseDbData.TABLE_NAME_PORTUGUESE}")
    fun getPortuguese(): List<PortugueseDbData>

    @Query("SELECT * FROM ${PortugueseDbData.TABLE_NAME_PORTUGUESE} " +
            "WHERE ROWID = :rowId")
    fun getPortugueseById(rowId: Int): PortugueseDbData
}