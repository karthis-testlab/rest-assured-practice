package com.json.response.validation;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class CheckKeyPresence {

	public static void main(String[] args) {
		
		baseURI = "https://reqres.in/api";
		
		given()
		  .when()
		  .get("/users")
		  .then()
		  .assertThat()
		  .body("data[0]", hasKey("email"));
	

	}

}