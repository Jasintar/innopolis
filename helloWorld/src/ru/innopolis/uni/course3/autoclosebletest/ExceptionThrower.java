package ru.innopolis.uni.course3.autoclosebletest;

import java.io.FileNotFoundException;

/**
 * Created by julia on 07.12.2016.
 */
public class ExceptionThrower {
    public void doSome() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
