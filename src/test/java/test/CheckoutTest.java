package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.AddToCartPage;
import pom.CheckoutPage;
import utility.Reports;

public class CheckoutTest extends BaseClass{
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
		@Test (priority = 1)
		public void verifyWorkingOfCheckoutButton() {
			test = extent.createTest("verifyWorkingOfCheckoutButton");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			String currenturl = driver.getCurrentUrl();
			Assert.assertEquals(currenturl, "https://www.saucedemo.com/checkout-step-one.html");
		}
		
		@Test (priority = 2)
		public void verifyAlphaCharactersInFirstNameField() {
			test = extent.createTest("verifyAlphaCharactersInFirstNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.clickOnContinueButton();
			Assert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Last Name is required");
		}
		
		@Test(priority =3)
		public void verifyNumbersInFirstNameField() {
			test = extent.createTest("verifyNumbersInFirstNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("12345");
			checkoutPage.clickOnContinueButton();
			Assert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Last Name is required");
		}
		
		@Test (priority =4)
		public void verifySpecialCharactersInFirstNameField() {
			test = extent.createTest("verifySpecialCharactersInFirstNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("%#@#");
			checkoutPage.clickOnContinueButton();
			Assert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Last Name is required");
		}
		
		@Test (priority = 5)
		public void verifyAlphaCharactersAndNumbersInFirstNameField() {
			test = extent.createTest("verifyAlphaCharactersAndNumbersInFirstNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit123");
			checkoutPage.clickOnContinueButton();
			Assert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Last Name is required");
		}
		
		@Test (priority = 6)
		public void verifyAlphaCharactersInLastNameField() {
			test = extent.createTest("verifyAlphaCharactersInLastNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("Sharma");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Postal Code is required");
			softAssert.assertAll();
		}
		
		@Test (priority =7)
		public void verifyNumbersInLastNameField() {
			test = extent.createTest("verifyNumbersInLastNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("12345");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Postal Code is required");
			softAssert.assertAll();
		}
		
		@Test (priority = 8)
		public void verifySpecialCharactersInLastNameField() {
			test = extent.createTest("verifySpecialCharactersInLastNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("%#@#");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Postal Code is required");
			softAssert.assertAll();
		}
		

		@Test(priority = 9)
		public void verifyAlphaCharactersAndNumbersInLastNameField() {
			test = extent.createTest("verifyAlphaCharactersAndNumbersInLastNameField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("Sharma123");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Postal Code is required");
			softAssert.assertAll();
		}
		
		@Test(priority = 10)
		public void verifyValidPostalCodeInPostalCodeField() {
			test = extent.createTest("verifyValidPostalCodeInPostalCodeField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("344569");
			checkoutPage.enterPostalCode("442001");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Last Name is required only characters");
			softAssert.assertAll();
			
		}
		
		@Test(priority = 11)
		public void verifyFourDigitNumberInPostalCodeField() {
			test = extent.createTest("verifyFourDigitNumberInPostalCodeField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("Sharma");
			checkoutPage.enterPostalCode("4420");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Zip Code is Invalid");
			softAssert.assertAll();
		}
		
		@Test(priority = 12)
		public void verifyAlphaCharactersInPostalCodeField() {
			test = extent.createTest("verifyAlphaCharactersInPostalCodeField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("Sharma");
			checkoutPage.enterPostalCode("Rohit");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Zip Code is Invalid");
			softAssert.assertAll();
			
		}
		
		@Test(priority = 13)
		public void verifySpecialCharactersInPostalCodeField() {
			test = extent.createTest("verifySpecialCharactersInPostalCodeField");
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("Sharma");
			checkoutPage.enterPostalCode("%#@#");
			checkoutPage.clickOnContinueButton();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(checkoutPage.getDisplyedErrorMessage(), "Error: Zip Code is Invalid");
			softAssert.assertAll();
		}

		
		@Test(priority = 14)
		public void verifyTheWrokingOfContinueButtonWithAllValidInformation() {
			AddToCartTest cartTest = new AddToCartTest();
			cartTest.verifyClickOnCheckoutButton();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			String currentUrl=driver.getCurrentUrl();
			checkoutPage.enterFirstName("Rohit");
			checkoutPage.enterLastName("Sharma");
			checkoutPage.enterPostalCode("442001");
			checkoutPage.clickOnContinueButton();
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
