/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 021 21.10.2014
 */
package by.academy.it.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.academy.it.rest.entity.Employee;

import javax.persistence.EntityManagerFactory;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(EntityManagerFactory factory) {
        super(Employee.class, factory);
    }

    @Override
    public List<Employee> getEmployee() {
        return getSession()
                .createQuery("from Employee")
                .getResultList();
    }
}
