package com.servicenow.api.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.utils.Config;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class IncidentTableTest {
	
	//@Test
	public void shouldUserAbleToGetAllIncidents() {
		RestAssured.given()
		           .auth()
		           .basic(Config.getUserName(), Config.getPassword())
		           .log()
		           .all()
		           .when()
		           .get("https://"+Config.getDomainName()+".service-now.com/api/now/table/incident")
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200)
		           .contentType(ContentType.JSON);
	}
	
	//@Test
	public void shouldUserAbleToGetASingleIncident() {
		RestAssured.given()
        .auth()
        .basic(Config.getUserName(), Config.getPassword())
        .log()
        .all()
        .when()
        .get("https://"+Config.getDomainName()+".service-now.com/api/now/table/incident/ff4c21c4735123002728660c4cf6a758")
        .then()
        .log()
        .all()
        .assertThat()
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"))
        .contentType(ContentType.JSON);
	}
	
	@Test
	public void shouldUserAbleToCreateOAuthToken() {
		RestAssured.given()
		           .contentType("application/x-www-form-urlencoded")
		           .formParam("grant_type", "password")
		           .formParam("client_id", Config.getClientId())
		           .formParam("client_secret", Config.getClientSecret())
		           .formParam("username", Config.getUserName())
		           .formParam("password", Config.getPassword())
		           .log()
		           .all()
		           .when()
		           .post("https://"+Config.getDomainName()+".service-now.com/oauth_token.do")
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.containsString("OK"))
		           .contentType(ContentType.JSON);
	}
	
	
}