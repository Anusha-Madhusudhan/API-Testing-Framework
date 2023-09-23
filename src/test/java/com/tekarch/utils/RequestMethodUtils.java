/**
 * 
 */
package com.tekarch.utils;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */
public class RequestMethodUtils {
	
	
public static Response login(HashMap<String, String> payload,HashMap<String, String> headers,String endPoint) {
		
	Response res=RestAssured
		.given()
		.headers(headers)
		.body(payload)
		.when()
		.post(endPoint);
		
	return res;
	}

public static Response post(HashMap<String, String> payload,HashMap<String, String> headers,String endPoint) {
	
	Response res=RestAssured
		.given()
		.headers(headers)
		.body(payload)
		.when()
		.post(endPoint);
		
	return res;
	}

public static Response get(HashMap<String, String> headers,String endPoint) {
	
	Response res=RestAssured
		.given()
		.headers(headers)
		.when()
		.get(endPoint);
		
	return res;
	}

public static Response put(HashMap<String, String> payload,HashMap<String, String> headers,String endPoint) {
	
	Response res=RestAssured
		.given()
		.headers(headers)
		.body(payload)
		.when()
		.put(endPoint);
		
	return res;
	}
public static Response delete(HashMap<String, String> payload,HashMap<String, String> headers,String endPoint) {
	
	Response res=RestAssured
		.given()
		.headers(headers)
		.body(payload)
		.when()
		.delete(endPoint);
		
	return res;
	}

public static Response post(String payload, HashMap<String, String> headers, String endPoint) {
	
	Response res=RestAssured
			.given()
			.headers(headers)
			.body(payload)
			.when()
			.post(endPoint);
	
	return res;
}

public static Response post(Object user1, HashMap<String, String> headers, String endPoint) {
	
	Response res=RestAssured
			.given()
			.headers(headers)
			.body(user1)
			.when()
			.post(endPoint);
	
	return res;
}
}
