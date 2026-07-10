package base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import page.LoginPage;
import utils.ConfigReader;

public class BasePage {

	public WebDriver driver;
	public static Properties prop;
	protected LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.initializeBrowser(ConfigReader.getBrowser());
		driver.get(ConfigReader.getApplicationUrl());
		loginPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreenshot(String testName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS")
		        .format(new Date());

		String destinationPath = System.getProperty("user.dir")
		        + "/screenshots/"
		        + testName + "_" + timestamp + ".png";
//		String destinationPath = System.getProperty("user.dir")
//							+"/screenshots/"+testName+".png";
		File destination = new File(destinationPath);
		FileUtils.copyFile(source, destination);
		
		return destinationPath;
	}
	
	
}
