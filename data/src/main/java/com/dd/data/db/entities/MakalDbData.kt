package com.dd.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = MakalDbData.TABLE_NAME)
data class MakalDbData(

        @PrimaryKey
        @ColumnInfo(name = ID) val id: Long,
        @ColumnInfo(name = CATEGORY_ID) val category_id: Int,
        @ColumnInfo(name = MAKAL_SORT_ID) val makal_sort_id: Int,
        @ColumnInfo(name = MAKAL_NAME) val makal_text: String,
        @ColumnInfo(name = MAKAL_BRANCH) val makal_branch: String,
        @ColumnInfo(name = MAKAL_PERSON) val makal_person: String?,
        @ColumnInfo(name = MAKAL_PHONE) val makal_phone: String?,
        @ColumnInfo(name = MAKAL_ADDRESS) val makal_address: String?,
        @ColumnInfo(name = MAKAL_SCHEDULE) val makal_schedule: String?
) {

    //////////////////////////TABLE///////////////////////////

    companion object {
        const val TABLE_NAME = "cons"
        const val ID = "id"
        const val CATEGORY_ID = "code"
        const val MAKAL_SORT_ID = "sort_id"
        const val MAKAL_NAME = "name"
        const val MAKAL_BRANCH = "branch"
        const val MAKAL_PERSON = "person"
        const val MAKAL_PHONE = "phone"
        const val MAKAL_ADDRESS = "address"
        const val MAKAL_SCHEDULE = "schedule"
    }
    //////////////////////////////////////////////////////////

}