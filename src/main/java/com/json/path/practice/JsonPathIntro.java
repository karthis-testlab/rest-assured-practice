package com.json.path.practice;

import io.restassured.path.json.JsonPath;

public class JsonPathIntro {
	
	public static void main(String[] args) {
		String jsonString = "{\n"
				+ "   \"code\":200,\n"
				+ "   \"message\":\"Welcome to REST API Session!\"\n"
				+ "}";
		JsonPath json = new JsonPath(jsonString);
		System.out.println(json.getString("message"));
		System.out.println(json.getInt("code"));
	}

}