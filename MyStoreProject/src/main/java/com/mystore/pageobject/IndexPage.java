package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement siginInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement MyStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public LoginPage clickOnsignIn() {
		Action.click(getdriver(),siginInBtn);
		return new LoginPage();
	}
	public boolean validateLogo() {
		return Action.isDisplayed(getdriver() , MyStoreLogo);
	}
	public String getMystoreTitle() {
		String mystoreTitle =getdriver().getTitle();
		return mystoreTitle;
	}
	public SearchResultPage searchProduct(String productname) {
		Action.type(searchProductBox,productname);
		Action.click(getdriver(), searchButton);
		return new SearchResultPage();
	}

}
