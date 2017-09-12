package com.ecm.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Service
public class AddDeviceACSServiceImpl {
	HttpHeaders headers = null;
	RestTemplate restTemplate = null;

	@SuppressWarnings({ "rawtypes", "unused" })
	public void addDeviceACS(String requestBody) {
		
		try {
			headers = new HttpHeaders();
			String auth=getAuthToken();
			headers.add("Authorization", "IncognitoUms auth="+auth);
			headers.add("Content-Type", "application/json");
			HttpEntity<String> httpEntitydevice = new HttpEntity<>( headers);
			
			JsonParser parser = new JsonParser();
			JsonObject jsonValue = (JsonObject)parser.parse(requestBody);
			String serial= jsonValue.get("serial").getAsString();
			ResponseEntity responseDevice = restTemplate.exchange(Constants.ADD_DEVICE_URL+"?q=serial="+serial, HttpMethod.GET, httpEntitydevice,
					String.class);
			JsonParser parserJson = new JsonParser();
			JsonObject jsonValueDevice = (JsonObject)parserJson.parse((String) responseDevice.getBody());
			int total=jsonValueDevice.get("totalRecordCount").getAsInt();
			if(total==0){
				HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
				System.out.println(httpEntity);
				restTemplate = new RestTemplate();
				ResponseEntity response = restTemplate.exchange(Constants.ADD_DEVICE_URL, HttpMethod.POST, httpEntity,
						String.class);
				System.out.println( "devices are registred sucessfully");
			}
			
		System.out.println("device is already existed ");

		} catch (Exception e) {
			
		}
		
	}
    public String getAuthToken() {
    	
		    String requestBody = "{\"username\":\"administrator\", \"password\":\"administrator\"}";
			headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
			restTemplate = new RestTemplate();
			ResponseEntity response = restTemplate.exchange(Constants.LOGIN_URL, HttpMethod.POST, httpEntity,
					String.class);
			JsonParser parser = new JsonParser();
			JsonObject jsonValue = (JsonObject)parser.parse((String) response.getBody());
			String authToken=jsonValue.get("IncognitoUms auth").getAsString();
			System.out.println(authToken);
			
           return authToken;
}
 
	

}
