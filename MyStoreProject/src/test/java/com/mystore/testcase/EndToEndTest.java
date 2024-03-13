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
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;

/**
 * @author HP
 *
 */
public class EndToEndTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartPage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addressPage;
	ShippingPage shipingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummerypage;
	OrderConfirmationPage orderconfirmationpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
		indexpage = new IndexPage();
		/*searchResultPage = new SearchResultPage();
		addtocartPage= new AddToCartPage();
		orderpage= new OrderPage();
		loginpage = new LoginPage();
		addressPage= new AddressPage();
		shipingpage = new ShippingPage();
		paymentpage = new PaymentPage();
		ordersummerypage= new OrderSummaryPage();
		orderconfirmationpage = new OrderConfirmationPage();
		*/
		
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teatDown() {
		getdriver().quit();
	}
	@Test(groups ="Regression")
	
	public void EndtoEndTest() throws InterruptedException {
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
		//OrderPsageTest orderpagrtest= new OrderPsageTest();
		//orderpagrtest.verifyTotalPrice();
	//	Assert.assertEquals(totalPrice, totalExpectedPrice);
		loginpage=orderpage.clickoncheckout();
		addressPage=loginpage.login1(prop.getProperty("username"),prop.getProperty("password"));
		shipingpage=addressPage.clickoncheckout();
		shipingpage.clickoncheckbox();
		paymentpage=shipingpage.clickonproceedtocheckout();
		ordersummerypage=paymentpage.clikonpaymentmethode();
		orderconfirmationpage=ordersummerypage.clickonconfirmorder();
		boolean result3 =orderconfirmationpage.validateconfirmmsg();
		Assert.assertTrue(result3);
		
		
		
	} 

}
