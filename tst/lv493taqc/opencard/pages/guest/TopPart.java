package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPart {
	
	protected WebDriver driver;
	//
	private WebElement currency;
	private WebElement logo;
	
	//
	
	public TopPart(WebDriver driver) {
		this.driver=driver;
		initElements();
	}
	
	private void initElements() {
		
		currency = driver.findElement(By.xpath("//span[contains(text(),'Currency')]"));
		logo = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		
	}
	
	// Page Object
	
	// currency
	public WebElement getCurrency() {
		return currency;
	}
	
	public void ClickCurrency() {
		getCurrency().click();
	}
	
	public String getCurrencyText() {
		return getCurrency().getText();
	}
	
	public boolean isDisplayedCurrency() {
		return getCurrency().isDisplayed();
	}
	
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
