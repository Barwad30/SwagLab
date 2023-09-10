package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage  {
	
	@FindBy (xpath = "//input[@id='first-name']") private WebElement firstName;
	@FindBy (xpath = "//input[@id='last-name']" ) private WebElement lastName;
	@FindBy (xpath = "//input[@id='postal-code']")private WebElement postalCode;
	@FindBy (xpath = "//input[@id='continue']")   private WebElement continueButton;
	@FindBy (xpath = "//h3[@data-test='error']")  private WebElement error;
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String first) {
		firstName.sendKeys(first);
	}
	
	public void enterLastName(String last) {
		lastName.sendKeys(last);
	}
	
	public void enterPostalCode(String postal) {
		postalCode.sendKeys(postal);
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public String getDisplyedErrorMessage() {
		String Error = error.getText();
		return Error;
	}

}
