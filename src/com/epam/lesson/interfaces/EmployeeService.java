package com.epam.lesson.interfaces;

public interface EmployeeService {
    CommonEmployee getById(int id);

    CommonEmployee save(CommonEmployee toSave);
}
