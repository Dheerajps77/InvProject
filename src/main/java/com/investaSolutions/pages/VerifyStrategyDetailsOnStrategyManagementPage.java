package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyStrategyDetailsOnStrategyManagementPage {

	WebDriver driver;

	public VerifyStrategyDetailsOnStrategyManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By strategyManagementTab = By.xpath("//a//span[text()='Strategy Management ']");
	public final By strategyManagementTitleTextElement = By.xpath("//div[@class='layout-content']//legend");
	public final By searchPlusButton = By
			.xpath("//div[@class='ui-table ui-widget']//table//tr[1]//td[1]//fa-icon[@icon='search-plus']");
	public final By strategyNameText = By.xpath("//div[@class='ui-table ui-widget']//table//tr[1]//td[2]");
	public final By strategyManagmentParentTitle = By.xpath("//legend[text()='Strategy Management : ']");
	public final By strategyMangementNameTitleWithStrategyNameText = By
			.xpath("//legend[text()='Strategy Details']//preceding::legend");
	public final By strategyDetailsTitleText = By.xpath("//legend[text()='Strategy Details']");
	public final By strategyDetailsTabTitleText = By.xpath(" //a[@role='tab']//span[text()='Strategy Details']");
	public final By backButton = By.xpath("//button[@label='Back']");
	public final By NEW_STRATEGYBUTTON = By.xpath("//button[@label='New Strategy']");
	public final By labelsNameOnStrategyDetails = By.xpath(
			"//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div//div[contains(@class,'ui-g-12 ui-md-6')]//label");
	public final By NEW_STRATEGYBUTTON_UNDER_STRATEGYDETAILS_TAB = By.xpath(
			"//button[@class='ui-button-warning ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");
	public final By COLLECTED_ELEMENTS_OF_STRATEGYNAME = By
			.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//tbody//tr");

	public boolean clickOnStrategyManagementTab() throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, strategyManagementTab, 30).click();
			flag = true;
			TestBase.logInfo(
					String.format(TestBase.properties.getLogMessage("VerifyClickOnStrategyManagmentTabPassed")));
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyClickOnStrategyManagmentTabFailed")));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyManagementTab(String strategyManagementText) throws Exception {
		boolean flag = false;
		String getstrategyManagementTextFromUI = "";
		SeleniumUtils objSeleniumUtils;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getstrategyManagementTextFromUI = objSeleniumUtils.getTitleText(driver, strategyManagementTab);
			if (getstrategyManagementTextFromUI.equalsIgnoreCase(strategyManagementText)
					&& objSeleniumUtils.IsElementDisplayed(driver, strategyManagementTab)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyStrategyManagementTabTitlePassed"),
								strategyManagementText, getstrategyManagementTextFromUI));

			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStrategyManagementTabTitleFailed"),
					strategyManagementText, getstrategyManagementTextFromUI));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyManagmentTitle(String strategyManagementTitleText) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String getTitleTextFromUI = null;
		try {

			objSeleniumUtils = new SeleniumUtils();
			getTitleTextFromUI = objSeleniumUtils.getTitleText(driver, strategyManagementTitleTextElement);
			Thread.sleep(2000);
			if (getTitleTextFromUI.equalsIgnoreCase(strategyManagementTitleText.trim())) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStrategyManagementTitlePassed"),
						strategyManagementTitleText, getTitleTextFromUI));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStrategyManagementTitleFailed"),
					strategyManagementTitleText, getTitleTextFromUI));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyListPageOpened(String strategyListUrlFraction, String strategyListPageURL)
			throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String getCurrentURLOfPage = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (clickOnStrategyManagementTab()) {
				getCurrentURLOfPage = objSeleniumUtils.GetCurrentPageURL(driver);
				flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, strategyListUrlFraction, 30);
				if (flag) {
					flag = true;
					TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifystrategyListPageURLPassed"),
							getCurrentURLOfPage, strategyListPageURL));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifystrategyListPageURLFailed"),
					getCurrentURLOfPage, strategyListPageURL));
			throw e;
		}
		return flag;
	}

	public boolean clickOnNewStrategyButton() throws Exception {
		boolean flag = false;
		String getNewStrategyButtonText = "";
		SeleniumUtils objSeleniumUtils;
		try {
			Thread.sleep(3000);
			objSeleniumUtils = new SeleniumUtils();
			boolean isElementPresentFlag = SeleniumUtils.isElementPresent(driver, NEW_STRATEGYBUTTON);
			if (isElementPresentFlag) {
				getNewStrategyButtonText = objSeleniumUtils.getTitleText(driver, NEW_STRATEGYBUTTON);
				Thread.sleep(2000);
				SeleniumUtils.scrollToViewElement(driver, NEW_STRATEGYBUTTON);
				SeleniumUtils.waitForElementClickable(driver, NEW_STRATEGYBUTTON, 30).click();
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyNewStrategyButtonPassed"),
						getNewStrategyButtonText));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewStrategyButtonFailed"),
					getNewStrategyButtonText));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyManagementPageOpened(String strategyManagementUrlFraction,
			String strategyManagementURL) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String currentPageUrl = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.waitForElementPresence(driver, strategyManagmentParentTitle, 30);
			if (SeleniumUtils.isElementPresent(driver, strategyManagmentParentTitle)) {
				currentPageUrl = objSeleniumUtils.GetCurrentPageURL(driver);
				flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, strategyManagementUrlFraction, 30);
				if (flag) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyStrategyManagementPageURLPassed"),
									strategyManagementURL, currentPageUrl));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStrategyManagementPageURLPassed"),
					strategyManagementURL, currentPageUrl));
			throw e;
		}
		return flag;
	}

	public String StrategyNameInTable() throws Exception {
		SeleniumUtils objSeleniumUtils;
		String strategyName;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.waitForElementPresence(driver, strategyNameText, 30);
			strategyName = objSeleniumUtils.getTitleText(driver, strategyNameText);
		} catch (Exception e) {
			throw e;
		}
		return strategyName;
	}

	public boolean stategyManagementTitleWithStrategyNameInStrategyManagementPage(String strategyName,
			String strategyManagmentText) throws Exception {
		SeleniumUtils obSeleniumUtils;
		String expectedStrategyNameWithStrategyManagementTitle = null;
		String actualStrategyNameWithStrategyManagementTitle = null;
		boolean flag = false;
		try {
			obSeleniumUtils = new SeleniumUtils();
			actualStrategyNameWithStrategyManagementTitle = obSeleniumUtils.getTitleText(driver,
					strategyMangementNameTitleWithStrategyNameText);
			expectedStrategyNameWithStrategyManagementTitle = strategyManagmentText.trim() + " : " + strategyName;

			if (actualStrategyNameWithStrategyManagementTitle
					.equalsIgnoreCase(expectedStrategyNameWithStrategyManagementTitle)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage(
								"VerifystategyManagementTitleWithStrategyNameInStrategyManagementPagePassed"),
						strategyName, expectedStrategyNameWithStrategyManagementTitle,
						actualStrategyNameWithStrategyManagementTitle));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage(
							"VerifystategyManagementTitleWithStrategyNameInStrategyManagementPagePassed"),
					strategyName, expectedStrategyNameWithStrategyManagementTitle,
					actualStrategyNameWithStrategyManagementTitle));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyManagementTabAndStrategyListPageDetails(String strategyManagementText,
			String strategyManagementTitleText, String strategyListUrlFraction, String strategyListPageURL,
			String strategyManagementUrlFraction, String strategyManagementURL, String backButtonLabel,
			String newStrategyButtonLabel) throws Exception {
		boolean flag = false;
		try {

			if (verifyStrategyManagementTab(strategyManagementText)) {
				if (verifyStrategyListPageOpened(strategyListUrlFraction, strategyListPageURL)) {
					if (verifyStrategyManagmentTitle(strategyManagementTitleText)) {
						if (verifyButtonsUnderStrategyDetails(backButtonLabel, newStrategyButtonLabel)) {
							if (clickOnNewStrategyButton()) {
								if (verifyStrategyManagementPageOpened(strategyManagementUrlFraction,
										strategyManagementURL)) {
									flag = true;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public ArrayList<String> getStrategyDetailsLabelName() {
		ArrayList<String> arrayList = null;
		List<WebElement> strategyDetailsLabelElements;
		String labelNamesValue;
		int totalCountOfLabelNames;
		try {
			arrayList = new ArrayList<String>();
			strategyDetailsLabelElements = driver.findElements(labelsNameOnStrategyDetails);
			totalCountOfLabelNames = strategyDetailsLabelElements.size();
			for (int i = 1; i <= totalCountOfLabelNames; i++) {
				WebElement labelNameElement = driver.findElement(
						By.xpath("//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div[" + i
								+ "]//div[contains(@class,'ui-g-12 ui-md-6')]//label"));
				labelNamesValue = labelNameElement.getText();
				arrayList.add(labelNamesValue);
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	public boolean verifyStrategyDetailsTabTitle(String StrategyDetailsTabLabel) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		String getStrategyDetailsTablTitle = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			Thread.sleep(2000);
			getStrategyDetailsTablTitle = objSeleniumUtils.getTitleText(driver, strategyDetailsTabTitleText);
			if (StrategyDetailsTabLabel.equalsIgnoreCase(getStrategyDetailsTablTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsTabTitlePassed"),
						StrategyDetailsTabLabel, getStrategyDetailsTablTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsTabTitleFailed"),
					StrategyDetailsTabLabel, getStrategyDetailsTablTitle));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyDetailsTitle(String StrategyDetailsTitleLabel) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		String getStrategyDetailsTitle = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			getStrategyDetailsTitle = objSeleniumUtils.getTitleText(driver, strategyDetailsTitleText);
			if (StrategyDetailsTitleLabel.equalsIgnoreCase(getStrategyDetailsTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsTitlePassed"),
						StrategyDetailsTitleLabel, getStrategyDetailsTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsTitleFailed"),
					StrategyDetailsTitleLabel, getStrategyDetailsTitle));
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyDetailsLabelName(String strategyNameLabel, String shortDescription,
			String strategyHighlightsLabel, String strategyImageLabel) throws Exception {

		ArrayList<String> listOfLabels = null;
		boolean flag = false;
		try {
			listOfLabels = getStrategyDetailsLabelName();
			if (listOfLabels.contains(strategyNameLabel.trim()) && listOfLabels.contains(shortDescription)
					&& listOfLabels.contains(strategyHighlightsLabel)
					&& listOfLabels.contains(strategyImageLabel.trim())) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyStrategyDetailsLabelNamePassed"), strategyNameLabel,
						shortDescription, strategyHighlightsLabel, strategyImageLabel, listOfLabels));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsLabelNameFailed"),
					strategyNameLabel, shortDescription, strategyHighlightsLabel, strategyImageLabel, listOfLabels));
			throw e;
		}
		return flag;
	}

	public boolean clickOnStrategyDetailsTab() throws Exception {
		boolean flag = false;
		String getStrategyDetailsTabText = "";
		try {
			Thread.sleep(2000);
			if (SeleniumUtils.isElementPresent(driver, strategyDetailsTabTitleText)) {
				getStrategyDetailsTabText = driver.findElement(strategyDetailsTabTitleText).getText();
				Thread.sleep(2000);
				SeleniumUtils.waitForElementClickable(driver, strategyDetailsTabTitleText, 30).click();
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsTabButtonPassed"),
								getStrategyDetailsTabText));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStrategyDetailsTabButtonFailed"),
					getStrategyDetailsTabText));
			throw e;
		}
		return flag;
	}

	public boolean verifyButtonsUnderStrategyDetails(String backButtonLabel, String newStrategyButtonLabel)
			throws Exception {
		boolean flag = false;
		String getbackButtonText = "";
		String getNewStrategyButtonText = "";
		try {
			SeleniumUtils.scrollToViewElement(driver, NEW_STRATEGYBUTTON_UNDER_STRATEGYDETAILS_TAB);
			Thread.sleep(2000);
			if (SeleniumUtils.isElementPresent(driver, backButton)
					&& SeleniumUtils.isElementPresent(driver, NEW_STRATEGYBUTTON_UNDER_STRATEGYDETAILS_TAB)) {
				getbackButtonText = driver.findElement(backButton).getText();
				getNewStrategyButtonText = driver.findElement(NEW_STRATEGYBUTTON_UNDER_STRATEGYDETAILS_TAB).getText();
				Thread.sleep(2000);
				if (backButtonLabel.equalsIgnoreCase(getbackButtonText)
						&& newStrategyButtonLabel.equalsIgnoreCase(getNewStrategyButtonText)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyButtonsUnderStrategyDetailsPassed"),
							backButtonLabel, getbackButtonText, newStrategyButtonLabel, getNewStrategyButtonText));
				}
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyButtonsUnderStrategyDetailsFailed"),
							backButtonLabel, getbackButtonText, newStrategyButtonLabel, getNewStrategyButtonText));
			throw e;
		}
		return flag;
	}

	/*
	 * This will check if existing Strategy is present under strategy management
	 */
	public boolean verifyCreatedNewlyStrategy(String newStrategyName) {
		boolean flag = false;
		List<WebElement> elements;
		try {
			elements = driver.findElements(COLLECTED_ELEMENTS_OF_STRATEGYNAME);
			int totalCountOfStrategyNameElement = elements.size();
			for (int i = 2; i <= totalCountOfStrategyNameElement; i++) {
				String strategyName = driver
						.findElement(By.xpath(
								"//div[@class='ui-table-wrapper ng-star-inserted']//table//tbody//tr[" + i + "]//td[2]"))
						.getText();
				if (strategyName.equals(newStrategyName)) {
					flag = true;
					break;
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public final By STRATEGY_NAME_VALUE = By.xpath(
			"//div[@class='ui-g ui-fluid']//div[2]//b[1]//input");
	public final By STRATEGY_DESCRIPTION = By.xpath(
			"//div[@class='ui-g ui-fluid']//div[2]//textarea");
	public final By SUCCESSMESSAGE = By.xpath("//*[contains(@class,'ui-messages-success')]//ul/li");

	public boolean EnterStrategyDetails(String strategyName, String strategyDescriptions) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			objSeleniumUtils.SendToTextbox(driver, STRATEGY_NAME_VALUE, strategyName);
			objSeleniumUtils.SendToTextbox(driver, STRATEGY_DESCRIPTION, strategyDescriptions);
			SeleniumUtils.scrollToViewElement(driver, NEW_STRATEGYBUTTON_UNDER_STRATEGYDETAILS_TAB);
			Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, NEW_STRATEGYBUTTON_UNDER_STRATEGYDETAILS_TAB, 30).click();

			if (driver.findElement(SUCCESSMESSAGE).getText()
					.equalsIgnoreCase("Successstrategy is successfully saved")) {
				driver.navigate().back();				
				flag = true;
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean CreateNewStrategy(String newStrategyName, String strategyDescriptions) throws Exception {
		boolean flag = false;
		try {

			if (clickOnStrategyManagementTab()) {
				if (clickOnNewStrategyButton()) {
					if (EnterStrategyDetails(newStrategyName, strategyDescriptions)) {
						if(verifyCreatedNewlyStrategy(newStrategyName))
						{
							flag=true;
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean verifyStrategyDetailsOnStrategyManagementPage(String StrategyDetailsTabLabel,
			String strategyDetailsLabel, String strategyNameLabel, String shortDescription,
			String strategyHighlightsLabel, String strategyImageLabel, String backButtonLabel,
			String newStrategyButtonLabel) throws Exception {
		boolean flag = false;
		try {
			if (clickOnStrategyManagementTab()) {
				if (clickOnNewStrategyButton()) {
					if (clickOnStrategyDetailsTab()) {
						if (verifyStrategyDetailsTabTitle(StrategyDetailsTabLabel)) {
							if (verifyStrategyDetailsTitle(StrategyDetailsTabLabel)) {
								if (verifyButtonsUnderStrategyDetails(backButtonLabel, newStrategyButtonLabel)) {
									if (verifyStrategyDetailsLabelName(strategyNameLabel, shortDescription,
											strategyHighlightsLabel, strategyImageLabel)) {
										flag = true;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
}
