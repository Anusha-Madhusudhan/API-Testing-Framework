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
public class UpdateUser extends BaseTest {

	
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
}
