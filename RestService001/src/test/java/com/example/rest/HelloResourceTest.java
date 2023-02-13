package com.example.rest;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloResourceTest {
	private static final URI baseUri = URI.create("http://localhost:8080/RestService001/");
	private ClientConfig config;
	private Client client;
	private WebTarget target;

	@Before
	public void setup() {
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		target = client.target(baseUri);
	}

	@After
	public void tearDown() {
		client.close();
	}

	@Test
	public void testGetTextPlainData() {
		String response = target.path("rest/hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response);
		assertEquals(response, "Hello, World!");
	}

	@Test
	public void testGetJsonData() throws ParseException {
		String response = target.path("rest/hello").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonResponse = (JSONObject)parser.parse(response);
		JSONObject msgObject = (JSONObject)jsonResponse.get("message");
		String msgHello = (String)msgObject.get("hello");
		String msgWelcome = (String)msgObject.get("welcome");

		System.out.println("Hello Message: "+msgHello);
		System.out.println("Welcome Message: "+msgWelcome);
		assertEquals(msgHello, "Hello, World!");
		assertEquals(msgWelcome, "You are welcome!");	
	}
	
	@Test
	public void testGetHtmlData() {
		String response = target.path("rest/hello").request().accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(response);
	}

	@Test
	public void testGetXmlData() {
		String response = target.path("rest/hello").request().accept(MediaType.TEXT_XML).get(String.class);
		System.out.println(response);
	}
}
