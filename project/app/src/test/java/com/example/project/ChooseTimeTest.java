package com.example.project;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ChooseTimeTest {
    private ChooseTime chooseTimeTest = new ChooseTime(7,20,10,30);

    @Test
    public void isInitialized(){
        assertNotNull(chooseTimeTest);
    }

    public  void isCorrectStartingHour(){
        assertNotNull("10",String.valueOf(chooseTimeTest.getStartingHours()));
    }

    public void isCorrectStartingMinute(){
        assertNotNull("30",String.valueOf(chooseTimeTest.getStartingMinutes()));
    }
    public void isCorrectEndingHour(){
        assertNotNull("7",String.valueOf(chooseTimeTest.getEndingHours()));
    }
    public  void isCorrectEndingMinute(){
        assertNotNull("20",String.valueOf(chooseTimeTest.getEndingMinutes()));
    }




}
