package com.cts.fmslogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fmslogin.model.AuthRequest;
import com.cts.fmslogin.model.AuthResponse;
import com.cts.fmslogin.repository.UserRepository;
import com.cts.fmslogin.security.PBKDF2Encoder;
import com.cts.fmslogin.util.JWTUtil;

import reactor.core.publisher.Mono;


@RestController
public class AuthenticationREST {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PBKDF2Encoder passwordEncoder;

//	@Autowired
//	private UserStubService userService;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
//	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
		return userService.findByUsername(ar.getUsername()).map((userDetails) -> {
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	*/
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
//		return userRepository.findByUsername(ar.getUsername()).map((userDetails) -> {
//			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
//				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
//			} else {
//				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//			}
//		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
		return userRepository.findById(ar.getUsername()).map((userDetails) -> {
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	

}