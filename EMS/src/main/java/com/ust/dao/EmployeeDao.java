package com.ust.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
