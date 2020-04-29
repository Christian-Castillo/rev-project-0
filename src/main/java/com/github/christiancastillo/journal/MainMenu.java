package com.github.christiancastillo.journal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainMenu{  

    public static int Home(int y){

        Journal journal = new Journal();
        Data instance = new Data();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");
     
        System.out.println("Today is: " + LocalDateTime.now().format(dateTimeFormatter));
        System.out.println("----------------------------------------------------------");
        System.out.println("                        JOURNAL");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. New Entry");
        System.out.println("2. View Past Entries");
        System.out.println("3. Complete Habits");
        System.out.println("4. Add New Habit");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------------------------");
           
        Scanner in = new Scanner(System.in);
        System.out.println("Select Option: ");
        int x = in.nextInt();
       
        switch(x)
        {
            case 1:
                journal.AddEntry();
                return 1;
            case 2:
                journal.showEntry();

                int c = 1;
                while(c!=1 || c!=2){
                    System.out.println("ENTER 1 to go to MAIN MENU or 2 to EXIT Application.");
                    c = in.nextInt();
                    if(c==1)
                    {
                        return 2;
                    }
                    else if(c==2)
                    {
                        return 5;
                    }   
                    else{
                        System.out.println("Please Enter a Valid Option");
                    }
                }
                
                
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                System.out.println("Please enter a valid option.");
                return 0;
           }

    }

    public static void main(String args[]) {

        String test = "test";
        Data num = new Data();
        int h = 0;
        h = num.getNumH();
        num.Load();
        num.fillHabitArr(h);
        
        int exit = 0;
        while(exit!=5)
        {
            exit = Home(h);

            if(exit==3){
                h = num.getNumH();
                num.HabitTrack(h);
            }
            if(exit==4){
                h = num.getNumH();
                num.AddHabit(h);
            }
        }

        num.fillHabitDoc(h);

    }  
}  