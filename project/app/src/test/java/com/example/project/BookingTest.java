package com.example.project;

import static org.junit.Assert.assertNotNull;

public class BookingTest {
    private Booking_appointment bookingtest = new Booking_appointment("baby",2020,1,13,2,20,"headache","He is a baby");

    public void isInitialized(){
        assertNotNull(bookingtest);
    }
    public  void isCorrectStartingHour(){
        assertNotNull("10",String.valueOf(bookingtest.getHour()));
    }

    public void isCorrectStartingMinute(){
        assertNotNull("30",String.valueOf(bookingtest.getMinutes()));
    }
    public void isCorrectservicename(){
        assertNotNull("toothache",String.valueOf(bookingtest.getService_name()));
    }
    public  void isCorrectEndingMinute(){
        assertNotNull("mama",String.valueOf(bookingtest.getUser_name()));
    }



}
