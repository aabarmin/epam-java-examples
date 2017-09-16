package com.epam.lesson.innerclasses.statical;

public class TopParentClass {
    public static void main(String[] args) {
        final InnerStaticClass staticClass = new InnerStaticClass();
        staticClass.sayHello();
    }

    public static class InnerStaticClass {
        public void sayHello() {
            System.out.println("Hello");
        }
    }
}
