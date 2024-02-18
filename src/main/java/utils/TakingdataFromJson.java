package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;


public class TakingdataFromJson {
	
	
	public static JSONObject readJsonFile(String fileName) {
	    String filePath = "/" + fileName; // Assuming the file is directly under src/main/resources
	    JSONParser parser = new JSONParser();
	    try {
	        // Load the JSON file as a resource
	        InputStream inputStream = TakingdataFromJson.class.getResourceAsStream(filePath);
	        if (inputStream == null) {
	            throw new RuntimeException("File not found: " + filePath);
	        }
	        InputStreamReader reader = new InputStreamReader(inputStream);

	        Object obj = parser.parse(reader);
	        return (JSONObject) obj;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}



