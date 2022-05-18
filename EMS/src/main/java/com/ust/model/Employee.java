package com.ust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data 

//@NoArgsConstructor 
@RequiredArgsConstructor 
@AllArgsConstructor 	
@Entity 
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer empid;
	
	@Column(name="empcode",length=50)
	private String empcode;
	
	@Column(name="empname",length=100)
	private String empname;
	
	@Column(name="designation",length=100)
	private String designation;
	
	@Column(name="dept",length=100)
	private String dept;
	
	@Column(name="address",length=500)
	private String address;
}

