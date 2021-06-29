package com.eBanking.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eBanking.BasePage.BasePageClass;

public class NewCustomerPage extends BasePageClass {
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement male;
	@FindBy(xpath="//input[@type='date']")
	WebElement date;
	@FindBy(xpath="//td/textarea[@name='addr']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement telephone;
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	//@FindBy(xpath="//input[@name='password']")
	//WebElement password;
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitBtn;
	
	public NewCustomerPage() {
		
		PageFactory.initElements(driver, this);
	}
	public void addNewCustomer(String customerName, String dob, String CustAddress, String custCity, String custState, 
			String custPin, String custTel, String custEmail, String custPass)
	{
		name.sendKeys(customerName);
		male.click();
		date.sendKeys(dob);
		address.sendKeys(CustAddress);
		city.sendKeys(custCity);
		state.sendKeys(custState);
		pin.sendKeys(custPin);
		String tel=generateNumber();
		telephone.sendKeys(tel);
		email.sendKeys(custEmail);
		submitBtn.click();
				
	}
	

}
