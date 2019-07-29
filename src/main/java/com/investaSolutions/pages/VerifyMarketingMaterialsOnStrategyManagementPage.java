package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyMarketingMaterialsOnStrategyManagementPage {

	WebDriver driver;

	public VerifyMarketingMaterialsOnStrategyManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By STRATEGY_MANAGEMENT_TAB = By.xpath("//a//span[text()='Strategy Management ']");
	public final By STRATEGY_MANAGEMENT_TITLET_EXT_ELEMENT = By.xpath("//div[@class='layout-content']//legend");
	public final By SEARCH_PLUS_BUTTON = By
			.xpath("//div[@class='ui-table ui-widget']//table//tr[1]//td[1]//fa-icon[@icon='search-plus']");
	public final By STRATEGYNAMET_EXT = By.xpath("//div[@class='ui-table ui-widget']//table//tr[1]//td[2]");
	public final By STRATEGYMANAGEMENT_NAME_TITLE_WITH_STRATEGYNAME_TEXT = By
			.xpath("//legend[text()='Strategy Details']//preceding::legend");
	public final By MARKET_MATERIALS_TITLE_TEXT = By.xpath("//legend[text()='Marketing Materials']");
	public final By MARKET_MATERIALS_TITLE_TAB_TEXT = By.xpath(" //a[@role='tab']//span[text()='Marketing Materials']");
	public final By BACK_BUTTON = By.xpath("//button[@label='Back']");
	public final By SAVE_BUTTON = By.xpath("//button//span[text()='Save']");
	public final By INVESTMENT_OBJECTIVES_NAME = By.xpath(
			"//legend[text()='Investment Objectives']//following::div[@class='ui-table ui-widget ui-table-hoverable-rows']//table//thead//tr//th[2]");
	public final By TITLE_OF_INVESTMENTOBJECTIVES = By.xpath(
			"//legend[text()='Investment Objectives']//following::div[@class='ui-toolbar-group-left']//parent::span[text()=' Please order investment Objectives from lowest to highest risk']");
	public final By INVESTMENT_OBJECTIVES_DESCRIPTION = By.xpath(
			"//legend[text()='Investment Objectives']//following::div[@class='ui-table ui-widget ui-table-hoverable-rows']//table//thead//tr//th[3]");
	public final By LABELS_NAMES = By.xpath("//legend[text()='Marketing Materials']//following::label[@for='input']");
	public final By NEW_STRATEGYBUTTON = By.xpath("//button[@label='New Strategy']");

	public boolean clickOnStrategyManagementTab() throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, STRATEGY_MANAGEMENT_TAB, 30).click();
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
				SeleniumUtils.scrollToViewElement(driver, NEW_STRATEGYBUTTON);
				Thread.sleep(2000);
				SeleniumUtils.waitForElementClickable(driver, NEW_STRATEGYBUTTON, 30).click();
				Thread.sleep(2000);
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

	public boolean clickOnMarketingMaterialsTab() throws Exception {
		boolean flag = false;
		String getInvestmentObjectivesTabText = "";
		try {
			Thread.sleep(2000);
			if (SeleniumUtils.isElementPresent(driver, MARKET_MATERIALS_TITLE_TAB_TEXT)) {
				getInvestmentObjectivesTabText = driver.findElement(MARKET_MATERIALS_TITLE_TAB_TEXT).getText();
				Thread.sleep(2000);
				SeleniumUtils.waitForElementClickable(driver, MARKET_MATERIALS_TITLE_TAB_TEXT, 30).click();
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTabButtonPassed"),
								getInvestmentObjectivesTabText));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTabButtonFailed"),
							getInvestmentObjectivesTabText));
			throw e;
		}
		return flag;
	}

	public boolean verifyMarketingMaterialsTabTitle(String marketingMaterialsTabLabel) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		String getmarketingMaterialsTablTitle = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			Thread.sleep(2000);
			getmarketingMaterialsTablTitle = objSeleniumUtils.getTitleText(driver, MARKET_MATERIALS_TITLE_TAB_TEXT);
			if (marketingMaterialsTabLabel.equalsIgnoreCase(getmarketingMaterialsTablTitle)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTabTitlePassed"),
								marketingMaterialsTabLabel, getmarketingMaterialsTablTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTabTitleFailed"),
					marketingMaterialsTabLabel, getmarketingMaterialsTablTitle));
			throw e;
		}
		return flag;
	}

	public final By NEW_STRATEGYBUTTON_UNDER_MARKETINGMATERIALS_TAB = By.xpath(
			"//button[@class='ui-button-warning ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");

	public boolean verifyButtonsUnderMarketingMaterials(String backButtonLabel, String newStrategyButtonLabel) {
		boolean flag = false;
		String getbackButtonText = "";
		String getNewStrategyButtonText = "";

		try {

			if (SeleniumUtils.isElementPresent(driver, BACK_BUTTON)
					&& SeleniumUtils.isElementPresent(driver, NEW_STRATEGYBUTTON_UNDER_MARKETINGMATERIALS_TAB)) {
				//SeleniumUtils.scrollToViewElement(driver, NEW_STRATEGYBUTTON_UNDER_MARKETINGMATERIALS_TAB);
				getbackButtonText = driver.findElement(BACK_BUTTON).getText();
				getNewStrategyButtonText = driver.findElement(NEW_STRATEGYBUTTON_UNDER_MARKETINGMATERIALS_TAB).getText();
				if (backButtonLabel.equalsIgnoreCase(getbackButtonText)
						&& newStrategyButtonLabel.equalsIgnoreCase(getNewStrategyButtonText)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyButtonsUnderMarketingMaterialsPassed"),
							backButtonLabel, getbackButtonText, newStrategyButtonLabel, getNewStrategyButtonText));
				}
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyButtonsUnderMarketingMaterialsFailed"),
							backButtonLabel, getbackButtonText, newStrategyButtonLabel, getNewStrategyButtonText));
			throw e;
		}
		return flag;
	}

	public ArrayList<String> getLabelsNamesUnderMarketingMaterials() {
		ArrayList<String> arrayList = null;
		List<WebElement> element;
		String labelsNameValue = "";
		try {
			arrayList = new ArrayList<String>();
			element = driver.findElements(LABELS_NAMES);
			int countOfLabels = element.size();
			for (int i = 1; i <= countOfLabels; i++) {
				labelsNameValue = driver
						.findElement(By.xpath(
								"//legend[text()='Marketing Materials']//following::label[@for='input'][" + i + "]"))
						.getText();
				arrayList.add(labelsNameValue);
			}

		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	public boolean verifyInvestmentObjectivesLabelsName(String strategyVideoLabel, String updateFrequencyLabel,
			String effectiveDateLabel, String vidoeLabel, String strategySlidesLabel,
			String updateFrequencyLabelOfSlides, String slidesLabel, String strategyReportLabel,
			String updateFrequencyLabelOfReport, String reportLabel, String riskDisclosureLabel,
			String updateFrequencyLabelOfRisk, String reportLabelOfRisk) {
		ArrayList<String> arrayList = null;
		boolean flag = false;
		try {
			arrayList = getLabelsNamesUnderMarketingMaterials();
			if (arrayList.contains(strategyVideoLabel) && arrayList.contains(updateFrequencyLabel)
					&& arrayList.contains(effectiveDateLabel) && arrayList.contains(vidoeLabel)
					&& arrayList.contains(strategySlidesLabel) && arrayList.contains(updateFrequencyLabelOfSlides)
					&& arrayList.contains(slidesLabel) && arrayList.contains(strategyReportLabel)
					&& arrayList.contains(updateFrequencyLabelOfReport) && arrayList.contains(reportLabel)
					&& arrayList.contains(riskDisclosureLabel) && arrayList.contains(updateFrequencyLabelOfRisk)
					&& arrayList.contains(reportLabelOfRisk)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyMarketingMaterialsLabelNamePassed"),
						strategyVideoLabel, updateFrequencyLabel, effectiveDateLabel, vidoeLabel, strategySlidesLabel,
						updateFrequencyLabelOfSlides, slidesLabel, strategyReportLabel, updateFrequencyLabelOfReport,
						reportLabel, riskDisclosureLabel, updateFrequencyLabelOfRisk, reportLabelOfRisk, arrayList));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyMarketingMaterialsLabelNameFailed"), strategyVideoLabel,
					updateFrequencyLabel, effectiveDateLabel, vidoeLabel, strategySlidesLabel,
					updateFrequencyLabelOfSlides, slidesLabel, strategyReportLabel, updateFrequencyLabelOfReport,
					reportLabel, riskDisclosureLabel, updateFrequencyLabelOfRisk, reportLabelOfRisk, arrayList));
			throw e;
		}
		return flag;
	}

	public boolean verifyMarketingMaterialsTitle(String marketMaterialsTitleLabel) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		String getMarketMaterialsTitle = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			getMarketMaterialsTitle = objSeleniumUtils.getTitleText(driver, MARKET_MATERIALS_TITLE_TEXT);
			if (marketMaterialsTitleLabel.equalsIgnoreCase(getMarketMaterialsTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTitlePassed"),
						marketMaterialsTitleLabel, getMarketMaterialsTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTitleFailed"),
					marketMaterialsTitleLabel, getMarketMaterialsTitle));
			throw e;
		}
		return flag;
	}

	public boolean verifyMarketMaterialsOnStrategyManagementPage(String marketingMaterialsTabLabel,
			String marketMaterialsTitleLabel, String backButtonLabel, String newStrategyButtonLabel,
			String strategyVideoLabel, String updateFrequencyLabel, String effectiveDateLabel, String vidoeLabel,
			String strategySlidesLabel, String updateFrequencyLabelOfSlides, String slidesLabel,
			String strategyReportLabel, String updateFrequencyLabelOfReport, String reportLabel,
			String riskDisclosureLabel, String updateFrequencyLabelOfRisk, String reportLabelOfRisk) throws Exception {
		boolean flag = false;
		try {
			if (clickOnStrategyManagementTab()) {
				if (clickOnNewStrategyButton()) {
					if (clickOnMarketingMaterialsTab()) {
						if (verifyMarketingMaterialsTabTitle(marketingMaterialsTabLabel)) {
							if (verifyMarketingMaterialsTitle(marketMaterialsTitleLabel)) {
								if (verifyButtonsUnderMarketingMaterials(backButtonLabel, newStrategyButtonLabel)) {
									if (verifyInvestmentObjectivesLabelsName(strategyVideoLabel, updateFrequencyLabel,
											effectiveDateLabel, vidoeLabel, strategySlidesLabel,
											updateFrequencyLabelOfSlides, slidesLabel, strategyReportLabel,
											updateFrequencyLabelOfReport, reportLabel, riskDisclosureLabel,
											updateFrequencyLabelOfRisk, reportLabelOfRisk)) {
										flag = true;
									}
								}
							}
						}
					}
				}
			}

		} catch (

		Exception e) {
			throw e;
		}
		return flag;
	}

}
