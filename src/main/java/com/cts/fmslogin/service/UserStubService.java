package com.cts.fmslogin.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.cts.fmslogin.constants.Role;
import com.cts.fmslogin.model.User;

import reactor.core.publisher.Mono;

@Service
public class UserStubService {
	
	//username:passwowrd -> user:user
	private final String userUsername = "user";// password: user
	private final User user = new User(userUsername, "user", true, Arrays.asList(Role.ROLE_USER));
	
	//username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final User admin = new User(adminUsername, "admin", true, Arrays.asList(Role.ROLE_ADMIN));
	
	public Mono<User> findByUsername(String username) {
		if (username.equals(userUsername)) {
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}
	}
	
}