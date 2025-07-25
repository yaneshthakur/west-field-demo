package com.example.service;


import java.time.Duration;
import java.time.LocalTime;

import com.example.model.User;

import reactor.core.publisher.Mono;

public class UserRepository {

    public Mono<User> findById(String id) {
        System.out.println("📡 [Repo] Received DB call for id: " + id);
        
//        return Mono.just(new User(id, "YAnesh_" + id))
//        		.doOnNext(user);

        // Simulate async DB with a delay of 2 seconds
        return Mono.just(new User(id, "Reactive_" + id))
        		 .delayElement(Duration.ofSeconds(5)) // Simulating DB delay
                 .doOnSubscribe(subs -> log(" [Repo] Starting simulated DB fetch..."))
                 .doOnNext(user -> log(" [Repo] Fetched user: " + user.getName()));
    }
    
    
    private void log(String message) {
        System.out.println(LocalTime.now() + " [Thread: " + Thread.currentThread().getName() + "] " + message);
    }
}