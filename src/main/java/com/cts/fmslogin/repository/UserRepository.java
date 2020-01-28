package com.cts.fmslogin.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fmslogin.model.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository	extends ReactiveCrudRepository<User, String> {
	
	
	//public Mono<User> findByUsername(String username);

}
