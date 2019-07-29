package com.investaSolutions.tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.AssetManagerPortalPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AssetManagerPortalTest extends TestBase{

	@Test(groups = {"regression"}, priority=2)
	// TC_5 This test verifies the details present on the Asset Manager Portal's home page
	public void verifyAsserManagerPortalDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_5");
			String dashboardTab = testData.get("DASHBOARD");
			String assetManagerTab = testData.get("ASSETMANAGER");
			String strategyManagementTab = testData.get("STRATEGYMANAGEMENT");
			String instrumentManagementTab = testData.get("INSTRUMENTMANAGEMENT");
			String portfolioModelManagementTab = testData.get("PORTFOLIOMODELMANAGEMENT");
			String portfolioModelApprovalTab = testData.get("PORTFOLIOMODELAPPROVAL");
			String disconnectTab = testData.get("DISCONNECT");	
			StartTest(properties.getLogMessage("VerifyAssetManagerPortalDetailsTest"), properties.getLogMessage("VerifyAssetManagerPortalDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAssetManagerPortalDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));	

			AssetManagerPortalPage userManagementPage = new AssetManagerPortalPage(driver);			
			Assert.assertTrue(userManagementPage.verifyAssetManagerPortalPageDetails(dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab), String.format(properties.getLogMessage("AssetManagerPortalPageDetailsVerificationFailed"), dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab));
			logInfo(String.format(properties.getLogMessage("AssetManagerPortalPageDetailsVerificationPassed"), dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab));
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
