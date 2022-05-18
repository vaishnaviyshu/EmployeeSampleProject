package com.ust.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Employee;
import com.ust.service.IEmpService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	IEmpService empserObj;
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		int iobj=empserObj.addEmployee(emp);
		String mg="Employee id "+iobj+" Record inserted Successfully ";
		return new ResponseEntity<String>(mg,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		String mg;
		boolean bobj=empserObj.isPresent(emp.getEmpid());
		if(bobj) {
			empserObj.updateEmployee(emp);
			mg= "Employee Record updated  Successfully ";
			return new ResponseEntity<String>(mg,HttpStatus.OK);
		}else {		
			mg= "No DataFound Based on EmpId ";
			return new ResponseEntity<String>(mg,HttpStatus.OK);
		}	
	}

	
	@GetMapping("/search/{id}")
	public Optional<Employee> searchEmployeeById(@PathVariable int id){
			Optional<Employee> em=empserObj.getEmployeeById(id);
			return em;
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
		String mg;
		boolean bobj=empserObj.isPresent(id);
		if(bobj) {
			empserObj.deleteById(id);
			mg="Employee  Record deleted Successfully ";
		}
		else {
			mg="Employee  Record not found ";
		}
		
		return new ResponseEntity<String>(mg,HttpStatus.OK);
	}
	
	
	@GetMapping("/list")
	public List<Employee> listAllRecordsEmp(){
		List<Employee> em=empserObj.listAllrecords();
			return em;
	
	}
}
