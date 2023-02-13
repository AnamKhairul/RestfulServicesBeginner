package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTextData() {
		return "Hello, World!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getJsonData() {
		return "{\"name\":\"greeting\","
				+ "\"message\":{\"hello\":\"Hello, World!\", \"welcome\":\"You are welcome!\"}"
				+ "}";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtmlData() {
		return "<html><title>Hello</title><body><h1>Hello, World!</h1><body></html>";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String getXmlData() {
		return "<msg>Hello, World!</msg>";
	}

}
