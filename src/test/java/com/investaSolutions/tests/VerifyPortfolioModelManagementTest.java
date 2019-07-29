package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyPortfolioModelManagementPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyPortfolioModelManagementTest extends TestBase {

	SoftAssert softAssert;

	@Test(priority = 1)
	public void testPortfolioModelManagementTest(Method method) throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME_PORTFOLIOMANGEMENTPAGE"), "TC_4");
			String portfolioManagementTabText = testData.get("PM_MANAGEMENTTITLE");
			String portfolioModelListTitleText = testData.get("PORTFOLIOMODELLIST");
			String dColumnLabelText = testData.get("D_COLUMNNAME");
			String cColumnLabelText = testData.get("C_COLUMNNAME");
			String modelNameLabelText = testData.get("MODELNAME_COLUMNNAME");
			String currencyLabelText = testData.get("CURRENCY_COLUMNNAME");
			String contactDetailsLabelText = testData.get("CONTACTDETAILS_COLUMNNAME");
			String modelStyleLabelText = testData.get("MODELSTYLE_COLUMNNAME");
			String openCloseLabelText = testData.get("OPENCLOSE_COLUMNNAME");
			String lastUpdatedLabelText = testData.get("LASTUPDATED_COLUMNNAME");
						
			boolean titleOf_ModelListFlag;
			StartTest(properties.getLogMessage("VerifyPortfolioModelManagementDetailsTest"),
					properties.getLogMessage("VerifyPortfolioModelManagementDetail"));
			setTestCategory(properties.getLogMessage("CategoryPortfolioModelManagementDetail"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			logInfo(properties.getLogMessage("LoginTestPassed"));
			VerifyPortfolioModelManagementPage objVerifyPortfolioModelManagementPageDetails = new VerifyPortfolioModelManagementPage(
					driver);
			boolean flag = objVerifyPortfolioModelManagementPageDetails.VerifyProtfolioManagementTabAndDetailsInPage(portfolioManagementTabText, dColumnLabelText, cColumnLabelText, modelNameLabelText,
					currencyLabelText, contactDetailsLabelText, modelStyleLabelText, openCloseLabelText,
					lastUpdatedLabelText);			
			Assert.assertTrue(flag, properties.getLogMessage("VerifyPortfolioManagementTabAndDetailsPassed"));			
					
			titleOf_ModelListFlag = objVerifyPortfolioModelManagementPageDetails.VerifyPortfolioModelListTitle(portfolioModelListTitleText.trim());			
			Assert.assertTrue(titleOf_ModelListFlag, properties.getLogMessage("VerifyPortfolioModelListTitlePassed"));		
			
			boolean backButton=objVerifyPortfolioModelManagementPageDetails.VerifyBackButton();
			Assert.assertTrue(backButton, properties.getLogMessage("VerifyBackButton"));
			
			boolean newPortfolioButton=objVerifyPortfolioModelManagementPageDetails.VerifyNewPortfolioButton();
			Assert.assertTrue(newPortfolioButton, properties.getLogMessage("VerifyNewPortfolioButton"));
		} catch (Throwable e) {
			logError(properties.getLogMessage("VerifyPortfolioManagementPageDetailsPTestFailed"));			
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}		
	}

}
