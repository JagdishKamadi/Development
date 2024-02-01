package org.example.task5;

class PrimeNumberService {

  private final boolean[] primeNumbersCache = new boolean[250000];

  PrimeNumberService() {
    for (int i = 0; i < primeNumbersCache.length; ++i) {
      primeNumbersCache[i] = verifyPrime(i);
    }
  }

  boolean isPrime(int number) {
    if (number < primeNumbersCache.length) {
      return primeNumbersCache[number];
    }

    return verifyPrime(number);
  }

  private static boolean verifyPrime(int number) {
    for (int i = 2; i <= number / 2; ++i) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

}
