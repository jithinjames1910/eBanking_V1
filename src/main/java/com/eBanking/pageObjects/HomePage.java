package com.eBanking.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eBanking.BasePage.BasePageClass;

public class HomePage extends BasePageClass {
	
	@FindBy(xpath="//a[text()='New Customer']")
	public WebElement newCustomerBtn;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
public NewCustomerPage clickOnNewCustomer()
{
	
	newCustomerBtn.click();
	logger.info("Clicked on New Customer");
	return new NewCustomerPage();
}
}