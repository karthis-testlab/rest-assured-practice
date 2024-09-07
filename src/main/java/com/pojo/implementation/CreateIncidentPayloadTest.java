package com.pojo.implementation;

import com.google.gson.Gson;

public class CreateIncidentPayloadTest {

	private static String json;

	public static void main(String[] args) {
		
		CreateIncidentPayload payload = new CreateIncidentPayload();
		payload.setCaller_id("j8470ghbngkg2387903572hjehgvnb");
		payload.setDescription("Test Description");
		payload.setShort_description("Test Short Description");
		
		Gson gson = new Gson();
		json = gson.toJson(payload);
		
		System.out.println(json);

	}

}
