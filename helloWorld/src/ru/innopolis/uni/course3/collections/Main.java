package ru.innopolis.uni.course3.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by julia on 06.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Map map = new HashMap();

        Human human = new Human(25, "Ivan");
        map.put(human, new Car("Vesta", 2016));
        Human human2 = getHumanFromDB();

        System.out.println(human.equals(human2));
        System.out.println("Ivan's car = " + map.get(human2));
    }

    private static Human getHumanFromDB() {
        return new Human(25, "Ivan");
    }
}
