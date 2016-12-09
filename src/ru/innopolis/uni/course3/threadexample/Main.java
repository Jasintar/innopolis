package ru.innopolis.uni.course3.threadexample;

/**
 * Created by julia on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Begin");
        Thread t = new SimpleThread();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread 2");
                }
            }
        });
        t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
//        t2.start();
//        while (true) {
//            System.out.println("Main Thread");
//        }
    }
}
