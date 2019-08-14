package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.SettingVerifyGlobalFilterOnPMConfigPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifySettingVerifyGlobalFilterOnPMConfigTest extends TestBase {

	@Test(priority = 1)
	public void testToVerifySettingVerifyGlobalFilterOnPMConfigTest(Method method) throws Exception {
		SettingVerifyGlobalFilterOnPMConfigPage objSettingVerifyGlobalFilterOnPMConfigPage;
		String settingsTabText;
		String dropdownValue;
		String urlFractionValue;
		String expectedURL;
		String assetManagerNameValue;

		boolean flagVerifyGlobalFilterOnPMConfigPage;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_PMCONFIGURATIONPAGE"), "TC_19");
			settingsTabText = testData.get("SETTING_TAB_TITLE");
			dropdownValue = testData.get("DROPDOWNVALUE_OF_SETTINGSTAB");
			urlFractionValue = testData.get("URL_FRACTION_VALUE");
			expectedURL = testData.get("URL");
			assetManagerNameValue = testData.get("ASSETMANAGER_NAME");

			StartTest(properties.getLogMessage("GlobalFilterOnPMConfigurationPage"),
					properties.getLogMessage("VerifyGlobalFilterFunctionalityOnPMConfigurationPage"));
			setTestCategory(properties.getLogMessage("CategoryGlobalFilterOnPMConfigurationPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));
			objSettingVerifyGlobalFilterOnPMConfigPage = new SettingVerifyGlobalFilterOnPMConfigPage(driver);
			flagVerifyGlobalFilterOnPMConfigPage = objSettingVerifyGlobalFilterOnPMConfigPage
					.verifyGlobalFilterFunctionalityOnPMConfigurationPage(settingsTabText, dropdownValue,
							urlFractionValue, expectedURL, assetManagerNameValue);

			Assert.assertTrue(flagVerifyGlobalFilterOnPMConfigPage,
					properties.getLogMessage("VerifyGlobalFilterOnPMConfigurationTestFailed"));
			EndTest(properties.getLogMessage("GlobalFilterOnPMConfigurationPage"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyGlobalFilterOnPMConfigurationTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
