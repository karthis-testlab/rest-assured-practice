package com.json.schema.validation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ValidateJsonSchemaAsaString {

	public static void main(String[] args) {
		
		var jsonSchema = """
				{
				  "$schema": "http://json-schema.org/draft-04/schema#",
				  "type": "array",
				  "items": [
				    {
				      "type": "object",
				      "properties": {
				        "id": {
				          "type": "integer"
				        },
				        "name": {
				          "type": "string"
				        },
				        "slug": {
				          "type": "string"
				        },
				        "sorting": {
				          "type": "integer"
				        }
				      },
				      "required": [
				        "id",
				        "name",
				        "slug",
				        "sorting"
				      ]
				    }
				  ]
				}
												""";
		
		Response response = RestAssured.given()
		           .when()
		           .get("https://demostore.gatling.io/api/category");
		
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

	}

}