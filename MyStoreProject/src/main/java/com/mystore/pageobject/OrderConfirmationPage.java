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
public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//div[contains(text(),'Please send us a bank wire with')]")
	WebElement ConfirmMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getdriver() , this);
	}
	
	public boolean validateconfirmmsg() {
		return Action.isDisplayed(getdriver(), ConfirmMsg);
	}

}
