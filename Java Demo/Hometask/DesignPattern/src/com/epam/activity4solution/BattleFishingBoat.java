package com.epam.activity4solution;

public class BattleFishingBoat implements BattleShip {

    private FishingBoat fishingBoat ;

    public BattleFishingBoat() {
        fishingBoat = new FishingBoat();
    }

    @Override
    public void fire() {
        System.out.println("Fire....");
    }

    @Override
    public void move() {
        fishingBoat.fish();
        fishingBoat.sail();
    }
}

