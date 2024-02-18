package pageEvents;

import org.openqa.selenium.WebElement;

import base.baseTest;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
	
	//ElementFetch ele = new ElementFetch();
			ElementFetch ele = new ElementFetch();

			// Method to click on the Sign In button on the Home Page
			
			public void signinButton()
			{
				
				
				ele.getwebElement("XPATH", HomePageElements.signinButtonText).click();
			}


	}


