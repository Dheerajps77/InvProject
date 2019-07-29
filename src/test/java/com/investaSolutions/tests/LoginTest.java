package com.investaSolutions.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.SeleniumUtils;
import com.investaSolutions.utils.UserFunctions;

public class LoginTest extends TestBase{

	@Test(groups = {"regression"}, priority=1)
	public void testUserLoginFunctionality() throws Throwable {
		try {
			String title;
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_1");
			StartTest(properties.getLogMessage("LoginVerification"), properties.getLogMessage("LoginVerificationDetail"));
			setTestCategory(properties.getLogMessage("CategoryLogin"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			// To login to Bank Portal - (properties.getConstant("Bank"), properties.getConstant("Bank_User1"));
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			logInfo(properties.getLogMessage("LoginTestPassed"));
			title = SeleniumUtils.getCurrentPageTitle(driver);
			assertEquals(title, testData.get("DASHBOARDTITLE"));
			logInfo(String.format(properties.getLogMessage("VerifiedDashboardTitle"), title));
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
