package com.mocking.wiremock.practice;

import org.hamcrest.Matchers;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

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
		
		RestAssured.given()
		           .header(new Header("Content-Type", "application/json"))
		           .when()
		           .body("{\"name\": \"Dummy\"}")
		           .log().all()
		           .post("http://localhost:8585/some/endpoint")		           
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(201)
		           .statusLine(Matchers.containsString("Created"))
		           .contentType(ContentType.JSON);
		           
		//Test

		mockServer.stop();
	}

}