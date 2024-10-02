package com.mocking.wiremock.practice;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class APIWireMockForPostCall {

	public static void main(String[] args) {
		
		WireMockServer mockServer = new WireMockServer(8585);
		mockServer.start();
		
		mockServer.stubFor(WireMock.post("/some/endpoint")
				  .willReturn(WireMock.aResponse()
						  .withHeader("Content-Type", "application/json")
						  .withBody("{\"name\": \"Dummy\"}")
						  .withStatus(201)
						  .withBody("{\"success\": \"OK\", \"code\": 201}")));

		mockServer.stop();
	}

}