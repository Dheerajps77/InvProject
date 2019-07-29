package com.investaSolutions.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AssetManagerUserManagementPage {
	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();
	
	public AssetManagerUserManagementPage (WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By ASSET_MANAGER_TAB = By.xpath("//span[contains(text(),'Asset Manager')]");
	private final By PROFILE_LINK = By.xpath("//span[contains(text(),'Profile')]");
	private final By USER_MANAGEMENT_LINK = By.xpath("//span[contains(text(),'User Management')]");
	private final By USER_MANAGEMENT_LABEL = By.xpath("//legend[contains(text(),'User Management')]");
	private final By USER_MANAGEMENT_SEARCH_HEADER = By.xpath("(//th[text()='E'])[1]");
	private final By USER_MANAGEMENT_DELETE_HEADER = By.xpath("//th[text()='D']");
	private final By USER_MANAGEMENT_FIRSTNAME_HEADER = By.xpath("//th[contains(text(),'Firstname')]");
	private final By USER_MANAGEMENT_LASTNAME_HEADER = By.xpath("//th[contains(text(),'Lastname')]");
	private final By USER_MANAGEMENT_EMAIL_HEADER = By.xpath("//th[contains(text(),'Email')]");
	private final By USER_MANAGEMENT_ENABLED_HEADER = By.xpath("(//th[text()='E'])[2]");
	private final By USER_MANAGEMENT_LOCKED_HEADER = By.xpath("//th[text()='L']");
	private final By USER_MANAGEMENT_NEWUSER_BUTTON = By.xpath("//span[contains(text(),'New User')]");
	private final By USER_MANAGEMENT_BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	private final By USER_MANAGEMENT_FIRST_PAGINATION = By.xpath("//a[@class='ui-paginator-first ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_PREVIOUS_PAGINATION = By.xpath("//a[@class='ui-paginator-prev ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_NEXT_PAGINATION = By.xpath("//a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_LAST_PAGINATION = By.xpath("//a[@class='ui-paginator-last ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_CURRENTPAGE_PAGINATION = By.xpath("//span[@class='ui-paginator-pages']");
	private final By NEW_USER_BUTTON = By.xpath("//span[contains(text(),'New User')]");
	private final By FIRSTNAME_TEXTBOX = By.xpath("//div[@class='ui-g-12']//div[1]//div[2]//span[1]//span[1]//input[1]");
	private final By LASTNAME_TEXTBOX = By.xpath("//div[@class='ui-g-12']//div[1]//div[4]//span[1]//span[1]//input[1]");
	private final By EMAIL_TEXTBOX = By.xpath("//div[@class='layout-main']//div[2]//div[2]//span[1]//span[1]");
	private final By PASSWORD_TEXTBOX = By.xpath("//div[@class='ui-g-12 ui-md-6 ui-lg-3 ng-star-inserted']//span[@class='md-inputfield']//span[@class='md-inputfield']");
	private final By EXPIRATION_DATE_TEXTBOX = By.xpath("//input[@class='ng-tns-c13-86 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']");
	private final By CREATE_NEW_USER_BUTTON = By.xpath("//span[contains(text(),'Create new user')]");
	
	private final By LIST_OF_USER_ROWS = By.xpath("//tbody[@class='ui-table-tbody']//tr");
	private final By LIST_OF_USER_COLUMNS = By.xpath("//thead[@class='ui-table-thead']//tr[@class='ng-star-inserted']/th");
	
	public WebElement assetManagerTabElement() {
		return SeleniumUtils.waitForElementVisibility(driver, ASSET_MANAGER_TAB, WAIT_SECONDS);
	}
	
	public void clickAssetManagerTab() {
		assetManagerTabElement().click();
	}

	public void clickProfileLink() {
		SeleniumUtils.waitForElementPresence(driver, PROFILE_LINK, WAIT_SECONDS).click();
	}

	public WebElement userManagementLinkElement() {
		return SeleniumUtils.waitForElementVisibility(driver, USER_MANAGEMENT_LINK, WAIT_SECONDS);
	}
	
	public void clickUserManagementLink() {
		userManagementLinkElement().click();
	}

	public void clickNewUserButton() {
		SeleniumUtils.waitForElementPresence(driver, NEW_USER_BUTTON, WAIT_SECONDS).click();
	}

	public void enterFirstName(String firstName) {
		SeleniumUtils.clickAndEnterText(driver, FIRSTNAME_TEXTBOX, WAIT_SECONDS, firstName);				
	}

	public void enterLastName(String lastName) {
		SeleniumUtils.clickAndEnterText(driver, LASTNAME_TEXTBOX, WAIT_SECONDS, lastName);				
	}

	public void enterEmail(String email) {
		SeleniumUtils.clickAndEnterText(driver, EMAIL_TEXTBOX, WAIT_SECONDS, email);				
	}

	public void enterPassword(String password) {
		SeleniumUtils.clickAndEnterText(driver, PASSWORD_TEXTBOX, WAIT_SECONDS, password);				
	}

	public void clickCreateNewUserButton() {
		SeleniumUtils.waitForElementClickable(driver, CREATE_NEW_USER_BUTTON, WAIT_SECONDS).click();
	}

	public String userManagementLabelElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LABEL, WAIT_SECONDS).getText();
	}
	
	public String userManagementSearchHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_SEARCH_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementDeleteHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_DELETE_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementFirstNameHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_FIRSTNAME_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementLastNameHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LASTNAME_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementEmailHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_EMAIL_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementEnabledHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_ENABLED_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementLockedHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LOCKED_HEADER, WAIT_SECONDS).getText();
	}
	
	public String userManagementNewUserButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_NEWUSER_BUTTON, WAIT_SECONDS).getText();
	}	
	
	public String userManagementBackButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_BACK_BUTTON, WAIT_SECONDS).getText();
	}
	
	public WebElement userManagementFirstPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_FIRST_PAGINATION, WAIT_SECONDS);
	}
	
	public WebElement userManagementPreviousPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_PREVIOUS_PAGINATION, WAIT_SECONDS);
	}
	
	public WebElement userManagementNextPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_NEXT_PAGINATION, WAIT_SECONDS);
	}
	
	public WebElement userManagementLastPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LAST_PAGINATION, WAIT_SECONDS);
	}
	
	public WebElement userManagementCurrentPagePaginationElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_CURRENTPAGE_PAGINATION, WAIT_SECONDS);
	}
		
	
	public void createNewUser(String firstName, String lastName, String email, String password) throws Exception{
		try {
			clickAssetManagerTab();
			clickUserManagementLink();
			clickNewUserButton();
			TestBase.logInfo(String.format(properties.getLogMessage("NewUserData"), firstName, lastName, email, password));
			enterFirstName(firstName);
			enterLastName(lastName);
			enterEmail(email);
			enterPassword(password);
			SeleniumUtils.actionScrollToBottom(driver);
			SeleniumUtils.clickElement(driver, CREATE_NEW_USER_BUTTON);			
		} catch (Exception e) {
			throw e;
		}		
	}
	
	public ArrayList<String> getUsersList(){
		ArrayList<String> listOfUsers = new ArrayList<String>();
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		for(int i=1;i<=countOfUserRows;i++){
			String finalText = "";
			for(int j=3;j<=countOfUserColumns-2;j++){
				String columnText = driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]")).getText();
				if(j==3){
					finalText = columnText;
				}
				else{
					finalText = finalText + " || " + columnText;
				}
			}
			listOfUsers.add(finalText);
		}
		return listOfUsers;
	}
	
	public boolean verifyUserCreation(String firstName, String lastName, String email, String password) throws Exception{
		try {
			createNewUser(firstName, lastName, email, password);
			String expectedUserDetails;
			ArrayList<String> listOfUSerDetails = getUsersList();
			expectedUserDetails = firstName + " || " + lastName + " || " + email;
			if(listOfUSerDetails.contains(expectedUserDetails)){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean verifyUserManagementPageDetails(String userManagementLabelText, String searchHeaderText, String deleteHeaderText, String firstNameHeaderText, String lastNameHeaderText, String emailHeaderText, String enabledHeaderText, String lockedHeaderText, String newUserButtonText, String backButtonText) throws Exception{
		boolean flag = false;
		if(assetManagerTabElement().isDisplayed()){
			SeleniumUtils.Click(assetManagerTabElement(), properties.getLogMessage("AssetManagerTabClicked"));
			SeleniumUtils.Click(userManagementLinkElement(), properties.getLogMessage("UserManagementTabClicked"));
			if(userManagementLabelElementText().equals(userManagementLabelText) && userManagementSearchHeaderElementText().equals(searchHeaderText) && userManagementDeleteHeaderElementText().equals(deleteHeaderText) && userManagementFirstNameHeaderElementText().equals(firstNameHeaderText) && userManagementLastNameHeaderElementText().equals(lastNameHeaderText) && userManagementEmailHeaderElementText().equals(emailHeaderText) && userManagementEnabledHeaderElementText().equals(enabledHeaderText) && userManagementLockedHeaderElementText().equals(lockedHeaderText) && userManagementNewUserButtonElementText().equals(newUserButtonText) && userManagementBackButtonElementText().equals(backButtonText)){
				try {
					if(userManagementFirstPaginationElement().isDisplayed() && userManagementLastPaginationElement().isDisplayed() && userManagementPreviousPaginationElement().isDisplayed() && userManagementNextPaginationElement().isDisplayed() && userManagementCurrentPagePaginationElementText().isDisplayed()){				
					flag = true;
					TestBase.logInfo(String.format(properties.getLogMessage("UserManagementDetailsVerified"), userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText, lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText, newUserButtonText, backButtonText, userManagementLabelElementText(), userManagementSearchHeaderElementText(), userManagementDeleteHeaderElementText(), userManagementFirstNameHeaderElementText(), userManagementLastNameHeaderElementText(), userManagementEmailHeaderElementText(), userManagementEnabledHeaderElementText(), userManagementLockedHeaderElementText(), userManagementNewUserButtonElementText(), userManagementBackButtonElementText()));
					return flag;	
					}
				} catch (Exception e) {
					TestBase.logError(properties.getLogMessage("UserManagementPaginationError"));
					throw e;
				}
			}		
		}
		else{
			TestBase.logError(properties.getLogMessage("AssetManagerTabNotFound"));
		}
		return flag;
	}
}
