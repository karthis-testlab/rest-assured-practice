package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("./config.properties")));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUserName() {		
		return properties.getProperty("sn.username");
	}
	
	public static String getPassword() {
		return properties.getProperty("sn.password");
	}
	
	public static String getDomainName() {
		return properties.getProperty("sn.domain.name");
	}

}