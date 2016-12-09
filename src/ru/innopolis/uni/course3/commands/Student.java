package ru.innopolis.uni.course3.commands;

import java.io.Serializable;

/**
 * Created by julia on 07.12.2016.
 */
public class Student implements Serializable {
    int age;
    String name;

    Student(String name, int age) {
        this.age = age;
        this.name = name;

    }
}
