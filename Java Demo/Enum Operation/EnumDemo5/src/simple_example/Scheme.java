package simple_example;

import simple_example.Card;

public enum Scheme implements Card {
    VISA("Visa"),
    MC("VMC");
    public String schemeName;

    Scheme(String schemeName) {
        this.schemeName = schemeName;
    }

    @Override
    public void cardName() {
        System.out.println(schemeName);
    }
}
