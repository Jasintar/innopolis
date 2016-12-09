package ru.innopolis.uni.course3.threadClassicTask;

/**
 * Created by julia on 08.12.2016.
 */
public class CounterThread extends Thread implements Runnable {
    int timeInterval;
    Chronometr cloack;

    public CounterThread(Chronometr cloack, int interval) {
        this.cloack = cloack;
        this.timeInterval = interval;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            synchronized(cloack) {
                try {
                    cloack.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (cloack.getTime() % timeInterval == 0) {
                System.out.println(timeInterval + " seconds ended");
            }
        }
    }
}
