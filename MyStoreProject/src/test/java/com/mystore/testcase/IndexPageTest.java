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
import com.mystore.pageobject.IndexPage;

/**
 * @author HP
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexpage;
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
	@Test(groups ="Smoke")
	
	public void verifylogo() {
		
		boolean result=indexpage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test(groups ="Smoke")
	
	public void verifyTitle() {
		String acttitle =indexpage.getMystoreTitle();
		Assert.assertEquals(acttitle, "My Shop");
	}
	

}
