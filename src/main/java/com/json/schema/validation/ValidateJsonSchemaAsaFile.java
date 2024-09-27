package com.json.schema.validation;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ValidateJsonSchemaAsaFile {

	public static void main(String[] args) {
		
		Response response = RestAssured.given()
		           .when()
		           .get("https://demostore.gatling.io/api/category");
		
		response.then().assertThat()
		        .body(JsonSchemaValidator
		        		.matchesJsonSchema(new File("./json-schema.json")));
		
		System.out.println("*****Testcase Passed!*****");
		

	}

}