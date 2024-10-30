package com.danghassan.airline.controller;

import com.danghassan.airline.model.airport;
import com.danghassan.airline.services.airport_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class airport_controller {
    @Autowired
    private airport_service airportService;

    @GetMapping
    public List<airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping
    public airport createAirport(@RequestBody airport airport) {
        return airportService.saveAirport(airport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<airport> getAirportById(@PathVariable Long id) {
        airport airport = airportService.getAirportById(id);
        return airport != null ? ResponseEntity.ok(airport) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<airport> updateAirport(@PathVariable Long id, @RequestBody airport airportDetails) {
        airport updatedAirport = airportService.updateAirport(id, airportDetails);
        return updatedAirport != null ? ResponseEntity.ok(updatedAirport) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        boolean isDeleted = airportService.deleteAirport(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
