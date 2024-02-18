package pageObjects;

public interface LoginPageElements {
	

	// XPath for the loginText element on the Login Page
		String loginText = "//div[@class='ui fluid large blue submit button']";
		
		// XPath for the email address input field on the Login Page
		String emailAddress = "//input[@placeholder='Email']";
		
		// XPath for the password input field on the Login Page
		String passwordField = "//input[@placeholder='Password']";
		
		
		//After login home page title
		String homepagetitle = "//div[@class='header item']";
		
		//Login Button 
		String loginButton = "//div[@class='ui fluid large blue submit button']";

}
