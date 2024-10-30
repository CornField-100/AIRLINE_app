package com.danghassan.airline.controller;

import com.danghassan.airline.model.employee;
import com.danghassan.airline.services.employee_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class employee_controller {
    @Autowired
    private employee_service employeeService;

    @GetMapping
    public List<employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public employee createEmployee(@RequestBody employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable Long id) {
        employee employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable Long id, @RequestBody employee employeeDetails) {
        employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
