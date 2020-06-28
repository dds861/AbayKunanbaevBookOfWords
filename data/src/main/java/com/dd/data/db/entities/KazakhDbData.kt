package com.dd.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = KazakhDbData.TABLE_NAME_KAZAKH)
data class KazakhDbData(
        @PrimaryKey
        @ColumnInfo(name = ID) val id: Int,
        @ColumnInfo(name = TITLE) val title: String,
        @ColumnInfo(name = TEXT) val text: String
) {

    //////////////////////////TABLE///////////////////////////

    companion object {
        const val TABLE_NAME_KAZAKH = "kazakh"
        const val ID = "_id"
        const val TITLE = "num"
        const val TEXT = "text"
    }

    //////////////////////////////////////////////////////////

}