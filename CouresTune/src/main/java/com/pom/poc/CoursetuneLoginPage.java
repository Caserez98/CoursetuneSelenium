package com.pom.poc;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.pom.base.Base;
import com.pom.base.GlobalVariables;

public class CoursetuneLoginPage extends Base{
	public CoursetuneLoginPage(WebDriver driver, Actions action) {
		super(driver,action);
	}
	//Objects
	By txtUserName= By.xpath(GlobalVariables.USERNAME_XPATH);
	By txtUserPassword= By.xpath(GlobalVariables.PASSWORD_XPATH);
	By btnLogin = By.xpath(GlobalVariables.LOGIN_BUTTON_XPATH);
	By frmLogin = By.xpath(GlobalVariables.LOGIN_FORM_XPATH);
	
	//Method to login user;
	public void login(String username, String password){
				waitForElementPresent(frmLogin);
				type(txtUserName,username);
				type(txtUserPassword,password);
				waitForElementPresent(btnLogin);
				click(btnLogin);
	}
}
