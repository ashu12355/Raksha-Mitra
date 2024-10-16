package com.rakshamitra.RakshaMitra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RakshaMitraApplication {

	public static void main(String[] args) {
		SpringApplication.run(RakshaMitraApplication.class, args);
		PasswordEncoder encoder = new BCryptPasswordEncoder();
    System.out.println(encoder.encode("javaa"));
	}
}
