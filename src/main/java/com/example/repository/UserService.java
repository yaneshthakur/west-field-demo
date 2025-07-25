package com.example.repository;

import com.example.model.User;
import com.example.service.UserRepository;

import reactor.core.publisher.Mono;

public class UserService {

    private final UserRepository repository = new UserRepository();

    public Mono<User> getUserById(String id) {
        System.out.println(" [Service] Calling repository for user id: " + id);
        return repository.findById(id);
    }
}

