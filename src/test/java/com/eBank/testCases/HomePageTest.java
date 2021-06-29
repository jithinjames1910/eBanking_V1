package com.eBank.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;


import com.eBanking.BasePage.BasePageClass;
import com.eBanking.pageObjects.HomePage;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.pageObjects.NewCustomerPage;

public class HomePageTest extends BasePageClass{
	
	HomePage  homePage;
	LoginPage loginPage;
	@BeforeMethod()
	public void setUp() throws IOException
	{
		
		initialize();
		loginPage = new LoginPage();
		homePage=new HomePage();
		loginPage.login(prop.getProperty("userId") , prop.getProperty("password"));
		homePage = new HomePage();
		

	}
	
	@Test(priority=1)
	public void clickOnNewCustomer()
	{
		homePage.clickOnNewCustomer();
	}
	
}
