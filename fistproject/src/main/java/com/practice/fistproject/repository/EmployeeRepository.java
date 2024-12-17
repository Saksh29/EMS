package com.practice.fistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.fistproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    

    
}
