package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.MakalDbData

@Dao
interface MakalDbDao : BaseDbDao<MakalDbData> {
    @Query("SELECT * FROM ${MakalDbData.TABLE_NAME}")
    fun getAllMakals(): List<MakalDbData>

    @Query("SELECT * FROM ${MakalDbData.TABLE_NAME} WHERE ${MakalDbData.CATEGORY_ID}=:categoryId")
    fun getMakalsByCategoryId(categoryId: Int): List<MakalDbData>

    @Query("SELECT * FROM ${MakalDbData.TABLE_NAME} WHERE ${MakalDbData.MAKAL_ADDRESS} LIKE '%' || :queryText|| '%'")
    fun getMakalsByQueryText(queryText: String): List<MakalDbData>

    @Query("SELECT ${MakalDbData.MAKAL_NAME} FROM ${MakalDbData.TABLE_NAME} ORDER BY RANDOM() LIMIT 1")
    fun getRandomMakal(): String
}