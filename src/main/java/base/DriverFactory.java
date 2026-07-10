package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver initializeBrowser(String browser) {
		
		WebDriver driver = null;
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
			//doing this for the google chrome alert which doesnt work with switch to and all
		    ChromeOptions options = new ChromeOptions();

		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);

		    options.setExperimentalOption("prefs", prefs);

		    options.addArguments("--disable-notifications");
		    options.addArguments("--disable-save-password-bubble");
		    options.addArguments("--guest");   // Opens Chrome in Guest mode

		    driver = new ChromeDriver(options);
		    break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
		
		case "firefox":
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

}
