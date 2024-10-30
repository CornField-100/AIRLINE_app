package com.danghassan.airline.services;

import com.danghassan.airline.model.users;
import com.danghassan.airline.repository.users_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class users_service {
    @Autowired
    private users_repo userRepository;

    public List<users> getAllUsers() {
        return userRepository.findAll();
    }

    public users saveUser(users user) {
        return userRepository.save(user);
    }

    public users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public users updateUser(Long id, users userDetails) {
        Optional<users> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            users user = optionalUser.get();
            user.setFirstname(userDetails.getFirstname());
            user.setLastname(userDetails.getLastname());
            user.setAddress(userDetails.getAddress());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            user.setBirthdate(userDetails.getBirthdate());
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
