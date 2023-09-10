package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {
	
	@FindBy (xpath = "//a[text()='Twitter']")         private WebElement twitter;
	@FindBy (xpath = "//a[text()='Facebook']")        private WebElement facebook;
	@FindBy (xpath = "//li[@class='social_linkedin']")private WebElement linkedin;
    @FindBy (xpath = "//div[@class='footer_copy']")   private WebElement footer;
	
	public FooterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTwitter(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(twitter));
		twitter.click();
	}
	
	public void clickOnFacebook(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(facebook));
		facebook.click();
	}
	
	public void clickOnLinkedin(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(linkedin));
		linkedin.click();
	}
	
	public String getChildWindowUrl(WebDriver driver) {
		String actualTitle="";
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		while(i.hasNext()) {
			String handle=i.next();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.switchTo().window(handle);
			actualTitle=driver.getCurrentUrl();
		}
		return actualTitle;
	}
	
	public String getTextOfPrivacyPolicy() {
		String policy=footer.getText();
		return policy;
	}
}
