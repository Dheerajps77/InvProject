package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyInvestmentObjectivesOnStrategyManagementpage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyInvestmentObjectivesOnStrategyManagementTest extends TestBase {

	@Test(priority = 1, enabled = true, description = "Verifying investment objectives on strategy-management page in the page")
	public void testToVerifyInvestmentObjectivesOnStrategyManagementpageTest(Method method) throws Throwable {
		String investmentObjectivesTabLabel = "";
		String investmentObjectivesTitleLabel = "";
		String investmentObjectivesTitleUnderTable = "";
		String investmentObjectiveNameLabel = "";
		String investmentObjectiveDescriptionLabel = "";
		String backButtonLabel = "";
		String newStrategyButtonLabel = "";		
		boolean flagStrategyManagementTabAndPageDetails;

		VerifyInvestmentObjectivesOnStrategyManagementpage objVerifyInvestmentObjectivesOnStrategyManagementpage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_STRATEGYMANAGEMENTPAGE"), "TC_14");
			objVerifyInvestmentObjectivesOnStrategyManagementpage = new VerifyInvestmentObjectivesOnStrategyManagementpage(
					driver);
			investmentObjectivesTabLabel = testData.get("INVESTMENTOBJECTIVESTABTITLE_NAME");
			investmentObjectivesTitleLabel = testData.get("INVESTMENTOBJECTIVESTITLE_NAME");
			investmentObjectivesTitleUnderTable = testData.get("TITLE");
			investmentObjectiveNameLabel = testData.get("INVESTMENTOBJECTIVE_NAME");
			investmentObjectiveDescriptionLabel = testData.get("INVESTMENTOBJECTIVEDESCRIPTION_NAME");
			backButtonLabel = testData.get("BACKBUTTON");
			newStrategyButtonLabel = testData.get("NEWSTRATEGY_BUTTON");

			StartTest(properties.getLogMessage("InvestmentObjectives"),
					properties.getLogMessage("InvestmentObjectivesTabAndStrategyManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryInvestmentObjectivesOnStrategyListPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagStrategyManagementTabAndPageDetails = objVerifyInvestmentObjectivesOnStrategyManagementpage
					.verifyInvestmentObjectivesOnStrategyManagementPage(investmentObjectivesTabLabel,
							investmentObjectivesTitleLabel, investmentObjectivesTitleUnderTable,
							investmentObjectiveNameLabel, investmentObjectiveDescriptionLabel, backButtonLabel,
							newStrategyButtonLabel);
			EndTest(properties.getLogMessage("InvestmentObjectives"));
			Assert.assertTrue(flagStrategyManagementTabAndPageDetails,
					properties.getLogMessage("VerifyInvestmentObjectivesTabAndDetailsOnStrategyManagementTestFailed"));
			
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyInvestmentObjectivesTabAndDetailsOnStrategyManagementTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
