package com.epam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CharRemovalTest {
    /**
     * To-Do list
     * 1) " " => " "
     * 2) A => " "
     * 3) BACD => BCD
     * 4) BBAA => BBAA
     * 5) AABAA => BAA
     * 6) ABCD => BCD
     * 7) AACD => CD
     */
    private final CharRemoval charRemoval = new CharRemoval();

    @Test
    @DisplayName("Checking for blank")
    public void checkForBlankCharTest()
    {
        String result = charRemoval.removeFirstTwoA("");
        assertEquals("",result);
    }

    @Test
    @DisplayName("Checking for one char")
    public void checkForOneCharTest()
    {
        String result = charRemoval.removeFirstTwoA("A");
        assertEquals("",result);
    }

    @Test
    @DisplayName("Checking for two char")
    public void checkForTwoCharTest()
    {
        String result = charRemoval.removeFirstTwoA("BB");
        assertEquals("BB",result);
    }

    @Test
    @DisplayName("Checking for N character")
    public void checkForNChar()
    {
        assertAll("Checking for multiple string ",()->assertEquals("BBCD",charRemoval.removeFirstTwoA("AABBCD")),
                ()->assertEquals("BCD",charRemoval.removeFirstTwoA("BACD")),
                ()->assertEquals("BBAA",charRemoval.removeFirstTwoA("BBAA")),
                ()->assertEquals("BCD",charRemoval.removeFirstTwoA("ABCD")),
                ()->assertEquals("CD",charRemoval.removeFirstTwoA("AACD")),
                ()->assertEquals("  CD",charRemoval.removeFirstTwoA("  CD")));
    }
}
