package com.practice.fistproject.mapper;

import com.practice.fistproject.dto.EmployeeDto;
import com.practice.fistproject.entity.Employee;

public class EmployeeMapper {
    // Map employee jpa entity to dto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );

        
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        );
    }
    
}
