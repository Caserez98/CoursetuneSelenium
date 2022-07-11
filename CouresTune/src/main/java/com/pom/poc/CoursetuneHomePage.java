package com.pom.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.pom.base.Base;
import com.pom.base.GlobalVariables;
import com.pom.base.Utils;

public class CoursetuneHomePage extends Base {

	public String trainingName, groupName, divisionName;

	public CoursetuneHomePage(WebDriver driver, Actions action, String trainingName, String groupName,
			String divisionName) {
		super(driver, action);
		this.trainingName = trainingName;
		this.groupName = groupName;
		this.divisionName = divisionName;
	}
	

	By btnAddNewTraining = By.xpath(GlobalVariables.ADD_TRAINING_BUTTON_XPATH);
	By frmHomePage = By.xpath(GlobalVariables.HOME_PAGE_VIEW_XPATH);
	By btnEditView = By.xpath(GlobalVariables.EDIT_BUTTON_XPATH);
	By btnAddNewDivision = By.xpath(GlobalVariables.ADD_NEW_DIVISION_BUTTON_XPATH);
	By frmNewDivision = By.xpath(GlobalVariables.ADD_DIVISION_FORM_XPATH);
	By txtDivisionName = By.xpath(GlobalVariables.DIVISION_NAME_XPATH);
	By btnFirstIcon = By.xpath(GlobalVariables.FIRST_ICON_XPATH);
	By btnSecondIcon = By.xpath(GlobalVariables.SECOND_ICON_XPATH);
	By btnThirdIcon = By.xpath(GlobalVariables.THIRD_ICON_XPATH);
	By btnAdd = By.xpath(GlobalVariables.BUTTON_ADD_XPATH);
	By btnDivisionCreated;
	By btnSave = By.xpath(GlobalVariables.SAVE_BUTTON_XPATH);
	By btnGroupCreated;
	By txtTrainingName = By.xpath(GlobalVariables.TRAINING_NAME_INPUT_XPATH);
	By btnTraining;
	By btnDisplay = By.xpath(GlobalVariables.DISPLAY_BUTTON_XPATH);
	By btnAddBundle = By.xpath(GlobalVariables.ADD_BUNDLE_BUTTON_XPATH);
	By txtAreaBundle = By.xpath(GlobalVariables.BUNDLE_TEXT_AREA_XPATH);

	By btnModule;
	By btnClose = By.xpath(GlobalVariables.BUTTON_CLOSE_XPATH);
	By btnAddMultiple = By.xpath(GlobalVariables.BUTTON_ADD_MULTIPLE_BUTTON_XPATH);

	By btnAddNewGroup = By.xpath(GlobalVariables.GROUP_BUTTON_XPATH);
	By txtGroupName = By.xpath(GlobalVariables.PROGRAM_NAME_INPUT_XPATH);

	By btnUserAccount = By.xpath(GlobalVariables.USER_ACCOUNT_XPATH);
	By btnLoggout = By.xpath(GlobalVariables.SIGN_OUT_BUTTON_XPATH);

	public void enableEditButton() {
		waitForElementPresent(frmHomePage);
		click(btnDisplay);
		click(btnEditView);
		waitForElementPresent(btnAddNewDivision);
	}

	public void createNewDivision() {
		click(btnAddNewDivision);

		waitForElementPresent(frmNewDivision);
		type(txtDivisionName, divisionName);

		click(btnFirstIcon);

		click(btnSecondIcon);

		click(btnThirdIcon);

		click(btnAdd);
		btnDivisionCreated=Utils.assignXPath(divisionName);
		scrollIntoView(btnDivisionCreated);
		waitForElementPresent(btnDivisionCreated);

	}

	public void clickNewDivision() {
		click(btnDivisionCreated);
		click(btnDivisionCreated);

	}

	public void addNewGroup() {
		waitForElementPresent(btnAddNewGroup);
		mouseHover(btnAddNewGroup);
		click(btnAddNewGroup);

		waitForElementPresent(txtGroupName);
		type(txtGroupName, groupName);

		click(btnSave);
		btnGroupCreated=Utils.assignXPath(groupName);
	}

	public void enterInGroup() {
		mouseHover(btnGroupCreated);
		doubleClick(btnGroupCreated);

	}

	public void addTraining() {
		waitForElementPresent(btnAddNewTraining);
		mouseHover(btnAddNewTraining);
		click(btnAddNewTraining);
		waitForElementPresent(txtTrainingName);
		waitForElementPresent(btnAdd);
		type(txtTrainingName, trainingName);
		mouseHover(btnAdd);
		click(btnAdd);
		waitForElementPresent(btnSave);
		mouseHover(btnSave);

		click(btnSave);
		btnTraining = Utils.assignXPath(trainingName);
	}

	public void enterTraining() {
		waitForElementPresent(btnTraining);
		mouseHover(btnTraining);
		click(btnTraining);

	}

	public void addBundles(String bundle1, String bundle2, String bundle3, String bundle4) {

		waitForElementPresent(btnAddBundle);
		mouseHover(btnAddBundle);
		click(btnAddBundle);
		waitForElementPresent(btnAddMultiple);
		mouseHover(btnAddMultiple);
		click(btnAddMultiple);
		waitForElementPresent(txtAreaBundle);
		type(txtAreaBundle, bundle1 + "\n" + bundle2 + "\n" + bundle3 + "\n" + bundle4);
		mouseHover(btnAdd);
		click(btnAdd);

	}

	public void addObjectivesModule(String bundle, String goal1, String goal2, String goal3) {

		btnModule = Utils.assignXPath(bundle);
		waitForElementPresent(btnModule);
		click(btnModule);
		click(btnModule);
		waitForElementToBeClickeable(btnAddMultiple);
		click(btnAddMultiple);
		waitForElementPresent(txtAreaBundle);
		type(txtAreaBundle, goal1 + "\n" + goal2 + "\n" + goal3);
		waitForElementToBeClickeable(btnAdd);
		click(btnAdd);
		mouseHover(btnTraining);
		click(btnTraining);

	}

	public void loggout() {
		click(btnUserAccount);
		waitForElementPresent(btnLoggout);
		click(btnLoggout);
	}

}
