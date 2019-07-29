package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyGlobalFilterOnInstrumentPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyGlobalFilterOnInstrumentPageTest extends TestBase {

	@Test(priority = 1, enabled = true, description = "Verifying Global filter in instrument management page")
	public void testToVerifyGlobalFilterOnInstrument(Method method) throws Throwable {
		String instrumentManagementTabText = "";
		String instrumentManagementTitleText = "";
		String isinIdValue = "";

		boolean flagVerifyGlobalFilter;

		VerifyGlobalFilterOnInstrumentPage objVerifyGlobalFilterOnInstrumentPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_INSTRUMENTMANAGEMENTPAGE"), "TC_15");
			objVerifyGlobalFilterOnInstrumentPage = new VerifyGlobalFilterOnInstrumentPage(driver);
			instrumentManagementTabText = testData.get("INSTRUMENTMANAGEMENT_TAB_TITLE");
			instrumentManagementTitleText = testData.get("INSTRUMENTMANAGEMENT_TITLE");
			isinIdValue = testData.get("ISINID");
			StartTest(properties.getLogMessage("GlobalFilter"),
					properties.getLogMessage("GlobalFilterOnInstrumentManagement"));
			setTestCategory(properties.getLogMessage("CategoryGlobalFilterOnInstrumentManagementPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagVerifyGlobalFilter = objVerifyGlobalFilterOnInstrumentPage.verifyGlobalFilterOnInstrumentPage(
					instrumentManagementTabText, instrumentManagementTitleText, isinIdValue);
			Assert.assertTrue(flagVerifyGlobalFilter,
					properties.getLogMessage("VerifyGlobalFilterOnInstrumentManagementPageTestFailed"));
			EndTest(properties.getLogMessage("GlobalFilter"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyGlobalFilterOnInstrumentManagementPageTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}
}
