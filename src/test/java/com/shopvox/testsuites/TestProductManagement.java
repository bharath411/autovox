package com.shopvox.testsuites;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.selenium.Sync;
import com.shopvox.pageobjects.AdminLoginPage;

public class TestProductManagement extends BaseSetup {

	private Logger log = Logger.getLogger("TestProductManagement");	
	
	Sync sync =null;
	/**
	 * @case - OPC-1:Add a new Product to the opencart
	 * 
	 * @step 1 : 	Launch Opencart application as admin
	 */
	@Test
	public void testAddProduct(){
		WebDriver driver = getDriver();
		String baseUrl  = environment.getProperty("url");
		log.debug("Starting testAddProduct in TestProductManagement class");
		
		log.debug("navigating to " + baseUrl);
		driver.get(baseUrl);
		sync = new Sync(driver);
		sync.waitForPageToLoad();
		
		log.info("step 1 : 	Launch Opencart application as admin ");
		driver.get(baseUrl+ "/admin");
		
		AdminLoginPage adminLoginPage  = new AdminLoginPage(driver);
		String username  = environment.getProperty("username");
		String password  = environment.getProperty("password");
		adminLoginPage.login(username, password);
	}
}
