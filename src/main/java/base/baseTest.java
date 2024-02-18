package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class baseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;


	// This method is executed before the test suite starts

	@BeforeTest
	@Parameters({"browser", "testClass"})
	public void beforeTestMethod(String browser, String testClass) {
	    // Get the current date and time
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	    LocalDateTime now = LocalDateTime.now();
	    String timeStamp = dtf.format(now);

	    // Extracting the test class name
	    String[] classNameParts = testClass.split("\\.");
	    String className = classNameParts[classNameParts.length - 1];

	    // Initializing ExtentReports
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
	            + File.separator + className + "_" + browser + "_" + timeStamp + ".html");

	    // Creating an instance of ExtentReports
	    extent = new ExtentReports();

	    // Attaching the ExtentSparkReporter to the ExtentReports instance
	    extent.attachReporter(sparkReporter);

	    // Configuring ExtentReports
	    sparkReporter.config().setTheme(Theme.DARK);
	    extent.setSystemInfo("HostName", "RHEL8");
	    extent.setSystemInfo("UserName", "root");
	    sparkReporter.config().setDocumentTitle("Automation Report");
	    sparkReporter.config().setReportName("Automation Test Result by Vishavam");
	}


	// This method is executed before each test method
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser, Method testMethod) {
		{
			// Creating a new test in the Extent report
			logger = extent.createTest(testMethod.getName());

			// Setting up the WebDriver based on the browser parameter
			setupDriver(browser);
			driver.manage().window().maximize();
			driver.get(Constants.url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}
	}

	// This method is executed after each test method
	@AfterMethod
	public void afterMethod(ITestResult result) {

		// Checking if the test method failed and logging the result accordingly
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + "- Test Case Failed", ExtentColor.RED));}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "- Test Case Skipped", ExtentColor.ORANGE));}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "- Test Case PASS", ExtentColor.GREEN));}
		driver.quit();


	}

	// This method is executed after the test suite finishes
	@AfterTest

	public void afterTest() {
		// Flushing the ExtentReports to write the results to the report file
		extent.flush();

	}


	// Method to set up the WebDriver based on the specified browser
	public void setupDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

	}

}
