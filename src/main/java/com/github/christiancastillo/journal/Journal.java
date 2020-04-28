package com.github.christiancastillo.journal;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Journal {

    private Scanner scanner = new Scanner(System.in);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");

    public void AddEntry() {

        try {
            File file = new File("log.csv");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            String date = LocalDateTime.now().format(dateTimeFormatter);
            System.out.println("Enter the entry text:");
            String text = scanner.nextLine();

            pw.println(date);
            pw.println(text);
            pw.println("-------------------------------------------------------------------");
            pw.close();

        }  catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void showEntry(){

        try {
            File file = new File("log.csv");
            Scanner fileSC = new Scanner(file);
    
            while(fileSC.hasNext()){
                System.out.println(fileSC.nextLine());
            }
            
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }

}