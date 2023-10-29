package com.corejava.basics.classmembers;

public class Cat {
    public static final int MAX_ENERGY = 100;
    public static final int MIN_ENERGY_FEED_THRESHOLD = 50;
    private static int catCount = 0;
    String name;
    int age;
    int energyRemaining;

    public Cat() {
        this.energyRemaining = MAX_ENERGY; // Initial energy value
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void displayCatDetails() {

    }

    // Method to simulate feeding the cat
    public void feed() {
        System.out.print("Trying to feed " + this.name + ". ");
        if (this.energyRemaining <= MIN_ENERGY_FEED_THRESHOLD) {
            this.energyRemaining += 30;
            System.out.println(this.name + " has been fed with milk. Now energy increased to " + energyRemaining + "%");
        } else {
            System.out.println(this.name + " is not hungry. Feed when energy < " + MIN_ENERGY_FEED_THRESHOLD + "%");
        }
    }

    // Method to simulate cat play
    public void play() {
        if (this.energyRemaining > 0) {
            this.energyRemaining -= 30;;
            System.out.println(this.name + " started playing! Energy remaining --> "+ this.energyRemaining + "%");
        } else {
            System.out.println(this.name + " has no energy left to play.");
        }
    }
}

