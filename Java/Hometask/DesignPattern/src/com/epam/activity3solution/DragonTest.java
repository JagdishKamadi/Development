package com.epam.activity3solution;

public class DragonTest {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        dragon.setAge(6);
        System.out.println("Can fly   : "+dragon.fly());
        System.out.println("Can crawl : "+dragon.crawl());
        System.out.println();

        Dragon dragon2 = new Dragon();
        dragon2.setAge(1);
        System.out.println("Can fly   : "+dragon2.fly());
        System.out.println("Can crawl : "+dragon2.crawl());
        System.out.println();

        Dragon dragon3 = new Dragon();
        dragon3.setAge(10);
        System.out.println("Can fly   : "+dragon3.fly());
        System.out.println("Can crawl : "+dragon3.crawl());
    }
}
