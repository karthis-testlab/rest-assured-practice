package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Secret {

	private static Properties properties;

	static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("src/main/resources/secret.properties")));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"Unable to found 'secret.properties.properties' file in the src/main/resources location. Kindly create one.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return properties.getProperty(key);
	}

}
