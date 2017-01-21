package com.shopvox.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;
import com.shopvox.pageobjects.locators.AdminLoginPageLocators;

public class AdminLoginPage extends SafeActions implements AdminLoginPageLocators {

	public AdminLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void login(String username , String password){
		safeType(USERNAME_TXT, username, 30);
		safeType(PASSWORD_TXT, password, 30);
		safeClick(LOGIN_BTN);
	}

}
