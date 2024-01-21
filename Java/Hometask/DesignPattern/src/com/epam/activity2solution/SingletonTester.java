package com.epam.activity2solution;
import java.util.function.Supplier;

public class SingletonTester {
    public static boolean isSingleton(Supplier<Object> func) {

        if(func == null)
            return false;

        Object obj = func.get();

        if(obj instanceof SingletonClass)
            return true;

        return false;
    }

}
