package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.AbstractComponents;

public class CartPage extends AbstractComponents{

	@FindBy(css="[class*='item_name']")
	private List<WebElement> prodNames;
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProdDisplayed(String productName) {
		
		Boolean match = prodNames.stream().anyMatch(product->product.getText().contains(productName));
		return match;
		
	}

}
