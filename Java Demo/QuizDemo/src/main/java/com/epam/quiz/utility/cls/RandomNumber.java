package com.epam.quiz.utility.cls;

import java.util.*;

public class RandomNumber {

    public static Set<Integer> getQuestionNumberList(List<Integer> questionNumberList)
    {
        Random rand= new Random();
       Set<Integer> storeRandomNumber = new LinkedHashSet<>();

        // store 5 random number
        while(storeRandomNumber.size()<5)
        {
            storeRandomNumber.add(questionNumberList.get(rand.nextInt(questionNumberList.size())));
        }
        return storeRandomNumber;
    }
}
