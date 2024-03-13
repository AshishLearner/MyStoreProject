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
public class LoginPage extends BaseClass {
	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccountBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(getdriver() , this);
	}
	public HomePage login(String uname , String pswd) {
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getdriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname , String pswd) {
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getdriver(), signInBtn);
		return new AddressPage();
	}
	
	
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(getdriver() , createNewAccountBtn);
		return new AccountCreationPage();
		
	}
}
