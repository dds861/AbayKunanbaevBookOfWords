package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.DutchDbData


@Dao
interface DutchDbDao : BaseDbDao<DutchDbData> {

    @Query("SELECT * FROM ${DutchDbData.TABLE_NAME_DUTCH}")
    fun getDutch(): List<DutchDbData>


    @Query("SELECT * FROM ${DutchDbData.TABLE_NAME_DUTCH} " +
            "WHERE ROWID = :rowId")
    fun getDutchById(rowId: Int): DutchDbData
}