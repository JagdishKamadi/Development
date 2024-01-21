package com.epam.activity3solution;

class Dragon {
    Bird bird = new Bird();

    Lizard lizard = new Lizard();

    private int age;

    public void setAge(int age) {
        bird.age=age;
        lizard.age = age;
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }
}
