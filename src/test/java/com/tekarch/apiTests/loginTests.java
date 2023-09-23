/**
 * 
 */
package com.tekarch.apiTests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.constants.FileConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.RequestMethodUtils;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 */
public class loginTests extends BaseTest{
	
//	String token;
//	String userId;
//	File jsonFile=new File(FileConstants.USER_CREDS_FILE_PATH); // Reading from JSON file
//	JsonPath jp=JsonPath.from(jsonFile);
	
//	@Test
//	void login_TC01() throws IOException {
//		
////		String userCreds=CommonUtils.readJsonFile(FileConstants.USER_CREDS_FILE_PATH);
//		
//		RestAssured.baseURI=jp.get("prod.uri");
//		String userName=jp.get("prod.username");
//		String password=jp.get("prod.password");
//		
//		HashMap<String, String> loginCreds=new HashMap<String, String>();
//		loginCreds.put("username",userName);
//		loginCreds.put("password",password);
//		
//		
//		
//		
////		HashMap<String, String> loginCreds=new HashMap<String, String>();
////		loginCreds.put("username", "anusha@tekarch.com");
////		loginCreds.put("password", "Admin123");
//		
//		HashMap<String, String> headers=new HashMap<String, String>();
//		headers.put("Content-Type", "application/json");
//		
//		Response res=RequestMethodUtils.login(loginCreds, headers, "/login");
//				
//		
//		token=res.jsonPath().getString("token").replace("[", "").replace("]", "");
//		userId=res.jsonPath().getString("userid").replace("[", "").replace("]", "");
//		
//		System.out.println(token);
//		System.out.println(userId);
//		
//		Assert.assertEquals(res.statusCode(), 201);
//	}
	
	@Test
	void addUser_TC02() {
		
		RestAssured.baseURI=jp.get("prod.uri");
		
		HashMap<String, String> userData=new HashMap<String, String>();
		userData.put("accountno", "TA-3334446");
		userData.put("departmentno", "1");
		userData.put("salary", "40000");
		userData.put("pincode", "123456");
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		
		
		Response res=RequestMethodUtils.post(userData, headers, "/addData");
		
		System.out.println(res.asPrettyString());		
		
		Assert.assertEquals(res.statusCode(), 201);
		Assert.assertEquals(res.jsonPath().getString("status"), "success");
	}

	@Test
	void getUsers_TC03() {
		
		RestAssured.baseURI=jp.get("prod.uri");
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		
		Response res=RequestMethodUtils.get(headers, "/getdata");
		System.out.println(res.asPrettyString());
		
		res.then().assertThat().body(matchesJsonSchema(new File(FileConstants.USER_DATA_SCHEMA_FILE_PATH)));
			
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test
	void updateUser_TC04() {

		RestAssured.baseURI=jp.get("prod.uri");
		
		HashMap<String, String> updateUserData=new HashMap<String, String>();
		
		updateUserData.put("accountno", "TA-3334445");
		updateUserData.put("departmentno", "2");
		updateUserData.put("id", "GvAA5BiBsmA2nM4MF3B3");
		updateUserData.put("salary", "70000");
		updateUserData.put("pincode", "123456");
		updateUserData.put("userid", userId);
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		
		Response res=RequestMethodUtils.put(updateUserData,headers, "/updateData");
		
		System.out.println(res.asPrettyString());
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.jsonPath().getString("status"), "success");
	}
	
	@Test
	void deleteUser_TC05() {
		

		RestAssured.baseURI=jp.get("prod.uri");
		
		HashMap<String, String> deleteUserData=new HashMap<String, String>();
		
		
		deleteUserData.put("id", "GvAA5BiBsmA2nM4MF3B3");
	
		deleteUserData.put("userid", userId);
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		
		Response res=RequestMethodUtils.delete(deleteUserData, headers, "/deleteData");
		
		System.out.println(res.asPrettyString()); 
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.jsonPath().getString("status"), "success");
		
	}
}
