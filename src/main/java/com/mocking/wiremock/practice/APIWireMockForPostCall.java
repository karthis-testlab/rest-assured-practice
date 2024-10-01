package com.mocking.wiremock.practice;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class APIWireMockForPostCall {

	public static void main(String[] args) {
		
		WireMockServer mockServer = new WireMockServer(8585);
		mockServer.start();

		mockServer.stop();
	}

}