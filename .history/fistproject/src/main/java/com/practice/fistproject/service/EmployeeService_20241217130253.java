package com.practice.fistproject.service;

import java.util.List;

import com.practice.fistproject.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees(); 

    EmployeeDto updateEmployeeDto(Long employeeId , EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId); 
    
}
