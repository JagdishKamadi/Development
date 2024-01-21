package com.epam;

public class CharRemoval {
    public String removeFirstTwoA(String string) {
        Integer len = string.length();

        return (len > 2) ? string.substring(0, 2).replace("A", "") + string.substring(2) :
                (len == 2) ? string.substring(0, 2).replace("A", "") :
                        (len == 1) ? string.substring(0, 1).replace("A", "") : "";
    }
}
