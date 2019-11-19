package by.academy.it.rest.config;

import by.academy.it.rest.dao.BaseDao;
import by.academy.it.rest.dao.EmployeeDao;
import by.academy.it.rest.dao.EmployeeDaoImpl;
import by.academy.it.rest.entity.Department;
import by.academy.it.rest.entity.Meeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class DaoConfig {

    @Bean
    public EmployeeDao employeeDao(EntityManagerFactory emf) {
        return new EmployeeDaoImpl(emf);
    }

    @Bean
    public BaseDao<Department> departmentDao(EntityManagerFactory emf) {
        return new BaseDao<>(Department.class, emf);
    }

    @Bean
    public BaseDao<Meeting> meeting(EntityManagerFactory emf) {
        return new BaseDao<>(Meeting.class, emf);
    }
}
