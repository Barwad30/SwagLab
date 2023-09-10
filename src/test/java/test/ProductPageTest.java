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
import pom.ProductPage;
import pom.SwagLabLoginPage;
import utility.Reports;

public class ProductPageTest extends BaseClass{
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
	
	@Test (priority=1)
	public void verifyTheProductImage() {
		test = extent.createTest("verifyTheProductImage");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
	    String current = driver.getCurrentUrl();
		productPage.clickOnProductImage(1);	
		String after= driver.getCurrentUrl();
		Assert.assertNotEquals(current, after);
	}
	
	@Test (priority=2)
	public void verifyTheProductNameLink() {
		test = extent.createTest("verifyTheProductNameLink");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		String current = driver.getCurrentUrl();
		ProductPage productPage = new ProductPage(driver);
		productPage.getProductsName();
		String New = driver.getCurrentUrl();
		Assert.assertNotEquals(current, New);
	}
	
	@Test (priority=3)
	public void verifyTheProductsList() {
		test = extent.createTest("verifyTheProductsList");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
	    productPage.getSelectProductName(driver);
	    productPage.selectProductList(0);
	    String currenturl = driver.getCurrentUrl();
	    Assert.assertEquals(currenturl, "https://www.saucedemo.com/inventory.html");
	}
	
	@Test (priority=4)
	public void verifyTheMouseOverTheProductName() {
		test = extent.createTest("verifyTheMouseOverTheProductName");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		productPage.getSelectProductName(driver);
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.saucedemo.com/inventory.html");
	}
	
	@Test (priority=5)
	public void verifyTheClickOnAddToCart() {
		test = extent.createTest("verifyTheClickOnAddToCart");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		String currenturl = driver.getCurrentUrl();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCart(1);
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=6)
	public void verifyTheClickOnFilterAtoZ() {
		test = extent.createTest("verifyTheClickOnFilterAtoZ");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		String currenturl = driver.getCurrentUrl();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();	
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=7)
	public void verifyTheClickOnFilterZtoA() {
		test = extent.createTest("verifyTheClickOnFilterZtoA");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		String currenturl = driver.getCurrentUrl();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();
		productPage.selectFiltersZtoA();
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=8)
	public void verifyTheClickOnFilterLowToHigh() {
		test = extent.createTest("verifyTheClickOnFilterLowToHigh");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		String currenturl = driver.getCurrentUrl();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();
		productPage.selectFiltersLowToHigh();
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=9)
	public void verifyTheClickOnFilterHighToLow() {
		test = extent.createTest("verifyTheClickOnFilterHighToLow");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		String currenturl = driver.getCurrentUrl();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnFilter();
		productPage.selectFiltersHightoLow();
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
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
