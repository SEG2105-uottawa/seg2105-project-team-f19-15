package com.example.segproject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accounts.db";
    private static final String NAME="accountList";
    public static final String EMAIL = "email";
    public static final String ACCOUNTNAME = "accountName";
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    public static final String PASSWORD = "password";

    public MyDBHandler(Context context, String s, int i){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase sqli){
        String CREATE_PRODUCTS_TABLE =
                "CREATE TABLE " + NAME + "("
                + "_id INTEGER PRIMARY KEY," +
                ACCOUNTNAME + " ," + EMAIL + " ," + FIRSTNAME+","+LASTNAME+","+PASSWORD+")";
        sqli.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqli, int oldVersion, int newVersion) {
        sqli.execSQL("DROP TABLE IF EXISTS "+ NAME);
        onCreate(sqli);
    }

}