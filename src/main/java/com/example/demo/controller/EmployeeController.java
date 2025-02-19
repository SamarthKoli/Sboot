package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.services.DepartmentServices;
import com.example.demo.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentServices departmentServices;
	
	
	
	@PostMapping("/addEmployee/{deptId}")
	
	public Employee addEmployee(@RequestBody Employee employee,@PathVariable int deptId) {
	  return employeeService.addEmployee(employee, deptId);
	}
	
	@GetMapping("/viewAllEmployee")
	
	public List<Employee> viewAllEmployees(){
		return employeeService.viewAllEmployees();
	}
	
	@GetMapping("/viewEmployeeById/{empid}")
	public Employee viewEmployeeById(@PathVariable 	int empid) {
		return employeeService.viewEmployeeById(empid);
	}
	
	 // Update an existing employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
    
    // Delete an employee by id
    @DeleteMapping("/deleteEmployee/{empid}")
    public String deleteEmployee(@PathVariable int empid) {
        return employeeService.deleteEmployee(empid);
    }
    
    @GetMapping("/viewBySalary/{salary}")
    public List<Employee> findEmployeeBySalaryAndDesignation(@PathVariable double salary) {
        return employeeService.findBySalary(salary);
    }
    @GetMapping("/viewByDesignation/{designation}")
    public List<Employee> getEmployeesByDesignation(@PathVariable String designation) {
        return employeeService.findByDesignation(designation);
    }

    @GetMapping("/viewByEmpName/{empName}")
    public List<Employee> getEmployeesByEmpName(@PathVariable String EmpName) {
        return employeeService.findByEmpName(EmpName);
    }
    
    // Find employees by salary and designation
    @GetMapping("/viewBySalaryAndDesignation/{designation}/{salary}")
    public List<Employee> findEmployeeBySalaryAndDesignation(@PathVariable String designation, 
                                                             @PathVariable double salary) {
        return employeeService.findBySalaryAndDesignation(designation, salary);
    }
    
    // Find employees with salary greater than or equal to a given value
    @GetMapping("/viewBySalaryGte/{salary}")
    public List<Employee> findEmployeeBySalaryGreaterThanEqual(@PathVariable double salary) {
        return employeeService.findBySalaryGreaterThanEqual(salary);
    }
    
    // Find employees with salary between two values
    @GetMapping("/viewBySalaryBetween/{lowSalary}/{highSalary}")
    public List<Employee> findEmployeeBySalaryBetween(@PathVariable double lowSalary, 
                                                      @PathVariable double highSalary) {
        return employeeService.findBySalaryBetween(lowSalary, highSalary);
    }
    
    // Find employees by department name
    @GetMapping("/viewByDeptName/{deptName}")
    public List<Employee> findEmployeeByDeptName(@PathVariable String DeptName) {
        return employeeService.findByDeptObjDeptName(DeptName);
    }
    
    // Get employee(s) with the maximum salary
    @GetMapping("/viewEmpWithMaxSalary")
    public List<Employee> getEmpWithMaxSalary() {
        return employeeService.getEmpWithMaxSalary();
    }
	
	
}
