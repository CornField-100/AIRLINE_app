package com.danghassan.airline.repository;

import com.danghassan.airline.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employee_repo extends JpaRepository<employee, Long> {}
