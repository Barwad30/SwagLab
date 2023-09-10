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
import pom.AddToCartPage;
import pom.CheckoutOverviewPage;
import utility.Reports;

public class OverviewTest extends BaseClass{
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
	
	@Test(priority = 1)
	public void verifyTheCheckoutOverivewPageWithFinishButton() {
		test = extent.createTest("verifyTheCheckoutOverivewPageWithFinishButton");
		CheckoutTest checkoutTest = new CheckoutTest();
		checkoutTest.verifyTheWrokingOfContinueButtonWithAllValidInformation();
		String currenturl = driver.getCurrentUrl();
		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
		overviewPage.clickOnFinishButton();
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	    
	}
	
	@Test (priority=2)
	public void verifyTheCheckoutOverviewPageWithBackHomeButton() {
		test = extent.createTest("verifyTheCheckoutOverviewPageWithBackHomeButton");
		CheckoutTest checkoutTest = new CheckoutTest();
		checkoutTest.verifyTheWrokingOfContinueButtonWithAllValidInformation();
		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
		overviewPage.clickOnFinishButton();
		String current= driver.getCurrentUrl();
		overviewPage.clickOnBackHomeButton();
		String New =driver.getCurrentUrl();
		Assert.assertNotEquals(current, New);
	}
	
	@Test(priority=3)
	public void verifyTheProductPrice() {
		test = extent.createTest("verifyTheProductPrice");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		double price= cartPage.checkPriceOfProductsPage(0, driver);
		Assert.assertEquals(cartPage.checkPriceOfProductsPage(0, driver), 29.99);
	
	}
	
	@Test (priority=4)
	public void verifyIteamTotalWithAdditionOfProductPrice() {
		test = extent.createTest("verifyIteamTotalWithAdditionOfProductPrice");
		CheckoutTest checkoutTest = new CheckoutTest();
		checkoutTest.verifyTheWrokingOfContinueButtonWithAllValidInformation();
		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
		Double itemTotal= overviewPage.additionOfPrice(0, driver);
		Assert.assertEquals(overviewPage.getIteamTotal(), itemTotal);
	}
	
	@Test(priority=5)
	public void verifySumofIteamTotalAndTaxWithTotalPrice() {
		test = extent.createTest("verifySumofIteamTotalAndTaxWithTotalPrice");
		CheckoutTest checkoutTest = new CheckoutTest();
		checkoutTest.verifyTheWrokingOfContinueButtonWithAllValidInformation();
		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
		double sum= overviewPage.getIteamTotal()+ overviewPage.getTaxPrice(driver);
		Assert.assertEquals(overviewPage.getTotalPrice(driver), sum);
	
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
