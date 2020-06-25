package com.dd.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDbDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg entity: T)

    @Update
    fun update(vararg entity: T)

    @Delete
    fun delete(entity: T)
}