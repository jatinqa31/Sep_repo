package com.qa.openkart.utilities;

import java.io.FileReader;
import java.util.Properties;

import com.qa.openkart.factory.PlaywrightFactory;

public class Utilities {

	public static String getProeprty(String strProp) 
	{
		String property = null;
		try {
			FileReader reader = new FileReader("config.properties");
			Properties prop = new Properties();
			prop.load(reader);
			property = prop.getProperty(strProp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property; 
	} 
} 
 