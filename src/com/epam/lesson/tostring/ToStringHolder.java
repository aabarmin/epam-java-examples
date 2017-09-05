package com.epam.lesson.tostring;

public class ToStringHolder {
    private int age;
    private String name;

    public ToStringHolder(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ToStringHolder{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        final ToStringHolder vasya = new ToStringHolder(10, "Vasya");
        System.out.println(vasya);

        Converter converter = new FormattedConverter();
        System.out.println(converter.convert(vasya));

        converter = new DieConverter();
        System.out.println(converter.convert(vasya));
    }
}
