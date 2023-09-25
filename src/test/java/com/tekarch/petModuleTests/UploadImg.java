/**
 * 
 */
package com.tekarch.petModuleTests;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.tekarch.constants.FileConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */
public class UploadImg extends PetModuleBaseTest {
	
	@Test
	void validateUploadImg() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		Response res=RestAssured
				.given()
				.multiPart(new File(FileConstants.UPLOAD_IMG_FILE_PATH))
				.when()
				.post("/pet/20/uploadImage")
				.then()
				.statusCode(200)
				.assertThat()
				.body("message", Matchers.containsString("th.jpg"))
				.extract().response();
		
		System.out.println(res.asPrettyString());
		
	}

}
