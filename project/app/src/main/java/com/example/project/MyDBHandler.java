package com.example.project;


import android.content.Context;
import android.database.CrossProcessCursor;
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
        db.execSQL("Create table user_employee(username text primary key, address text, phoneNum text, clinicName text, Insurance text, Payment text)");
        db.execSQL("Create table ClinicRateAndComment(clinicName text primary key, rate text, comment text)");
        db.execSQL("Create table user_service(username textVARCHAR(32), service textVARCHAR(15))");
        db.execSQL("Create table booking(user_name textVARCHAR(32), year textVARCHAR(16),month textVARCHAR(12),day textVARCHAR(64),hour textVARCHAR(32),minutes textVARCHAR(32) ,service_name textVARCHAR(32),notes textVARCHAR(32)) ");
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists time");
        db.execSQL("drop table if exists user_employee");
        db.execSQL("drop table if exists user_service");
        db.execSQL("drop table if exists serviceRateAndComement");
        db.execSQL("drop table if exists booking");
        onCreate(db);
    }


    //The following methods are for insertion.

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
    public boolean insertSer(String username, String service){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("service", service);
        long ins= db.insert("user_service", null, contentValues);
        if(ins== -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insert_WorkingTime(ChooseTime chooseTime){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("StartHours", chooseTime.getStartingHours());
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


    public boolean insertCR(String name, String rate, String comment){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("clinicName",name);
        contentValues.put("rate", rate);
        contentValues.put("comment", comment);

        long ins= db.insert("ClinicRateAndComment", null, contentValues);
        if(ins== -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insert_booking(Booking_appointment booking){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",booking.getUser_name());
        contentValues.put("service",booking.getService_name());
        contentValues.put("year",booking.getYear());
        contentValues.put("month",booking.getMonth());
        contentValues.put("day",booking.getDay());
        contentValues.put("notes",booking.getNotes());
        long ins= db.insert("booking", null, contentValues);
        if(ins== -1){
            return false;
        }else{
            return true;
        }
    }



    //The following methods are for checking.

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

    public boolean checkSer(String service){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user_service where service= ?", new String[]{service});
        if(cursor.getCount()> 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkClinic(String clinic){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user_employee where clinicName= ?", new String[]{clinic});
        if(cursor.getCount()> 0){
            return true;
        }else{
            return false;
        }
    }

    public ChooseTime selectTime(int StartingHours,int EndingHours){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select StartingHours,StartingMinutes.EndingHours and EndingMinutes from ChooseTime where StartingHours and EndingHours=\"" + StartingHours+EndingHours;
        Cursor cursor = db.rawQuery(sql, null);
        ChooseTime chooseTime = new ChooseTime();
        if (cursor.moveToFirst()) {
            chooseTime.setStartHours(cursor.getInt(0));
            chooseTime.setStartMinutes(cursor.getInt(1));
            chooseTime.setEndingHours(cursor.getInt(2));
            chooseTime.setEndingMinutes(cursor.getInt(3));
        }
        else {
            chooseTime = null;
        }
        cursor.close();
        db.close();
        return chooseTime;
    }




    //The following methods are for finding.

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

    public boolean findClinicByAddress(String address){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user_employee where address= ?", new String[]{address});
        return cursor.getCount()> 0;

    }

    public boolean findClinicByWorkingHour(String starthr, String startmin, String endhr, String endmin){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from time where starthr= ? and startmin= ? and endhr= ? and endmin= ?", new String[]{starthr, startmin, endhr, endmin});
        return cursor.getCount()> 0;
    }

    public boolean findClinicByServiceType(String serviceType){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user_service where serviceType= ?", new String[]{serviceType});
        return cursor.getCount()> 0;
    }


    //The following methods are for deletion.

    //delete person by checking username in user table
    public Integer deleteUser(String username){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("user", "username= ?", new String[]{username});
    }

    public Integer deleteSer(String service){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("user_service", "service= ?", new String[]{service});
    }

    //delete ending time in time table
    public Integer deleteEndingTime(int EndingHours,int EndingMinutes){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete("time", "EndingHours=?", new String[]{String.valueOf(EndingHours)});

    }



    //The following methods are for displaying the existing data in the database

    //show all username
    public Cursor showAll(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from user", null);
        return cursor;
    }

    public Cursor viewAll(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from time", null);
        return cursor;
    }

    public Cursor seeAll(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from user_service", null);
        return cursor;
    }

    public Cursor showAllClinicRate(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from  ClinicRateAndComment", null);
        return cursor;
    }
}

