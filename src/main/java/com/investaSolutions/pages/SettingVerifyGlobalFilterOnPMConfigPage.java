package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class SettingVerifyGlobalFilterOnPMConfigPage {

	WebDriver driver;

	public SettingVerifyGlobalFilterOnPMConfigPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By SETTINGS_TAB = By
			.xpath("//a[@class='ripplelink ng-tns-c2-0 ng-star-inserted']//span[text()='Settings']");
	public final By SETTINGS_TAB_DROPDOWNVALUES_TEXT = By.xpath(
			"//ul[@class='ng-tns-c2-1 ng-tns-c2-0 ng-trigger ng-trigger-children ng-star-inserted']//li//a//span[@class='ng-tns-c2-1']");
	public final By GLOBALFILTER_TEXTBOX = By
			.xpath("//div[@class='ui-table-caption ui-widget-header ng-star-inserted']//input");

	// This will get all dropdown text values of Settings Tab
	public ArrayList<String> getSettingsTabDropDownText() {
		ArrayList<String> arrayList;
		List<WebElement> dropDownTextElements;
		WebElement element;
		try {
			arrayList = new ArrayList<String>();
			dropDownTextElements = driver.findElements(SETTINGS_TAB_DROPDOWNVALUES_TEXT);
			int counts = dropDownTextElements.size();

			for (int i = 1; i < counts; i++) {
				element = driver.findElement(By.xpath(
						"//ul[@class='ng-tns-c2-1 ng-tns-c2-0 ng-trigger ng-trigger-children ng-star-inserted']//li["
								+ i + "]//a//span"));
				String textValue = element.getText();
				arrayList.add(textValue);
			}

		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	// This will verify the Settings Tab
	public boolean verifySettingsTab() {
		boolean flag = false;
		String tabText = null;
		try {

			if (SeleniumUtils.isElementPresent(driver, SETTINGS_TAB)) {
				tabText = driver.findElement(SETTINGS_TAB).getText();
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifySettingsTabTitlePassed"), tabText));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifySettingsTabTitleFailed"), tabText));
			throw e;
		}
		return flag;
	}

	// This will verify the Settings Tab Text
	public boolean verifySettingsTabText(String settingsTabText) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String getTitleTextOfSettingTab = null;
		try {
			if (verifySettingsTab()) {
				objSeleniumUtils = new SeleniumUtils();
				getTitleTextOfSettingTab = objSeleniumUtils.getTitleText(driver, SETTINGS_TAB);
				if (getTitleTextOfSettingTab.equalsIgnoreCase(settingsTabText)) {
					flag=true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifySettingsTabTextTitlePassed"),
									settingsTabText, getTitleTextOfSettingTab));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifySettingsTabTextTitleFailed"),
					settingsTabText, getTitleTextOfSettingTab));
			throw e;
		}
		return flag;
	}

	// This will click on Settings Tab
	public boolean clickOnSettingsTab(String settingsTabText) throws Exception {
		boolean flag = false;
		WebElement clickOnSettingsTab;
		String tabTextValue = null;
		try {
			if (verifySettingsTabText(settingsTabText)) {
				clickOnSettingsTab = driver.findElement(SETTINGS_TAB);
				tabTextValue = clickOnSettingsTab.getText();
				SeleniumUtils.waitAndClick(driver, clickOnSettingsTab, 20);
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyClickOnSettingsTabPassed"),
						tabTextValue));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyClickOnSettingsTabFailed"), tabTextValue));
			throw e;
		}
		return flag;
	}

	// This will verify the dropdown value of Settings
	public boolean verifyPortfolioModelConfigurationDropDownValue(String dropdownValue) throws Exception {
		boolean flag = false;
		ArrayList<String> arrayList;
		WebElement dropdownElement;
		String dropdownTextValue = null;
		try {
			arrayList = getSettingsTabDropDownText();
			if (arrayList.contains(dropdownValue.trim())) {
				dropdownElement = driver.findElement(By.xpath("//a[@href='#/pm-configuration']"));
				dropdownTextValue = dropdownElement.getText();
				SeleniumUtils.waitAndClick(driver, dropdownElement, 20);
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyDropdownValuesInSettingsTabPassed"),
								dropdownTextValue));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyDropdownValuesInSettingsTabFailed"), dropdownTextValue));
			throw e;
		}
		return flag;
	}

	// This will verify pm-configuration page is opened or not
	public boolean verifyPMConfigurationPageOpened(String urlFractionValue, String expectedURL) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualURL = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			actualURL = objSeleniumUtils.GetCurrentPageURL(driver);
			if (objSeleniumUtils.WaitTillPageURLToBeLoad(driver, urlFractionValue, 30)) {
				if (actualURL.equalsIgnoreCase(expectedURL)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyPMConfingurationPageURLPassed"),
									urlFractionValue, expectedURL, actualURL));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyPMConfingurationPageURLFailed"),
					urlFractionValue, expectedURL, actualURL));
			throw e;
		}
		return flag;
	}

	// This will verify the Global filter textBox
	public boolean verifyGlobalFilterTextBox(String assetManagerNameValue) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils = null;
		WebElement globalFilterTextBoxWebElement;
		VerifyInstrumentsPage objVerifyInstrumentsPage;
		ArrayList<String> arrayList;
		try {
			objSeleniumUtils=new SeleniumUtils();
			objVerifyInstrumentsPage = new VerifyInstrumentsPage(driver);
			if (objVerifyInstrumentsPage.VerifyGlobalFilterSearchTextBox()) {
				globalFilterTextBoxWebElement = driver.findElement(GLOBALFILTER_TEXTBOX);
				globalFilterTextBoxWebElement.sendKeys(assetManagerNameValue);
				Thread.sleep(2000);
				arrayList = objSeleniumUtils.getSepcificColumnCellDetailsFromTable(driver);
				if (arrayList.contains(assetManagerNameValue)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyColumnCellsUnderTableInPMConfigurationPagePassed"),
							assetManagerNameValue));
				}

			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyColumnCellsUnderTableInPMConfigurationPageFailed"),
					assetManagerNameValue));
			throw e;
		}
		return flag;
	}

	// This Verify Global filter functionality on PM Configuration page
	public boolean verifyGlobalFilterFunctionalityOnPMConfigurationPage(String settingsTabText, String dropdownValue,
			String urlFractionValue, String expectedURL, String assetManagerNameValue) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			if (clickOnSettingsTab(settingsTabText)) {
				if (verifyPortfolioModelConfigurationDropDownValue(dropdownValue)) {
					if (verifyPMConfigurationPageOpened(urlFractionValue, expectedURL)) {
						if (verifyGlobalFilterTextBox(assetManagerNameValue)) {
							flag = true;
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
