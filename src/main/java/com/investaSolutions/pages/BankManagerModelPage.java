package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class BankManagerModelPage {

	WebDriver driver;

	public BankManagerModelPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By MODELS_TAB_TITLE = By
			.xpath("//li[@class='ng-tns-c2-0 ng-star-inserted']//a[@href='#/portfolio-model-list']");
	public final By PORTFOLIO_MODEL_APPROVALS_TITLE_TEXT = By.xpath("//div[@class='page-container']//legend");
	public final By TABLE_HEADER_NAME = By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//th");
	public final By STATUS_LIST_VALUE = By.xpath("//div[@class='card card-w-title']//div[2]//span");

	// This is to verify the Models Tab
	public boolean verifyModelsTab(String modelsTitleText) throws Exception {
		boolean flag = false;
		WebElement ClickOnModelsTab;
		SeleniumUtils objSeleniumUtils;
		String getTabTextValue = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, MODELS_TAB_TITLE)) {
				getTabTextValue = objSeleniumUtils.getTitleText(driver, MODELS_TAB_TITLE);
				Thread.sleep(2000);
				if (verifyModelsTabTitleText(modelsTitleText)) {
					ClickOnModelsTab = SeleniumUtils.waitForElementClickable(driver, MODELS_TAB_TITLE, 30);
					Thread.sleep(2000);
					ClickOnModelsTab.click();
					flag = true;
				}
			}
			if (flag) {
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyModelsTabTitlePassed"),
						getTabTextValue));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyModelsTabTitleFailed"), getTabTextValue));
			throw e;
		}
		return flag;
	}

	// This is too verify the Models Tab title Text
	public boolean verifyModelsTabTitleText(String modelsTitleText) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String getTitleText = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getTitleText = objSeleniumUtils.getTitleText(driver, MODELS_TAB_TITLE);
			if (getTitleText.equalsIgnoreCase(modelsTitleText)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyModelsTabTextTitlePassed"),
						getTitleText, modelsTitleText));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyModelsTabTextTitleFailed"),
					getTitleText, modelsTitleText));
			throw e;
		}
		return flag;
	}

	// This is to verify the portfolio-model-list page
	public boolean verifyPortfolioModelListPageOpened(String fractionTextValueOfURL, String expectedPageURL)
			throws Exception {
		boolean flag;
		SeleniumUtils objSeleniumUtils;
		String actualPageURL = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			actualPageURL = objSeleniumUtils.GetCurrentPageURL(driver);
			flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, fractionTextValueOfURL, 30);
			if (actualPageURL.contains(fractionTextValueOfURL)) {
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyModelsListPageURLPassed"),
						fractionTextValueOfURL, expectedPageURL, actualPageURL));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyModelsListPageURLFailed"),
					fractionTextValueOfURL, expectedPageURL, actualPageURL));
			throw e;
		}
		return flag;
	}

	// This is to verify the title of porfolio models approvals
	public boolean VerifyPortfolioModelsApprovalsTitle(String expectedPortfolioModelsApprovalsTitleTextValue)
			throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualPortfolioModelsApprovalsTitleTextValue = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, PORTFOLIO_MODEL_APPROVALS_TITLE_TEXT)) {
				actualPortfolioModelsApprovalsTitleTextValue = objSeleniumUtils.getTitleText(driver,
						PORTFOLIO_MODEL_APPROVALS_TITLE_TEXT);
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioModelsApprovalsTitleTextPassed"),
						expectedPortfolioModelsApprovalsTitleTextValue, actualPortfolioModelsApprovalsTitleTextValue));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioModelsApprovalsTitleTextFailed"),
					expectedPortfolioModelsApprovalsTitleTextValue, actualPortfolioModelsApprovalsTitleTextValue));
			throw e;
		}
		return flag;
	}

	// This will hold the header name of table in list
	public ArrayList<String> getHeaderNameOfTableInList() {
		ArrayList<String> arrayList;
		List<WebElement> elements;
		WebElement elementValue;
		String stringValueOfElement;
		try {
			arrayList = new ArrayList<String>();
			elements = driver.findElements(TABLE_HEADER_NAME);
			int totalCountOfHeaderName = elements.size();

			for (int i = 1; i <= totalCountOfHeaderName; i++) {
				elementValue = driver.findElement(
						By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//th[" + i + "]"));
				stringValueOfElement = elementValue.getText();
				arrayList.add(stringValueOfElement);
			}

		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	// This is to verify the header name of table in portfolio-model-list page
	public boolean VerifyTableHeaderName(String e_Text, String assetManager_Text, String asetManager_Text,
			String strategyName_Text, String investmentObjectives_Text, String currency_Text, String status_Text) {
		boolean flag = false;
		ArrayList<String> arrayList = null;
		try {
			arrayList = getHeaderNameOfTableInList();
			if (arrayList.contains(e_Text) && arrayList.contains(asetManager_Text)
					&& arrayList.contains(asetManager_Text) && arrayList.contains(strategyName_Text)
					&& arrayList.contains(investmentObjectives_Text) && arrayList.contains(currency_Text)
					&& arrayList.contains(status_Text)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioModelsApprovalsTableColumnNamePassed"),
						e_Text, assetManager_Text, asetManager_Text, strategyName_Text, investmentObjectives_Text,
						currency_Text, status_Text, arrayList));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioModelsApprovalsTableColumnNameFailed"), e_Text,
					assetManager_Text, asetManager_Text, strategyName_Text, investmentObjectives_Text, currency_Text,
					status_Text, arrayList));
			throw e;
		}
		return flag;
	}

	// This is to verify the status label name
	public boolean verifyStatusLabelName(String notSubmittedLabel, String submittedToBankLabel,
			String approvedByBankLabel, String cancelledByAssertManagerLabel, String revokedByBankLabel,
			String rejectedByBankLabel) throws Exception {
		boolean flag = false;		
		SeleniumUtils objSeleniumUtils;
		String statusLabelName = null;
		try {			
			objSeleniumUtils = new SeleniumUtils();
			statusLabelName = objSeleniumUtils.getTitleText(driver, STATUS_LIST_VALUE);
			if (statusLabelName.contains(notSubmittedLabel) && statusLabelName.contains(submittedToBankLabel)
					&& statusLabelName.contains(approvedByBankLabel)
					&& statusLabelName.contains(cancelledByAssertManagerLabel) && statusLabelName.contains(revokedByBankLabel)
					&& statusLabelName.contains(rejectedByBankLabel)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStatusLabelNamePassed"),
						notSubmittedLabel, submittedToBankLabel, approvedByBankLabel, cancelledByAssertManagerLabel,
						revokedByBankLabel, rejectedByBankLabel, statusLabelName));

			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStatusLabelNameFailed"),
					notSubmittedLabel, submittedToBankLabel, approvedByBankLabel, cancelledByAssertManagerLabel,
					revokedByBankLabel, rejectedByBankLabel, statusLabelName));
			throw e;
		}
		return flag;
	}
	
	/*
	// This is to get all status text value in list
	public ArrayList<String> getStatusTextInList() throws Exception {
		ArrayList<String> arrayList;
		SeleniumUtils objSeleniumUtils;
		String statusLabelName;
		try {
			arrayList = new ArrayList<String>();
			objSeleniumUtils = new SeleniumUtils();
			statusLabelName = objSeleniumUtils.getTitleText(driver, STATUS_LIST_VALUE);

			String[] valueSplited = statusLabelName.split(",");
			for (String stringValue : valueSplited) {
				arrayList.add(stringValue);
			}
		} catch (Exception e) {

			throw e;
		}
		return arrayList;
	}
	*/
	
	public boolean verifyModelListPageDetails(String modelsTitleText, String fractionTextValueOfURL,
			String expectedPageURL, String expectedPortfolioModelsApprovalsTitleTextValue, String e_Text,
			String assetManager_Text, String asetManager_Text, String strategyName_Text,
			String investmentObjectives_Text, String currency_Text, String status_Text, String notSubmittedLabel,
			String submittedToBankLabel, String approvedByBankLabel, String cancelledByAssertManagerLabel,
			String revokedByBankLabel, String rejectedByBankLabel) throws Exception {
		boolean flag = false;
		try {
			if (verifyModelsTab(modelsTitleText)) {
				if (verifyPortfolioModelListPageOpened(fractionTextValueOfURL, expectedPageURL)) {
					if (VerifyPortfolioModelsApprovalsTitle(expectedPortfolioModelsApprovalsTitleTextValue)) {
						if (VerifyTableHeaderName(e_Text, assetManager_Text, asetManager_Text, strategyName_Text,
								investmentObjectives_Text, currency_Text, status_Text)) {
							if (verifyStatusLabelName(notSubmittedLabel, submittedToBankLabel, approvedByBankLabel,
									cancelledByAssertManagerLabel, revokedByBankLabel, rejectedByBankLabel)) {
								flag=true;
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
