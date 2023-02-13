package com.example.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;

@Path("/hello")
public class HelloResource {
	
	@POST
	public String postMultivalued(MultivaluedMap<String, String> map) {
		if (map.get("fname") != null && map.get("lname") != null) {
			String fname = map.get("fname").get(0);
			String lname = map.get("lname").get(0);
			return "Your name: "+fname+" "+lname;
		}
		
		return "Received nothing";
	}


}
