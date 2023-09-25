/**
 * 
 */
package com.tekarch.petModuleTests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.tekarch.constants.FileConstants;
import com.tekarch.utils.RequestMethodUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */
public class AddPet extends PetModuleBaseTest {
	
	
	@Test
	void validateAddPet_TC01() throws IOException {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		String payload=new String(Files.readAllBytes(Paths.get(FileConstants.ADD_PET_FILE_PATH)),StandardCharsets.UTF_8);
		
		System.out.println("Request payload for add pet method \n "+payload);
		
		HashMap<String, String> headers=new HashMap<String, String>();
		
		headers.put("Content-Type", "application/json");
		Response res=RequestMethodUtils.post(payload, headers, "/pet");
		
		res.then()
		.assertThat()
		.statusCode(200)
		.body("name",Matchers.equalTo("Tiger"))
		.body("status",Matchers.equalTo("available"))
		.header("Content-Type", Matchers.equalTo("application/json"))
		.log().all();
		
		petId=res.jsonPath().get("id");
		
		System.out.println("Pet id is :"+petId);
		
	}

}
