package com.epam.activity2solution;

public class SingletonDesignPatternTest {
    public static void main(String[] args) {

        // 1st check for Singleton instance
        SingletonClass singletonClass = SingletonClass.getInstance();
        System.out.println(SingletonTester.isSingleton(singletonClass));

        // 2nd check for null
        System.out.println(SingletonTester.isSingleton(null));
    }
}
