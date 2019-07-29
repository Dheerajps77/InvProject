package com.investaSolutions.tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.AssetManagerStrategyManagementPage;
import com.investaSolutions.pages.AssetManagerUserManagementPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMAssetManagerTest extends TestBase{

	@Test(groups = {"regression"}, priority=2)
	// TC_4 This test verifies the details present on the User Management page
	public void verifyUserManagementDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_4");
			String userManagementLabelText = testData.get("LABEL");
			String searchHeaderText = testData.get("SEARCH");
			String deleteHeaderText = testData.get("DELETE");
			String firstNameHeaderText = testData.get("FIRSTNAME");
			String lastNameHeaderText = testData.get("LASTNAME");
			String emailHeaderText = testData.get("EMAIL");
			String enabledHeaderText = testData.get("ENABLED");
			String lockedHeaderText = testData.get("LOCKED");
			String newUserButtonText = testData.get("NEWUSERBUTTON");
			String backButtonText = testData.get("BACKBUTTON");
			StartTest(properties.getLogMessage("VerifyUserManagementDetailsTest"), properties.getLogMessage("VerifyUserManagementDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyUserManagementDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));			
			AssetManagerUserManagementPage userManagementPage = new AssetManagerUserManagementPage(driver);
			Assert.assertTrue(userManagementPage.verifyUserManagementPageDetails(userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText, lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText, newUserButtonText, backButtonText), String.format(properties.getLogMessage("UserManagementDetailsVerificationFailed"), userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText, lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText, newUserButtonText, backButtonText));
			logInfo(String.format(properties.getLogMessage("UserManagementDetailsVerificationPassed"), userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText, lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText, newUserButtonText, backButtonText));
		
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

	@Test(priority=2)
	// TC_2 This test creates a new User through Asset Manager -> User Management Section
	public void createNewUserTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_2");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			StartTest(properties.getLogMessage("CreateNewUserTest"), properties.getLogMessage("CreateNewUserDetail"));
			setTestCategory(properties.getLogMessage("CategoryCreateNewUser"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AssetManagerUserManagementPage userManagementPage = new AssetManagerUserManagementPage(driver);
			Assert.assertTrue(userManagementPage.verifyUserCreation(firstName, lastName, email, password), String.format(properties.getLogMessage("UserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("UserCreationPassed"), firstName));
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
