package com.corejava.basics.oops.inheritance;

interface Dog {
    void makeNoise();
}

interface Cat {
    void makeNoise();
}

class Cog implements Dog, Cat {

    public static void main(String args[]) {
        Cog obj = new Cog();
        obj.makeNoise();
    }

    @Override
    public void makeNoise() {
        System.out.println("Hey! This is Cog.");
    }
}
/* Hey! This is Cog. */