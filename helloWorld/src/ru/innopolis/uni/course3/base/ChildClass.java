package ru.innopolis.uni.course3.base;

/**
 * Created by julia on 05.12.2016.
 */
public class ChildClass extends BaseClass {
    ChildClass() {
        super();
        System.out.println("child constructor");
    }

    {
        System.out.println("child init");
    }
}
