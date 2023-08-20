package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	public Properties intializeProperties() {
		Properties pro = new Properties();
		File proFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(proFile);
		pro.load(fis);
		}catch(Throwable e) {
			e.getStackTrace();
		}
		return pro;
	}

}
