package com.corejava.basics.oops.nestedclasses;

public class MainClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.heyThere();

        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.whatsUp();
    }
}

/*
Hey there!!
Here' Johnny
What's up from the Inner Class
*/