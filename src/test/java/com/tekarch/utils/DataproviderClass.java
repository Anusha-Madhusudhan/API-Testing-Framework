/**
 * 
 */
package com.tekarch.utils;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.tekarch.constants.FileConstants;

import io.restassured.path.json.JsonPath;

/**
 * 
 */
public class DataproviderClass {
	
	@DataProvider(name = "LoginCredsDataProvider")
	Object[][] loginCredsDataProvider(){
		
		String[][] loginCreds=new String[4][2];
		
		File userLoginCreds=new File(FileConstants.LOGIN_CREDS_FILE_PATH);
		
		JsonPath jp=new JsonPath(userLoginCreds);
		
		for(int i=0;i<4;i++) {
			
				loginCreds[i][0]=jp.get("loginCreds["+i+"].username");
				loginCreds[i][1]=jp.get("loginCreds["+i+"].password");
			
				System.out.println(loginCreds[i][0]+"  "+loginCreds[i][1]);
		}
		
		return loginCreds;
		
	}

}
