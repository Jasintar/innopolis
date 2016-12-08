package ru.innopolis.uni.course3.deadlock;

/**
 * Created by julia on 08.12.2016.
 */
public class Main {
    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) {
        final Object monitor1 = new Object();
        final Object monitor2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread 1");
                    synchronized(monitor1) {
                        count1++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized(monitor2) {
                            System.out.println("DEADLOCK1");
                            count2++;
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread 2");
                    synchronized(monitor2) {
                        count2++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized(monitor1) {
                            System.out.println("DEADLOCK1");
                            count1++;
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
