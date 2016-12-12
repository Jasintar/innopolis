package ru.innopolis.uni.course3.reflect;

/**
 * Created by julia on 12.12.2016.
 */
public class InterfaceOneImpl implements InterfaceOne {
    @Override
    public void doSome(int number) {
        System.out.println("Doing method doSome of InterfaceOne with parametr " + number);
    }
}
