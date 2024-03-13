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
public class AccountCreationPage extends BaseClass {
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement createpage;
	
	public AccountCreationPage() {
		PageFactory.initElements(getdriver(), this);
	}
	public boolean validateAccounCreationpage() {
		return Action.isDisplayed(getdriver(), createpage);
	}

}
