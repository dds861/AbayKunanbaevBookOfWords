package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.LanguagesDbData


@Dao
interface LanguagesDbDao : BaseDbDao<LanguagesDbData> {

    @Query("SELECT * FROM ${LanguagesDbData.TABLE_NAME}")
    fun getAllLanguages(): List<LanguagesDbData>
}