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
import com.mystore.detaprovider.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

/**
 * @author HP
 *
 */
public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
	IndexPage indexpage;
	HomePage homePage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})	
	public void setup(String browser) {
		launchApp(browser);
		indexpage= new IndexPage();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teatDown() {
		getdriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass=DataProviders.class, groups = {"Smoke","Sanity"})
	public void logintest(String username , String password) {
		Log.startTestCase("Login Test");
		loginPage=indexpage.clickOnsignIn();
	    Log.info("user is going to click on sign in");
		//homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    homePage =  loginPage.login(username, password);
		Log.info("ener username and password");
		String actualURl = homePage.getcurrenturl();
		String ExpectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("verifying if user is able to login");
		Assert.assertEquals(actualURl, ExpectedURL);
		Log.info("Login Is sucrsess");
		Log.endTestCase("Login test End here");
		
	}
}
