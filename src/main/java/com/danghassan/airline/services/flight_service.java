package com.danghassan.airline.services;

import com.danghassan.airline.model.flight;
import com.danghassan.airline.repository.flight_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class flight_service {
    @Autowired
    private flight_repo flightRepository;

    public List<flight> getAllflights() {
        return flightRepository.findAll();
    }

    public flight saveflight(flight flight) {
        return flightRepository.save(flight);
    }

    public flight getflightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public flight updateflight(Long id, flight flightDetails) {
        Optional<flight> optionalflight = flightRepository.findById(id);
        if (optionalflight.isPresent()) {
            flight flight = optionalflight.get();
            flight.setDepartureCity(flightDetails.getDepartureCity());
            flight.setArrivalCity(flightDetails.getArrivalCity());
            flight.setDepartureTime(flightDetails.getDepartureTime());
            flight.setArrivalTime(flightDetails.getArrivalTime());
            flight.setNumberOfSeats(flightDetails.getNumberOfSeats());
            flight.setDepartureAirport(flightDetails.getDepartureAirport());
            flight.setArrivalAirport(flightDetails.getArrivalAirport());
            flight.setPlane(flightDetails.getPlane());
            return flightRepository.save(flight);
        }
        return null;
    }

    public boolean deleteflight(Long id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<flight> searchflights(String departureCity, String arrivalCity, LocalDate departureDate) {
        return flightRepository.findByDepartureCityAndArrivalCityAndDepartureTimeBetween(
                departureCity, arrivalCity, departureDate.atStartOfDay(), departureDate.atTime(LocalTime.MAX));
    }
}
