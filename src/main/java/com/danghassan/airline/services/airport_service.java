package com.danghassan.airline.services;

import com.danghassan.airline.model.airport;
import com.danghassan.airline.repository.airport_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class airport_service {

    @Autowired
    private airport_repo airportRepository;

    public List<airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public airport saveAirport(airport airport) {
        return airportRepository.save(airport);
    }

    public airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public airport updateAirport(Long id, airport airportDetails) {
        Optional<airport> optionalAirport = airportRepository.findById(id);
        if (optionalAirport.isPresent()) {
            airport airport = optionalAirport.get();
            airport.setName(airportDetails.getName());
            airport.setCountry(airportDetails.getCountry());
            airport.setCity(airportDetails.getCity());
            return airportRepository.save(airport);
        }
        return null;
    }

    public boolean deleteAirport(Long id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
