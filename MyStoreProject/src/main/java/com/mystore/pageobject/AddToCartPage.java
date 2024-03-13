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
public class AddToCartPage extends BaseClass {
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//i[@class='icon-check']")
	WebElement addtocartmsg;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement ProcedtoCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}
	public void enterquantity(String quantity1) {
		Action.type(quantity, quantity1);
	
	}
	 
	public void addocart() {
		Action.fluentWait(getdriver(), addtocartbtn,10);
		try {
			Action.JSClick(getdriver(), addtocartbtn);
		}
		catch(Exception e) {
			getdriver().navigate().refresh();
			Action.JSClick(getdriver(), addtocartbtn);
		}
		
	}
	public boolean validateaddtocart() {
		Action.fluentWait(getdriver(), addtocartmsg,10);
		return Action.isDisplayed(getdriver(), addtocartmsg);
	}
	public OrderPage clickOnCheckOut() {
		Action.JSClick(getdriver(), ProcedtoCheckoutBtn);
	//	Action.fluentWait(driver, ProcedtoCheckoutBtn,10);
		return new OrderPage();
		
	}

}
