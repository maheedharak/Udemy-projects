package org.example;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main mainClass = new Main();
        mainClass.deadLock();
    }
    public void deadLock(){
        String hostage = "hostage";
        String ransom = "ransom";
        Thread criminalThread = new Thread(() -> {
            synchronized(ransom) {
                System.out.println("ransom acquired will not release hostage");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException ex){
                    System.out.println("Criminal thread interrupted");
                }
                synchronized (hostage) {
                    System.out.println("Ransom received hostage will not be relased");
                }
            }
        });

        Thread policeThread = new Thread(() ->{
           synchronized (ransom){
               System.out.println("Ransom available release hostage");
               try{
                   Thread.sleep(500);
               }catch(InterruptedException ex){
                   System.out.println("Police thread interrupted");
               }
               synchronized (hostage){
                   System.out.println("Both are acquired");
               }
           }
        });
        criminalThread.start();
        policeThread.start();

    }
}