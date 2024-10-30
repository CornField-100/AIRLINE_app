package com.danghassan.airline.services;

import com.danghassan.airline.model.booking;
import com.danghassan.airline.model.clients;
import com.danghassan.airline.model.flight;
import com.danghassan.airline.repository.booking_repo;
import com.danghassan.airline.repository.clients_repo;
import com.danghassan.airline.repository.flight_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class booking_service {

    @Autowired
    private booking_repo booking_repo;

    @Autowired
    private clients_repo clients_repo;

    @Autowired
    private flight_repo flight_repo;

    public booking bookFlight(Long clientsId, Long flightId) {
        clients clients = clients_repo.findById(clientsId).orElseThrow();
        flight flight = flight_repo.findById(flightId).orElseThrow();
        booking booking = new booking();
        booking.setClient(clients);
        booking.setFlight(flight);
        return booking_repo.save(booking);
    }

    public booking getbookingById(Long id) {
        return booking_repo.findById(id).orElse(null);
    }

    public boolean deletebooking(Long id) {
        if (booking_repo.existsById(id)) {
            booking_repo.deleteById(id);
            return true;
        }
        return false;
    }
}
