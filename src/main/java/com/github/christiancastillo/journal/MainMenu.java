package com.github.christiancastillo.journal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class MainMenu{  
 public static void main(String args[]) {
     
    Journal journal = new Journal();

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");

     int loop = 0;
     while(loop==0){
    
     
     System.out.println("Today is: " + LocalDateTime.now().format(dateTimeFormatter));
     System.out.println("---------------------------");
     System.out.println("          JOURNAL");
     System.out.println("---------------------------");
     System.out.println("1. New Entry");
     System.out.println("2. View Past Entries");
     System.out.println("3. Edit Habit List");
     System.out.println("4. Exit");
     System.out.println("---------------------------");
    
    Scanner in = new Scanner(System.in);
    System.out.println("Select Option: ");
    int x = in.nextInt();

    switch(x)
    {
            case 1:
                journal.AddEntry();
                break;
            case 2:
                journal.showEntry();
                break;
            case 3:
                System.out.println("You Selected option 3");
                break;
            case 4:
                loop=1;
                break;
            default:
                System.out.println("Please choose between option 1, 2, or 3");
    }
    }
    
}  
}  