package com.epam.lesson.interfaces.old;

public class Client {
    public static void main(String[] args) {
        final DefaultEmployee employee = new DefaultEmployee();

        CommonEmployee commonEmployee = employee;
        commonEmployee.getId();

        Entity entity = employee;
        entity.getId();

        System.out.println(commonEmployee instanceof Entity);

        System.out.println(CommonEmployee.POSITION);
    }
}
