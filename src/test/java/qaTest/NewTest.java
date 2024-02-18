package qaTest;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class NewTest extends baseTest {
	
	// ElementFetch = new ElementFetch();
				ElementFetch ele = new ElementFetch();

				HomePageEvents homePage = new HomePageEvents();
				LoginPageEvents loginPage = new LoginPageEvents();
 
			//Test method to perform login functionality
  @Test
  public void SampleMethodForEntringCredential() {
	  logger.info("Sign in into LoginPage");

		homePage.signinButton();
		logger.info("Verifying  if login text is present or not ");
		loginPage.verifyIfLoginPageIsLoaded();
		logger.info("Entering the credentials");
		loginPage.enterCredentials();
	}
}
