package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement zipCode;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(css="[class*='item_name']")
	private List<WebElement> prodNames;
	
	@FindBy(css=".complete-header")
	WebElement checkoutMsg;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishBtn;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	By title = By.cssSelector(".title");
	
	
	public void fillCheckoutDetails(String firstname, String lastname, String zipcode) {
		
		waitForElementToAppear(title);
		waitForWebElementToAppear(zipCode);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		zipCode.sendKeys(zipcode);
		continueBtn.click();
		
	}
	
	public void overviewDetails(String firstname, String lastname, String zipcode,String prodName) {
		fillCheckoutDetails(firstname, lastname, zipcode);
		waitForElementToAppear(title);
		Boolean match = prodNames.stream().anyMatch(product->product.getText().contains(prodName));
		Assert.assertEquals(match, true);
		finishBtn.click();
		
	}
	
	public String checkoutComplete(String firstname, String lastname, String zipcode,String prodName) {
		overviewDetails(firstname, lastname, zipcode, prodName);
		waitForElementToAppear(title);
		String checkoutcompleted= checkoutMsg.getText();
		return checkoutcompleted;
	}
}
