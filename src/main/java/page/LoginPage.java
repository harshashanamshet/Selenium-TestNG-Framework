package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.AbstractComponents;
import utils.ConfigReader;

public class LoginPage extends AbstractComponents{
	private By errorMessage = By.xpath("//h3[@data-test='error']");
//	WebDriver driver;
	
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(xpath="//input[contains(@class,'submit')]")
	WebElement LoginBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String UserName, String password) {
		userName.sendKeys(UserName);
		pwd.sendKeys(password);
		LoginBtn.click();
	}
	
	public InventoryPage loginandreturnInventory(String UserName, String password) {
		userName.sendKeys(UserName);
		pwd.sendKeys(password);
		LoginBtn.click();
		InventoryPage inventoryPage = new InventoryPage(driver);
		return inventoryPage;
	}

	public String getErrorMessage() {
	    return driver.findElement(errorMessage).getText();
	}
}
