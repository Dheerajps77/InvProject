package com.investaSolutions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AssetManagerStrategyManagementPage {
private WebDriver driver;
	
	public AssetManagerStrategyManagementPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public static PropertiesManager properties = PropertiesManager.getInstance();
	private final By STRATEGY_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Strategy Management')]");
	private final By STRATEGY_MANAGEMENT_LABEL = By.xpath("//legend[contains(text(),'Strategy Management')]");
	private final By STRATEGY_MANAGEMENT_SEARCH_HEADER = By.xpath("//th[text()='D']");
	private final By STRATEGY_MANAGEMENT_NAME_HEADER = By.xpath("//th[contains(text(),'Name')]");
	private final By STRATEGY_MANAGEMENT_DESCRIPTION_HEADER = By.xpath("//th[contains(text(),'Description')]");
	private final By STRATEGY_MANAGEMENT_NEWSTRATEGY_BUTTON = By.xpath("//span[contains(text(),'New Strategy')]");
	private final By STRATEGY_MANAGEMENT_BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	
	public WebElement strategyManagementTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_TAB, WAIT_SECONDS);
	}
	
	public String strategyManagementLabelElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_LABEL, WAIT_SECONDS).getText();
	}
	
	public String strategyManagementSearchHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_SEARCH_HEADER, WAIT_SECONDS).getText();
	}
	
	public String strategyManagementNameHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_NAME_HEADER, WAIT_SECONDS).getText();
	}
	
	public String strategyManagementDescriptionHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_DESCRIPTION_HEADER, WAIT_SECONDS).getText();
	}
	
	public String strategyManagementNewStrategyButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_NEWSTRATEGY_BUTTON, WAIT_SECONDS).getText();
	}
	
	public String strategyManagementBackButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_BACK_BUTTON, WAIT_SECONDS).getText();
	}
	
	public boolean verifyStrategyManagementPageDetails(String strategyManagementLabelText, String searchHeaderText, String nameHeaderText, String descHeaderText, String newStrategyButtonText, String backButtonText) throws Exception{
		boolean flag = false;
		try {
			if(strategyManagementTabElement().isDisplayed()){
				SeleniumUtils.Click(strategyManagementTabElement(), properties.getLogMessage("StrategyManagementTabClicked"));
				if(strategyManagementLabelElementText().equals(strategyManagementLabelText) && strategyManagementSearchHeaderElementText().equals(searchHeaderText) && strategyManagementNameHeaderElementText().equals(nameHeaderText) && strategyManagementDescriptionHeaderElementText().equals(descHeaderText) && strategyManagementNewStrategyButtonElementText().equals(newStrategyButtonText) && strategyManagementBackButtonElementText().equals(backButtonText)){
					flag = true;
					TestBase.logInfo(String.format(properties.getLogMessage("StrategyManagementDetailsVerified"), strategyManagementLabelElementText(), strategyManagementSearchHeaderElementText(), strategyManagementNameHeaderElementText(), strategyManagementDescriptionHeaderElementText(), strategyManagementNewStrategyButtonElementText(), strategyManagementBackButtonElementText(), strategyManagementLabelText, searchHeaderText, nameHeaderText, descHeaderText, newStrategyButtonText, backButtonText));
					return flag;
				}
				else{
					TestBase.logError(String.format(properties.getLogMessage("StrategyManagementDetailsNotMatched"), strategyManagementLabelText, searchHeaderText, nameHeaderText, descHeaderText, newStrategyButtonText, backButtonText, strategyManagementLabelElementText(), strategyManagementSearchHeaderElementText(), strategyManagementNameHeaderElementText(), strategyManagementDescriptionHeaderElementText(), strategyManagementNewStrategyButtonElementText(), strategyManagementBackButtonElementText()));
				}
			}
			else{
				TestBase.logError(properties.getLogMessage("StrategyManagementTabNotFound"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
