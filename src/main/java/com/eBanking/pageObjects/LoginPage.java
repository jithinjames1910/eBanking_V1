package com.eBanking.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eBanking.BasePage.BasePageClass;

public class LoginPage extends BasePageClass {
	
	@FindBy(name="uid")
	WebElement userId;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement loginButton;
	@FindBy(name="btnReset")
	WebElement resetButton;
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String userName, String pswd)
	{
		
		userId.sendKeys(userName);
		password.sendKeys(pswd);
		loginButton.click();
		return new HomePage();
	}
	
	public String homePageTitle()
	{
		String homePageTitle=driver.getTitle();
		return homePageTitle;
	}
	
	

	
	
}
