package com.example.project;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Account.db";

    public MyDBHandler(Context context){

        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table user(username text primary key, email text, password text, identity text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists user");
    }

    //insert into database
    public boolean insert(String username, String email, String password, String identity){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("identity", identity);
        long ins= db.insert("user", null, contentValues);
        if(ins== -1){
            return false;
        }else{
            return true;
        }
    }

    //check if username exists
    public boolean checkUsername(String username){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where username= ?", new String[] {username});
        if(cursor.getCount()> 0){
            return false;
        }else{
            return true;
        }
    }

    //find person by checking username and password
    public boolean findUser(String username, String password){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where username= ? and password= ?", new String[]{username, password});
        if(cursor.getCount()> 0){
            return true;
        }else{
            return false;
        }
    }

}

