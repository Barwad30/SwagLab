package test;

import java.time.Duration;

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
import pom.AddToCartPage;
import pom.CheckoutOverviewPage;
import pom.CheckoutPage;
import utility.Reports;

public class EndToEndTest extends BaseClass{
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
	public void verifyTheCoustomerAbleToPlaceOrderSuccessuflly() {
		test = extent.createTest("verifyTheCoustomerAbleToPlaceOrderSuccessuflly");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		cartPage.clickOnCart();
		cartPage.clickOnCheckoutButton(driver);
		CheckoutPage checkoutPage= new CheckoutPage(driver);
		checkoutPage.enterFirstName("Rohit");
		checkoutPage.enterLastName("Sharma");
		checkoutPage.enterPostalCode("442001");
		checkoutPage.clickOnContinueButton();
		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
		overviewPage.clickOnFinishButton();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-complete.html"));
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
