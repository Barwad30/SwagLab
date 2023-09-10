package test;

import java.time.Duration;

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
import pom.ProductPage;
import pom.SwagLabLoginPage;
import utility.Reports;

public class AddToCartTest extends BaseClass{
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
	public void verifyTheClickOnAddToCart() {
		test = extent.createTest("verifyTheClickOnAddToCart");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		String currenturl = driver.getCurrentUrl();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		String newurl= driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=2)
	public void verifyTheClickOncart() {
		test = extent.createTest("verifyTheClickOncart");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		String currenturl = driver.getCurrentUrl();
		cartPage.clickOnCart();
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl , newurl);
	}
	
	@Test (priority=3)
	public void verifyTheClickOnRemoveButton() {
		test = extent.createTest("verifyTheClickOnRemoveButton");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		cartPage.clickOnRemoveButton(0);
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.saucedemo.com/inventory.html");
	}
	
	@Test (priority=4)
	public void verifyRemoveProductFromProductDetailsPage() {
		test = extent.createTest("verifyRemoveProductFromProductDetailsPage");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		String currenturl = driver.getCurrentUrl();
		cartPage.clickOnCart();
		cartPage.clickOnRemoveButton(0);
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=5)
	public void verifyClickOnContinueShoppingButton() {
		test = extent.createTest("verifyClickOnContinueShoppingButton");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		cartPage.clickOnCart();
		String currenturl = driver.getCurrentUrl();
		cartPage.clickOnContinueShopping(driver);
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=6)
	public void verifyClickOnCheckoutButton() {
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		cartPage.clickOnCart();
		String currenturl = driver.getCurrentUrl();
		cartPage.clickOnCheckoutButton(driver);
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority=7)
	public void verifyAddProductFromProductDetailsPage() {
		test = extent.createTest("verifyAddProductFromProductDetailsPage");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		ProductPage productPage = new ProductPage(driver);
		String currenturl = driver.getCurrentUrl();
		productPage.getProductsName();
		AddToCartPage cartpage=new AddToCartPage(driver);
    	cartpage.clickOnAddToCart(0);
    	String newurl = driver.getCurrentUrl();
    	Assert.assertNotEquals(currenturl, newurl);
	}
	

	@Test (priority=8)
	public void verifyClickOnProductNameFromCart() {
		test = extent.createTest("verifyClickOnProductNameFromCart");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		cartPage.clickOnAddToCart(0);
		cartPage.clickOnCart();
		String currenturl = driver.getCurrentUrl();
		cartPage.clickOnProductName(driver);
		String newurl = driver.getCurrentUrl();
		Assert.assertNotEquals(currenturl, newurl);
	}
	
	@Test (priority =9)
	public void addMultipleProductsInCart() {
		test = extent.createTest("addMultipleProductsInCart");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
	    	cartPage.clickOnAddToCart(0);
	    	String currenturl = driver .getCurrentUrl();
	        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    		cartPage.clickOnAddToCart(1);
    		cartPage.clickOnCart();
    		String newurl = driver.getCurrentUrl();
    		Assert.assertNotEquals(currenturl, newurl);

	
	}

	@Test (priority=10)
	public void verifyProductNameOFProductPageWithCartPage() {
		test = extent.createTest("verifyProductNameOFProductPageWithCartPage");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
	    cartPage.getProductName();
	    String currenttitle = driver.getTitle();
		cartPage.clickOnAddToCart(0);
		cartPage.clickOnCart();
		cartPage.getProductNameOfCartPage(0);
		String newtitle =driver.getTitle();
		Assert.assertEquals(currenttitle, newtitle);
	}
	
	@Test (priority=11)
	public void verifyTheProductPrice() {
		test = extent.createTest("verifyTheProductPrice");
		SwagLabLoginTest loginTest = new SwagLabLoginTest();
		loginTest.logInWithStandardUser();
		AddToCartPage cartPage = new AddToCartPage(driver);
		double price= cartPage.checkPriceOfProductsPage(0, driver);
		Assert.assertEquals(cartPage.checkPriceOfProductsPage(0, driver), 29.99);
	
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
