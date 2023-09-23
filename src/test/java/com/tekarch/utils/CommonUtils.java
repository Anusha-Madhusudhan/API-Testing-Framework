/**
 * 
 */
package com.tekarch.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tekarch.payloads.User;

/**
 * 
 */
public class CommonUtils {
	
	public static String readJsonFile(String filePath) throws IOException {
		
		String sUserCreds=new String(Files.readAllBytes(Paths.get(filePath)),StandardCharsets.UTF_8);
		
		System.out.println(sUserCreds);
		
		return sUserCreds;
	}

	public static String serealizePojoObjToStr(User user) throws JsonProcessingException {
		ObjectMapper om=new ObjectMapper();
		return om.writeValueAsString(user);
	}

}
