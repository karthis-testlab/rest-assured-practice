package com.github.api.practice;

import org.json.JSONObject;

import com.utils.Secret;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class GitHubGraghqlAPI {

	public static void main(String[] args) {
	
		String url = "https://api.github.com/graphql";
		
		String query = """
				
				query {
				  user(login: "karthis-testlab") {
				    name
				  }
				}
				
				""";
		
		RestAssured.given()
		           .header(new Header("Authorization", "Bearer "+Secret.getValue("github.api.token")))
                   .contentType(ContentType.JSON)
                   .log().all()
                   .body(convertToJsonString(query))
                   .post(url)
                   .then()
                   .log().all();
	}
	
	private static String convertToJsonString(String jsonBody) {
		JSONObject obj = new JSONObject();
		obj.put("query", jsonBody);
		return obj.toString();	
	}

}