package com.servicenow.api.test;

import java.io.File;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.utils.Config;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class IncidentTableTest {
	
	@Test
	public void shouldUserAbleToCreateNewIncident() {
		RestAssured.given()
        .auth()
        .basic(Config.getUserName(), Config.getPassword())  
        .header("Content-Type", "application/json")
        .when()
        .body(new File("./request-payload/Create-Incident.json"))  
        .post("https://"+Config.getDomainName()+".service-now.com/api/now/table/incident")
        .then().log().all()
        .assertThat()
        .statusCode(201)
        .contentType(ContentType.JSON);
	}
	
	@Test
	public void shouldUserAbleToGetAllIncidents() {
		List<String> list = RestAssured.given()
		           .auth()
		           .basic(Config.getUserName(), Config.getPassword())		           
		           .when()
		           .get("https://"+Config.getDomainName()+".service-now.com/api/now/table/incident")
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .contentType(ContentType.JSON)
		           .extract()
		           .jsonPath()
		           .getList("result.findAll{it.category == 'hardware'}.sys_id");
		System.out.println(list.size());
		System.out.println(list);
	}
	
	@Test
	public void shouldUserAbleToGetASingleIncident() {
		RestAssured.given()
        .auth()
        .basic(Config.getUserName(), Config.getPassword())        
        .when()
        .get("https://"+Config.getDomainName()+".service-now.com/api/now/table/incident/ff4c21c4735123002728660c4cf6a758")
        .then()
        .assertThat()
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"))
        .contentType(ContentType.JSON);
	}
	
	@Test
	public void shouldUserAbleToCreateOAuthToken() {
		String access_token = RestAssured.given()
				.contentType("application/x-www-form-urlencoded")
				.formParam("grant_type", "password")
				.formParam("client_id", Config.getClientId())
				.formParam("client_secret", Config.getClientSecret())
				.formParam("username", Config.getUserName())
				.formParam("password", Config.getPassword())		
				.when()
				.post("https://" + Config.getDomainName() + ".service-now.com/oauth_token.do")
				.then()
				.assertThat().statusCode(200).statusLine(Matchers.containsString("OK"))
				.contentType(ContentType.JSON)
				.extract().jsonPath().getString("access_token");
		System.out.println(access_token);
	}
	
	
}