package org.example.task5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumberServiceTest {

    private static PrimeNumberService primeNumberService;

    @BeforeAll
    static void setUp() {
        primeNumberService = new PrimeNumberService();
    }

    @Test
    void testIsPrimeWithPrimeNumbers2() {
        assertTrue(primeNumberService.isPrime(2));
    }

    @Test
    void testIsPrimeWithPrimeNumbers17() {
        assertTrue(primeNumberService.isPrime(17));
    }

    @Test
    void testIsPrimeWithPrimeNumbers89() {
        assertTrue(primeNumberService.isPrime(89));
    }


    @Test
    void testIsPrimeWithLargeNumbers999983() {
        assertTrue(primeNumberService.isPrime(999983));
    }

    @Test
    void testIsPrimeWithLargeNumbers1000000() {
        assertFalse(primeNumberService.isPrime(1000000));
    }
}