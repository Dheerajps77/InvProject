package com.investaSolutions.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyPortfolioModelManagementPage {

	public WebDriver driver;

	public VerifyPortfolioModelManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By pm_Management_Tab = By.xpath("//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Portfolio Model Management ']");
	public final By pm_List_Title = By.xpath("//div[@class='ui-g']//div[@class='ui-g-12']//legend");
	public final By table_Column_Values = By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//tr//th");
	public final By backButton = By.xpath("//div[@class='ui-g-12 ui-md-3']//button[@label='Back']");
	public final By new_PortfolioButton = By.xpath("//div[@class='ui-g-12 ui-md-3']//button[@label='New Portfolio Model']");

	public boolean VerifyProtfolioManagementTabAndDetailsInPage(String portfolioMangementTabLabelText,
			String dColumnValue, String cColumnValue, String modelNameColumnValue, String currencyColumnValue,
			String contactDetailsColumnValue, String modelStyleColumnValue, String openCloseColumnValue,
			String lastUpdatedColumnValue) throws Exception {
		boolean flag = false;
		try {
			if (VerifyPortfolioManagementTabTitle(portfolioMangementTabLabelText)) {
				ClickOnPortfolioManagementTab();
				if (VerifyDetailsOnPortfolioPortfolioManagement(dColumnValue, cColumnValue, modelNameColumnValue,
						currencyColumnValue, contactDetailsColumnValue, modelStyleColumnValue, openCloseColumnValue,
						lastUpdatedColumnValue)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyPortfolioManagementPageDetailsPassed"),
							dColumnValue, cColumnValue, modelNameColumnValue, currencyColumnValue,
							contactDetailsColumnValue, modelStyleColumnValue, openCloseColumnValue,
							lastUpdatedColumnValue));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioManagementPageDetailsFailed"), dColumnValue,
					cColumnValue, modelNameColumnValue, currencyColumnValue, contactDetailsColumnValue,
					modelStyleColumnValue, openCloseColumnValue, lastUpdatedColumnValue));
			throw e;
		}
		return flag;
	}
	
	public boolean VerifyBackButton() throws Exception
	{
		SeleniumUtils objSeleniumUtils = null;
		boolean flag;
		try {
			objSeleniumUtils=new SeleniumUtils();
			flag=objSeleniumUtils.IsElementDisplayed(driver, backButton);			
			if(flag)
			{
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyBackButtonPassed")));
			}
			
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyBackButtonFailed")));
			throw e;
		}
		return flag;
	}
	
	public boolean VerifyNewPortfolioButton() throws Exception
	{
		SeleniumUtils objSeleniumUtils = null;
		boolean flag;
		try {
			objSeleniumUtils=new SeleniumUtils();
			flag=objSeleniumUtils.IsElementDisplayed(driver, new_PortfolioButton);			
			if(flag)
			{
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyNewPortfolioButtonPassed")));
			}
			
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewPortfolioButtonFailed")));
			throw e;
		}
		return flag;
	}

	public void ClickOnPortfolioManagementTab() throws Exception {
		try {
			SeleniumUtils.waitForElementClickable(driver, pm_Management_Tab, 25).click();
			TestBase.properties.getLogMessage("PortfolioManagementTabClicked");

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean VerifyPortfolioManagementTabTitle(String portfolioMangementTabLabelText) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		String getTitleOfPMTab = "";
		boolean flag = false;
		try {

			objSeleniumUtils = new SeleniumUtils();
			getTitleOfPMTab = objSeleniumUtils.getTitleText(driver, pm_Management_Tab);
			WebElement portfolioManElement = driver.findElement(pm_Management_Tab);
			if (portfolioManElement.isDisplayed() && portfolioMangementTabLabelText.equalsIgnoreCase(getTitleOfPMTab)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioManagementTabTitlePassed"), getTitleOfPMTab));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioManagementTabTitleFailed"), getTitleOfPMTab));
			throw e;
		}
		return flag;
	}

	public boolean VerifyDetailsOnPortfolioPortfolioManagement(String dColumnValue, String cColumnValue,
			String modelNameColumnValue, String currencyColumnValue, String contactDetailsColumnValue,
			String modelStyleColumnValue, String openCloseColumnValue, String lastUpdatedColumnValue) throws Exception {
		ArrayList<String> arrayList = null;
		GenericUtils objGenericUtils=new GenericUtils();
		boolean flag = false;
		try {			
			arrayList = new ArrayList<String>();
			arrayList=objGenericUtils.TableColumnNameValues(driver, table_Column_Values);			
			if (arrayList.contains(dColumnValue) && arrayList.contains(cColumnValue)
					&& arrayList.contains(modelNameColumnValue) && arrayList.contains(currencyColumnValue)
					&& arrayList.contains(contactDetailsColumnValue) && arrayList.contains(modelStyleColumnValue)
					&& arrayList.contains(openCloseColumnValue) && arrayList.contains(lastUpdatedColumnValue)) {
				flag = true;
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
		
	public boolean VerifyPortfolioModelListTitle(String portfolioModelListName) throws Exception {
		String getTitleOfPMModelList = "";
		SeleniumUtils objSeleniumUtils = null;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getTitleOfPMModelList = objSeleniumUtils.getTitleText(driver, pm_List_Title);
			WebElement element = driver.findElement(pm_List_Title);
			if (element.isDisplayed() && getTitleOfPMModelList.equalsIgnoreCase(portfolioModelListName)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelListOfTitlePassed"),
						portfolioModelListName, getTitleOfPMModelList));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelListOfTitleFailed"),
					portfolioModelListName, getTitleOfPMModelList));
			throw e;
		}
		return flag;
	}	
}
