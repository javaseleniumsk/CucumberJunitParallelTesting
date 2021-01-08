package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/*
	Read the values from the properties file and return the values	
	*/
	public Properties getProp() {
		prop = new Properties();
		try {
			FileInputStream fileIO = new FileInputStream(new File("./src/test/resources/config/Config.properties"));
			prop.load(fileIO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
