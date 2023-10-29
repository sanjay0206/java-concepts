package com.corejava.basics.exceptions.dog;

public class Dog {
    String name;
    boolean isCollarPutOn;
    boolean isLeashPutOn;
    boolean isMuzzlePutOn;

    public Dog(String name) {
        this.name = name;
    }

    public void putCollar() {
        System.out.println("The collar is on!");
        this.isCollarPutOn = true;
    }

    public void putLeash() {
        System.out.println("The leash is on!");
        this.isLeashPutOn = true;
    }

    public void putMuzzle() {
        System.out.println("The muzzle is on!");
        this.isMuzzlePutOn = true;
    }

    public void walk() throws DogIsNotReadyException {
        System.out.println("We're getting ready for a walk!");
        if (isCollarPutOn && isLeashPutOn && isMuzzlePutOn) {
            System.out.println("Hooray, let's go for a walk! " + name + " is very happy!");
        } else {
            throw new DogIsNotReadyException(name + " is not ready for a walk! Check the gear!");
        }
    }


    public static void main(String[] args) {
        Dog dog = new Dog("Fluffy");
        dog.putCollar();
        //  dog.putLeash();
        dog.putMuzzle();
        try {
            // Leash is not put on so exception will be thrown if we try to take for a walk.
            dog.walk();
        } catch (DogIsNotReadyException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Checking the gear...\n" +
                    "Is the collar on? " + dog.isCollarPutOn + "\n" +
                    "Is the leash on? " + dog.isLeashPutOn + "\n" +
                    "Is the muzzle on? " + dog.isMuzzlePutOn);
        }
    }

}
/*
The collar is on!
The muzzle is on!
We're getting ready for a walk!
Exception occurred: Fluffy is not ready for a walk! Check the gear!
Checking the gear...
Is the collar on? true
Is the leash on? false
Is the muzzle on? true
*/