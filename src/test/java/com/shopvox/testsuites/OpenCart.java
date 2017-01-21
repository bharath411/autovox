package com.shopvox.testsuites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.shopvox.pageobjects.AdminDashBoardPage;
import com.shopvox.pageobjects.AdminLoginPage;
import com.shopvox.pageobjects.HomePage;

public class OpenCart extends BaseSetup {

	
	WebDriver driver;
	AdminLoginPage adminLoginPage = null;
	HomePage homePage = null;
	AdminDashBoardPage adminDashBoardPage = null;
	@BeforeMethod (groups = { "regression" })
	public void baseClassSetUp() throws Exception
	{
		String url = environment.getProperty("url");
		driver = getDriver();
		driver.get(url);
		 adminLoginPage = new AdminLoginPage(driver);
		  homePage = new HomePage(driver);
		  adminDashBoardPage = new AdminDashBoardPage(driver);
	}
	
	@Test
	public void testProductAdd(){
		
		//navigate to admin page
		homePage.navigateToAdminLoginPage();
		//Login to admin application
		adminLoginPage.login("user", "user123");
		//click on product
		adminDashBoardPage.openMenuItem("Catalog", "Products");
	}
}
