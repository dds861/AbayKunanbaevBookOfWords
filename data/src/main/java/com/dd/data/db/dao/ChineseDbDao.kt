package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.ChineseDbData
import com.dd.data.db.entities.PortugueseDbData


@Dao
interface ChineseDbDao : BaseDbDao<ChineseDbData> {

    @Query("SELECT * FROM ${ChineseDbData.TABLE_NAME_CHINESE}")
    fun getChinese(): List<ChineseDbData>

    @Query("SELECT * FROM ${ChineseDbData.TABLE_NAME_CHINESE} " +
            "WHERE ROWID = :rowId")
    fun getChineseById(rowId: Int): ChineseDbData
}