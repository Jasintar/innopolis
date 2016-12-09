package ru.innopolis.uni.course3.autoclosebletest;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by julia on 07.12.2016.
 */
public class MyResourse implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("Close resourse" + toString());
        throw new RuntimeException();
    }
}
