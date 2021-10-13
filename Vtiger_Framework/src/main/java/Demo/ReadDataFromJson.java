package Demo;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJson {
/**
 * 
 * @param jsonKey
 * @return jsonValue
 * @throws Throwable
 */
	@Test
	public void getDataFromJson() throws Throwable
	{
//		FileReader reader = new FileReader("./Data/CommonData.json");
//		JSONParser parser = new JSONParser();
//		Object object = parser.parse(reader);
//		JSONObject jsonObject = (JSONObject)object;
//		String value = jsonObject.get("url").toString();
//		String username = jsonObject.get("username").toString();
//		String browse = jsonObject.get("browser").toString();
//		String password = jsonObject.get("password").toString();
//
//		System.out.println(value);
//		System.out.println(username);
//		System.out.println(browse);
//		System.out.println(password);
		
		//read the data from json file	
		FileReader file = new FileReader("./Data/CommonData.json");
		
		//convert the json file into java object
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);
		
		//type cast java ob to hashmap
		HashMap map = (HashMap)jobj;
		String USERNAME = map.get("username").toString();
		System.out.println(USERNAME);
		String PASSWORD = map.get("password").toString();
		System.out.println(PASSWORD);
		String URL = map.get("url").toString();
		System.out.println(URL);
	}
}
