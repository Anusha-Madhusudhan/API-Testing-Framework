/**
 * 
 */
package com.tekarch.apiTests;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tekarch.payloads.User;
import com.tekarch.utils.RequestMethodUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */
public class AddUser extends BaseTest{
	
	@Test
	void addUser_TC02() throws JsonProcessingException {
		
		RestAssured.baseURI=jp.get("prod.uri");
		
		String accountNum=generateRandomAccountNum();
		
		System.out.println("Random account num is ::"+accountNum);
		
		User user1=new User(accountNum, "1", "100000", "123456");  //POJO Object as request body
		
//		String sUser1=CommonUtils.serealizePojoObjToStr(user1);
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		
		
		Response res=RequestMethodUtils.post(user1, headers, "/addData");
		
		System.out.println(res.asPrettyString());		
		
		Assert.assertEquals(res.statusCode(), 201);
		Assert.assertEquals(res.jsonPath().getString("status"), "success");
	}

	

}
