/**
 * 
 */
package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

/**
 * @author HP
 *
 */
public class HomePageTest extends BaseClass {
 	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Parameters("browser")

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
		indexpage = new IndexPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teatDown() {
		getdriver().quit();
	}
	
	@Test(groups ="Smoke")
	
	public void verifyWishLisTest() {
		indexpage.clickOnsignIn();
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result=homepage.ValidateWishlist();
		Assert.assertTrue(result);
	}
	
@Test(groups ="Smoke")
	
	public void Orderhistorydetails() {
		indexpage.clickOnsignIn();
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result=homepage.ValidateHistory();
		Assert.assertTrue(result);
	}
	
	
}
