package com.coursetune.tests;

import org.testng.annotations.Test;

import com.pom.base.Base;
import com.pom.base.GlobalVariables;
import com.pom.poc.CoursetuneHomePage;
import com.pom.poc.CoursetuneLoginPage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class CourseTuneTest {
	WebDriver driver;
	Base base;
	Actions action;
	CoursetuneLoginPage coursetuneLoginPage;
	CoursetuneHomePage coursetuneHomePage;
	String username, password, exptedtedURL, divisionName, groupName, trainingName;
	String goalsList[][] = new String[4][3];
	String bundleList[] = new String[4];

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		base = new Base(driver, action);
		driver = base.setupChromeDriver();
		action = base.setupActions();
		coursetuneLoginPage = new CoursetuneLoginPage(driver, action);
		this.username = base.getJSONValue("Data", "username");
		this.password = base.getJSONValue("Data", "password");
		this.exptedtedURL = base.getJSONValue("Data", "expectedURL");
		this.divisionName = base.getJSONValue("Data", "division");
		this.groupName = base.getJSONValue("Data", "program");
		this.trainingName = base.getJSONValue("Data", "training");
		coursetuneHomePage = new CoursetuneHomePage(driver, action, trainingName, groupName, divisionName);

		for (int i = 0; i < 4; i++) {
			this.bundleList[i] = base.getJSONValue("Data", "module " + (i + 1));
			for (int j = 0; j < 3; j++) {
				this.goalsList[i][j] = base.getJSONValue("Data", "module " + (i + 1) + " goal " + (j + 1));
			}
		}

	}

	@Test
	public void TestLogin() {
		base.launchBrowser(GlobalVariables.LOGIN_URL);
		coursetuneLoginPage.login(username, password);

	}

	@Test(dependsOnMethods = { "TestLogin" })
	public void TestAddDivision() {
		coursetuneHomePage.enableEditButton();
		coursetuneHomePage.createNewDivision();
		coursetuneHomePage.clickNewDivision();
	}

	@Test(dependsOnMethods = { "TestAddDivision" })
	public void TestAddGroup() {
		coursetuneHomePage.addNewGroup();
		coursetuneHomePage.enterInGroup();
	}

	@Test(dependsOnMethods = { "TestAddGroup" })
	public void TestAddTraining() {
		coursetuneHomePage.addTraining();
		coursetuneHomePage.enterTraining();
	}

	@Test(dependsOnMethods = { "TestAddTraining" })
	public void TestAddBundles() {
		coursetuneHomePage.addBundles(bundleList[0], bundleList[1], bundleList[2], bundleList[3]);
	}

	@Test(dependsOnMethods = { "TestAddBundles" })
	public void TestAddGoals() {

		for (int i = 0; i < 4; i++) {
			coursetuneHomePage.addObjectivesModule(bundleList[i], goalsList[i][0], goalsList[i][1], goalsList[i][2]);

		}

	}

	@Test(dependsOnMethods = { "TestAddGoals" })
	public void TestLoggout() {
		coursetuneHomePage.loggout();
	}

	@AfterTest
	public void afterTest() {
		 driver.close();
	}

}
