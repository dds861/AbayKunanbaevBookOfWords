package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class DatabaseAccess extends AppCompatActivity {
    private final SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    private final Context context;

    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
        this.context = context;
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);

        }
        return instance;
    }

    public void open() {
        context.deleteDatabase("abay.db");
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<String> getTextBlackWords(String tableName) {
        List<String> list = new ArrayList<>();
        String sqlQueryText = "SELECT text FROM " + tableName;
        Cursor cursor = database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getNumBlackWord(String tableName) {
        String sqlQueryText = "SELECT num FROM " + tableName;


        Cursor cursor = database.rawQuery(sqlQueryText, null);

        List<String> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getLanguages(String tableName) {
        String sqlQueryText = "SELECT text FROM " + tableName;


        Cursor cursor = database.rawQuery(sqlQueryText, null);

        List<String> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getLanguageByPosition(String position) {

        String sqlQueryText = "SELECT text FROM languages WHERE num = " + position;
        Cursor cursor = database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        List<String> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list.get(0);

    }


}