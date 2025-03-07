package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
}
