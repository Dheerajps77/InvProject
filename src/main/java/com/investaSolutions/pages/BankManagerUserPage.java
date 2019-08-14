package com.investaSolutions.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class BankManagerUserPage {

	WebDriver driver;

	public BankManagerUserPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By USER_TAB_TITLE = By.xpath("//span[text()='Users ']");
	public final By USER_MANAGEMENT_TITLE_TEXT = By.xpath("//div[@class='layout-main module-container']//legend");
	public final By BACKBUTTON = By.xpath(
			"//button[@class='ui-button-danger ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");
	public final By NEW_USERBUTTON = By.xpath(
			"//button[@class='ui-button-warning ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");

	// This will verify the user tab in the user-list page
	public boolean verifyUserTab(String userTabTitleText) throws Exception {

		boolean flag;
		WebElement tabButton;
		SeleniumUtils objSeleniumUtils;
		String getUserTabTitleText = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			flag = SeleniumUtils.isElementPresent(driver, USER_TAB_TITLE);
			Thread.sleep(3000);
			if (flag) {
				getUserTabTitleText = objSeleniumUtils.getTitleText(driver, USER_TAB_TITLE);
				if (verifyUserTabTitleText(userTabTitleText)) {
					tabButton = SeleniumUtils.waitForElementClickable(driver, USER_TAB_TITLE, 30);
					Thread.sleep(3000);
					SeleniumUtils.waitAndClick(driver, tabButton, 10);
					TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyUserTabTitlePassed"),
							getUserTabTitleText));
				}
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyUserTabTitleFailed"), getUserTabTitleText));
			throw e;
		}
		return flag;
	}

	// This is to verify the title of user management
	public boolean VerifyUserManagementTitle(String expectedUserManagementTitleTextValue) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualUserManagementTitleTextValue = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, USER_MANAGEMENT_TITLE_TEXT)) {
				actualUserManagementTitleTextValue = objSeleniumUtils.getTitleText(driver, USER_MANAGEMENT_TITLE_TEXT);
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyUserManagementTitleTextPassed"),
						expectedUserManagementTitleTextValue, actualUserManagementTitleTextValue));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyUserManagementTitleTextFailed"),
					expectedUserManagementTitleTextValue, actualUserManagementTitleTextValue));
			throw e;
		}
		return flag;
	}

	// This will verify user tab title text
	public boolean verifyUserTabTitleText(String userTabTitleText) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String getTabTitleText = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getTabTitleText = objSeleniumUtils.getTitleText(driver, USER_TAB_TITLE);
			Thread.sleep(2000);
			if (getTabTitleText.equalsIgnoreCase(userTabTitleText)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyUserTabTextTitlePassed"),
						userTabTitleText, getTabTitleText));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyUserTabTextTitleFailed"),
					userTabTitleText, getTabTitleText));
			throw e;
		}
		return flag;
	}

	// This will verify the user-list page opened
	public boolean verifyUserListPageOpened(String fractionURLValue, String exepctedURL) throws Exception {
		boolean flag;
		String actualURL = null;
		SeleniumUtils objSeleniumUtils;
		try {
			objSeleniumUtils = new SeleniumUtils();
			actualURL = SeleniumUtils.getCurrentPageTitle(driver);
			Thread.sleep(2000);
			flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, fractionURLValue, 30);
			if (flag) {
				if (exepctedURL.equalsIgnoreCase(actualURL)) {
					TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyUserListPageURLPassed"),
							fractionURLValue, exepctedURL, actualURL));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyUserListPageURLFailed"),
					fractionURLValue, exepctedURL, actualURL));
			throw e;
		}
		return flag;
	}

	// This will Verify back button
	public boolean verifyBackButton(String backButtonText) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		boolean flag;
		String getBackButtonText = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			flag = objSeleniumUtils.IsElementDisplayed(driver, BACKBUTTON);
			if (flag) {
				getBackButtonText = objSeleniumUtils.getTitleText(driver, BACKBUTTON);
				if (getBackButtonText.equalsIgnoreCase(backButtonText)) {
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyBackButtonOnUserPagePassed"),
									backButtonText, getBackButtonText));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyBackButtonOnUserPageFailed"),
					backButtonText, getBackButtonText));
			throw e;
		}
		return flag;
	}

	// This will Verify new user button
	public boolean verifyNewUserButton(String newUserButtonText) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		boolean flag;
		String getNewUserButtonText = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			flag = objSeleniumUtils.IsElementDisplayed(driver, NEW_USERBUTTON);
			if (flag) {
				getNewUserButtonText = objSeleniumUtils.getTitleText(driver, NEW_USERBUTTON);
				if (getNewUserButtonText.equalsIgnoreCase(newUserButtonText)) {
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyNewUserButtonOnUserPagePassed"),
									newUserButtonText, getNewUserButtonText));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewUserButtonOnUserPageFailed"),
					newUserButtonText, getNewUserButtonText));
			throw e;
		}
		return flag;
	}

	// This will verify the userManagement Table columns name
	public boolean verifyTableColumnNameValues(String e_Text, String d_Text, String firstName_Text,
			String LastName_Text, String email_Text, String e2_Text, String l_Text) {
		boolean flag = false;
		BankManagerModelPage objBankManagerModelPage;
		ArrayList<String> arrayList = null;
		try {
			objBankManagerModelPage = new BankManagerModelPage(driver);
			arrayList = objBankManagerModelPage.getHeaderNameOfTableInList();
			if (arrayList.contains(e_Text) && arrayList.contains(d_Text) && arrayList.contains(firstName_Text)
					&& arrayList.contains(LastName_Text) && arrayList.contains(email_Text)
					&& arrayList.contains(e2_Text) && arrayList.contains(l_Text)) {
				flag=true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyUserManagementTableColumnNamePassed"),
								e_Text, d_Text, firstName_Text, LastName_Text, email_Text, e2_Text, l_Text, arrayList));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyUserManagementTableColumnNamePassed"),
							e_Text, d_Text, firstName_Text, LastName_Text, email_Text, e2_Text, l_Text, arrayList));
			throw e;
		}
		return flag;
	}

	// This will verify the details on user-list page
	public boolean verifyUserListPageDetails(String userTabTitleText, String fractionURLValue, String exepctedURL,
			String expectedUserManagementTitleTextValue, String e_Text, String d_Text, String firstName_Text,
			String LastName_Text, String email_Text, String e2_Text, String l_Text, String backButtonText,
			String newUserButtonText) throws Exception {
		boolean flag = false;
		try {
			if (verifyUserTab(userTabTitleText)) {
				if (verifyUserListPageOpened(fractionURLValue, exepctedURL)) {
					if (VerifyUserManagementTitle(expectedUserManagementTitleTextValue)) {
						if (verifyTableColumnNameValues(e_Text, d_Text, firstName_Text, LastName_Text, email_Text,
								e2_Text, l_Text)) {
							if (verifyBackButton(backButtonText)) {
								if (verifyNewUserButton(newUserButtonText)) {
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
}
