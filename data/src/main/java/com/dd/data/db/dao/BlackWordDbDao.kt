package com.dd.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.dd.data.db.entities.BlackWordDbData

@Dao
interface BlackWordDbDao : BaseDbDao<BlackWordDbData> {
    @Query("SELECT * FROM ${BlackWordDbData.TABLE_NAME}")
    fun getAllMakals(): List<BlackWordDbData>

    @Query("SELECT * FROM ${BlackWordDbData.TABLE_NAME} WHERE ${BlackWordDbData.CATEGORY_ID}=:categoryId")
    fun getMakalsByCategoryId(categoryId: Int): List<BlackWordDbData>

    @Query("SELECT * FROM ${BlackWordDbData.TABLE_NAME} WHERE ${BlackWordDbData.MAKAL_ADDRESS} LIKE '%' || :queryText|| '%'")
    fun getMakalsByQueryText(queryText: String): List<BlackWordDbData>

    @Query("SELECT ${BlackWordDbData.MAKAL_NAME} FROM ${BlackWordDbData.TABLE_NAME} ORDER BY RANDOM() LIMIT 1")
    fun getRandomMakal(): String
}