package test;

import org.openqa.selenium.WebDriver;
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
import pom.SwagLabLoginPage;
import utility.Reports;

public class SwagLabLoginTest extends BaseClass{
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
	
	@Test(priority=1)
	public void logInWithValidStandardUser() {
		test = extent.createTest("logInWithValidStandardUser");
		SwagLabLoginPage loginPage = new SwagLabLoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLogin();
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, "https://www.saucedemo.com/inventory.html");
		
	}

	public void logInWithStandardUser() {
		SwagLabLoginPage loginPage = new SwagLabLoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLogin();
		
	}
	@Test(priority=2)
	public void logInWithLockedOutUser() {
	    test = extent.createTest("logInWithLockedOutUser");
		SwagLabLoginPage loginPage = new SwagLabLoginPage(driver);
		loginPage.enterUserName("locked_out_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLogin();
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, "https://www.saucedemo.com/");
			
		}
	@Test(priority=3)
	public void logInWithProblemUser() {
		    test = extent.createTest("logInWithProblemUser");
			SwagLabLoginPage loginPage = new SwagLabLoginPage(driver);
			loginPage.enterUserName("problem_user");
			loginPage.enterPassword("secret_sauce");
			loginPage.clickOnLogin();
			String current = driver.getCurrentUrl();
			Assert.assertEquals(current, "https://www.saucedemo.com/inventory.html");	
		}
	@Test(priority=4)
	public void logInWithPerformanceGlitchUser() {
		    test = extent.createTest("logInWithPerformanceGlitchUser");
			SwagLabLoginPage loginPage = new SwagLabLoginPage(driver);
			loginPage.enterUserName("performance_glitch_user");
			loginPage.enterPassword("secret_sauce");
			loginPage.clickOnLogin();
			String current = driver.getCurrentUrl();
			Assert.assertEquals(current, "https://www.saucedemo.com/inventory.html");	
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
