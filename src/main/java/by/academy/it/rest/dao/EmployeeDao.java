package by.academy.it.rest.dao;

import java.util.List;
import by.academy.it.rest.entity.Employee;

public interface EmployeeDao extends Dao<Employee> {
    List<Employee> getEmployee();
}
