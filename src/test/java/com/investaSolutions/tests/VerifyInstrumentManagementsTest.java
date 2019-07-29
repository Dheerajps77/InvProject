package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyInstrumentsPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyInstrumentManagementsTest extends TestBase {

	@Test(priority = 2, enabled=true, description = "Verifying instrument management tab and instrument_list details in the page")
	public void testInstrumentManagementAndInstrumentListPageDetailsTest(Method method) throws Throwable {
		String instrumentManagementTabText = "";
		String instrumentsDropdownValueText = "";
		String benchMarksDropdownValueText = "";
		String instrumentsPageURL = "";
		String instrumentsPageURLFractions = "";
		String instrumentManagementTitleText = "";

		String d_ColumnName = "";
		String isin_ColumnName = "";
		String name_ColumnName = "";
		String productType_ColumnName = "";
		String majorAssertClass_ColumnName = "";
		String currency_ColumnName = "";
		String lastPrice_ColumnName = "";
		String lastPriceDate_ColumnName = "";
		String backbtnTextValue = "";
		String newInstrumentbtnTextValue = "";

		boolean flagInstrumentManagementTabAndDetails;
		boolean flagBackButtonInInstrumentManagement;
		boolean flagNewInstrumentButtonInInstrumentManagement;
		boolean flagInstrumentManagementTitle;
		boolean flagGlobalFilterSearchTextBox;
		VerifyInstrumentsPage objInstrumentManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_INSTRUMENTMANAGEMENTPAGE"), "TC_8");
			objInstrumentManagementPage = new VerifyInstrumentsPage(driver);
			instrumentManagementTabText = testData.get("INSTRUMENTMANAGEMENT_TAB_TITLE");
			instrumentsDropdownValueText = testData.get("INSTRUMENTS");
			benchMarksDropdownValueText = testData.get("BENCHMARKS");
			instrumentsPageURL = testData.get("INSTRUMENTS_PAGE_URL");
			instrumentsPageURLFractions = testData.get("INSTRUMENTS_PAGE_FRACTIONS");
			instrumentManagementTitleText = testData.get("INSTRUMENTMANAGEMENT_TITLE");
			d_ColumnName = testData.get("D_COLUMNNAME");
			isin_ColumnName = testData.get("ISIN_COLUMNNAME");
			name_ColumnName = testData.get("NAME_COLUMNNAME");
			productType_ColumnName = testData.get("PRODUCTTYPE_COLUMNNAME");
			majorAssertClass_ColumnName = testData.get("MAJORASSETCLASS_COLUMNNAME");
			currency_ColumnName = testData.get("CURRENCY_COLUMNNAME");
			lastPrice_ColumnName = testData.get("LASTPRICE_COLUMNNAME");
			lastPriceDate_ColumnName = testData.get("LASTPRICEDATE_COLUMNNAME");
			backbtnTextValue = testData.get("BACKBUTTON");
			newInstrumentbtnTextValue = testData.get("NEW_INSTRUMENTBUTTON");

			StartTest(properties.getLogMessage("InstrumentManagement"),
					properties.getLogMessage("InstrumentManagementTabAndDetail"));
			setTestCategory(properties.getLogMessage("CategoryInstrumentManagementPageDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagInstrumentManagementTabAndDetails = objInstrumentManagementPage
					.VerifyInstrumentManagementTabAndInstrumentsListPageDetails(instrumentManagementTabText,
							instrumentsDropdownValueText, benchMarksDropdownValueText, instrumentsPageURLFractions,
							instrumentsPageURL, d_ColumnName, isin_ColumnName, name_ColumnName, productType_ColumnName,
							majorAssertClass_ColumnName, currency_ColumnName, lastPrice_ColumnName,
							lastPriceDate_ColumnName);
			Assert.assertTrue(flagInstrumentManagementTabAndDetails,
					properties.getLogMessage("VerifyInstrumentManagementTabAndDropDownValuesTestFailed"));

			flagInstrumentManagementTitle = objInstrumentManagementPage
					.VerifyInstrumentManagementTitle(instrumentManagementTitleText);
			Assert.assertTrue(flagInstrumentManagementTitle);
			flagBackButtonInInstrumentManagement = objInstrumentManagementPage
					.VerifyBackButtonInInstrumentManagementPage(backbtnTextValue);
			Assert.assertTrue(flagBackButtonInInstrumentManagement, properties.getLogMessage("VerifyBackButton"));

			flagNewInstrumentButtonInInstrumentManagement = objInstrumentManagementPage
					.VerifyNewInstrumentButtonInInstrumentManagementPage(newInstrumentbtnTextValue);
			Assert.assertTrue(flagNewInstrumentButtonInInstrumentManagement,
					properties.getLogMessage("VerifyNewInstrumentButton"));

			flagGlobalFilterSearchTextBox = objInstrumentManagementPage.VerifyGlobalFilterSearchTextBox();
			Assert.assertTrue(flagGlobalFilterSearchTextBox);			
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyInstrumentManagementTabAndDropDownValuesTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

	@Test(priority = 3, enabled=true, description = "Verifying instrument management tab and benchmarks_list details in the page")
	public void testInstrumentManagementAndBenchmarksListPageDetailsTest(Method method) throws Throwable {
		String instrumentManagementTabText = "";
		String instrumentsDropdownValueText = "";
		String benchMarksDropdownValueText = "";
		String benchmarksPageURL = "";
		String benchmarksPageURLFractions = "";
		String benchmarksManagementTitleText = "";

		String benchmarkName_ColumnName = "";
		String provider_ColumnName = "";
		String currency_ColumnName = "";
		String lastPrice_ColumnName = "";		
		String lastPriceDate_ColumnName = "";
		String backbtnTextValue = "";
		String dateAdded_ColumnName = "";

		boolean flagInstrumentManagementTabAndDetails;
		boolean flagBackButtonInBenchmarksManagement;
		boolean flagBenchmarksManagementTitle;
		boolean flagGlobalFilterSearchTextBox;

		VerifyInstrumentsPage objInstrumentManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_INSTRUMENTMANAGEMENTPAGE"), "TC_12");
			objInstrumentManagementPage = new VerifyInstrumentsPage(driver);
			instrumentManagementTabText = testData.get("INSTRUMENTMANAGEMENT_TAB_TITLE");
			instrumentsDropdownValueText = testData.get("INSTRUMENTS");
			benchMarksDropdownValueText = testData.get("BENCHMARKS");			
			benchmarksPageURL = testData.get("BENCHMARK_PAGE_URL");
			benchmarksPageURLFractions = testData.get("BENCHMARK_PAGE_FRACTIONS");
			benchmarksManagementTitleText = testData.get("BENCHMARKMANAGEMENT_TITLE");
			benchmarkName_ColumnName = testData.get("BENCHMARKNAME_COLUMNNAME");
			provider_ColumnName = testData.get("PROVIDER_COLUMNNAME");
			currency_ColumnName = testData.get("CURRENCY_COLUMNNAME");
			lastPrice_ColumnName = testData.get("LASTPRICE_COLUMNNAME");
			lastPriceDate_ColumnName = testData.get("LASTPRICEDATE_COLUMNNAME");
			backbtnTextValue = testData.get("BACKBUTTON");
			dateAdded_ColumnName = testData.get("DATEADDED_COLUMNNAME");

			StartTest(properties.getLogMessage("BenchmarksManagement"),
					properties.getLogMessage("InstrumentManagementTabAndBenchmarksPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryBenchmarksManagementPageDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagInstrumentManagementTabAndDetails = objInstrumentManagementPage
					.verifyInstrumentManagementTabAndBenchmarksListPageDetails(instrumentManagementTabText,
							instrumentsDropdownValueText, benchMarksDropdownValueText, benchmarksPageURLFractions,
							benchmarksPageURL, benchmarkName_ColumnName, provider_ColumnName, currency_ColumnName,
							lastPrice_ColumnName, lastPriceDate_ColumnName, dateAdded_ColumnName);
			Assert.assertTrue(flagInstrumentManagementTabAndDetails,
					properties.getLogMessage("VerifyInstrumentManagementTabAndDropDownValuesTestPassed"));

			flagBenchmarksManagementTitle = objInstrumentManagementPage
					.verifyBenchmarksManagementTitle(benchmarksManagementTitleText);
			Assert.assertTrue(flagBenchmarksManagementTitle);
			flagBackButtonInBenchmarksManagement = objInstrumentManagementPage
					.verifyBackButtonInBenchmarksManagementPage(backbtnTextValue);
			Assert.assertTrue(flagBackButtonInBenchmarksManagement, properties.getLogMessage("VerifyBackButton"));

			flagGlobalFilterSearchTextBox = objInstrumentManagementPage.VerifyGlobalFilterSearchTextBox();
			Assert.assertTrue(flagGlobalFilterSearchTextBox);

		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyInstrumentManagementTabAndDropDownValuesTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
