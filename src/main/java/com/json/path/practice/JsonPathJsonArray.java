package com.json.path.practice;

import io.restassured.path.json.JsonPath;

public class JsonPathJsonArray {

	public static void main(String[] args) {
		String jsonArray = """
				[
				  {
				   "firstName": "Raj",
				   "lastName": "Kumar"
				  },
				  {
				   "firstName": "Karthi",
				   "lastName": "Keyan"
				  }
				]
				""";
		JsonPath jsonPath = new JsonPath(jsonArray);
		System.out.println(jsonPath.getList("$").size());
	}

}
