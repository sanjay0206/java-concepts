package com.corejava.reflection;

public class Cat {

    private final String name; 
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void thisIsPublicStaticMethod() {
        System.out.println("I'm public and static!");
    }

    private static void thisIsPrivateStaticMethod() {
        System.out.println("Hey, I'm private and static!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void makeAnonymousSound(String sound) {
        System.out.println(sound);
    }

    public void meow() {
        System.out.println("Cat is saying meow!!");
    }

    private void hetThisIsPrivate() {
        System.out.println("How did you call this??");
    }

}
