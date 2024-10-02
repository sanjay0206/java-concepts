package com.corejava.basics.oops.nestedclasses;

public class MainClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.heyThere();

        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.whatsUp();
    }
}

/*
Hey there!!
Here' Johnny
What's up from the Inner Class
*/