package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyStrategyDetailsOnStrategyManagementPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyStrategyDetailsOnStrategyManagementTest extends TestBase {

	@Test(priority = 2, enabled = false, description = "Verifying strategy management tab and strategy-management details in the page")
	public void testToVerifyStrategyManagementAndPageDetailsTest(Method method) throws Throwable {
		String strategyManagementTabLabelText = "";
		String strategyManagementNameLabelText = "";
		String strategyNameLabelText = "";
		String strategyUrl = "";
		String strategyUrlFractionValue = "";
		String strategyManagementUrl = "";
		String strategyManagementUrlFractionValue = "";
		String backButtonText = "";
		String newStrategyButtonText = "";

		boolean flagStrategyManagementTabAndPageDetails;

		VerifyStrategyDetailsOnStrategyManagementPage objvVerifyStrategyDetailsOnStrategyManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_STRATEGYMANAGEMENTPAGE"), "TC_13");
			objvVerifyStrategyDetailsOnStrategyManagementPage = new VerifyStrategyDetailsOnStrategyManagementPage(
					driver);
			strategyManagementTabLabelText = testData.get("STRATEGYMANAGEMENTTAB");
			strategyManagementNameLabelText = testData.get("STRATEGYMANAGEMENTNAME");
			strategyNameLabelText = testData.get("STRATEGYNAME");
			strategyUrl = testData.get("STRATEGY_URL");
			strategyUrlFractionValue = testData.get("STRATEGY_URL_FRACTION");
			strategyManagementUrl = testData.get("STRATEGYMANAGEMENT_URL");
			strategyManagementUrlFractionValue = testData.get("STRATEGYMANAGEMENT_URL_FRACTION");
			backButtonText = testData.get("BACKBUTTON");
			newStrategyButtonText = testData.get("NEWSTRATEGY_BUTTON");

			StartTest(properties.getLogMessage("StrategyManagement"),
					properties.getLogMessage("StrategyManagementTabAndStrategyManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryStrategyManagementPageDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagStrategyManagementTabAndPageDetails = objvVerifyStrategyDetailsOnStrategyManagementPage
					.verifyStrategyManagementTabAndStrategyListPageDetails(strategyManagementTabLabelText,
							strategyManagementNameLabelText, strategyUrlFractionValue, strategyUrl,
							strategyManagementUrlFractionValue, strategyManagementUrl, backButtonText,
							newStrategyButtonText);

			Assert.assertTrue(flagStrategyManagementTabAndPageDetails,
					properties.getLogMessage("VerifyStrategyManagementTabAndStrategyListTestFailed"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyStrategyManagementTabAndStrategyListTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

	@Test(priority = 3, enabled = true, description = "Verifying strategy details on strategy-management page in the page")
	public void testToVerifyStrategyDetailsOnStrategyManagementPageTest(Method method) throws Throwable {
		String strategyDetailsLabelText = "";
		String strategyNameLabelText = "";
		String descriptionLabelText = "";
		String highLightLabelText = "";
		String imageLabelText = "";
		String backButtonText = "";
		String newStrategyButtonText = "";
		boolean flagStrategyDetails;

		VerifyStrategyDetailsOnStrategyManagementPage objvVerifyStrategyDetailsOnStrategyManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_STRATEGYMANAGEMENTPAGE"), "TC_13");
			objvVerifyStrategyDetailsOnStrategyManagementPage = new VerifyStrategyDetailsOnStrategyManagementPage(
					driver);
			strategyDetailsLabelText = testData.get("STRTEGYDETAILSNAME");
			strategyNameLabelText = testData.get("STRATEGYNAME");
			descriptionLabelText = testData.get("DESCRIPTION");
			highLightLabelText = testData.get("HIGHLIGHTS");
			imageLabelText = testData.get("IMAGE");
			backButtonText = testData.get("BACKBUTTON");
			newStrategyButtonText = testData.get("NEWSTRATEGY_BUTTON");

			StartTest(properties.getLogMessage("StrategyDetails"),
					properties.getLogMessage("StrategyDetailsOnStrategyManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryStrategyDetailsOnStrategyListPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			/*
			 * flagStrategyDetails = objvVerifyStrategyDetailsOnStrategyManagementPage
			 * .verifyStrategyDetailsOnStrategyManagementPage(strategyDetailsLabelText,
			 * strategyDetailsLabelText, strategyNameLabelText, descriptionLabelText,
			 * highLightLabelText, imageLabelText, backButtonText, newStrategyButtonText);
			 * 
			 */
			flagStrategyDetails = objvVerifyStrategyDetailsOnStrategyManagementPage
					.CreateNewStrategy("FirstTestStrategy", "This is to check if first test strategy");
			EndTest(properties.getLogMessage("StrategyDetails"));
			Assert.assertTrue(flagStrategyDetails,
					properties.getLogMessage("VerifyStrategyDetailsOnStrategyManagementPageFailed"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyStrategyDetailsOnStrategyManagementPageFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
