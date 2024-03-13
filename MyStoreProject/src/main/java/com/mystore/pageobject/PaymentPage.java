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
public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement bankWiremehode;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement paybyCheckehod;
	
	
	public PaymentPage() {
		PageFactory.initElements(getdriver() , this);
	}
	
	public OrderSummaryPage clikonpaymentmethode() {
		Action.click(getdriver(), bankWiremehode);
		return new OrderSummaryPage();
	}

}
