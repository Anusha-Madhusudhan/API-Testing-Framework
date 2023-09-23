/**
 * 
 */
package com.tekarch.apiTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.RequestMethodUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */
public class DeleteUser extends BaseTest{

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
