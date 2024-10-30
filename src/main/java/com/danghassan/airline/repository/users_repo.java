package com.danghassan.airline.repository;

import com.danghassan.airline.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface users_repo extends JpaRepository<users, Long> {}
