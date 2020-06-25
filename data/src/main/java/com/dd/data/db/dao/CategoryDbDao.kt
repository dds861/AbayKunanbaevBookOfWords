package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.CategoryDbData


@Dao
interface CategoryDbDao : BaseDbDao<CategoryDbData> {

    @Query("SELECT * FROM ${CategoryDbData.TABLE_NAME}")
    fun getAllCategories(): List<CategoryDbData>
}