package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	private int EmpId;
	private String EmpName;
	private String designation; 
	private double salary;  // Ensure lowercase "salary"
	
	@ManyToOne
	@JoinColumn(name = "DeptId") // This is the foreign key column in Employee referencing Department
	@JsonIgnoreProperties("employee") // Ignores the employee list in Department to prevent recursion
	private Department deptObj;
	
	public Employee(String designation) {
		super();
		this.designation = designation;
	}
	
	public Employee() {
		super();
		// Default constructor
	}
	
	public Employee(int empId, String empName, double salary, Department deptObj, String desgination) {
		super();
		EmpId = empId;
		this.designation = desgination;
		EmpName = empName;
		this.salary = salary;
		this.deptObj = deptObj;
	}
	
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public double getSalary() {  
        return salary;  
    }  

    public void setSalary(double salary) {  
        this.salary = salary;  
    }  
	public Department getDeptObj() {
		return deptObj;
	}
	public void setDeptObj(Department deptObj) {
		this.deptObj = deptObj;
	}
	 public String getDesignation() {  
	        return designation;  
	    }  

	    public void setDesignation(String designation) {  
	        this.designation = designation;  
	    }  
}
