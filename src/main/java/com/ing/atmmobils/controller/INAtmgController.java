package com.ing.atmmobils.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;  
import org.json.JSONArray; 

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class INAtmgController {
	
	@RequestMapping(value="/ingMboil")
	public String getIng() {
		
		RestTemplate restTemplate=new RestTemplate();
		String fooResourceUrl = "https://www.ing.nl/api/locator/atms/";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(fooResourceUrl, String.class);
		//responseEntity.
		return responseEntity.toString();
	}
	
	@RequestMapping(value="/ingMboilJson")
	public JSONObject getIngJson() throws ParseException {
		JSONObject object = null;
		RestTemplate restTemplate=new RestTemplate();
		String fooResourceUrl = "https://www.ing.nl/api/locator/atms/";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(fooResourceUrl, String.class);
		 JSONParser parser = new JSONParser(fooResourceUrl);
	        JSONObject json = (JSONObject) parser.parse(); 
	        JSONArray jsonArray = (JSONArray) json.get("list"); 
		for(int i=0; i < jsonArray.length(); i++)   
		{  
		object = jsonArray.getJSONObject(i);  
		
		}
		return object;  
	}
	

}
