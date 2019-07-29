package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyBenchmarkCategorizationOnBenchmarkCreationPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyBenchmarkCategorizationOnBenchmarkCreationTest extends TestBase {

	@Test(priority = 1, enabled = true, description = "Verifying details under benchmark categorization in the benchmark_creation page")
	public void testToVerifyBenchmarkCategorizationOnBenchmarkCreationTest(Method method) throws Throwable {

		String benchmarksManagementTabTextValue = "";
		String instrumentManagementTabTitleTextValue = "";
		String benchmarksManagementTitle = "";
		String benchCategorizationTabTitleText = "";
		String benchCategorizationTitleText = "";
		String cancelButtonText = "";
		String nameLabel = "";
		String providerLabel = "";
		String currencyLabel = "";
		String hedgedLabel = "";
		String hedgedCurrencyLabel = "";
		String lastPriceLabel = "";
		String lastPriceDateLabel = "";
		String benchmarkCreationPageURL = "";
		String benchmarkCreationPageURLFraction = "";

		boolean flagBenchmarkCategorizationDetailsInPage;

		VerifyBenchmarkCategorizationOnBenchmarkCreationPage objVerifyBenchmarkCategorizationOnBenchmarkCreationPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_INSTRUMENTMANAGEMENTPAGE"), "TC_16");
			objVerifyBenchmarkCategorizationOnBenchmarkCreationPage = new VerifyBenchmarkCategorizationOnBenchmarkCreationPage(
					driver);

			benchmarksManagementTabTextValue = testData.get("BENCHMARKS").trim();
			instrumentManagementTabTitleTextValue = testData.get("INSTRUMENTMANAGEMENT_TAB_TITLE");
			benchmarksManagementTitle = testData.get("BENCHMARKMANAGEMENT_TITLE").trim();
			benchCategorizationTabTitleText = testData.get("BENCHMARKCATEGORIZATION_TAB_TITLE");
			benchCategorizationTitleText = testData.get("BENCHMARKCATEGORIZATION_TITLE");
			cancelButtonText = testData.get("CANCE_BUTTON_TEXT");
			nameLabel = testData.get("NAME_LABEL");
			providerLabel = testData.get("PROVIDER_LABEL");
			currencyLabel = testData.get("CURRENCY_LABEL");
			hedgedLabel = testData.get("HEDGED_LABEL");
			hedgedCurrencyLabel = testData.get("HEDGED_CURRENCY_LABEL").trim();
			lastPriceLabel = testData.get("LAST_PRICE_LABEL");
			lastPriceDateLabel = testData.get("LAST_PRICE_DATE_LABEL");
			benchmarkCreationPageURL = testData.get("BENCHMARK_CREATION_PAGE_URL");
			benchmarkCreationPageURLFraction = testData.get("BENCHMARK_CREATION_PAGE_FRACTIONS");

			StartTest(properties.getLogMessage("BenchMark"),
					properties.getLogMessage("BenchmarkCategorizationDetailsOnBenchmarksCreationPage"));
			setTestCategory(properties.getLogMessage("CategoryBenchmarkCategorizationOnBenchmarkCreationPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagBenchmarkCategorizationDetailsInPage = objVerifyBenchmarkCategorizationOnBenchmarkCreationPage
					.verifyBenchmarkCategorizationOnBenchmarkCreationPage(instrumentManagementTabTitleTextValue,
							benchmarksManagementTabTextValue, benchmarksManagementTitle,
							benchCategorizationTabTitleText, benchCategorizationTitleText, cancelButtonText,
							benchmarkCreationPageURL, benchmarkCreationPageURLFraction, nameLabel, providerLabel,
							currencyLabel, hedgedLabel, hedgedCurrencyLabel, lastPriceLabel, lastPriceDateLabel);

			Assert.assertTrue(flagBenchmarkCategorizationDetailsInPage,
					properties.getLogMessage("VerifyBenchmarksCategorizationTestFailed"));
			EndTest(properties.getLogMessage("BenchMark"));

		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyBenchmarksCategorizationTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
