package net.nguyen.dao;

import net.nguyen.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDao {
    void create(Employee e);
    Employee findById(Long id);
    List<Employee> findByName(String name);
}
