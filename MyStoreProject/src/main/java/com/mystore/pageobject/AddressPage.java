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
public class AddressPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
     WebElement procedtocheckout;
	
	
	public AddressPage() {
		PageFactory.initElements(getdriver() , this);
	}
	
	public ShippingPage clickoncheckout() {
		Action.click(getdriver(), procedtocheckout);
		return new ShippingPage();
	}
}
