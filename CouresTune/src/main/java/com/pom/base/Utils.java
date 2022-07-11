package com.pom.base;

import org.openqa.selenium.By;

public class Utils {
	
	public static String createNewXPath(String name) {
			if(name.contains(" ")) {
				name = name.split(" ")[0];
				

			}

			return GlobalVariables.DIVISION_XPATH_START + name + GlobalVariables.DIVISION_XPATH_END;		
		//name = name.contains(" ") ? name.split(" ")[0] : name;
	}
	

	public static By assignXPath(String name) {
		return By.xpath(createNewXPath(name));
		
	}
	
}
