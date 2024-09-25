package com.mocking.wiremock.practice;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class APIWireMockForGetCall {

	public static void main(String[] args) {
		
		WireMockServer mockServer = new WireMockServer();
		mockServer.start();
		
		mockServer.stubFor(WireMock.get("/some/endpoint")
				  .willReturn(WireMock.aResponse()
						  .withHeader("Content-Type", "application/json")
						  .withStatus(200)
						  .withBody("{\"message\": \"Hello world!\"}")));
		
		mockServer.stop();

	}

}