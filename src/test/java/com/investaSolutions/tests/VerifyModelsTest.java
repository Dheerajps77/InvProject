package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.BankManagerModelPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyModelsTest extends TestBase {

	@Test(priority = 1)
	public void testToVerifyModelsTabAndDetailsOnPortfolioModelApprovalTest(Method method) throws Exception {
		BankManagerModelPage objBankManagerModelPage;
		String modelsTitleText;
		String fractionTextValueOfURL;
		String expectedPageURL;
		String expectedPortfolioModelsApprovalsTitleTextValue;
		String e_Text;
		String assetManager_Text;
		String asetManager_Text;
		String strategyName_Text;
		String investmentObjectives_Text;
		String currency_Text;
		String status_Text;
		String notSubmittedLabel;
		String submittedToBankLabel;
		String approvedByBankLabel;
		String cancelledByAssertManagerLabel;
		String revokedByBankLabel;
		String rejectedByBankLabel;
		boolean flagVerifyModelsPageDetails;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_PORTFOLIOMODELlISTPAGE"), "TC_17");
			modelsTitleText = testData.get("MODELS_TAB_TITLE");
			fractionTextValueOfURL = testData.get("URL_FRACTION_VALUE");
			expectedPageURL = testData.get("URL");
			expectedPortfolioModelsApprovalsTitleTextValue = testData.get("PORTFOLIOMODELAPPROVAL_TITLE");
			e_Text = testData.get("E_COLUMNNAME");
			assetManager_Text = testData.get("ASSET_MANAGER_COLUMNNAME");
			asetManager_Text = testData.get("ASET_MANAGER_COLUMNNAME");
			strategyName_Text = testData.get("STRATEGY_NAME_COLUMNNAME");
			investmentObjectives_Text=testData.get("INVESTMENTOBJECTIVE_COLUMNNAME");
			currency_Text = testData.get("CURRENCY_COLUMNNAME");
			status_Text = testData.get("STATUS_COLUMNNAME");
			notSubmittedLabel = testData.get("NOTSUBMITTED_LABEL");
			submittedToBankLabel = testData.get("SUBMITTEDTOBANK_LABEL");			
			approvedByBankLabel = testData.get("APPROVEDBYBANK_LABEL");
			cancelledByAssertManagerLabel = testData.get("CANCELLEDBYASSETMANAGER_LABEL");
			revokedByBankLabel = testData.get("REVOKEDBYBANK_LABEL");
			rejectedByBankLabel = testData.get("REJECTEDBYBANK_LABEL");
			
			StartTest(properties.getLogMessage("PortfolioModelList"),
					properties.getLogMessage("VerifyModelsTabAndModelsPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryModelsPageDetailsOnPortfolioModelListPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			objBankManagerModelPage = new BankManagerModelPage(driver);
			flagVerifyModelsPageDetails=objBankManagerModelPage.verifyModelListPageDetails(modelsTitleText, fractionTextValueOfURL, expectedPageURL,
					expectedPortfolioModelsApprovalsTitleTextValue, e_Text, assetManager_Text, asetManager_Text,
					strategyName_Text, investmentObjectives_Text, currency_Text, status_Text, notSubmittedLabel, submittedToBankLabel,
					approvedByBankLabel, cancelledByAssertManagerLabel, revokedByBankLabel, rejectedByBankLabel);
			
			Assert.assertTrue(flagVerifyModelsPageDetails, properties.getLogMessage("VerifyModelsOnPortfolioModelListPageTestFailed"));
			EndTest(properties.getLogMessage("PortfolioModelList"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyModelsOnPortfolioModelListPageTestFailed"));			
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));			
			throw e;
		}
	}

}
