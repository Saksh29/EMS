package com.practice.fistproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.fistproject.dto.EmployeeDto;
import com.practice.fistproject.entity.Employee;
import com.practice.fistproject.exception.ResourceNotFoundException;
import com.practice.fistproject.mapper.EmployeeMapper;
import com.practice.fistproject.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee Id Not exists with given id :" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeDto(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee is not exist eith given id"+ employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setEmail(updateEmployee.getEmail());
        employee.setLastName(updateEmployee.getLastName());

        Employee updatedEmployee = employeeRepository.save(employee);

    return EmployeeMapper.mapToEmployeeDto(updatedEmployee) ;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee is not exist eith given id"+ employeeId)
        );
        employeeRepository.deleteById(employeeId);
        return ;
    }
    

    

}
