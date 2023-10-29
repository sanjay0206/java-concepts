package com.corejava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;

public class ReflectionTutorial {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://monstar-lab.com/global/");
            String protocol = url.getProtocol();
            System.out.println(protocol); // https

            /* From the snippet above we can see that I have just made an instance of class URL and called method
               getProtocol() and printed the output. Now we can see that the decision of which method to call was
               taken at the compile time. Let’s do the same thing with Reflection API.
             */
            Class<?> type = Class.forName("java.net.URL");
            Method method = type.getMethod("getProtocol");

            Constructor<?> constructor = type.getConstructor(String.class);
            Object instance = constructor.newInstance("http://monstar-lab.com/global/");
            Object methodCallResult = method.invoke(instance);
            System.out.println(methodCallResult); // http

            /*  Now in the snippet above you can see a bit more complex code than the previous one but will be
                giving you the same result. The interesting part is, in compile time we did not decide which
                method to call. We left it to be decided on runtime.
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
