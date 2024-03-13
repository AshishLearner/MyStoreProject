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
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;

/**
 * @author HP
 *
 */
public class SearchResultPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartPage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
		indexpage = new IndexPage();
		searchResultPage = new SearchResultPage();
		addtocartPage= new AddToCartPage();
		//loginpage = new LoginPage();
		//accountCreationpage = new AccountCreationPage();
		//homepage = new HomePage();
		
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teatDown() {
		getdriver().quit();
	}
	@Test(groups ="Smoke")
	public void verifyProductAvailability() {
		searchResultPage=indexpage.searchProduct("t shirt");
		boolean result=searchResultPage.isproductavailable();
		Assert.assertTrue(result);
		
	}
	@Test(groups ="Smoke")
	public void verifyProductclikable() {
		searchResultPage=indexpage.searchProduct("t shirt");
		boolean result=searchResultPage.isproductavailable();
		Assert.assertTrue(result);
		addtocartPage=searchResultPage.clickonproduct();
		
	}
	
	

}
