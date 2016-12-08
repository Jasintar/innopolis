package ru.innopolis.uni.course3.threadClassicTask;

/**
 * Created by julia on 08.12.2016.
 */
public class Main {
    static Chronometr cloack = new Chronometr();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cloack.increment();
                    synchronized(cloack) {
                        cloack.notifyAll();
                    }
                    System.out.println("Thread 1 time " + cloack.getTime());
                }
            }
        });

        Thread t2 = new CounterThread(cloack, 5);
        Thread t3 = new CounterThread(cloack, 7);

        t1.start();
        t2.start();
        t3.start();
    }
}
