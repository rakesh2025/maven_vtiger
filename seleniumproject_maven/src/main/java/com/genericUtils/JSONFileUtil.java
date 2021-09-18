package com.genericUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Rakesh
 */
public class JSONFileUtil {
/**
 * read data from JSON file
 * @throws ParseException 
 * @throws IOException 
 */
public String readDataFromJSON(String key) throws Throwable{
	//read data from JSOn file
	FileReader file=new FileReader("./commonData.json");
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
