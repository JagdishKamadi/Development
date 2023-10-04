package com.epam.quiz.utility.cls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumber {
    private static final  Logger logger = LogManager.getLogger(RandomNumber.class);

    private RandomNumber() {
        throw new IllegalStateException("");
    }

    private static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            logger.error("Facing problem to generate the question {} ", e.getMessage());
        }
    }

    public static Set<Integer> getQuestionNumberList(List<Integer> questionNumberList) {


        Set<Integer> storeRandomNumber = new LinkedHashSet<>();

        // store 5 random number
        while (storeRandomNumber.size() < 5) {
            storeRandomNumber.add(questionNumberList.get(rand.nextInt(questionNumberList.size())));
        }
        return storeRandomNumber;
    }
}