package com.eBank.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.eBank.utilities.ExcelUtil;
import com.eBank.utilities.ScreenShot;
import com.eBanking.BasePage.BasePageClass;
import com.eBanking.pageObjects.LoginPage;

@Listeners(ScreenShot.class)
public class LoginPageTest extends BasePageClass{
	
	LoginPage login;
	ExcelUtil excelUtil;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws IOException
	{
		
		initialize();
		login = new LoginPage();

	}
	@Test(priority=1)
	public void loginTest()
	{
		logger.info("Opening login page");
		login.login(prop.getProperty("userId"),prop.getProperty("password"));
		String homePageTitle = login.homePageTitle();
		logger.info("HomePage Title Test");
		AssertJUnit.assertEquals(homePageTitle,prop.getProperty("title"));
		logger.info("Login page Test passed");

	}
	
	
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.close();
	}
	

}
