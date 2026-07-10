package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import listeners.RetryListeners;
import page.CartPage;
import page.CheckoutPage;
import page.InventoryPage;
import page.LoginPage;
import utils.ConfigReader;

public class E2ETestFlow extends BasePage{
	
	

	@Test(retryAnalyzer = RetryListeners.class)
	public void EndtoEndFlow() {
		String productTobeOrdered = "Backpack";
		LoginPage loginPage = new LoginPage(driver);
	    InventoryPage inventorypage =	loginPage.loginandreturnInventory(ConfigReader.getUserName(), ConfigReader.getPassword());
	    List<WebElement> prods =  inventorypage.getProducts();
	    prods.forEach(product -> System.out.println(product.getText()));
	    inventorypage.addProductToCart(productTobeOrdered);
	    CartPage cartPage = inventorypage.goToCartPage();
	    cartPage.verifyProdDisplayed(productTobeOrdered);
	    CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
	    String msg = checkoutPage.checkoutComplete("Harsha", "H", "411022", productTobeOrdered);
	    Assert.assertEquals(msg, "Thank you for your order!");
	}
}
