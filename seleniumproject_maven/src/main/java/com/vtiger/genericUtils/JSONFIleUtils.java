package com.vtiger.genericUtils;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFIleUtils implements AutoConstant{
	public String readDataFromJSON(String key) throws Throwable{
	//read data from JSOn file
		FileReader file=new FileReader(jsonFilePath);
		//convert JSON file Into Java object
		JSONParser jsonobJ =new JSONParser();
		Object jObj =jsonobJ.parse(file);
		//typecast java object to hashmap
		HashMap map=(HashMap)jObj;
		String value = map.get(key).toString();
		//return the value
		return value;
		
		
	}
}
