package com.eBank.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBank.utilities.ExcelUtil;
import com.eBanking.BasePage.BasePageClass;
import com.eBanking.pageObjects.HomePage;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.pageObjects.NewCustomerPage;

public class NewCustomerTest extends BasePageClass{
	public LoginPage loginPage;
	public HomePage homePage;
	public NewCustomerPage newCustomer;

	public NewCustomerTest()
	{
		super();
	}
	
	
	@BeforeMethod()
	public void setUp() throws IOException
	{
		
		initialize();
		loginPage = new LoginPage();
		homePage=new HomePage();
		loginPage.login(prop.getProperty("userId") , prop.getProperty("password"));
		homePage.clickOnNewCustomer();

	}
	
	@DataProvider
	public Object[][] getExcelValue()
	{
		
		Object[][] excelData=ExcelUtil.getTestdata(prop.getProperty("excelSheetName"));
		return excelData;
	}
	@Test(priority=1, dataProvider="getExcelValue")
	public void addNewCustomer(String name, String dob, String address, String city, String state, String pin, String mobileNumber, String email, String password)
	{
		newCustomer=new NewCustomerPage();
		logger.info("Opening Add New Customer Test");
		newCustomer.addNewCustomer(name, dob, address, city, state, pin, mobileNumber, email, password);
	}
	@AfterMethod()
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
