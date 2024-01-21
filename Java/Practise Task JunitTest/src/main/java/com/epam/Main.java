package com.epam;

public class Main {
    public static void main(String[] args) {
        CharRemoval charRemoval = new CharRemoval();
        String result = charRemoval.removeFirstTwoA("AAVV");
        System.out.println(result);
    }
}
