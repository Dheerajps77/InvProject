package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyGlobalFilterOnInstrumentPage {

	WebDriver driver;

	public VerifyGlobalFilterOnInstrumentPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By instrumentManagementTabText = By
			.xpath("//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Instrument Management']");
	public final By globalFilterSearchTextBox = By.xpath("//input[@placeholder='Global Filter']");
	public WebElement instrumentManagementElement;
	public final By instrumentManagementTitleText = By.xpath("//div[@class='layout-content']//legend");
	public final By rowdetailsOfInstrument = By
			.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//tbody[@class='ui-table-tbody']//tr");
	public final By rowDataValues = By
			.xpath("//div[@class='ui-table ui-widget ui-table-responsive']//table//tbody[@class='ui-table-tbody']//tr");
	public final By cellDataValues = By.xpath(
			"//div[@class='ui-table ui-widget ui-table-responsive']//table//tbody[@class='ui-table-tbody']//tr//td");
	public final By instrumentDropdownText = By
			.xpath("//div[@class='nano-content menu-scroll-content']//li[4]//ul//li//span[text()='Instruments ']");

	public ArrayList<String> VerifyRecordsPresentInInstrumentListTable() {
		List<WebElement> rowElement = null;
		ArrayList<String> list = null;
		WebElement cellElementValue = null;
		String cellStringValue = "";		
		try {
			list = new ArrayList<String>();
			rowElement = driver.findElements(rowDataValues);
			int rowSize = rowElement.size();
			for (int i = 1; i <= rowSize; i++) {
				List<WebElement> listOfParticularRowCellValues = driver.findElements(By.xpath(
						"//div[@class='ui-table ui-widget ui-table-responsive']//table//tbody[@class='ui-table-tbody']//tr["
								+ i + "]//td"));
				int totalNoOfCellInParticularRow = listOfParticularRowCellValues.size();
				for (int j = 2; j <= totalNoOfCellInParticularRow; j++) {
					cellElementValue = driver.findElement(By.xpath(
							"//div[@class='ui-table ui-widget ui-table-responsive']//table//tbody[@class='ui-table-tbody']//tr["
									+ i + "]//td[" + j + "]"));
					cellStringValue = cellElementValue.getText();					
					list.add(cellStringValue);					
				}				
			}						
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	public boolean verifyGlobalFilterSearchTextBox(String isinId) throws Exception {
		boolean flag = false;
		WebElement textBoxElement;
		ArrayList<String> arrayList;
		SeleniumUtils objSeleniumUtils;
		try {			
			objSeleniumUtils=new SeleniumUtils();
			//arrayList = VerifyRecordsPresentInInstrumentListTable();
			textBoxElement = SeleniumUtils.waitForElementVisibility(driver, globalFilterSearchTextBox, 40);
			flag = textBoxElement.isDisplayed();
			if (flag) {
				objSeleniumUtils.SendToTextbox(driver, globalFilterSearchTextBox, isinId);
				Thread.sleep(2000);
				arrayList = VerifyRecordsPresentInInstrumentListTable();
				Thread.sleep(2000);
				if (arrayList.contains(isinId)) {
					flag = true;
					TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyGlobalFilterSearchPassed"),
							isinId, arrayList, isinId));
				}
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyGlobalFilterSearchFailed"), isinId));
			throw e;
		}
		return flag;
	}

	public boolean ClickOnInstrumentsDropDownValue() throws Exception {
		boolean flag = false;
		try {
			// Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, instrumentDropdownText, 30).click();
			flag = true;
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("InstrumentsDropDownValueClicked")));

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("InstrumentsDropDownValueDoNotClicked")));
			throw e;
		}
		return flag;
	}

	public boolean clickOnInstrumentManagementTab() throws Exception {
		boolean flag = false;
		try {

			if (instrumentManagementElement.isDisplayed()) {
				SeleniumUtils.waitForElementClickable(driver, instrumentManagementTabText, 30).click();
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("InstrumentManagementTabClicked")));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("InstrumentManagementTabDoNotClicked")));
			throw e;
		}
		return flag;
	}

	public boolean verifyInstrumentManagementTabTitle(String instrumentManagementTabTextValue) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		String getTitleOfInstrumentManagementFromUI = "";
		boolean flag = false;
		try {

			objSeleniumUtils = new SeleniumUtils();
			getTitleOfInstrumentManagementFromUI = objSeleniumUtils.getTitleText(driver, instrumentManagementTabText);
			instrumentManagementElement = driver.findElement(instrumentManagementTabText);
			SeleniumUtils.waitForElementPresence(driver, instrumentManagementTabText, 30);
			if (instrumentManagementElement.isDisplayed()
					&& getTitleOfInstrumentManagementFromUI.equalsIgnoreCase(instrumentManagementTabTextValue)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagementTabTitlePassed"),
								instrumentManagementTabTextValue, getTitleOfInstrumentManagementFromUI));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagementTabTitleFailed"),
							instrumentManagementTabTextValue, getTitleOfInstrumentManagementFromUI));
			throw e;
		}
		return flag;
	}

	public boolean verifyInstrumentManagementTitle(String instrumentManagementTitle) throws Exception {
		SeleniumUtils objSeleniumUtils;
		String getTitleOfInstrumentManagement = "";
		WebElement element;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.waitForElementPresence(driver, instrumentManagementTitleText, 30);
			element = driver.findElement(instrumentManagementTitleText);
			getTitleOfInstrumentManagement = objSeleniumUtils.getTitleText(driver, instrumentManagementTitleText);

			if (element.isDisplayed()
					&& getTitleOfInstrumentManagement.equalsIgnoreCase(instrumentManagementTitle.trim())) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagementTitlePassed"),
								instrumentManagementTitle, getTitleOfInstrumentManagement));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagementTitleFailed"),
					instrumentManagementTitle, getTitleOfInstrumentManagement));
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	// This will verify the searched instrument in Global search textbox
	// As of now we are picking Isin id from instrument management table list and
	// verifying the search functionality
	// This method must be linked to "instrument creation" functionalities as
	// pre-requities
	public boolean verifyGlobalFilterOnInstrumentPage(String instrumentManagementTabTextValue,
			String instrumentManagementTitle, String isinId) throws Exception {
		boolean flag = false;
		try {

			if (verifyInstrumentManagementTabTitle(instrumentManagementTabTextValue)) {
				if (clickOnInstrumentManagementTab()) {
					if (ClickOnInstrumentsDropDownValue()) {
						if (verifyInstrumentManagementTitle(instrumentManagementTitle)) {
							if (verifyGlobalFilterSearchTextBox(isinId)) {
								flag = true;
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
