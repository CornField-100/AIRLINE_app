package com.danghassan.airline.repository;

import com.danghassan.airline.model.clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clients_repo extends JpaRepository<clients, Long> {}
