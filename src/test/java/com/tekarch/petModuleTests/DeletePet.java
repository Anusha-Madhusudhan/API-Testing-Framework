/**
 * 
 */
package com.tekarch.petModuleTests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 */
public class DeletePet extends PetModuleBaseTest {
	
	@Test
	void validateDeletePet() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		Response res=RestAssured
				.given()
				.when()
				.delete("/pet/"+20)
				.then()
				.statusCode(200)
				.assertThat()
				.body("code", Matchers.equalTo(200))
				.body("message", Matchers.equalTo("20"))
				.extract().response();
		
		JsonPath jp=res.jsonPath();
		
		System.out.println(jp.getJsonObject(""));
		
		
	}

}
