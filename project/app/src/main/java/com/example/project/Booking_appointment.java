package com.example.project;

import androidx.annotation.NonNull;

public class Booking_appointment {
    private int year;
    private int month;
    private int day;
    private String service_name;
    private String user_name;
    private String notes;
    private int hour;
    private  int minutes;

    public  Booking_appointment(String user_name,int year,int month,int day,int hour,int minutes,String service_name,String notes){
        this.day=day;
        this.hour = hour;
        this.user_name = user_name;
        this.year =year;
        this.month=month;
        this.minutes=minutes;
        this.service_name =service_name;
        this.notes =notes;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHour() {
        return hour;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getNotes() {
        return notes;
    }

    public String getService_name() {
        return service_name;
    }

    @NonNull
    @Override
    public String toString() {
        return user_name + "The Time is"+year+month+day+hour+minutes+"The service name is"+service_name;
    }
}
