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
public class HomePage extends BaseClass {
	
	@FindBy(xpath="//span[text()='My addresses']")
	WebElement Wishlist;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement OrderHistory;
	
	public HomePage() {
		PageFactory.initElements(getdriver(),this);
	}
	public boolean ValidateWishlist() {
	return Action.isDisplayed(getdriver(), Wishlist);		
			
	}
	public boolean ValidateHistory() {
	return	Action.isDisplayed(getdriver(), OrderHistory);
	}
	
	public String getcurrenturl() {
		String homepageurl=getdriver().getCurrentUrl();
		return homepageurl;
	}

}
