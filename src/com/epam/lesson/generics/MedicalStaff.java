package com.epam.lesson.generics;

import java.util.ArrayList;
import java.util.List;

public class MedicalStaff {
    public static void main(String[] args) {
        // List<? super Doctor> list7 = new ArrayList<HeadDoctor>(); // error
        List<? super Doctor> list6 =
                new ArrayList<Doctor>();
        List<? super Doctor> list5 =
                new ArrayList<MedicalStaff>();
        List<? super Doctor> list4 =
                new ArrayList<Object>();

        // list5.add(new Object()); // error
        // list5.add(new MedicalStaff()); // error
        list5.add(new Doctor());
        list5.add(new HeadDoctor());

        // list4.add(new Object());

        final Object object = list5.get(10);

    }
}
class Doctor extends MedicalStaff {}
class HeadDoctor extends Doctor {}
class Nurse extends MedicalStaff {}

