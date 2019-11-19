package by.academy.it.rest.dao;

import by.academy.it.rest.config.DaoConfig;
import by.academy.it.rest.config.HibernateConfig;
import by.academy.it.rest.entity.Department;
import by.academy.it.rest.entity.Employee;
import by.academy.it.rest.entity.Meeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HibernateConfig.class, DaoConfig.class})
class DaoTest {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private BaseDao<Department> departmentDao;

    @Autowired
    private BaseDao<Meeting> meetingDao;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    void saveTest() {
        Employee employee = new Employee();
        employee.setFirstName("Yuli");
        employee.setLastName("Slabko");

        employee = employeeDao.save(employee);
        final Employee employeeFromDb = employeeDao.get(employee.getId());

        assertEquals("Yuli", employeeFromDb.getFirstName());
    }

    @Test
    void saveTestTx() {
        Employee employee = new Employee();
        employee.setFirstName("Yuli");
        employee.setLastName("Slabko");

        Employee employee2 = new Employee();
        employee2.setFirstName("Sergey");
        employee2.setLastName("Kruk");
        transactionTemplate.execute((st) -> {
            employeeDao.save(employee2);
            return employeeDao.save(employee);
        });
        final Employee employeeFromDb = employeeDao.get(employee.getId());

        assertEquals("Yuli", employeeFromDb.getFirstName());
    }

    @Test
    void name() {
        Department department = new Department();
        department.setDepartmentName("qa");

        department = departmentDao.save(department);
        final Department departmentFromDb = departmentDao.get(department.getDepartmentId());

        assertEquals("qa", departmentFromDb.getDepartmentName());
    }
}
