package ru.innopolis.uni.course3.autoclosebletest;

import java.io.*;

/**
 * Created by julia on 07.12.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {

//        ExceptionThrower exceptionThrower = new ExceptionThrower();
//        try {
//            exceptionThrower.doSome();
//        } catch (FileNotFoundException e) {
//            System.out.println("catch");
//            throw e;
//        } finally {
//            System.out.println("finally");
//        }
//
//        System.out.println("end");

        try (Closeable closeable1 = new MyResourse();
             Closeable closeable2 = new MyResourse();) {
            System.out.println("try");
            throw new IOException();
//            inputStream.read(null);
        } catch (Exception e) {
            System.out.println("catch");
            throw e;
        } finally {
            System.out.println("finally");
        }
    }
}
