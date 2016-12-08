package ru.innopolis.uni.course3.threadClassicTask;

/**
 * Created by julia on 08.12.2016.
 */
public class Chronometr {
    private int time;

    public Chronometr() {
        time = 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void increment(){
        time++;
    }
}
