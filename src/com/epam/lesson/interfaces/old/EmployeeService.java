package com.epam.lesson.interfaces.old;

public interface EmployeeService {
    CommonEmployee getById(int id);

    CommonEmployee save(CommonEmployee toSave);
}
