package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "abay.db";
    private static final int DATABASE_VERSION = 2;


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
