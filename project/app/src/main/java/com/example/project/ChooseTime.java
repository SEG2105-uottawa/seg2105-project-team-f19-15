package com.example.project;

import java.io.Serializable;

public class ChooseTime  {
    private int StartingHours;
    private int StartingMinutes;
    private int EndingHours;
    private int EndingMinutes;

    public ChooseTime(int StartingHours,int StartingMinutes,int EndingHours,int EndingMinutes){
        this.EndingHours = EndingHours;
        this.EndingMinutes = EndingMinutes;
        this.StartingHours = StartingHours;
        this.StartingMinutes = StartingMinutes;
    }
    public ChooseTime(){

    }
    public int getStartingHours(){
        return  StartingHours;
    }

    public int getStartingMinutes() {
        return StartingMinutes;
    }

    public int getEndingHours() {
        return EndingHours;
    }

    public int getEndingMinutes() {
        return EndingMinutes;
    }

    public void setEndingHours(int endingHours) {
        EndingHours = endingHours;
    }

    public void setEndingMinutes(int endingMinutes) {
        EndingMinutes = endingMinutes;
    }

    public void setStartHours(int startHours) {
        StartingHours = startHours;
    }

    public void setStartMinutes(int startMinutes) {
        StartingMinutes = startMinutes;
    }
    public String toString(){
        return "The StartTime is "+StartingHours+":"+StartingMinutes +" " +"The Ending Time is"+EndingHours+":"+EndingMinutes;

    }
}
