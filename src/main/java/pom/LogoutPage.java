package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	
	@FindBy (xpath = "//a[@id='logout_sidebar_link']")private WebElement logOut;
    
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogoutButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(logOut));
		logOut.click();
	}
	
	public void moveToLogout(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(logOut);
		actions.perform();
	}
	
	
	
}
