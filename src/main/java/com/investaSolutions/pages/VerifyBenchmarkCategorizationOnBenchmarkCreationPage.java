package com.investaSolutions.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.TestPanel;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class VerifyBenchmarkCategorizationOnBenchmarkCreationPage {

	WebDriver driver;

	public VerifyBenchmarkCategorizationOnBenchmarkCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By INSTRUMENT_MANAGEMENT_TAB_TEXT = By
			.xpath("//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Instrument Management']");
	public WebElement INSTRUMENT_MANAGEMENT_ELEMENT;
	public final By BENCHMARKS_DROPDOWN_TEXT = By
			.xpath("//div[@class='nano-content menu-scroll-content']//li[4]//ul//li//span[text()='Benchmarks ']");
	public final By BENCHMARK_MANAGEMENT_TITLE_TEXT = By.xpath("//div[@class='layout-content']//legend");
	public final By SEARCH_PLUS_BUTTON = By
			.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//tbody/tr[1]//td[1]");
	public final By BENCHMARK_CATEGORIZATION_TAB_TITLE = By.xpath(
			"//li[@class='ui-state-default ui-corner-top ui-tabview-selected ui-state-active ng-star-inserted']//span");
	public final By BENCHMARK_CATEGORIZATION_TITLE = By
			.xpath("//div[@class='ui-g ng-star-inserted']//legend[text()='Benchmark Categorization']");
	public final By CANCEL_BUTTON = By.xpath(
			"//button[@class='ui-button-danger ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ng-star-inserted']");
	public final By BENCHMARK_CATEGORIZATION_LABELS_ELEMENTS = By.xpath(
			"//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div//div[1]//div//div[1]//div//div[1]//label");

	// This will get all labels name which is current present in Benchmarks
	// Categorization
	public ArrayList<String> getLabelsOfBenchmarksCategorization() {
		ArrayList<String> arrayList = new ArrayList<String>();
		List<WebElement> elements;
		try {
			elements = driver.findElements(BENCHMARK_CATEGORIZATION_LABELS_ELEMENTS);
			int totalCountOfLabel = elements.size();
			for (int i = 1; i <= totalCountOfLabel; i++) {
				WebElement element = driver.findElement(By.xpath(
						"//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div//div[1]//div//div[1]//div["
								+ i + "]//div[1]//label"));
				String lablesValue = element.getText();
				arrayList.add(lablesValue);
			}

		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	// This will verify the labels which is under present of
	// benchmark_categorization
	public boolean verifyBenchmarksCategorizationLabels(String nameLabel, String providerLabel, String currencyLabel,
			String hedgedLabel, String hedgedCurrencyLabel, String lastPriceLabel, String lastPriceDateLabel) {
		ArrayList<String> arrayList = null;
		boolean flag = false;
		try {
			arrayList = getLabelsOfBenchmarksCategorization();
			if (arrayList.contains(nameLabel) && arrayList.contains(providerLabel) && arrayList.contains(currencyLabel)
					&& arrayList.contains(hedgedLabel) && arrayList.contains(hedgedCurrencyLabel)
					&& arrayList.contains(lastPriceLabel) && arrayList.contains(lastPriceDateLabel)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyBenchmarksCategorizationLabelsPassed"),
								nameLabel, providerLabel, currencyLabel, hedgedLabel, hedgedCurrencyLabel,
								lastPriceLabel, lastPriceDateLabel, arrayList));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyBenchmarksCategorizationLabelsFailed"),
							nameLabel, providerLabel, currencyLabel, hedgedLabel, hedgedCurrencyLabel, lastPriceLabel,
							lastPriceDateLabel, arrayList));
			throw e;
		}
		return flag;
	}

	// This will verify the imstrument management tab title
	public boolean verifyInstrumentManagementTabTitle(String instrumentManagementTabTextValue) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		String getTitleOfInstrumentManagementFromUI = "";
		boolean flag = false;
		try {

			objSeleniumUtils = new SeleniumUtils();
			getTitleOfInstrumentManagementFromUI = objSeleniumUtils.getTitleText(driver,
					INSTRUMENT_MANAGEMENT_TAB_TEXT);
			INSTRUMENT_MANAGEMENT_ELEMENT = driver.findElement(INSTRUMENT_MANAGEMENT_TAB_TEXT);
			SeleniumUtils.waitForElementPresence(driver, INSTRUMENT_MANAGEMENT_TAB_TEXT, 30);
			if (INSTRUMENT_MANAGEMENT_ELEMENT.isDisplayed()
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

	// This will click on instrument management tab
	public boolean clickOnInstrumentManagementTab() throws Exception {
		boolean flag = false;
		try {

			if (INSTRUMENT_MANAGEMENT_ELEMENT.isDisplayed()) {
				SeleniumUtils.waitForElementClickable(driver, INSTRUMENT_MANAGEMENT_TAB_TEXT, 30).click();
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("InstrumentManagementTabClicked")));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("InstrumentManagementTabDoNotClicked")));
			throw e;
		}
		return flag;
	}

	// // This will verify the benchmark management title in benchmark_list page
	public boolean verifyBenchmarksManagementTitle(String benchmarksManagementTitleText) throws Exception {
		SeleniumUtils objSeleniumUtils;
		String getTitleOfBenchmarksManagement = "";
		WebElement element;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.waitForElementPresence(driver, BENCHMARK_MANAGEMENT_TITLE_TEXT, 30);
			element = driver.findElement(BENCHMARK_MANAGEMENT_TITLE_TEXT);
			getTitleOfBenchmarksManagement = objSeleniumUtils.getTitleText(driver, BENCHMARK_MANAGEMENT_TITLE_TEXT);

			if (element.isDisplayed()
					&& getTitleOfBenchmarksManagement.equalsIgnoreCase(benchmarksManagementTitleText.trim())) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyBenchmarkCategorizationTitlePassed"),
								benchmarksManagementTitleText, getTitleOfBenchmarksManagement));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyBenchmarkCategorizationTitleFailed"),
							benchmarksManagementTitleText, getTitleOfBenchmarksManagement));
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	// This will verify the visiblity of Cancel button in the benchmark_creatio page
	public boolean verifyCanceButtonInBenchmarkCreationPage(String cancelButtonText) {
		boolean flag;
		WebElement element;
		String getCancelButtonText = null;
		try {

			element = SeleniumUtils.waitForElementPresence(driver, CANCEL_BUTTON, 30);
			flag = SeleniumUtils.isElementPresent(driver, CANCEL_BUTTON);

			if (flag) {
				getCancelButtonText = element.getText();

				if (getCancelButtonText.equalsIgnoreCase(getCancelButtonText)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyCancelButtonUnderBenchmarkCategorizationPassed"),
							getCancelButtonText, cancelButtonText, getCancelButtonText));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyCancelButtonUnderBenchmarkCategorizationFailed"),
					getCancelButtonText, cancelButtonText, getCancelButtonText));
			throw e;
		}
		return flag;
	}

	// This will select an benchmarks option from the dropdown value in dashboard
	// page
	public boolean clickOnBenchmarkDropDownValue() throws Exception {
		boolean flag = false;
		try {
			// Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, BENCHMARKS_DROPDOWN_TEXT, 30).click();
			flag = true;
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("BenchMarksDropDownValueClicked")));

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("BenchMarksDropDownValueDoNotClicked")));
			throw e;
		}
		return flag;
	}

	// This will click on search-plus button in benchmark_list page
	public boolean clickOnSearchPlusButton() throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		WebElement clickOnSearchButtonElement = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.waitForElementClickable(driver, SEARCH_PLUS_BUTTON, 30);
			if (objSeleniumUtils.IsElementDisplayed(driver, SEARCH_PLUS_BUTTON)
					&& SeleniumUtils.isElementPresent(driver, SEARCH_PLUS_BUTTON)) {
				flag = true;
			}
			if (flag) {
				Thread.sleep(2000);
				clickOnSearchButtonElement = SeleniumUtils.waitForElementClickable(driver, SEARCH_PLUS_BUTTON, 30);
				clickOnSearchButtonElement.click();
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifySearchPlusButtonPassed")));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifySearchPlusButtonFailed")));
			throw e;
		}
		return flag;
	}

	// This will verify Benchmark Categorization Tab Title
	public boolean verifyBenchmarkCategorizationTabTitle(String benchCategorizationTabTitleText) {
		boolean flag;
		WebElement element;
		String getTextOfBenchmarkCategorizationTab = null;
		try {
			element = SeleniumUtils.waitForElementPresence(driver, BENCHMARK_CATEGORIZATION_TAB_TITLE, 30);
			flag = SeleniumUtils.isElementPresent(driver, BENCHMARK_CATEGORIZATION_TAB_TITLE);
			if (flag) {
				getTextOfBenchmarkCategorizationTab = element.getText();
				if (getTextOfBenchmarkCategorizationTab.equalsIgnoreCase(benchCategorizationTabTitleText)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyBenchmarkCategorizationTabTitlePassed"),
							benchCategorizationTabTitleText, getTextOfBenchmarkCategorizationTab));
				}
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyBenchmarkCategorizationTabTitleFailed"),
							benchCategorizationTabTitleText, getTextOfBenchmarkCategorizationTab));
			throw e;
		}
		return flag;
	}

	// This will verify Benchmark Categorization Title
	public boolean verifyBenchmarkCategorizationTitle(String benchCategorizationTitleText) {
		boolean flag;
		WebElement element;
		String getTextOfBenchmarkCategorizationTitle = null;
		try {
			element = SeleniumUtils.waitForElementPresence(driver, BENCHMARK_CATEGORIZATION_TITLE, 30);
			flag = SeleniumUtils.isElementPresent(driver, BENCHMARK_CATEGORIZATION_TITLE);
			if (flag) {
				getTextOfBenchmarkCategorizationTitle = element.getText();
				if (getTextOfBenchmarkCategorizationTitle.equalsIgnoreCase(benchCategorizationTitleText)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyBenchmarkCategorizationTabTitlePassed"),
							benchCategorizationTitleText, getTextOfBenchmarkCategorizationTitle));
				}
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyBenchmarkCategorizationTabTitleFailed"),
							benchCategorizationTitleText, getTextOfBenchmarkCategorizationTitle));
			throw e;
		}
		return flag;
	}

	// This will verify whether benchmark_creation page is opened
	public boolean verifyBenchmarkCreationPageOpened(String benchmarkCreationPageURL,
			String benchmarkCreationPageURLFraction) throws Exception {
		boolean flag;
		SeleniumUtils objSeleniumUtils;
		String currentPageURL = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			flag = objSeleniumUtils.WaitTillPageURLToBeLoad(driver, benchmarkCreationPageURLFraction, 30);
			if (flag) {
				currentPageURL = objSeleniumUtils.GetCurrentPageURL(driver);
				if (benchmarkCreationPageURL.equalsIgnoreCase(currentPageURL)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyBenchmarkCreationPageURLPassed"),
									benchmarkCreationPageURL, currentPageURL));
				}
			}

		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyBenchmarkCreationPageURLFailed"),
					benchmarkCreationPageURL, currentPageURL));
			throw e;
		}
		return flag;
	}

	public boolean verifyBenchmarkCategorizationOnBenchmarkCreationPage(String instrumentManagementTabTitleTextValue,
			String benchmarksManagementTabTextValue, String benchmarksManagementTitle,
			String benchCategorizationTabTitleText, String benchCategorizationTitleText, String cancelButtonText,
			String benchmarkCreationPageURL, String benchmarkCreationPageURLFraction, String nameLabel,
			String providerLabel, String currencyLabel, String hedgedLabel, String hedgedCurrencyLabel,
			String lastPriceLabel, String lastPriceDateLabel) throws Exception {
		boolean flag = false;
		try {

			if (verifyInstrumentManagementTabTitle(instrumentManagementTabTitleTextValue)) {
				if (clickOnInstrumentManagementTab()) {
					if (clickOnBenchmarkDropDownValue()) {
						if (verifyBenchmarksManagementTitle(benchmarksManagementTitle)) {
							if (clickOnSearchPlusButton()) {
								if (verifyBenchmarkCreationPageOpened(benchmarkCreationPageURL,
										benchmarkCreationPageURLFraction)) {
									if (verifyBenchmarkCategorizationTabTitle(benchCategorizationTabTitleText)) {
										if (verifyBenchmarkCategorizationTitle(benchCategorizationTitleText)) {
											if (verifyCanceButtonInBenchmarkCreationPage(cancelButtonText)) {
												if (verifyBenchmarksCategorizationLabels(nameLabel, providerLabel,
														currencyLabel, hedgedLabel, hedgedCurrencyLabel, lastPriceLabel,
														lastPriceDateLabel)) {
													flag = true;
												}
											}
										}
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
