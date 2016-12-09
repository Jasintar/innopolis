package ru.innopolis.uni.course3.threadexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia on 08.12.2016.
 */
public class IncrementCalculator {
    static volatile int count = 0;
    public static void main(String[] args) {
        final Object monitor = new Object();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10_000_000; j++) {
                        synchronized(monitor) {
                            count++;
                        }
                    }
                }
            });
            threads.add(t);
        }

        for (Thread t: threads) {
            t.start();
        }
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
