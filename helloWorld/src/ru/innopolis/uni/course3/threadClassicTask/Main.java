package ru.innopolis.uni.course3.threadClassicTask;

/**
 * Created by julia on 08.12.2016.
 */
public class Main {
    static int time = 0;

    public static void main(String[] args) {
        final Object monitor = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(monitor) {
                        time++;
                        if (time % 5 == 0) {
                            monitor.notify();
                        }
                    }
                    System.out.println("Thread 1 time " + time);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    synchronized(monitor) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Thread 2: 5 seconds ended");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
