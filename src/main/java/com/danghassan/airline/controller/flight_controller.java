package com.danghassan.airline.controller;

import com.danghassan.airline.model.flight;
import com.danghassan.airline.services.flight_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class flight_controller {
    @Autowired
    private flight_service flightService;

    @GetMapping
    public List<flight> getAllflights() {
        return flightService.getAllflights();
    }

    @PostMapping
    public flight saveflight(@RequestBody flight flight) {
        return flightService.saveflight(flight);
    }

    @GetMapping("/{id}")
    public ResponseEntity<flight> getflightById(@PathVariable Long id) {
        flight flight = flightService.getflightById(id);
        return flight != null ? ResponseEntity.ok(flight) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<flight> updateflight(@PathVariable Long id, @RequestBody flight flightDetails) {
        flight updatedflight = flightService.updateflight(id, flightDetails);
        return updatedflight != null ? ResponseEntity.ok(updatedflight) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteflight(@PathVariable Long id) {
        boolean isDeleted = flightService.deleteflight(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<flight> searchflights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {
        return flightService.searchflights(departureCity, arrivalCity, departureDate);
    }
}
