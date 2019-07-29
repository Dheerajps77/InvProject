package com.investaSolutions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.investaSolutions.utils.SeleniumUtils;

public class AssetManagerPortfolioManagementPage {
	private WebDriver driver;
	
	public AssetManagerPortfolioManagementPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By PORTFOLIO_MODEL_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Portfolio Model Management')]");
	private final By NEW_PORTFOLIO_BUTTON = By.xpath("//span[contains(text(),'New Portfolio Model')]");
}
