package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.AboutPage;
import utility.Reports;

public class AboutTest extends BaseClass{
	ExtentReports extent;
    ExtentTest test;
    
	@BeforeTest
	public void configureReports() {
		extent=Reports.createReports();
	}
	
	@BeforeMethod
	public void openBrowser() {
		driver = LaunchBrowser.chrome();
	}
	
	@Test
	public void verifyTheWorkingOfAboutPage() {
		test = extent.createTest("verifyTheWorkingOfAboutPage");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AboutPage aboutPage = new AboutPage(driver);
		String currentUrl = driver.getCurrentUrl();
		aboutPage.clickOnMenu(driver);
		aboutPage.clickOnAbout();
		String newUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl, newUrl);
	}
	
	@AfterMethod
    public void  captureResult(ITestResult result) {
  	
  	if(result.getStatus() == ITestResult.SUCCESS) {
  		test.log(Status.PASS, result.getName());
  	}
  	else if (result.getStatus() == ITestResult.FAILURE) {
  		test.log(Status.FAIL, result.getName());
  	}
  	else
  	{
  		test.log(Status.SKIP, result.getName());
  	}
  	    driver.close();
    }
  
    @AfterTest
    public void publish() {
  	    extent.flush();
  }

}
