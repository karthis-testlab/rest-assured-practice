package com.json.path.practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ArrayInlineAssertionPractice {
	
	@Test
	public void jsonArrayInlineAssertion() {
		RestAssured
	    .given()
            .log()
            .all()
            .baseUri("https://restful-booker.herokuapp.com/booking")
        .when()
            .get()
        .then()
            .log()
            .all()
            .body("bookingid", Matchers.hasItems(2, 78));
	}

}