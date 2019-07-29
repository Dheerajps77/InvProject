package com.investaSolutions.tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.AssetManagerStrategyManagementPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMStrategyManagementTest  extends TestBase{

	@Test(groups = {"regression"}, priority=4)
	// TC_3 This test verifies the details present on the Strategy Management page
	public void verifyStrategyManagementDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_3");
			String strategyManagementLabelText = testData.get("LABEL");
			String searchHeaderText = testData.get("SEARCH");
			String strategyNameHeaderText = testData.get("NAME");
			String strategyDescHeaderText = testData.get("DESCRIPTION");
			String newStrategyButtonText = testData.get("NEWSTRATEGYBUTTON");
			String backButtonText = testData.get("BACKBUTTON");
			StartTest(properties.getLogMessage("VerifyStrategyManagementDetailsTest"), properties.getLogMessage("VerifyStrategyManagementDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyStrategyManagementDetails"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));	
			
			AssetManagerStrategyManagementPage strategyManagementPage = new AssetManagerStrategyManagementPage(driver);
			Assert.assertTrue(strategyManagementPage.verifyStrategyManagementPageDetails(strategyManagementLabelText, searchHeaderText, strategyNameHeaderText, strategyDescHeaderText, newStrategyButtonText, backButtonText), String.format(properties.getLogMessage("StrategyManagementDetailsVerificationFailed"), strategyManagementLabelText, searchHeaderText, strategyNameHeaderText, strategyDescHeaderText, newStrategyButtonText, backButtonText));
			logInfo(String.format(properties.getLogMessage("StrategyManagementDetailsVerificationPassed"), strategyManagementLabelText, searchHeaderText, strategyNameHeaderText, strategyDescHeaderText, newStrategyButtonText, backButtonText));
		}
		catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {		
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}
}
