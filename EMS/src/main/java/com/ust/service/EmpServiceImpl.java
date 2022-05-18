package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.EmployeeDao;
import com.ust.model.Employee;

@Service
public class EmpServiceImpl implements IEmpService{
	
	@Autowired
	EmployeeDao edao;

	@Override
	public Integer addEmployee(Employee e) {
		edao.save(e);
		return e.getEmpid();
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		edao.save(e);
	}

	@Override
	public boolean isPresent(int id) {
	
		return edao.existsById(id);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
//		edao.findById(id);
		return edao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		edao.deleteById(id);
		
	}

	@Override
	public List<Employee> listAllrecords() {
		// TODO Auto-generated method stub
		return edao.findAll();
	}
	
	

}
