package com.danghassan.airline.controller;

import com.danghassan.airline.model.booking;
import com.danghassan.airline.services.booking_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class booking_controller {
    @Autowired
    private booking_service bookingService;

    @PostMapping
    public booking bookFlight(@RequestParam Long clientId, @RequestParam Long flightId) {
        return bookingService.bookFlight(clientId, flightId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<booking> getBookingById(@PathVariable Long id) {
        booking booking = bookingService.getbookingById(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        boolean isDeleted = bookingService.deletebooking(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
