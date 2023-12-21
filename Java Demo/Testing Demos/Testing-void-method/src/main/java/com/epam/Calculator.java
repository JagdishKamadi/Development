package com.epam;

public class Calculator {
    public void sum(int x, String element) {
        System.out.println("The sum is " + (x + element));
    }

    private void sumOfElement(Element element) {
        System.out.println(element.toString());
    }
}
