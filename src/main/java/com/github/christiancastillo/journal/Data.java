package com.github.christiancastillo.journal;

import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Data {

    private Scanner scanner = new Scanner(System.in);
    Habit instance = new Habit();
    Habit habit[] = new Habit[10];

    public int getNumH(){
        try {
            int x=0;
            String line;

            File file = new File("data.csv");
            Scanner fileSC = new Scanner(file);
            line = fileSC.nextLine();
            String [] parts = line.split(" ");

            x = Integer.parseInt(parts[0]);

            return x;
            
        } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 0;
        }
    }

    public void fillHabitDoc(int h){
        try {
            File file = new File("habit.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for(int i = 0; i < h; i++)
            {
                String name;
                int stk;
                int ld;

                name = habit[i].getName();
                stk = habit[i].getStreak();
                ld = habit[i].getLastDay();
                pw.println(name + " " + stk + " " + ld);
            }
            pw.close();

        }  catch(IOException e) {
            e.printStackTrace();
        }
        
    }

    public void fillHabitArr(int h){
        
        try {
            int x = 0;
            File file = new File("habit.csv");
            Scanner fileSC = new Scanner(file);
            int today = 0;
            today = instance.getToday();
            int streak = 0;
        
            while(fileSC.hasNext()){
                String line;
                line = fileSC.nextLine();
                String [] parts = line.split(" ");
                String name;
                int stk;
                int ld;
                name = parts[0];
                stk = Integer.parseInt(parts[1]);
                ld = Integer.parseInt(parts[2]);
               
                habit[x].setName(name);
                habit[x].setLastDay(ld);

                if(today==ld){
                    habit[x].setCompletion(1);
                }
                else{
                    habit[x].setCompletion(0);
                }
            
                streak = today-ld;

                if(streak==1 || streak == 0){
                    habit[x].setStreak(stk);
                }
                else{
                    habit[x].setStreak(0);
                }
                

                x++;
            }
                
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }

    public void Load(){
        for(int i = 0; i < 10; i++)
        {
            habit[i] = new Habit();
        }
    }

    public void AddHabit(int y){
        System.out.println("Enter Habit Name: ");
        String text = scanner.nextLine();
        int today = 0;
        today = instance.getToday();
        int n = y+1;
        habit[y].setName(text);
        habit[y].setStreak(0);
        habit[y].setLastDay(today-1);

        try {
            File file = new File("data.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            int newData = 0;
            newData = y+1;
            pw.println(n);
            pw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void HabitTrack(int y){
        int loop = 0;
        int loop2 = 0;
        int today = 0;
        today = instance.getToday();

        while(loop==0){
            System.out.println("----------------------------------------------------------");
            System.out.println("                       HABIT TRACKER");
    
            System.out.println("----------------------------------------------------------");

            loop2 = 0;

            for(int i = 0; i < y; i++)
            {
                String name;
                int stk;
                int ld;
                int comp;
                String c = "INCOMPLETE";

                name = habit[i].getName();
                stk = habit[i].getStreak();
                ld = habit[i].getLastDay();
                comp = habit[i].getCompletion();
                if(comp==1)
                {
                    c = "COMPLETED!!!";
                }
            //System.out.println(i + ". " + "HABIT: " + name  + " CURRENT STREAK: " + stk + "    --------    " + c);
                System.out.printf("%d. HABIT: %11s", i, name);
                System.out.printf(" --- CURRENT STREAK: %d --- %s%n", stk, c);
            
            }
            System.out.println("----------------------------------------------------------");
            while(loop2==0)
            {
                String exit = "exit";
                int x = 0;
                System.out.println("ENTER NUMBER OF COMPLETED HABIT(Type exit to exit): ") ;
                String text = scanner.nextLine();
                
                if(text.equals(exit)){
                    loop2=1;
                    loop=1;
                }
                else{
                    x = Integer.parseInt(text);
                }

                if(x < y){  

                    if(habit[x].getCompletion()==0){
                        int stk;
                        stk = habit[x].getStreak();
                        stk++;
                        habit[x].setStreak(stk);
                        habit[x].setCompletion(1);
                        habit[x].setLastDay(today);
                        loop2=1;
                    }
                    else{
                        //System.out.println("You've Already Completed That Today.");
                        loop2=1;
                    }

                }
                else {
                    System.out.println("Please Enter a Valid Number.");
                    loop2=1;
                }
            }
        }
    }


}