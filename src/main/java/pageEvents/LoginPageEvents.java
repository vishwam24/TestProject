package pageEvents;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.baseTest;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents extends baseTest{

	ElementFetch ele = new ElementFetch();
		//ElementFetch<WebElement> ele = new ElementFetch<>();


			public void verifyIfLoginPageIsLoaded() {
				
				// Method to verify if the Login Page is loaded by checking if the loginText element is present
				
				Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.loginText).size() >0, "Element Not Found");
				
			}
			
		public void enterCredentials() {
				
			    // Method to enter credentials in the email and password fields on the Login Page
				ele.getwebElement("XPATH", LoginPageElements.emailAddress).sendKeys("vishvam.acharya@gmail.com");
				ele.getwebElement("XPATH", LoginPageElements.passwordField).sendKeys("Test@123");
				
			}
		
		public void verifyAfterLogin () {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			ele.getwebElement("XPATH", LoginPageElements.loginButton).click();
			
			Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.homepagetitle).size() >0, "Home Page Title is not visible");
			
			//Assert.assertTrue(ele.getwebElement("XPATH", LoginPageElements.homepagetitle).size () >0, "Home Page Title is not visible");
		}
}
