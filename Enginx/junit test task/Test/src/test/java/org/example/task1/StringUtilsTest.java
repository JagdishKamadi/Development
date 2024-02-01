package org.example.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {
    private static StringUtils stringUtils;

    @BeforeAll
    static void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testStartsWithIgnoreCaseTrue() {
        assertTrue(stringUtils.startsWithIgnoreCase("HelloWorld", "hello"));
    }

    @Test
    void testStartsWithIgnoreCaseFalse() {
        assertFalse(stringUtils.startsWithIgnoreCase("HelloWorld", "world"));
    }

    @Test
    void testStartsWithIgnoreCaseEmptyString() {
        assertTrue(stringUtils.startsWithIgnoreCase("", ""));
    }

    @Test
    void testStartsWithIgnoreCaseIgnoreCase() {
        assertTrue(stringUtils.startsWithIgnoreCase("abc", "ABC"));
    }

    @Test
    void testStartsWithIgnoreCasePrefixLongerThanString() {
        assertFalse(stringUtils.startsWithIgnoreCase("abc", "abcd"));
    }

    @Test
    void testStartsWithIgnoreCaseNullString() {
        assertFalse(stringUtils.startsWithIgnoreCase(null, "prefix"));
    }

    @Test
    void testStartsWithIgnoreCaseNullPrefix() {
        assertFalse(stringUtils.startsWithIgnoreCase("string", null));
    }
}