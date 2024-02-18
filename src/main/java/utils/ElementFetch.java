package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.baseTest;

public class ElementFetch {


	// Method to fetch a single web element based on the identifier type and value

	public WebElement getwebElement(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "XPATH":
			return baseTest.driver.findElement(By.xpath(identifierValue));

		case "CSS":
			return baseTest.driver.findElement(By.cssSelector(identifierValue));
			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * add more web element identifier here
			 */

		default:
			return null;
		}
	}


	public List<WebElement> getWebElements(String identifierType, String identifierValue) {

		// Method to fetch a list of web elements based on the identifier type and value
		switch (identifierType) {
		case "XPATH":
			return baseTest.driver.findElements(By.xpath(identifierValue));

		case "CSS":
			return baseTest.driver.findElements(By.cssSelector(identifierValue));

			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * add more web element identifier here
			 */

		default:
			return null;
		}
	}
}


