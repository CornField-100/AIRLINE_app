package com.danghassan.airline.controller;

import com.danghassan.airline.model.plane;
import com.danghassan.airline.services.plane_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class plane_controller {
    @Autowired
    private plane_service planeService;

    @GetMapping
    public List<plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @PostMapping
    public plane createPlane(@RequestBody plane plane) {
        return planeService.savePlane(plane);
    }

    @GetMapping("/{id}")
    public ResponseEntity<plane> getPlaneById(@PathVariable Long id) {
        plane plane = planeService.getPlaneById(id);
        return plane != null ? ResponseEntity.ok(plane) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<plane> updatePlane(@PathVariable Long id, @RequestBody plane planeDetails) {
        plane updatedPlane = planeService.updatePlane(id, planeDetails);
        return updatedPlane != null ? ResponseEntity.ok(updatedPlane) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        boolean isDeleted = planeService.deletePlane(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
