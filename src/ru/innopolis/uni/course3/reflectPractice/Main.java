package ru.innopolis.uni.course3.reflectPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by julia on 12.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human("Ivan", 20);

        XMLSerializator serializator = new XMLSerializator();
//        serializator.serialize(human, "output.xml");

        List<Object> list = serializator.deserialize("output.xml");
        List<Human> humanList = new LinkedList<>();
        for (Object obj: list) {
            humanList.add((Human) obj);
        }
        System.out.println(humanList.toString());


    }
}
