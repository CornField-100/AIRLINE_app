package com.danghassan.airline.repository;

import com.danghassan.airline.model.airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface airport_repo extends JpaRepository<airport, Long> {}
