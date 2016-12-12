package ru.innopolis.uni.course3.reflect;
import ru.innopolis.uni.course3.collections.Human;

import java.lang.reflect.Field;

/**
 * Created by julia on 12.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human(5, "Ivan");
        /*try {
            Human h1 = Human.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        Class <Human> humanClass = Human.class;

        for (Field field: humanClass.getDeclaredFields()) {

            System.out.println(field);
            if ("name".equals(field.getName())) {
                field.setAccessible(true);
                try {
                    field.set(human, "Jon");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(field.get(human));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if ("money".equals(field.getName())) {
                field.setAccessible(true);
                try {
                    field.set(human, 50);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(field.get(human));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
