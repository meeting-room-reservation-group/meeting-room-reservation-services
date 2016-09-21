package com.github.verhagen.mrrs.service;

//import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.Test;

import io.restassured.http.ContentType;

public class UserAccountServiceIT {
	private final String basePath = "api/v1.0";

	@Test
	public void getAll() throws Exception {
		when().
        	get(basePath + "/users").
        then().
        	log().body().
        	statusCode(200).
        	contentType(ContentType.JSON);
		
//		get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
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
