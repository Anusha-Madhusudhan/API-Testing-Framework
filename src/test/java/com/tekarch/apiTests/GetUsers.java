/**
 * 
 */
package com.tekarch.apiTests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.constants.FileConstants;
import com.tekarch.utils.RequestMethodUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */
public class GetUsers extends BaseTest {

	
	@Test
	void getUsers_TC03() {
		
		RestAssured.baseURI=jp.get("prod.uri");
		
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		
		Response res=RequestMethodUtils.get(headers, "/getdata");
		System.out.println(res.asPrettyString());
		
		res.then().assertThat().body(matchesJsonSchema(new File(FileConstants.USER_DATA_SCHEMA_FILE_PATH)));
		
	    List<String> accountList=res.jsonPath().get("accountno");
	    
	    System.out.println(accountList.size());
	    
	    assertThat(accountList.size(), greaterThan(10000));
	    
	    
			
		Assert.assertEquals(res.statusCode(), 200);
		
	}
}
