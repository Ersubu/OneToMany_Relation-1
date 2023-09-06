package com.dakr.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.model.Department;
import com.dakr.model.Employee;
import com.dakr.repository.DepartmentRepository;
import com.dakr.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
    private  EmployeeRepository employeeRepository;
	@Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(Employee employee, Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            return employeeRepository.save(employee);
        }
        throw new EntityNotFoundException("Department not found with id: " + departmentId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

   
}
