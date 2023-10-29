package com.corejava.basics.classmembers;

public class Main {
    /* How to determine whether any field or method is Static or Non-static?
       Non-Static -> If method or a field that you're creating only makes sense for an individual object or instance of the class
       Static -> If something is more at the class level or something that should be the same or a shared value among all of your class
                 then it probably makes more sense to be static
    */

    public static final String STORE_NAME = "Cat Galaxy";

    public static void welcome () {
        System.out.println("########## Welcome to " + STORE_NAME + " ##########");
        System.out.println("Initial cat count in " + STORE_NAME + " is " + Cat.getCatCount());
        System.out.println("Things to know before playing with the cats,");
        System.out.println("1) Max energy for a cat: " + Cat.MAX_ENERGY + "%");
        System.out.println("2) Min energy threshold to feed: " + Cat.MIN_ENERGY_FEED_THRESHOLD + "%\n");
    }

    public static void main(String[] args) {
        welcome();
        Cat myCat = new Cat();
        myCat.name = "Stella";
        myCat.age = 8;
        System.out.println("########## Displaying cat details ##########");
        System.out.println("Name: " + myCat.name);
        System.out.println("Age: " + myCat.age);
        System.out.println("Initial energy of " + myCat.name + " is " + myCat.energyRemaining);
        System.out.println("New cat has been created. Now cat count is " + Cat.getCatCount());
        myCat.play();
        myCat.feed();
        myCat.play();
        myCat.feed();
        System.out.println("Current energy of " + myCat.name + " is " + myCat.energyRemaining + "%\n");

        Cat anotherCat = new Cat();
        anotherCat.name = "Smokey";
        anotherCat.age = 3;
        System.out.println("########## Displaying cat details ##########");
        System.out.println("Name: " + anotherCat.name);
        System.out.println("Age: " + anotherCat.age);
        System.out.println("Initial energy of " + anotherCat.name + " is " + anotherCat.energyRemaining);
        System.out.println("New cat has been created. Now cat count is " + Cat.getCatCount());
        anotherCat.play();
        anotherCat.feed();
        System.out.println("Current energy of " + anotherCat.name + " is " + anotherCat.energyRemaining + "%\n");
    }
}
/*
########## Welcome to Cat Galaxy ##########
Initial cat count in Cat Galaxy is 0
Things to know before playing with the cats,
1) Max energy for a cat: 100%
2) Min energy threshold to feed: 50%

########## Displaying cat details ##########
Name: Stella
Age: 8
Initial energy of Stella is 100
New cat has been created. Now cat count is 1
Stella started playing! Energy remaining --> 70%
Trying to feed Stella. Stella is not hungry. Feed when energy < 50%
Stella started playing! Energy remaining --> 40%
Trying to feed Stella. Stella has been fed with milk. Now energy increased to 70%
Current energy of Stella is 70%

########## Displaying cat details ##########
Name: Smokey
Age: 3
Initial energy of Smokey is 100
New cat has been created. Now cat count is 2
Smokey started playing! Energy remaining --> 70%
Trying to feed Smokey. Smokey is not hungry. Feed when energy < 50%
Current energy of Smokey is 70%
*/