package com.example.demo.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private int DeptId;
	private String DeptName;
	private String Location;

	@OneToMany(mappedBy = "deptObj")
	@JsonIgnoreProperties("deptObj")
	private List<Employee> employee;


	
	public int getDeptId() {
		return this.DeptId;
	}
	public void setDeptId(int deptId) {
		this.DeptId = deptId;
	}
	public String getDeptName() {
		return this.DeptName;
	}
	public void setDeptName(String deptName) {
		this.DeptName = deptName;
	}
	public String getLocation() {
		return this.Location;
	}
	public void setLocation(String location) {
		this.Location = location;
	}
	public Department(int deptId, String deptName, String location) {
		super();
		this.DeptId = deptId;
		this.DeptName = deptName;
		this.Location = location;
	}
	public Department() {
		super();
		// Default constructor
	}
}
