package com.shopvox.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;
import com.shopvox.commons.enums.MenuItems;

public class AdminDashBoardPage  extends SafeActions {

	
	public AdminDashBoardPage(WebDriver driver) {
		super(driver);
	}

	public void openMenuItem(String menu, String subMenu){
		mouseHover(By.xpath("//span[text()='"+menu+"']"), 30);
		safeClick(By.xpath("//a[text()='"+subMenu+"']"),  40);
	}
	
	public void openMenuItem(MenuItems item){
		mouseHover(By.xpath("//span[text()='"+item.getMenu()+"']"), 30);
		safeClick(By.xpath("//a[text()='"+item.getSubMenu()+"']"),  40);
	}
}
