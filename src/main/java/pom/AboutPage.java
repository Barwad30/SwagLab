package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage {
	@FindBy (xpath = "//button[text()='Open Menu']") private WebElement menu;
	@FindBy (xpath = "//a[@id='about_sidebar_link']")private WebElement about;
    
	
	public AboutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(menu));
		menu.click();
	}
	public void moveOnAbout(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(about);
		actions.perform();
	}
	
	public void clickOnAbout() {
		about.click();
	}
}
