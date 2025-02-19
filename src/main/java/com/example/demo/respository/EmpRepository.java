package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findBySalary(double salary);
    List<Employee> findByDesignation(String designation);  // New method
    List<Employee> findByEmpName(String EmpName);
    List<Employee> findBySalaryAndDesignation(double salary,String designation);
    List<Employee> findBySalaryGreaterThanEqual(double salary);
    List<Employee> findBySalaryBetween(double lowsalary,double highsalary);
//    
    List<Employee> findByDeptObjDeptName(String DeptName);
    
    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(emp.salary) FROM Employee emp)")
    List<Employee> getEmpWithMaxSalary();

   
}
