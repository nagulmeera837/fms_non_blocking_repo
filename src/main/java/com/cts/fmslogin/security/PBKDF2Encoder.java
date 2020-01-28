package com.cts.fmslogin.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PBKDF2Encoder implements PasswordEncoder{
	
	@Value("${springbootwebfluxjjwt.password.encoder.secret}")
	private String secret;

	@Value("${springbootwebfluxjjwt.password.encoder.iteration}")
	private Integer iteration;

	@Value("${springbootwebfluxjjwt.password.encoder.keylength}")
	private Integer keylength;
	
	/**
	 * More info (https://www.owasp.org/index.php/Hashing_Java)
	 * @param cs password
	 * @return encoded password
	 */
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
	
	
	
	@Override
	public String encode(CharSequence cs) {
		/*
		 * try { byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
		 * .generateSecret(new PBEKeySpec(cs.toString().toCharArray(),
		 * secret.getBytes(), iteration, keylength)) .getEncoded(); return
		 * Base64.getEncoder().encodeToString(result); } catch (NoSuchAlgorithmException
		 * | InvalidKeySpecException ex) { throw new RuntimeException(ex); }
		 */
		
		return (String) cs;
	}

	@Override
	public boolean matches(CharSequence cs, String string) {
		return encode(cs).equals(string);
	}
	
}
