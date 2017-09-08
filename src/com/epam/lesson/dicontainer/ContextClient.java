package com.epam.lesson.dicontainer;

public class ContextClient {
    public static void main(String[] args) throws Exception {
        final Context context = new Context();
        final Bean bean = context.getBean(Bean.class);
        System.out.println(bean != null);
    }
}
