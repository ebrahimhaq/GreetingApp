package com.ebrahim.app;

import java.net.URI;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingAppApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnSuccessForPersonalWithID() throws Exception {

		final String baseUrl = "http://localhost:" + port + "/greeting?userId=1&accountName=personal&accountType=";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals("Hi, userId 1", result.getBody());

	}

	@Test
	public void greetingShouldReturnFailureForBusinessAndSmall() throws Exception {

		final String baseUrl = "http://localhost:" + port + "/greeting?accountName=business&accountType=small";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request not implemented
		Assert.assertEquals(501, result.getStatusCodeValue());
		Assert.assertEquals("Error: Path is not yet implemented.", result.getBody());

	}

	@Test
	public void greetingShouldReturnSuccessForBusinessAndBig() throws Exception {

		final String baseUrl = "http://localhost:" + port + "/greeting?accountName=business&accountType=big";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals("Welcome, business user!", result.getBody());

	}
}