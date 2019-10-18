package com.example.project;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper{


        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "accounts.db";
      //  private static final String NAME="accountList";
      //  public static final String EMAIL = "email";
      //  public static final String ACCOUNTNAME = "accountName";
        //public static final String FIRSTNAME = "firstName";
       // public static final String LASTNAME = "lastName";
       // public static final String PASSWORD = "password";

        public MyDBHandler(Context context, String s, int i){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase sqli){
            String CREATE_PRODUCTS_TABLE =
                    "CREATE TABLE account(" +
                    "name varchar(50)," +
                            "password varchar(50)," +
                            "identity varchar(50)," +
                                  "email varchar(20)"+
                            "primary key(name))";

            sqli.execSQL(CREATE_PRODUCTS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqli, int oldVersion, int newVersion) {
            String sql = "delete table if exists account";
            onCreate(sqli);
        }
    public void addacount(account account_1) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",account_1.getName());
        values.put("email", account_1.getEmail());
        values.put("password", account_1.getPassword());
        values.put("identity", account_1.getidentity().toString());
        db.insert("Person", null, values);
        db.close();
    }
        public account findPerson(String name, String password){
            SQLiteDatabase db = getReadableDatabase();
            String sql = "select name, password, email from account where name=\"" + name;
            Cursor cursor = db.rawQuery(sql, null);
            account account_1 = new account();
            if (cursor.moveToFirst()) {
                account_1.setName(cursor.getString(0));
                account_1.setEmail(cursor.getString(1));
                account_1.setPassword(cursor.getString(2));
                account_1.setIdentity(Identity.valueOf(cursor.getString(3)));
            }

            else {
                account_1 = null;
            }
            cursor.close();
            db.close();
            return account_1;
        }

    }

