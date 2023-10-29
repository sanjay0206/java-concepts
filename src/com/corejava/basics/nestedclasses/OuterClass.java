package com.corejava.basics.nestedclasses;

public class OuterClass {
    int num = 6;

    public void heyThere() {
        System.out.println("Hey there!!");

        class LocalInnerClass {
            String localInnerClassVariable = "Here' Johnny";

            public void printLocalInnerClassVariable() {
                System.out.println(localInnerClassVariable);
            }
        }
        LocalInnerClass lic = new LocalInnerClass();
        lic.printLocalInnerClassVariable();
    }

    class InnerClass {
        int num = 10;

        public void whatsUp() {
            System.out.println("What's up from the Inner Class");
        }
    }
}
