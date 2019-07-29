package com.investaSolutions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AssetManagerPortalPage {

	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public AssetManagerPortalPage (WebDriver driver) {
		this.driver = driver;
	}

	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By DASHBOARD_TAB = By.xpath("//span[contains(text(),'Dashboard')]");
	private final By ASSET_MANAGER_TAB = By.xpath("//span[contains(text(),'Asset Manager')]");
	private final By STRATEGY_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Strategy Management')]");
	private final By INSTRUMENT_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Instrument Management')]");
	private final By PORTFOLIO_MODEL_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Portfolio Model Management')]");
	private final By PORTFOLIO_MODEL_APPROVAL_TAB = By.xpath("//span[contains(text(),'Portfolio Model Approval')]");
	private final By DISCONNECT_TAB = By.xpath("//span[contains(text(),'Disconnect')]");
	private final By LANGUAGE_TAB = By.xpath("//i[@class='topbar-icon material-icons']");

	public String assetManagerPortalDashboardElementText() {
		return SeleniumUtils.waitForElementPresence(driver, DASHBOARD_TAB, WAIT_SECONDS).getText();
	}

	public String assetManagerPortalAssetManagerElementText() {
		return SeleniumUtils.waitForElementPresence(driver, ASSET_MANAGER_TAB, WAIT_SECONDS).getText();
	}

	public String assetManagerPortalStrategyManagementElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_TAB, WAIT_SECONDS).getText();
	}

	public String assetManagerPortalInstrumentManagementElementText() {
		return SeleniumUtils.waitForElementPresence(driver, INSTRUMENT_MANAGEMENT_TAB, WAIT_SECONDS).getText();
	}

	public String assetManagerPortalPortfolioModelManagementElementText() {
		return SeleniumUtils.waitForElementPresence(driver, PORTFOLIO_MODEL_MANAGEMENT_TAB, WAIT_SECONDS).getText();
	}

	public String assetManagerPortalPortfolioModelApprovalElementText() {
		return SeleniumUtils.waitForElementPresence(driver, PORTFOLIO_MODEL_APPROVAL_TAB, WAIT_SECONDS).getText();
	}

	public String assetManagerPortalDisconnectElementText() {
		return SeleniumUtils.waitForElementPresence(driver, DISCONNECT_TAB, WAIT_SECONDS).getText();
	}
	
	public WebElement assetManagerPortalLanguageElement() {
		return SeleniumUtils.waitForElementPresence(driver, LANGUAGE_TAB, WAIT_SECONDS);
	}

	public boolean verifyAssetManagerPortalPageDetails(String dashboardTab, String assetManagerTab, String strategyManagementTab, String instrumentManagementTab, String portfolioModelManagementTab, String portfolioModelApprovalTab, String disconnectTab){
		boolean flag = false;
		if(assetManagerPortalDashboardElementText().equals(dashboardTab) && assetManagerPortalAssetManagerElementText().equals(assetManagerTab) && assetManagerPortalStrategyManagementElementText().equals(strategyManagementTab) && assetManagerPortalInstrumentManagementElementText().equals(instrumentManagementTab) && assetManagerPortalPortfolioModelManagementElementText().equals(portfolioModelManagementTab) && assetManagerPortalPortfolioModelApprovalElementText().equals(portfolioModelApprovalTab) && assetManagerPortalDisconnectElementText().equals(disconnectTab) && assetManagerPortalLanguageElement().isDisplayed()){
			flag = true;
			TestBase.logInfo(String.format(properties.getLogMessage("AssetManagerPortalPageDetailsVerified"), dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab, 
					assetManagerPortalDashboardElementText(), assetManagerPortalAssetManagerElementText(), assetManagerPortalStrategyManagementElementText(), assetManagerPortalInstrumentManagementElementText(), assetManagerPortalPortfolioModelManagementElementText(), assetManagerPortalPortfolioModelApprovalElementText(), assetManagerPortalDisconnectElementText()));
			return flag;
		}		
		return flag;
	}
}
