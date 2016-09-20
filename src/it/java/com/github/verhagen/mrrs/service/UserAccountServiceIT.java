package com.github.verhagen.mrrs.service;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

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
	public void getByIdHaddock() throws Exception {
		when().
        	get(basePath + "/users/{id}", "haddock").
        then().
        	statusCode(200).
        	body("id", equalTo("haddock"),
        			"name", equalTo("Captain Haddock"));
	}

	@Test
	public void getByIdCalculus() throws Exception {
		when().
        	get(basePath + "/users/{id}", "calculus").
        then().
        	statusCode(200).
        	body("id", equalTo("calculus"),
        			"name", equalTo("Professor Calculus"));
	}

	@Test
	public void getByIdSnowy() throws Exception {
		when().
        	get(basePath + "/users/{id}", "snowy").
        then().
        	statusCode(204);
	}

	@Test
	public void getSearchCalculus() throws Exception {
		when().
        	get(basePath + "/users/query?name={query}", "calculus").
        then().
        	statusCode(200).
        	body("id", equalTo("calculus"),
        			"name", equalTo("Professor Calculus"));
	}

	@Test
	public void getSearchSnowy() throws Exception {
		when().
        	get(basePath + "/users/query?name={query}", "snowy").
        then().
        	statusCode(204);
	}

}
