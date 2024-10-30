package com.danghassan.airline.repository;

import com.danghassan.airline.model.plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface plane_repo extends JpaRepository<plane, Long> {}