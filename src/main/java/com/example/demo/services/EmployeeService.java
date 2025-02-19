package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.EmpRepository;

@Service
public class EmployeeService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmpRepository empRepository;
	
	
	public Employee addEmployee(Employee employee,int deptId) {
		Optional<Department>optional=departmentRepository.findById(deptId);
		if (optional.isPresent()) {
			Department department=optional.get();
			employee.setDeptObj(department);
			return empRepository.save(employee);
		}
		return null;
		
	}
	
	
	public List<Employee> viewAllEmployees(){
		
		return empRepository.findAll();
	}
	
	
	public Employee viewEmployeeById(int empid) {
		Optional<Employee>optional= empRepository.findById(empid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	  // Update an existing employee
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optional = empRepository.findById(employee.getEmpId());
        if (optional.isPresent()) {
            Employee existingEmployee = optional.get();
            // Update necessary fields
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setDesignation(employee.getDesignation());
            existingEmployee.setSalary(employee.getSalary());
            // Optionally update department if provided
            if (employee.getDeptObj() != null) {
                existingEmployee.setDeptObj(employee.getDeptObj());
            }
            return empRepository.save(existingEmployee);
        }
        return null;
    }
    
    // Delete an employee by id
    public String deleteEmployee(int empid) {
        Optional<Employee> optional = empRepository.findById(empid);
        if (optional.isPresent()) {
            empRepository.deleteById(empid);
            return "Employee deleted successfully";
        }
        return "Employee not found with id " + empid;
    }
    
    // Custom finder: fetch employees matching both salary and designation
   public List<Employee> findBySalary(double Salary){
       return	empRepository.findBySalary(Salary);
    }
	
	
	
	
	

}
