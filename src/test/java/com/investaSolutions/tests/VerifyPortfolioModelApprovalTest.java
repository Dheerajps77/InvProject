package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.VerifyPortfolioModelApprovalPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyPortfolioModelApprovalTest extends TestBase {

	@Test(priority = 2)
	public void testPortfolioModelApprovalTest(Method method) throws Throwable {
		String portfolioModelNameColumnLabelText = "";
		String bankColumnLabelText = "";
		String bankPermissionTitleText = "";
		String portfolioModelApprovalTabTitleText = "";
		String revokedByBankIconText = "";
		String notSubmittedIconText = "";
		String submittedToBankIconText = "";
		String approvedByBankIconText = "";
		String cancelledByAssetManagerIconText = "";
		String rejectedByBankIconText = "";
		boolean flag;
		VerifyPortfolioModelApprovalPage objApprovalPage = null;
		try {
			objApprovalPage = new VerifyPortfolioModelApprovalPage(driver);
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_6");
			portfolioModelNameColumnLabelText = testData.get("PORTFOLIOMODELNAME");
			bankColumnLabelText = testData.get("BANK");
			bankPermissionTitleText = testData.get("BANKPERMISSIONS");
			portfolioModelApprovalTabTitleText = testData.get("PORTFOLIOMODELAPPROVALTABTITLE");
			revokedByBankIconText = testData.get("REVOKEDBYBANK");
			notSubmittedIconText = testData.get("NOTSUBMITTED");
			submittedToBankIconText = testData.get("SUBMITTEDTOBANK");
			approvedByBankIconText = testData.get("APPROVEDBYBANK");
			cancelledByAssetManagerIconText = testData.get("CANCELLEDBYASSETMANAGER");
			rejectedByBankIconText = testData.get("REJECTEDBYBANK");
			//AllureLogUtil.StartLog(method.getName() + " test method has been started");						
			StartTest(properties.getLogMessage("VerifyPortfolioModelApprovalDetailsTest"),
					properties.getLogMessage("VerifyPortfolioModelApprovalDetail"));
			setTestCategory(properties.getLogMessage("CategoryPortfolioModelApprovalDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			
			flag = objApprovalPage.VerifyPortfolioModelApprovalTabAndDetails(portfolioModelApprovalTabTitleText,
					portfolioModelNameColumnLabelText, bankColumnLabelText, bankPermissionTitleText,
					notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
					cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText);
  			Assert.assertTrue(flag, properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsTestPassed"));
  			EndTest(properties.getLogMessage("VerifyPortfolioModelApprovalDetailsTest"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsPTestFailed"));
			//AllureLogUtil.EndLog(properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsPTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));			
			throw e;
		}
	}
}
