package com.json.path.practice;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class InlineAssertionPractice {
	
	@Test(enabled = false)
	public void withoutInlineAssertions() {
		
		String jsonResponse = RestAssured
		    .given()
		        .log()
	            .all()
		        .baseUri("https://restful-booker.herokuapp.com/auth")
		        .body("{\n"
		        		+ "    \"username\" : \"admin\",\n"
		        		+ "    \"password\" : \"password123\"\n"
		        		+ "}")
		        .contentType(ContentType.JSON)
		    .when()
		        .post()
		    .then()
		        .log()
		        .all()
		        .extract()
		        .asString();
		
		JsonPath jsonPath = new JsonPath(jsonResponse);
		Assert.assertNotNull(jsonPath.get("token"));
	}
	
	@Test
	public void withInlineAssertions() {
		RestAssured
		    .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body("{\n"
        		        + "    \"username\" : \"admin\",\n"
        		        + "    \"password\" : \"password123\"\n"
        		        + "}")
                .contentType(ContentType.JSON)
            .when()
                .post()
            .then()
                .log()
                .all()
                .body("token", Matchers.notNullValue())
                .body("token.length()", Matchers.is(15))
                .body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

}