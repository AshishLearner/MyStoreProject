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
public class OrderSummaryPage extends BaseClass {
	
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	WebElement confirmOrder;
	
	
	
	public OrderSummaryPage() {
		PageFactory.initElements(getdriver() , this);
	}
	
	
	public OrderConfirmationPage clickonconfirmorder() {
		Action.click(getdriver(),confirmOrder);
		return new OrderConfirmationPage();
	}

}
