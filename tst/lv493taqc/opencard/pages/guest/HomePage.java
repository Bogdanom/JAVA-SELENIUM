package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {
	
	private WebElement logo;
	
	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		
		logo = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]/img[1]"));
		
	}
	
	// Page Object
	

	// logo
	public WebElement getLogo() {
		return logo;
	}

	public void ClickLogo() {
		getLogo().click();
	}

	public String getLogoText() {
		return getLogo().getAttribute("alt");
	}

	public boolean isDisplayedLogo() {
		return getLogo().isDisplayed();
	}
			// Functional
			
			// Business Logic
}
