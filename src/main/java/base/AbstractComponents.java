package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.CartPage;
import page.CheckoutPage;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractComponents {

	protected WebDriver driver;
	
	@FindBy(css = ".shopping_cart_link")
	WebElement cartHeader;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutBtn;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear(By find) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(find));
	}
	
	public void waitForWebElementToAppear(WebElement find) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(find));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public CheckoutPage goToCheckoutPage()
	{
		checkoutBtn.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
