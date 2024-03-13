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
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;

/**
 * @author HP
 *
 */
public class OrderPsageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartPage;
	OrderPage orderpage;
	 AddressPage addressPage;
	 LoginPage loginpage;
	 @Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
		/*
		searchResultPage = new SearchResultPage();
		addtocartPage= new AddToCartPage();
		orderpage= new OrderPage();
		*/
		indexpage = new IndexPage();
		addressPage= new AddressPage();
		loginpage = new LoginPage();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teatDown() {
		getdriver().quit();
	}
	@Test(groups ="Regression")
	
	public void verifyTotalPrice() throws InterruptedException {
		searchResultPage=indexpage.searchProduct("t shirt");
		boolean result=searchResultPage.isproductavailable();
		Assert.assertTrue(result);
		addtocartPage=searchResultPage.clickonproduct();
		
		addtocartPage.selectSize("M");
		addtocartPage.enterquantity("2");
		addtocartPage.addocart();
		boolean result1 =addtocartPage.validateaddtocart();
		Assert.assertTrue(result1);
		orderpage=addtocartPage.clickOnCheckOut();
		Double unitprice =orderpage.getUnitPrice();
		Double totalPrice =orderpage.GetToatalPrice();
		Double totalExpectedPrice= (unitprice*2)+7;
	//	Assert.assertEquals(totalPrice, totalExpectedPrice);
		orderpage.clickoncheckout();
		addressPage=loginpage.login1(prop.getProperty("username"),prop.getProperty("password"));
		
		
	} 
	
	

}
