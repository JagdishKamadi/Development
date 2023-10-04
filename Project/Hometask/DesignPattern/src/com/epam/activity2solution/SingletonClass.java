package com.epam.activity2solution;
import java.util.function.*;

public class SingletonClass implements Supplier<Object> {

    // 1st step
    private static SingletonClass instance;

    // 2nd step
    private SingletonClass(){}

    // 3rd step return object
    // make method thread safe
    public static synchronized SingletonClass getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonClass();
        }

        return instance;
    }

    // return the object
    @Override
    public Object get() {
        return instance;
    }
}
