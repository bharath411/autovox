package com.shopvox.pageobjects;

import org.openqa.selenium.WebDriver;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;

public class HomePage extends SafeActions {
	WebDriver driver =null;
	ConfigManager environment = new ConfigManager("environment");
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	public void navigateToAdminLoginPage(){
		
		driver.get(environment.getProperty("url")+"/admin");
		
	}
	
	
}
