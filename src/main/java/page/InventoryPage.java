package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import base.AbstractComponents;

public class InventoryPage extends AbstractComponents{
	//WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".inventory_item");
	By addToCart = By.cssSelector(".pricebar button");
	By removeBtn = By.xpath("//button[contains(@id,'remove')]");
	
	public List<WebElement> getProducts(){
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProducts().stream()
							.filter(product-> 
								product.findElement(By.cssSelector(".inventory_item_name "))
									.getText()
									.contains(productName))
							.findFirst()
							.orElse(null);
		return prod;
	}
	
	public void addProductToCart(String name)
	{
	    WebElement prod = getProductByName(name);
	    prod.findElement(addToCart).click();
	    waitForElementToAppear(removeBtn);
	    Assert.assertEquals(driver.findElement(removeBtn).getText(), "Remove");
	    
	}
	
	
	
}
