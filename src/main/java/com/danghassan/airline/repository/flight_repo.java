package com.danghassan.airline.repository;

import com.danghassan.airline.model.flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface flight_repo extends JpaRepository<flight, Long> {
    List<flight> findByDepartureCityAndArrivalCityAndDepartureTimeBetween(
            String departureCity, String arrivalCity, LocalDateTime start, LocalDateTime end);
}
