package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLdata extends SQLiteOpenHelper {
    private final static String DB="DB2019.db";//database
    private final static String TB="TB2019";//datatable
    private final static int VS=2;//BANBEN


    public SQLdata(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
        super(context, DB, null, VS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL="CREATE TABLE IF NOT EXISTS "+TB+"(_id INTEGER PRIMARY KEY AUTOINCREMENT, _title VARCHAR(50))";
        sqLiteDatabase.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String SQL="DROP TABLE"+TB;
        sqLiteDatabase.execSQL(SQL);

    }
}
