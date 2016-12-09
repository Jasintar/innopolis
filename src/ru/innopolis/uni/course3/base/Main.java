package ru.innopolis.uni.course3.base;

import java.awt.Point;

/**
 * Created by julia on 05.12.2016.
 */

public class Main {
    public static void main(String[] args) {
        BaseClass baseClass = new ChildClass();
        int i = 5;
        baseClass.setMyField(i);
    }
}
