package ru.innopolis.uni.course3.base;

/**
 * Created by julia on 05.12.2016.
 */
public class BaseClass {

    private int myField;

    public int getMyField() {
        return myField;
    }

    public void setMyField(int myField) {
        this.myField = myField;
    }

    public BaseClass() {
        super();
        System.out.println("parent constructor!");
    }

    {
        System.out.println("parent init");
    }

    public BaseClass(int arg) {
//        this();
    }
}
