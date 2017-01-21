package com.shopvox.pageobjects.locators;

import org.openqa.selenium.By;

public interface AdminLoginPageLocators {
	public static By USERNAME_TXT = By.name("username");
	public static By PASSWORD_TXT = By.name("password");
	public static By LOGIN_BTN = By.xpath("//button[@type='submit']");
	
}
