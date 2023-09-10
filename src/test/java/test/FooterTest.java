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
import pom.FooterPage;
import utility.Reports;

public class FooterTest extends BaseClass{
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
	public void verifyTheWorkingOfFacebook() {
		test = extent.createTest("verifyTheWorkingOfFacebook");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		FooterPage footerPage = new FooterPage(driver);
		footerPage.clickOnFacebook(driver);
		String currentUrl=footerPage.getChildWindowUrl(driver);
		Assert.assertEquals(currentUrl, "https://www.facebook.com/saucelabs");
		
	}
	
	@Test(priority=2)
	public void verifyTheWorkingOfTwitter() {
		test = extent.createTest("verifyTheWorkingOfTwitter");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		FooterPage footerPage = new FooterPage(driver);
		footerPage.clickOnTwitter(driver);
		String currentUrl=footerPage.getChildWindowUrl(driver);
		Assert.assertEquals(currentUrl, "https://twitter.com/saucelabs");
	}
	
	@Test(priority=3)
	public void verifyTheWorkingOfLinkedin() {
		test = extent.createTest("verifyTheWorkingOfLinkedin");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		FooterPage footerPage = new FooterPage(driver);
		footerPage.clickOnLinkedin(driver);
		String currentUrl=footerPage.getChildWindowUrl(driver);
		Assert.assertEquals(currentUrl, "https://www.linkedin.com/company/sauce-labs/");
	}
	
	@Test(priority=4)
	public void verifyThetextOfFooter() {
		test = extent.createTest("verifyThetextOfFooter");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		FooterPage footerPage = new FooterPage(driver);
	    String privacyPolicy=footerPage.getTextOfPrivacyPolicy();
	    Assert.assertEquals(privacyPolicy, "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");	
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
