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
public class GetPetByPetId extends PetModuleBaseTest {
	
	@Test
	void validateGetPetByPetId() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		System.out.println(petId);
		
		Response res=RestAssured
				.given()
				.when()
				.get("/pet/"+20)
				.then()
				.statusCode(200)
				.assertThat()
				.body("id", Matchers.equalTo(20))
				.body("name", Matchers.equalTo("Tiger"))
				.extract().response();
		
		JsonPath jp=res.jsonPath();
		
		System.out.println(jp.getJsonObject(""));
		
		
	}

}
