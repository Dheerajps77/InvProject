package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyPortfolioModelApprovalPage {

	WebDriver driver;

	public VerifyPortfolioModelApprovalPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By portfolioModelApprovalTab = By.xpath(
			"//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Portfolio Model Approval ']");
	public final By table_Column_Values = By
			.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//tr//th");
	public final By statusIconLabelName = By.xpath(
			"//div[@class='layout-content']//child::div[@class='ui-table-wrapper ng-star-inserted']//following::div[1]//span/text()");
	public final By pm_ApprovalBankPermissionTitle=By.xpath("//div[@class='layout-content']//legend");

	public boolean VerifyPortfolioModelApprovalTabTitle(String portfolioModelApprovalTabLabelText) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		String getTitleOfPMTab = "";
		boolean flag = false;
		try {

			objSeleniumUtils = new SeleniumUtils();
			getTitleOfPMTab = objSeleniumUtils.getTitleText(driver, portfolioModelApprovalTab);
			WebElement portfolioModelApprovalElement = driver.findElement(portfolioModelApprovalTab);
			if (portfolioModelApprovalElement.isDisplayed()
					&& getTitleOfPMTab.equalsIgnoreCase(portfolioModelApprovalTabLabelText.trim())) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalTabTitlePassed"),
								getTitleOfPMTab));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalTabTitleFailed"), getTitleOfPMTab));
			throw e;
		}
		return flag;
	}

	public void ClickOnPortfolioModelApprovalTab() throws Exception {
		try {

			SeleniumUtils.waitForElementClickable(driver, portfolioModelApprovalTab, 25).click();
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("PortfolioModelApprovalTabClicked")));

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean VerifyPortfolioModelApprovalBankPermissionsTitle(String portfolioModelApprovalBankPermissionTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils = null;
		WebElement element = null;
		String titleOfBankPermission = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			element = driver.findElement(pm_ApprovalBankPermissionTitle);
			titleOfBankPermission = objSeleniumUtils.getTitleText(driver, pm_ApprovalBankPermissionTitle);

			if (element.isDisplayed()
					&& titleOfBankPermission.equalsIgnoreCase(portfolioModelApprovalBankPermissionTitle.trim())) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioModelListBankPermissionsTitlePassed"),
						titleOfBankPermission));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioModelListBankPermissionsTitleFailed"),
					titleOfBankPermission));
			throw e;
		}
		return flag;
	}

	public boolean VerifyPortfolioModelApprovalTabAndDetails(String portfolioModelApprovalTabLabelText,
			String portfolioModelName, String bankName, String portfolioModelApprovalBankPermissionTitle,
			String notSubmittedIconText, String submittedToBankIconText, String approvedByBankIconText,
			String cancelledByAssetManagerIconText, String revokedByBankIconText, String rejectedByBankIconText) throws Exception {
		boolean flag = false;
		try {

			if (VerifyPortfolioModelApprovalTabTitle(portfolioModelApprovalTabLabelText)) {
				ClickOnPortfolioModelApprovalTab();
				if (VerifyPortfolioModelApprovalBankPermissionsTitle(portfolioModelApprovalBankPermissionTitle)) {
					Thread.sleep(2000);
					if (VerifyPortfolioModelApprovalDetails(portfolioModelName, bankName)) {
						if (VerifyStatusIconImageText(notSubmittedIconText, submittedToBankIconText,
								approvedByBankIconText, cancelledByAssetManagerIconText, revokedByBankIconText,
								rejectedByBankIconText)) {
							flag = true;
							TestBase.logInfo(String.format(
									TestBase.properties.getLogMessage("VerifyStatusIconTestPassed"),
									notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
									cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText));
						}
					}
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStatusIconTestFailed"),
					notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
					cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText));
			throw e;
		}
		return flag;
	}

	public boolean VerifyPortfolioModelApprovalDetails(String portfolioModelName, String bankName) throws Exception {
		boolean flag = false;		
		ArrayList<String> arrayList = null;
		GenericUtils objGenericUtils=null;
		try {		
			objGenericUtils=new GenericUtils();
			arrayList = objGenericUtils.TableColumnNameValues1(driver, table_Column_Values);
			if (arrayList.contains(portfolioModelName) && arrayList.contains(bankName)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsPassed"),
						portfolioModelName, bankName));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsFailed"),
							portfolioModelName, bankName));
			throw e;
		}
		return flag;
	}

	// Below method will return the column name in the arraylist
	public ArrayList<String> TableColumnNameValuesPortalfolioModelApproval() throws Exception {

		ArrayList<String> arrayList = null;
		try {
			arrayList = new ArrayList<String>();
			List<WebElement> element = driver.findElements(statusIconLabelName);
			int totalNumberOfColumn = element.size();
			for (int i = 1; i < totalNumberOfColumn; i++) {
				WebElement elementOfColumnText = driver.findElement(By.xpath(
						"//div[@class='layout-content']//child::div[@class='ui-table-wrapper ng-star-inserted']//following::div[1]//span//text()["
								+ i + "]"));
				String stringValueOfElement = elementOfColumnText.getText();
				arrayList.add(stringValueOfElement);
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	public boolean VerifyStatusIconImageText(String notSubmittedIconText, String submittedToBankIconText,
			String approvedByBankIconText, String cancelledByAssetManagerIconText, String revokedByBankIconText,
			String rejectedByBankIconText) throws Exception {
		//ArrayList<String> arrayList = null;
		boolean flag = false;
		try {
			//arrayList = TableColumnNameValuesPortalfolioModelApproval();
			String string=driver.findElement(By.xpath("//div[@class='layout-content']//child::div[@class='ui-table-wrapper ng-star-inserted']//following::div[1]//span")).getText();
			if (string.contains(notSubmittedIconText) && string.contains(submittedToBankIconText)
					&& string.contains(approvedByBankIconText) && string.contains(cancelledByAssetManagerIconText)
					&& string.contains(revokedByBankIconText) && string.contains(rejectedByBankIconText)) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
}
