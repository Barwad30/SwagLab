package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
	
	@FindBy (xpath = "//button[text()='Remove']")           private List <WebElement> removeButton;
    @FindBy (xpath = "//a[@class='shopping_cart_link']")    private WebElement cart;
	@FindBy (xpath = "//button[@id='continue-shopping']")   private WebElement continueShopping;
	@FindBy (xpath = "//button[@id='checkout']")            private WebElement checkoutButton;
	@FindBy (xpath = "//div[text()='Sauce Labs Backpack']") private WebElement productName;
	@FindBy (xpath = "//div[@class='inventory_item']")      private List <WebElement> productList;
	@FindBy (xpath = "//div[text()='Sauce Labs Backpack']") private List <WebElement> productNameCartPage;
	@FindBy (xpath = "//div[@class='inventory_item_price']")private List <WebElement> priceOFProductPage;
	@FindBy (xpath = "//button[text()='Add to cart']")      private List <WebElement> addToCart;
	
	
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getNumbersOfProducts(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productList));
		boolean result;
		if (productList.size()>0)
		{
			result=true;
		}
		else{
			result=false;
		}
		 return result;	
	}
	
	public void getProductName() {
		productName.getText();
	}
	public void clickOnDesiredProduct(int i) {
		productList.get(i).click();
	}
	public void getProductNameOfCartPage(int i) {
		WebElement productname= productNameCartPage.get(i);
	    productname.getText();
	}

	public void clickOnProductName( WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productName));
		productName.click();
		
	}
	
	public void clickOnAddToCart(int i) {
		WebElement value =addToCart.get(i);
		value.click();
	}
	
	public double checkPriceOfProductsPage(int i, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceOFProductPage));
		WebElement product=  priceOFProductPage.get(i);
		String productprice=product.getText();
		String s =productprice.substring(1);
		double Price=Double.parseDouble(s);
		return Price;	
	}
	public void clickOnCart() {
		cart.click();
	}
	public void clickOnCheckoutButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(6000));
		wait.until(ExpectedConditions.visibilityOf(checkoutButton));
	    checkoutButton.click();
	}
	public void clickOnContinueShopping(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(continueShopping));
		continueShopping.click();
	}
		
	public void clickOnRemoveButton(int i) {
			WebElement value =removeButton.get(i);
			value.click();
		
	}
}
