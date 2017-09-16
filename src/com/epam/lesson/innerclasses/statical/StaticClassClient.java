package com.epam.lesson.innerclasses.statical;

public class StaticClassClient {
    public static void main(String[] args) {
        final TopParentClass.InnerStaticClass staticClass =
                new TopParentClass.InnerStaticClass();
        staticClass.sayHello();
    }
}
