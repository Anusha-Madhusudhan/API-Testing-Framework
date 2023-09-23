/**
 * 
 */
package com.tekarch.apiTests;

import java.io.File;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.constants.FileConstants;
import com.tekarch.utils.DataproviderClass;
import com.tekarch.utils.RequestMethodUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 */
public class loginTest {
	
	@Test(dataProvider = "LoginCredsDataProvider",dataProviderClass = DataproviderClass.class)
	void validateLoginToAppln(String username,String password) {
		
		File jsonFile=new File(FileConstants.USER_CREDS_FILE_PATH); // Reading from JSON file
		JsonPath jp=JsonPath.from(jsonFile);
		
		RestAssured.baseURI=jp.get("prod.uri");
		
		
		HashMap<String, String> loginCreds=new HashMap<String, String>();
		loginCreds.put("username",username);
		loginCreds.put("password",password);
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		Response res=RequestMethodUtils.login(loginCreds, headers, "/login");
				
		Assert.assertEquals(res.statusCode(), 201);
		
	}
	

}
