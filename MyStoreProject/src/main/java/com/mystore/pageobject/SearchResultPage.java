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
public class SearchResultPage extends BaseClass {
	@FindBy(xpath = "//div/ul/li[2]/a/img")
	WebElement ProductResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean isproductavailable() {
		return Action.isDisplayed(getdriver(), ProductResult);
	}
	public AddToCartPage clickonproduct() {
		Action.click(getdriver(), ProductResult);
		return new AddToCartPage();
	}

}
