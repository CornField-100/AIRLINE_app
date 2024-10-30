package com.danghassan.airline.controller;

import com.danghassan.airline.model.clients;
import com.danghassan.airline.services.clients_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class clients_controller {
    @Autowired
    private clients_service clientService;

    @GetMapping
    public List<clients> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public clients createClient(@RequestBody clients client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<clients> getClientById(@PathVariable Long id) {
        clients client = clientService.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<clients> updateClient(@PathVariable Long id, @RequestBody clients clientDetails) {
        clients updatedClient = clientService.updateClient(id, clientDetails);
        return updatedClient != null ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        boolean isDeleted = clientService.deleteClient(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
