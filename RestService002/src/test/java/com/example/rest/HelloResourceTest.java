package com.example.rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class HelloResourceTest {
	private static final URI baseUri = URI.create("http://localhost:8080/RestService002/");
	private ClientConfig config;
	private Client client;
	private WebTarget target;
	
	@BeforeAll
	public void setup() {
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		target = client.target(baseUri);
	}
	
	@AfterAll
	public void tearDown() {
		client.close();
	}
	
	@Test
	public void testPostMultivalued() {
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("fname", "Kimba");
		map.add("lname", "Khan");
		
		String response = target.path("rest/hello").request().post(Entity.form(map), String.class);
		System.out.println("Response: "+response);
	}

}
