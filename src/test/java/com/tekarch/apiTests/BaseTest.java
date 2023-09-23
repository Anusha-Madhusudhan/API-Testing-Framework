/**
 * 
 */
package com.tekarch.apiTests;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.tekarch.constants.FileConstants;
import com.tekarch.utils.RequestMethodUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 */
public class BaseTest {
	
	public static String token;
	public static String userId;
	File jsonFile=new File(FileConstants.USER_CREDS_FILE_PATH); // Reading from JSON file
	JsonPath jp=JsonPath.from(jsonFile);
	
	

	@BeforeTest
	void setUp() {
		RestAssured.baseURI=jp.get("prod.uri");
		String userName=jp.get("prod.username");
		String password=jp.get("prod.password");
		
		HashMap<String, String> loginCreds=new HashMap<String, String>();
		loginCreds.put("username",userName);
		loginCreds.put("password",password);
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		Response res=RequestMethodUtils.login(loginCreds, headers, "/login");
				
		
		token=res.jsonPath().getString("token").replace("[", "").replace("]", "");
		userId=res.jsonPath().getString("userid").replace("[", "").replace("]", "");
		
		System.out.println(token);
		System.out.println(userId);
		
		Assert.assertEquals(res.statusCode(), 201);
		
	}
	
	
	 static String generateRandomAccountNum() {
		 Random rnd = new Random();
		 int n = 1000000 + rnd.nextInt(9000000);
		 String accountNum="TA-"+String.valueOf(n);
		 return accountNum;
	}
	
}
