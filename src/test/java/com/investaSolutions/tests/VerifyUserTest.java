package com.investaSolutions.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.pages.BankManagerUserPage;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class VerifyUserTest extends TestBase {

	@Test(priority = 1)
	public void testToVerifyUserTabAndDetailsOnUserListTest(Method method) throws Exception {
		BankManagerUserPage objBankManagerUserPage;
		String userTabTitleText;
		String fractionURLValue;
		String exepctedURL;
		String userManagementTitle_Text;
		String e_Text;
		String d_Text;
		String firstName_Text;
		String lastName_Text;
		String email_Text;
		String e2_Text;
		String l_Text;
		String backButtonText;
		String newUserButtonText;

		boolean flagVerifyUserPageDetails;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME_PORTFOLIOMODELlISTPAGE"), "TC_18");
			userTabTitleText = testData.get("USER_TAB_TITLE");
			fractionURLValue = testData.get("URL_FRACTION_VALUE");
			exepctedURL = testData.get("URL");
			userManagementTitle_Text = testData.get("USERMANAGEMENT_TITLE");
			e_Text = testData.get("E_COLUMNNAME");
			d_Text = testData.get("D_COLUMNNAME");
			firstName_Text = testData.get("FIRSTNAME_COLUMNNAME");
			lastName_Text = testData.get("LASTNAME_COLUMNNAME");
			email_Text = testData.get("EMAIL_COULMNNAME");
			e2_Text = testData.get("E_COLUMNNAME");
			l_Text = testData.get("L_COLUMNNAME");
			backButtonText = testData.get("BACKBUTTON_TEXT");
			newUserButtonText = testData.get("NEWUSERBUTTON_TEXT");

			StartTest(properties.getLogMessage("UserManagementList"),
					properties.getLogMessage("VerifyUserTabAndUserPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryUserPageDetailsOnUserPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));
			objBankManagerUserPage = new BankManagerUserPage(driver);

			flagVerifyUserPageDetails = objBankManagerUserPage.verifyUserListPageDetails(userTabTitleText,
					fractionURLValue, exepctedURL, userManagementTitle_Text, e_Text, d_Text, firstName_Text,
					lastName_Text, email_Text, e2_Text, l_Text, backButtonText, newUserButtonText);
			Assert.assertTrue(flagVerifyUserPageDetails, properties.getLogMessage("VerifyUserOnUserListPageTestFailed"));
			EndTest(properties.getLogMessage("UserManagementList"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyUserOnUserListPageTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}

}
