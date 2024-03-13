/**
 * 
 */
package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author HP
 *
 */
public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//li[@class='price']")
	WebElement UnitPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement TotalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement ProcedToCheckOut;
	
	
	
	public OrderPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public double getUnitPrice() throws InterruptedException {
	    Action.implicitWait(getdriver(), 10);
		String unitprice1=UnitPrice.getText();
		String unit =unitprice1.replaceAll("[^a-zA-Z0-9]","");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	
	public double GetToatalPrice() {
		 Action.fluentWait(getdriver(), TotalPrice, 10);
		String totalprice1=TotalPrice.getText();
		String tot =totalprice1.replaceAll("[^a-zA-Z0-9]","");
		double finaltotalprice=Double.parseDouble(tot);
		return finaltotalprice/100;
	}
	
	public LoginPage clickoncheckout() {
		Action.click(getdriver(), ProcedToCheckOut);
		return new LoginPage();
	}
	
	
	

}
