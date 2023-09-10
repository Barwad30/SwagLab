package pom;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {
	
	@FindBy (xpath = "//button[@id='finish']")                                private WebElement finishButton;
	@FindBy (xpath = "//button[@id='back-to-products']")                      private WebElement backHomeButton;
	@FindBy (xpath = "//div[@class='summary_tax_label']")                     private WebElement taxPrice;
	@FindBy (xpath = "//div[@class='summary_info_label summary_total_label']")private WebElement totalPrice;
	@FindBy (xpath = "//div[@class='summary_subtotal_label']")                private WebElement iteamTotal;
	@FindBy (xpath = "//div[@class='inventory_item_price']")                  private List <WebElement> priceOfProductPage;
	
	public CheckoutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFinishButton() {
		finishButton.click();
	}
	
	public void clickOnBackHomeButton() {
		backHomeButton.click();
	}
	

	public double checkPriceOfProductsPage(int i, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceOfProductPage));
		WebElement product=  priceOfProductPage.get(i);
		String productprice=product.getText();
		String s =productprice.substring(1);
		double Price=Double.parseDouble(s);
		return Price;	
	}
	
	public double additionOfPrice(int i, WebDriver driver) {
		double num=0;
		double d=0;
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceOfProductPage));
		for(i=0; i<priceOfProductPage.size(); i++) {
			String name=priceOfProductPage.get(i).getText();
			String s = name.substring(1);
			d=Double.parseDouble(s);
			num= num + d;
		}
		return num;
	}
	
	public double getTaxPrice(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(taxPrice));
		String value =taxPrice.getText();
		String s= value.substring(6);
		double price= Double.parseDouble(s);
		return price;
	}
	
	public double getTotalPrice(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(totalPrice));
		String value =totalPrice.getText();
		String s= value.substring(8);
		double price= Double.parseDouble(s);
		return price;
	}
	
	public double getIteamTotal() {
		String value =iteamTotal.getText();
		String s= value.substring(13);
		double iteamtotal= Double.parseDouble(s);
		return iteamtotal;	
	}

}
