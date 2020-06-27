package Common_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {
	
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void start_report() {
		htmlreporter = new ExtentHtmlReporter("G:\\JAVA videos\\iASYS_report\\demo1.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
	}
	
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public WebDriver launchBrowser(String browser,String url) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\JAVA videos\\batch\\soft\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.PASS, "TC Pass"+ result.getName());
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, "TC Pass"+ result.getThrowable());
		}
		
	}
	
	@AfterMethod
	public void close_browser() {
		driver.close();
		
	}
	
	@AfterSuite
	public void close_report() {
		extent.flush();
	}

}
