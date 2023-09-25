/**
 * 
 */
package com.tekarch.petModuleTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 */
public class GetPetsByStatus extends PetModuleBaseTest{
	
	@Test
	void validateGetPetsByStatus_TC02() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		Response res=RestAssured
				.given()
				.queryParam("status", "available")
				.when()
				.get("/pet/findByStatus")
				.then()
				.statusCode(200).extract().response();
		
		JsonPath jp=res.jsonPath();
		
		
		
	List<String> list=jp.getList("status");
	
	for(String s:list) {
		Assert.assertEquals("available",s);
	}
			
		
	}

}
