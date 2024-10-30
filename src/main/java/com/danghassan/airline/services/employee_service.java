package com.danghassan.airline.services;

import com.danghassan.airline.model.employee;
import com.danghassan.airline.repository.employee_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employee_service {

    @Autowired
    private employee_repo employeeRepository;

    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public employee saveEmployee(employee employee) {
        return employeeRepository.save(employee);
    }

    public employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public employee updateEmployee(Long id, employee employeeDetails) {
        Optional<employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employee employee = optionalEmployee.get();
            employee.setFirstname(employeeDetails.getFirstname());
            employee.setLastname(employeeDetails.getLastname());
            employee.setAddress(employeeDetails.getAddress());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPhone(employeeDetails.getPhone());
            employee.setBirthdate(employeeDetails.getBirthdate());
            employee.setEmployeeNumber(employeeDetails.getEmployeeNumber());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

