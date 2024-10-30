package com.danghassan.airline.services;

import com.danghassan.airline.model.clients;
import com.danghassan.airline.repository.clients_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clients_service {

    @Autowired
    private clients_repo clientRepository;

    public List<clients> getAllClients() {
        return clientRepository.findAll();
    }

    public clients saveClient(clients client) {
        return clientRepository.save(client);
    }

    public clients getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public clients updateClient(Long id, clients clientDetails) {
        Optional<clients> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clients client = optionalClient.get();
            client.setFirstname(clientDetails.getFirstname());
            client.setLastname(clientDetails.getLastname());
            client.setAddress(clientDetails.getAddress());
            client.setEmail(clientDetails.getEmail());
            client.setPhone(clientDetails.getPhone());
            client.setBirthdate(clientDetails.getBirthdate());
            client.setPassportNumber(clientDetails.getPassportNumber());
            return clientRepository.save(client);
        }
        return null;
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
