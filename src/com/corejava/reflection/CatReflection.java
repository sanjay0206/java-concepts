package com.corejava.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CatReflection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat myCat = new Cat("Stella", 6);

        System.out.println("###############################\n Available fields in Cat class \n###############################");
        Field[] fields = myCat.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field: " + field.getName());
        }
        System.out.println(myCat.getName());
        for (Field field : fields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(myCat, "Jimmy McGill");
            }
        }
        System.out.println(myCat.getName());

        System.out.println("###############################\n Available methods in Cat class \n###############################");
        Method[] methods = myCat.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("#######################");
        for (Method method : methods) {
            switch (method.getName()) {
                case "meow":
                    method.invoke(myCat);
                    break;
                case "makeAnonymousSound":
                    method.invoke(myCat, "Making anonymous sound!!");
                    break;
                case "hetThisIsPrivate":
                    method.setAccessible(true);
                    method.invoke(myCat);
                    break;
                case "thisIsPublicStaticMethod":
                    method.invoke(null);
                    break;
                case "thisIsPrivateStaticMethod":
                    method.setAccessible(true);
                    method.invoke(null);
                    break;
            }
        }
    }
}
/*
###############################
 Available fields in Cat class
###############################
field: name
field: age
Stella
Jimmy McGill
###############################
 Available methods in Cat class
###############################
getName
meow
hetThisIsPrivate
getAge
makeAnonymousSound
thisIsPrivateStaticMethod
thisIsPublicStaticMethod
#######################
Cat is saying meow!!
How did you call this??
Making anonymous sound!!
Hey, I'm private and static!
I'm public and static!
*/
