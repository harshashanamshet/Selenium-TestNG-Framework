package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	
	static {
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config/config.properties");
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public static String getBrowser() {
		return getProperty("browser");
	}
	
	public static String getApplicationUrl() {
		return getProperty("url");
	}
	
	public static String getUserName() {
		return getProperty("username");
	}

	public static String getPassword() {
		return getProperty("password");
	}
	
	public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicitWait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicitWait"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }
}
