package com.github.christiancastillo.journal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Habit {

    String HabitName;
    int Streak;
    int LastDay;
    int Today;
    int Complete;

    public void setCompletion(int comp){
        Complete = comp;
    }

    public int getCompletion(){
        return Complete;
    }

    public void setName(String name){
        HabitName = name;
    }

    public String getName(){
        return HabitName;
    }

    public void setStreak(int stk){
        Streak =  stk;
    }

    public int getStreak(){
        return Streak;
    }

    public void setLastDay(int ld){
        LastDay = ld;
    }

    public int getLastDay(){
        return LastDay;
    }

    public int getToday(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");
        String date = LocalDateTime.now().format(dateTimeFormatter);
        String delimeter = "/";
        String [] parts = date.split(delimeter);

        Today = Integer.parseInt(parts[1]);

        return Today;
    }


}