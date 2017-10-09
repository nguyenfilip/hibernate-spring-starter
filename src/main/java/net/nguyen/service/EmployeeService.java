package net.nguyen.service;

import net.nguyen.entity.Employee;

public interface EmployeeService {

    void create(Employee e);
    void findById(Long id);
}
