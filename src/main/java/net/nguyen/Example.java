package net.nguyen;

import net.nguyen.entity.Department;
import net.nguyen.entity.Employee;
import net.nguyen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by nguye on 10/9/2017.
 */
@Component
public class Example {

    @Autowired
    private EmployeeService employeeService;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void start() {
        search();
    }



    public void search() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> e = query.from(Employee.class);

        em.getTransaction().commit();
        em.close();
    }


    public Department findDepartment(String depName) {
        EntityManager em = emf.createEntityManager();
        Department dep = em.createQuery("select d from Department d where d.name = :name", Department.class)
                .setParameter("name", depName).getSingleResult();
        em.close();
        return dep;
    }

    public void setupEmployees() {
        Employee filip = new Employee("Filip", 20000);
        Employee jirka = new Employee("Filip", 19000);
        Employee martina = new Employee("Martina", 20000);
        Employee jana = new Employee("Jana", 19000);

        Department engineering = new Department("Engineering");
        Department marketing = new Department("Marketing");
        Department hr = new Department("HR");

        engineering.addEmployee(filip);
        engineering.addEmployee(martina);
        marketing.addEmployee(jirka);
        marketing.addEmployee(jana);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(filip);
        em.persist(jirka);
        em.persist(martina);
        em.persist(jana);

        em.persist(engineering);
        em.persist(marketing);
        em.persist(hr);

        em.getTransaction().commit();
        em.close();

    }
}
