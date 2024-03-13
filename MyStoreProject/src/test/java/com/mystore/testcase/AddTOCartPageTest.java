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

public class AddTOCartPageTest extends BaseClass {

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
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyProducttoAddInCart() throws InterruptedException {
		searchResultPage=indexpage.searchProduct("t shirt");
		boolean result=searchResultPage.isproductavailable();
		Assert.assertTrue(result);
		addtocartPage=searchResultPage.clickonproduct();
		
		addtocartPage.selectSize("M");
		addtocartPage.enterquantity("2");
		addtocartPage.addocart();
		boolean result1 =addtocartPage.validateaddtocart();
		Assert.assertTrue(result1);
	}
}
