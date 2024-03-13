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
public class ShippingPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckout;
	
	public ShippingPage() {
		PageFactory.initElements(getdriver() , this);
	}
	
	public void clickoncheckbox() {
		Action.click(getdriver(), terms);
	}
	
	public PaymentPage clickonproceedtocheckout() {
		Action.click(getdriver(),proceedtoCheckout);
		return new PaymentPage();
	}

}
