package ru.innopolis.uni.course3.threadexample;

/**
 * Created by julia on 08.12.2016.
 */
public class SimpleThread extends Thread {
//    @Override
//    public void interrupt() {
//        super.interrupt();
//    }

    @Override
    public void run() {
//        Thread.currentThread().isInterrupted();  // returns true or false
        while (!isInterrupted()) {
            System.out.println("Thread 1");
        }
    }
}
