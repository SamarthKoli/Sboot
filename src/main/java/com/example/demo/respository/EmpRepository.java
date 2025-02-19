package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findBySalary(double Salary);

}
