package com.clearconcepts.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.clearconcepts.constans.Env;

public class PropertiesUtility {

	public static String readPropertyFile(Env env, String propertyName) {

		File file = new File(System.getProperty("user.dir") + "\\config\\"+env+".properties");
		System.out.println(file);
		FileReader fileReader;
		Properties propertyfile = new Properties();
		try {
			fileReader = new FileReader(file);
			propertyfile.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyfile.getProperty(propertyName);

	}

}
