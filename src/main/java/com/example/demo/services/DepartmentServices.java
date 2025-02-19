package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Department;
import com.example.demo.respository.DepartmentRepository;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> viewAllDepartments() { // Corrected method name
        return departmentRepository.findAll();
    }

    public Optional<Department> viewDepartmentById(int id) { // Corrected method name
        return departmentRepository.findById(id);
    }
    public Department updateDepartment(int id, Department department) {
    	Optional<Department> dept=departmentRepository.findById(id);
    	if (dept.isPresent()) {
			Department dpt=dept.get();
			dpt.setLocation(department.getLocation());
			return departmentRepository.save(dpt);
		}
    	else {
    		throw new RuntimeException("Department not found");
    	}
    }
    
    public void deleteDepartment(int id) {
    	departmentRepository.deleteById(id);
    }
}
