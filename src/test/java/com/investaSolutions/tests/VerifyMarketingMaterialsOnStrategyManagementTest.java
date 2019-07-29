package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyMarketingMaterialsOnStrategyManagementPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyMarketingMaterialsOnStrategyManagementTest extends TestBase {

	@Test(priority = 1, enabled = true, description = "Verifying Marketing Materials on strategy-management page in the page")
	public void testToVerifyMarketingMaterialsOnStrategyManagementpageTest(Method method) throws Throwable {
		String marketingMaterialsTabLabel = "";
		String marketMaterialsTitleLabel = "";
		String backButtonLabel = "";
		String newStrategyButtonLabel = "";
		String strategyVideoLabel = "";
		String updateFrequencyLabel = "";
		String effectiveDateLabel = "";		
		String vidoeLabel = "";	
		String strategySlidesLabel = "";
		String updateFrequencyLabelOfSlides = "";
		String slidesLabel = "";
		String strategyReportLabel = "";
		String updateFrequencyLabelOfReport = "";
		String reportLabel = "";
		String riskDisclosureLabel = "";
		String updateFrequencyLabelOfRisk = "";
		String reportLabelOfRisk = "";
		
		boolean flagMarketMaterialsTabAndPageDetails;

		VerifyMarketingMaterialsOnStrategyManagementPage objVerifyMarketingMaterialsOnStrategyManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_STRATEGYMANAGEMENTPAGE"), "TC_15");
			objVerifyMarketingMaterialsOnStrategyManagementPage = new VerifyMarketingMaterialsOnStrategyManagementPage(
					driver);
			marketingMaterialsTabLabel = testData.get("MARKET_MATERIALS_TAB_TITLE_NAME");
			marketMaterialsTitleLabel = testData.get("MARKET_MATERIALS_TITLE_NAME");			
			backButtonLabel = testData.get("BACKBUTTON");
			newStrategyButtonLabel = testData.get("NEWSTRATEGY_BUTTON");			
			strategyVideoLabel = testData.get("STRATEGY_VIDEO_NAME");
			updateFrequencyLabel = testData.get("UPDATE_FREQUENCY_NAME");
			effectiveDateLabel = testData.get("EFFECTIVE_DATE_NAME");
			vidoeLabel = testData.get("VIDEO_NAME");
			strategySlidesLabel = testData.get("STRATEGY_SLIDES_NAME");
			updateFrequencyLabelOfSlides = testData.get("UPDATE_FREQUENCEY_NAME_UNDER_STRATEGYSLIDES");
			slidesLabel = testData.get("SLIDES_NAME");
			strategyReportLabel = testData.get("STRATEGY_REPORT_NAME");			
			updateFrequencyLabelOfReport = testData.get("UPDATE_FREQUENCEY_NAME_UNDER_STRATEGYREPORT");
			reportLabel = testData.get("REPORT_NAME");
			riskDisclosureLabel = testData.get("RISK_DISCLOSURE");
			updateFrequencyLabelOfRisk = testData.get("UPDATE_FREQUENCEY_NAME_UNDER_RISKDISCLOSURE");
			reportLabelOfRisk = testData.get("REPORT_NAME_UNDER_RISKDISCLOSURE");
			

			StartTest(properties.getLogMessage("MarketingMaterials"),
					properties.getLogMessage("MarketingMaterialsTabAndStrategyManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryMarketingMaterialsOnStrategyListPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagMarketMaterialsTabAndPageDetails = objVerifyMarketingMaterialsOnStrategyManagementPage
					.verifyMarketMaterialsOnStrategyManagementPage(marketingMaterialsTabLabel,
							marketMaterialsTitleLabel, backButtonLabel, newStrategyButtonLabel, strategyVideoLabel,
							updateFrequencyLabel, effectiveDateLabel, vidoeLabel, strategySlidesLabel,
							updateFrequencyLabelOfSlides, slidesLabel, strategyReportLabel,
							updateFrequencyLabelOfReport, reportLabel, riskDisclosureLabel, updateFrequencyLabelOfRisk,
							reportLabelOfRisk);
			EndTest(properties.getLogMessage("MarketingMaterials"));
			Assert.assertTrue(flagMarketMaterialsTabAndPageDetails,
					properties.getLogMessage("VerifyMarketingMaterialsTabAndDetailsOnStrategyManagementTestFailed"));

		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyMarketingMaterialsTabAndDetailsOnStrategyManagementTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
