package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyInstrumentsPage {

	WebDriver driver;

	public VerifyInstrumentsPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By instrumentManagementTabText = By
			.xpath("//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Instrument Management']");
	public final By instrumentManagementDropDownValues = By
			.xpath("//div[@class='nano-content menu-scroll-content']//li[4]//ul//li//span");
	public final By instrumentDropdownText = By
			.xpath("//div[@class='nano-content menu-scroll-content']//li[4]//ul//li//span[text()='Instruments ']");
	public final By benchmarksDropdownText = By
			.xpath("//div[@class='nano-content menu-scroll-content']//li[4]//ul//li//span[text()='Benchmarks ']");
	public final By instrumentManagementTitleText = By.xpath("//div[@class='layout-content']//legend");
	public final By benchMarkManagementTitleText = By.xpath("//div[@class='layout-content']//legend");
	public final By table_Column_Values = By
			.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//tr//th");
	public final By backButton = By.xpath("//button[@label='Back']");
	public final By newInstrumentButton = By.xpath("//button[@label='New Instrument']");
	public final By globalFilterSearchTextBox = By.xpath("//input[@placeholder='Global Filter']");
	public WebElement instrumentManagementElement;

	public boolean VerifyGlobalFilterSearchTextBox() throws Exception {
		boolean flag = false;
		WebElement textBoxElement;
		try {
			textBoxElement = SeleniumUtils.waitForElementVisibility(driver, globalFilterSearchTextBox, 40);
			flag = textBoxElement.isDisplayed();

			if (flag) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyGlobalFilterSearchTextBoxPassed")));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyGlobalFilterSearchTextBoxFailed")));
			throw e;
		}
		return flag;
	}

	public boolean VerifyInstrumentManagementTabTitle(String instrumentManagementTabTextValue) throws Exception {
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

	// This function will return the dropdown text values in array list
	public ArrayList<String> GetInstrumentManagementDropDownValueText() throws Exception {
		ArrayList<String> arrayList;
		List<WebElement> instrumentDropDownTextElement;
		WebElement element;
		String dropdownTextValue;
		try {
			arrayList = new ArrayList<String>();
			instrumentDropDownTextElement = driver.findElements(instrumentManagementDropDownValues);
			for (int i = 1; i <= instrumentDropDownTextElement.size(); i++) {
				element = driver.findElement(
						By.xpath("//div[@class='nano-content menu-scroll-content']//li[4]//ul//li[" + i + "]//span"));
				dropdownTextValue = element.getText();
				arrayList.add(dropdownTextValue);
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	public boolean ClickOnInstrumentManagementTab() throws Exception {
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

	public boolean VerifyInstrumentListPageOpened(String fractionTextValueOfUrl, String expectedPageURL)
			throws Exception {
		SeleniumUtils objSeleniumUtils;
		String getCurrentPageURL = "";
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			Thread.sleep(2000);
			if (ClickOnInstrumentsDropDownValue()) {
				getCurrentPageURL = objSeleniumUtils.GetCurrentPageURL(driver);
				flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, fractionTextValueOfUrl, 30);
				if (flag) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyInstrumentListPageURLPassed"),
									expectedPageURL, getCurrentPageURL));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyInstrumentListPageURLFailed"),
					expectedPageURL, getCurrentPageURL));
			throw e;
		}
		return flag;
	}

	public boolean verifyBenchmarksListPageOpened(String fractionTextValueOfUrl, String expectedPageURL)
			throws Exception {
		SeleniumUtils objSeleniumUtils;
		String getCurrentPageURL = "";
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			Thread.sleep(2000);
			if (clickOnBenchmarkDropDownValue()) {
				getCurrentPageURL = objSeleniumUtils.GetCurrentPageURL(driver);
				flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, fractionTextValueOfUrl, 30);
				if (flag) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyBenchmarksListPageURLPassed"),
									expectedPageURL, getCurrentPageURL));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyBenchmarksListPageURLFailed"),
					expectedPageURL, getCurrentPageURL));
			throw e;
		}
		return flag;
	}

	public boolean clickOnBenchmarkDropDownValue() throws Exception {
		boolean flag = false;
		try {
			// Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, benchmarksDropdownText, 30).click();
			flag = true;
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("BenchMarksDropDownValueClicked")));

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("BenchMarksDropDownValueDoNotClicked")));
			throw e;
		}
		return flag;
	}

	public boolean VerifyDropdownValuesOfInstrumentManagementTab(String instruments, String benchMarks)
			throws Exception {
		ArrayList<String> arrayList;
		String dropDownsValue = "";
		String addedDropDownValues = "";
		boolean flag = false;
		try {
			arrayList = GetInstrumentManagementDropDownValueText();
			Iterator<String> iterator = arrayList.iterator();
			while (iterator.hasNext()) {
				dropDownsValue = iterator.next();
				addedDropDownValues = addedDropDownValues + ", " + dropDownsValue;
			}
			if (arrayList.contains(instruments.trim()) && arrayList.contains(benchMarks.trim())) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyInstrumentManagemenDropdownValuesPassed"), instruments,
						benchMarks, addedDropDownValues));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagemenDropdownValuesFailed"),
							instruments, benchMarks, addedDropDownValues));
			throw e;
		}
		return flag;
	}

	public boolean VerifyInstrumentManagementTabAndInstrumentsListPageDetails(String instrumentManagementTabTextValue,
			String instruments, String benchMarks, String fractionTextValueOfUrl, String expectedPageURL,
			String dColumnName, String isinColumnName, String nameColumnName, String productTypeColumnName,
			String majorAssertClassColumnName, String currencyColumnName, String lastPriceColumnName,
			String lastPriceDateColumnName) throws Exception {
		boolean flag = false;
		try {

			if (VerifyInstrumentManagementTabTitle(instrumentManagementTabTextValue)) {
				if (ClickOnInstrumentManagementTab()) {
					Thread.sleep(2000);
					if (VerifyDropdownValuesOfInstrumentManagementTab(instruments, benchMarks)) {
						if (VerifyInstrumentListPageOpened(fractionTextValueOfUrl, expectedPageURL)) {
							if (VerifyInstrumentManagementTableColumnName(dColumnName, isinColumnName, nameColumnName,
									productTypeColumnName, majorAssertClassColumnName, currencyColumnName,
									lastPriceColumnName, lastPriceDateColumnName)) {
								flag = true;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	public boolean verifyInstrumentManagementTabAndBenchmarksListPageDetails(String instrumentManagementTabTextValue,
			String instruments, String benchMarks, String fractionTextValueOfUrl, String expectedPageURL,
			String benchmarkNameColumnName, String providerColumnName, String currencyColumnName,
			String lastPriceColumnName, String lastPriceDateColumnName, String dateAddedColumnName) throws Exception {
		boolean flag = false;
		try {

			if (VerifyInstrumentManagementTabTitle(instrumentManagementTabTextValue)) {
				if (ClickOnInstrumentManagementTab()) {
					Thread.sleep(2000);
					if (VerifyDropdownValuesOfInstrumentManagementTab(instruments, benchMarks)) {
						if (verifyBenchmarksListPageOpened(fractionTextValueOfUrl, expectedPageURL)) {
							if (verifyBenchmarksManagementTableColumnName(benchmarkNameColumnName, providerColumnName,
									currencyColumnName, lastPriceColumnName, lastPriceDateColumnName,
									dateAddedColumnName)) {
								flag = true;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	public boolean VerifyBackButtonInInstrumentManagementPage(String backbtnTextValue) throws Exception {
		WebElement backButtonElement;
		String backButtonText = "";
		boolean flag = false;
		try {
			backButtonElement = driver.findElement(backButton);
			backButtonText = backButtonElement.getText();
			if (backButtonElement.isDisplayed() && backButtonText.equalsIgnoreCase(backbtnTextValue)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyBackButtonPassed"),
						backButtonText, backbtnTextValue));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyBackButtonFailed"), backButtonText,
					backbtnTextValue));
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	public boolean verifyBackButtonInBenchmarksManagementPage(String backbtnTextValue) throws Exception {
		WebElement backButtonElement;
		String backButtonText = "";
		boolean flag = false;
		try {
			backButtonElement = driver.findElement(backButton);
			backButtonText = backButtonElement.getText();
			if (backButtonElement.isDisplayed() && backButtonText.equalsIgnoreCase(backbtnTextValue)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyBackButtonPassed"),
						backButtonText, backbtnTextValue));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyBackButtonFailed"), backButtonText,
					backbtnTextValue));
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	public boolean VerifyNewInstrumentButtonInInstrumentManagementPage(String newInstrumentbtnTextValue)
			throws Exception {
		WebElement newInstrumentElement;
		String newInstrumentButtonText = "";
		boolean flag = false;
		try {
			newInstrumentElement = driver.findElement(newInstrumentButton);
			newInstrumentButtonText = newInstrumentElement.getText();
			if (newInstrumentElement.isDisplayed()
					&& newInstrumentButtonText.equalsIgnoreCase(newInstrumentbtnTextValue)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyNewInstrumentButtonPassed"),
						newInstrumentButtonText, newInstrumentbtnTextValue));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewInstrumentButtonFailed"),
					newInstrumentButtonText, newInstrumentbtnTextValue));
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	public boolean VerifyInstrumentManagementTableColumnName(String dColumnName, String isinColumnName,
			String nameColumnName, String productTypeColumnName, String majorAssertClassColumnName,
			String currencyColumnName, String lastPriceColumnName, String lastPriceDateColumnName) throws Exception {
		boolean flag = false;
		GenericUtils objGenericUtils;
		ArrayList<String> arrayList;
		String columnNameFromUI = "";
		try {
			objGenericUtils = new GenericUtils();
			arrayList = objGenericUtils.TableColumnNameValues(driver, table_Column_Values);
			Iterator<String> iterator = arrayList.iterator();
			while (iterator.hasNext()) {
				String iteratorStringValue = iterator.next();
				columnNameFromUI = columnNameFromUI + ", " + iteratorStringValue;
			}

			if (arrayList.contains(dColumnName) && arrayList.contains(isinColumnName)
					&& arrayList.contains(nameColumnName) && arrayList.contains(productTypeColumnName)
					&& arrayList.contains(majorAssertClassColumnName) && arrayList.contains(currencyColumnName)
					&& arrayList.contains(lastPriceColumnName) && arrayList.contains(lastPriceDateColumnName)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyInstrumentManagementTableColumnNamePassed"),
						dColumnName, isinColumnName, nameColumnName, productTypeColumnName, majorAssertClassColumnName,
						currencyColumnName, lastPriceColumnName, lastPriceDateColumnName, columnNameFromUI));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyInstrumentManagementTableColumnNameFailed"), dColumnName,
					isinColumnName, nameColumnName, productTypeColumnName, majorAssertClassColumnName,
					currencyColumnName, lastPriceColumnName, lastPriceDateColumnName, columnNameFromUI));
			throw e;
		}
		return flag;
	}

	public boolean verifyBenchmarksManagementTableColumnName(String benchmarkNameColumnName, String providerColumnName,
			String currencyColumnName, String lastPriceColumnName, String lastPriceDateColumnName,
			String dateAddedColumnName) throws Exception {
		boolean flag = false;
		GenericUtils objGenericUtils;
		ArrayList<String> arrayList;
		String columnNameFromUI = "";
		try {
			objGenericUtils = new GenericUtils();
			arrayList = objGenericUtils.TableColumnNameValues(driver, table_Column_Values);
			Iterator<String> iterator = arrayList.iterator();
			while (iterator.hasNext()) {
				String iteratorStringValue = iterator.next();
				columnNameFromUI = columnNameFromUI + ", " + iteratorStringValue;
			}

			if (arrayList.contains(benchmarkNameColumnName) && arrayList.contains(providerColumnName)
					&& arrayList.contains(currencyColumnName) && arrayList.contains(lastPriceColumnName)
					&& arrayList.contains(lastPriceDateColumnName) && arrayList.contains(dateAddedColumnName)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyBenchmarksManagementTableColumnNamePassed"),
						benchmarkNameColumnName, providerColumnName, currencyColumnName, lastPriceColumnName,
						lastPriceDateColumnName, dateAddedColumnName, columnNameFromUI));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyBenchmarksManagementTableColumnNameFailed"),
							benchmarkNameColumnName, providerColumnName, currencyColumnName, lastPriceColumnName,
							lastPriceDateColumnName, dateAddedColumnName, columnNameFromUI));
			throw e;
		}
		return flag;
	}

	public boolean VerifyInstrumentManagementTitle(String instrumentManagementTitle) throws Exception {
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

	public boolean verifyBenchmarksManagementTitle(String benchmarksManagementTitleText) throws Exception {
		SeleniumUtils objSeleniumUtils;
		String getTitleOfBenchmarksManagement = "";
		WebElement element;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.waitForElementPresence(driver, benchMarkManagementTitleText, 30);
			element = driver.findElement(benchMarkManagementTitleText);
			getTitleOfBenchmarksManagement = objSeleniumUtils.getTitleText(driver, benchMarkManagementTitleText);

			if (element.isDisplayed()
					&& getTitleOfBenchmarksManagement.equalsIgnoreCase(benchmarksManagementTitleText.trim())) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagementTitlePassed"),
								benchmarksManagementTitleText, getTitleOfBenchmarksManagement));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyInstrumentManagementTitleFailed"),
					benchmarksManagementTitleText, getTitleOfBenchmarksManagement));
			e.printStackTrace();
			throw e;
		}
		return flag;
	}
}
