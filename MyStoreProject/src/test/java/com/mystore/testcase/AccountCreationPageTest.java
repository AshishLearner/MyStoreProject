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
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

/**
 * @author HP
 *
 */
public class AccountCreationPageTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationpage;
	//HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		indexpage = new IndexPage();
		loginpage = new LoginPage();
		accountCreationpage = new AccountCreationPage();
		//homepage = new HomePage();
		
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teatDown() {
		getdriver().quit();
	}
	
	@Test(groups ="Sanity")
	public void verifyCreateaccountPageTest() {
		loginpage = indexpage.clickOnsignIn();
		accountCreationpage=loginpage.createNewAccount("tuc@gmail.com");
		boolean result=accountCreationpage.validateAccounCreationpage();
		Assert.assertTrue(result);
	}
}
