package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Department;
import com.example.demo.services.DepartmentServices;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/add")
    public Department addDept(@RequestBody Department dept) {
        return departmentServices.addDepartment(dept);
    }
 
    @GetMapping("/viewAll")
    public List<Department> viewAllDepartment() {
        return departmentServices.viewAllDepartments();
    }

    @GetMapping("/view/{id}")
    public Optional<Department> viewDepartmentById(@PathVariable int id) {
        return departmentServices.viewDepartmentById(id);
    }
    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable int id,@RequestBody Department department) {
    	return departmentServices.updateDepartment(id, department);
    }
    
    @PutMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable int id) {
    	 departmentServices.deleteDepartment(id);
    }
}
