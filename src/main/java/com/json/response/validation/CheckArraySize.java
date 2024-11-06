package com.json.response.validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CheckArraySize {

	public static void main(String[] args) {

		baseURI = "https://reqres.in/api";

		given()
		  .when()
		  .get("/users")
		  .then()
		  .assertThat()
		  .body("data.size()", equalTo(6));

	}

}