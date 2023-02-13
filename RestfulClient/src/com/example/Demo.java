package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		System.out.println(response.statusCode());
		
		Optional<String> firstValue = response.headers().firstValue("Content-Type");
		System.out.println(firstValue);
		
		String body = response.body();
		System.out.println(body);
	}

}
