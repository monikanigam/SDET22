package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility {
/*
 * @Monika
 */
	/**
	 * This method used to read data from properties and return the value based on key specific
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	/**
	 * This method will return json value based on json key
	 * @param jsonKey
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromJson(String jsonKey) throws Throwable {
		FileReader reader = new FileReader(IPathConstant.JSONFILEPATH);
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonObject = (JSONObject)object;
		String value = jsonObject.get(jsonKey).toString();
		
		return value;
		
	}
}
