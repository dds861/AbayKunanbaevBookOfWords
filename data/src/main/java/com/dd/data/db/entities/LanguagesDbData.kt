package com.dd.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = LanguagesDbData.TABLE_NAME)
data class LanguagesDbData(
        @PrimaryKey
        @ColumnInfo(name = NUMERICAL) val language_id: String,
        @ColumnInfo(name = TEXT) val language_text: String
) {

    //////////////////////////TABLE///////////////////////////

    companion object {
        const val TABLE_NAME = "languages"
        const val NUMERICAL = "num"
        const val TEXT = "text"
    }

    //////////////////////////////////////////////////////////

}