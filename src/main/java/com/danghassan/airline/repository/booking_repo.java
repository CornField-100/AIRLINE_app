package com.danghassan.airline.repository;

import com.danghassan.airline.model.booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface booking_repo extends JpaRepository<booking, Long> {}
