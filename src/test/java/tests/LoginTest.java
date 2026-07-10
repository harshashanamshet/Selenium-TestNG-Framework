package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import base.BasePage;
import data.LoginData;
import data.LoginDataProvider;
import page.LoginPage;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginTest extends BasePage{

	
	@Test(
		    dataProvider = "loginData",
		    dataProviderClass = LoginDataProvider.class
		)
	public void VerifyLogin(LoginData data) {
		loginPage.login(data.getUsername(), data.getPassword());

	    if (data.isExpectedResult()) {

	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

	    } else {

	        Assert.assertEquals(
	                loginPage.getErrorMessage(),
	                data.getExpectedMsg());
	    }
	}
}
