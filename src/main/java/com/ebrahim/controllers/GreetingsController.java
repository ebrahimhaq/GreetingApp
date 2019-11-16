package com.ebrahim.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@RequestMapping("/greeting")
	public ResponseEntity<String> greetings(@RequestParam(value="userId") Optional<String> userId,
			@RequestParam(value="accountName") String accountName, @RequestParam(value="accountType") String accountType) {
		
		if (userId.isPresent() && accountName.equalsIgnoreCase("personal") && Long.parseLong(userId.get().toString()) >= 0) {

			return ResponseEntity.status(HttpStatus.OK).body("Hi, userId " + userId.get().toString());

		}
		else if (accountName.equalsIgnoreCase("business")
				&& accountType.equalsIgnoreCase("small")) {

			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Error: Path is not yet implemented.");
			
		} else if (accountName.equalsIgnoreCase("business")
				&& accountType.equalsIgnoreCase("big")) {

			return ResponseEntity.status(HttpStatus.OK).body("Welcome, business user!");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Please check inputs.");
	}
}
