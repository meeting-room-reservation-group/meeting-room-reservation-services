package com.github.verhagen.mrrs.service;

import static io.restassured.RestAssured.when;

import org.junit.Test;

public class UserAccountServiceIT {
	private final String basePath = "api/v1.0";

	@Test
	public void getAll() throws Exception {
		when().
        	get(basePath + "/users").
        then().
        	statusCode(200);
	}


	@Test
	public void getById() throws Exception {
		when().
        	get(basePath + "/users/{id}", "haddock").
        then().
        	statusCode(200);
	}

}
