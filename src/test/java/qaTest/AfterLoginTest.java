package qaTest;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class AfterLoginTest extends baseTest{



	ElementFetch ele = new ElementFetch();

	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	@Test

	public void loginintoHomePage() {

		logger.info("Sign in into LoginPage");

		homePage.signinButton();
		logger.info("Verifying  if login text is present or not ");
		loginPage.verifyIfLoginPageIsLoaded();
		logger.info("Entering the credentials");
		loginPage.enterCredentials();
		logger.info("Verifying the after entring correct credential navigate to homepahe");
		loginPage.verifyAfterLogin();



	}
}
