package net.nguyen.dao;

import net.nguyen.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Employee e) {
        em.persist(e);
    }

    public Employee findById(Long id) {
        return null;
    }

    public List<Employee> findByName(String name) {
        return null;
    }
}
