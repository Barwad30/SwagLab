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

public class ProductPage {
	
	@FindBy (xpath = "//a[@class='shopping_cart_link']")          private WebElement cart;
	@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement filterButton;
	@FindBy (xpath = "//div[text()='Sauce Labs Backpack']")       private WebElement productsName;
	@FindBy (xpath = "//button[text()='Add to cart']")            private List <WebElement> addToCart;
    @FindBy (xpath = "//div[@class='inventory_item_img']")        private List <WebElement> productImage;
	@FindBy (xpath = "//div[@class='inventory_item']")            private List <WebElement> productList;
	@FindBy (xpath = "//option[text()='Name (Z to A)']")          private WebElement filterZtoA;
	@FindBy (xpath = "//option[text()='Price (low to high)']")    private WebElement filterLowtoHigh;
	@FindBy (xpath = "//option[text()='Price (high to low)']")    private WebElement filterHightoLow;
	@FindBy (xpath = "//button[text()='Remove']")                 private List <WebElement> removeButton;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnRemoveButton(int i ) {
		WebElement value =removeButton.get(i);
		value.click();
	}
	public void getProductsName() {
		productsName.click();
	}
	public void getSelectProductName(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(productsName);
		actions.perform();
	}
	public void clickOnCart() {
		cart.click();
	}
	
	public void clickOnFilter() {
		filterButton.click();
	}
	
	public void selectFiltersZtoA() {
		filterZtoA.click();
	}
	public void selectFiltersLowToHigh() {
		filterLowtoHigh.click();
	}
	public void selectFiltersHightoLow() {
		filterHightoLow.click();
	}
	
	public void selectProductList(int i) {
		WebElement value = productList.get(i) ;
		value.click();
	}
	
	public void clickOnAddToCart(int i) {
		WebElement value =addToCart.get(i);
		value.click();
	}
	
	public void clickOnProductImage(int i) {
		WebElement value =productImage.get(i);
		value.click();
	}
	
}
