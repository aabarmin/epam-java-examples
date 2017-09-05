package com.epam.lesson.methods;

import java.lang.reflect.Method;

public class Methods {
    public String property = "value";

    public void method1() {
        System.out.println(property);
        method2();
    }

    public static void method2(){

    }

    public static void main(String[] args) throws Exception {
        final Methods instance1 = new Methods();
        instance1.property = "instance1";

        final Methods instance2 = new Methods();
        instance2.property = "instance2";

        final Method[] methods = Methods.class.getDeclaredMethods();
        final Method method = methods[1];

        method.invoke(instance1);
        method.invoke(instance2);
        method.invoke(null);
    }
}
