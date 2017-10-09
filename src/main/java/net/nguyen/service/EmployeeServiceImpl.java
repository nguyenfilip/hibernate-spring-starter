package net.nguyen.service;

import net.nguyen.dao.EmployeeDao;
import net.nguyen.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void create(Employee e) {
        employeeDao.create(e);
    }

    @Override
    public void findById(Long id) {
        employeeDao.findById(id);
    }
}
