package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {
	
	private WebElement myAccDropdown;
	
	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		
		myAccDropdown = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
		
	}
	
	// Page Object
	
	// myAccount
		public WebElement getMyAccDropdown() {
			return myAccDropdown;
		}
		
		public void ClickMyAccount() {
			getMyAccDropdown().click();
		}
		
		public String getMyAccDropdownText() {
			return getMyAccDropdown().getText();
		}
		
		public boolean isDisplayedMyAccDropdown() {
			return getMyAccDropdown().isDisplayed();
		}
			// Functional
			
			// Business Logic
}
