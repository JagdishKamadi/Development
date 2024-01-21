package com.epam.utility.cls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    public static List<Integer> getQuestionNumberList()
    {
        Random random= new Random();
        List<Integer> storeRandomNumber = new ArrayList<>();

        // store 5 random number
        while(storeRandomNumber.size()<5)
        {
            int randomNumber = random.nextInt(10)+1;
            if(!storeRandomNumber.contains(randomNumber))
                storeRandomNumber.add(randomNumber);
        }
        return storeRandomNumber;
    }
}
