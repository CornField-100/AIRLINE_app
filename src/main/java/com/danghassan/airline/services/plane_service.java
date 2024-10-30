package com.danghassan.airline.services;

import com.danghassan.airline.model.plane;
import com.danghassan.airline.repository.plane_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class plane_service {
    @Autowired
    private plane_repo planeRepository;

    public List<plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public plane savePlane(plane plane) {
        return planeRepository.save(plane);
    }

    public plane getPlaneById(Long id) {
        return planeRepository.findById(id).orElse(null);
    }

    public plane updatePlane(Long id, plane planeDetails) {
        Optional<plane> optionalPlane = planeRepository.findById(id);
        if (optionalPlane.isPresent()) {
            plane plane = optionalPlane.get();
            plane.setBrand(planeDetails.getBrand());
            plane.setModel(planeDetails.getModel());
            plane.setManufacturingYear(planeDetails.getManufacturingYear());
            return planeRepository.save(plane);
        }
        return null;
    }

    public boolean deletePlane(Long id) {
        if (planeRepository.existsById(id)) {
            planeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
