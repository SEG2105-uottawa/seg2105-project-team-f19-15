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
        db.execSQL("Create table time(EndingHours text primary key, EndingMinutes text, StartHours text, StartMinutes text)");
        db.execSQL("Create table user_employee(username text primary key, address text,phoneNum text, clinicName text, Insurance text,Payment text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists time");
        db.execSQL("drop table if exists user_employee");
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

    public boolean insertPro(String username, String Address, String phoneNum, String clinicName, String Insurance, String Payment){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("address", Address);
        contentValues.put("phoneNum", phoneNum);
        contentValues.put("clinicName", clinicName);
        contentValues.put("Insurance", Insurance);
        contentValues.put("Payment", Payment);
        long ins= db.insert("user_employee", null, contentValues);
        if(ins== -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insert_WorkingTime(ChooseTime chooseTime){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("StartingHours", chooseTime.getStartingHours());
        contentValues.put("StartMinutes",chooseTime.getStartingMinutes() );
        contentValues.put("EndingHours",chooseTime.getEndingHours());
        contentValues.put("EndingMinutes",chooseTime.getEndingMinutes() );
        long ins= db.insert("time", null, contentValues);
        if(ins== -1){
            return false;
        }else{
            return true;
        }
    }


    //check if username exists for table named user
    public boolean checkUsername(String username){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where username= ?", new String[]{username});
        if(cursor.getCount()> 0){
            return false;
        }else{
            return true;
        }
    }

    //find person by checking username and password in user table
    public boolean findUser(String username, String password, String identity){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where username= ? and password= ? and identity= ?", new String[]{username, password, identity});
        if(cursor.getCount()> 0){
            return true;
        }else{
            return false;
        }
    }


    //find person by checking username in user table
    public boolean findUser(String username){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where username= ?", new String[]{username});
        if(cursor.getCount()> 0){
            return true;
        }else{
            return false;
        }
    }


    //delete person by checking username in user table
    public Integer deleteUser(String username){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("user", "username= ?", new String[]{username});
    }

    //delete ending time in time table
    public Integer deleteEndingTime(int EndingHours,int EndingMinutes){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("time", "EndingHours=?", new String[]{String.valueOf(EndingHours)});

    }

    //show all username
    public Cursor showAll(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from user", null);
        return cursor;
    }
}



