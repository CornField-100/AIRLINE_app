package com.danghassan.airline.controller;

import com.danghassan.airline.model.users;
import com.danghassan.airline.services.users_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class users_controller {
    @Autowired
    private users_service userService;

    @GetMapping
    public List<users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public users createUser(@RequestBody users user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<users> getUserById(@PathVariable Long id) {
        users user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<users> updateUser(@PathVariable Long id, @RequestBody users userDetails) {
        users updatedUser = userService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
