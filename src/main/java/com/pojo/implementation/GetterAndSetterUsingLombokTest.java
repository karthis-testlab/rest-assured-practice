package com.pojo.implementation;

import org.json.JSONObject;

import com.google.gson.Gson;

public class GetterAndSetterUsingLombokTest {

	public static void main(String[] args) {
		
		GetterAndSetterUsingLombok jsonForm = new GetterAndSetterUsingLombok();
		jsonForm.setDescription("Getter and Setter method using Lombok library");
		jsonForm.setShort_description("RESTAPISESSIONSEP2024");
		jsonForm.setState("1");
		jsonForm.setUrgency("1");
		jsonForm.setCategory("Software");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(jsonForm));
		
		JSONObject json = new JSONObject(gson.toJson(jsonForm));
		System.out.println(json.getString("category"));

	}

}
