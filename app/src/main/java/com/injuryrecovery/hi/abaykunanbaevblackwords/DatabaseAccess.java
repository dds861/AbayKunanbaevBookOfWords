package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<String> getItems(String language) {
        List<String> list = new ArrayList<>();

        String sqlQueryText;
        switch (language) {
            case "kazakh":
                sqlQueryText = "SELECT kazakh_num FROM abay";
                break;
            case "russian":
                sqlQueryText = "SELECT russian_num FROM abay";
                break;
            case "english":
                sqlQueryText = "SELECT english_num FROM abay";
                break;
            default:
                sqlQueryText = "SELECT kazakh_num FROM abay";
                break;
        }


        Cursor cursor = database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getBlackWord(String language) {


        String columnName = "";
        switch (language) {

            case "kazakh":
                columnName = context.getResources().getString(R.string.kazakh_text);
                break;
            case "russian":
                columnName = context.getResources().getString(R.string.russian_text);
                break;
            case "english":
                columnName = context.getResources().getString(R.string.english_text);
                break;
        }

        String sqlQueryText = "SELECT " + columnName + " FROM abay";
        Log.i("autolog", "sqlQueryText: " + sqlQueryText);



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


}