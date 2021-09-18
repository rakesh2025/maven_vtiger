package com.vtiger.genericUtils;

import java.io.FileInputStream;


import java.util.Properties;
/**
 * This class contains generic method to read data from property file
 * @author Rakesh
 *
 */
public class PropertiesFile implements AutoConstant 
{
	public String getdata(String key) throws Throwable {
		
	
Properties p=new Properties();
p.load(new FileInputStream(propertyFilepath));
return p.getProperty(key);
	}
}
