package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccDropdown {

private WebDriver driver;

private WebElement login;
private WebElement register;
	
	public MyAccDropdown(WebDriver driver) {
		this.driver=driver;
		initElements();
	}

	private void initElements() {
		
		login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
	}
	
	// Page Object
	
	// login
	public WebElement getLogin() {
		return login;
	}
	
	public void ClickLogin() {
		getLogin().click();
	}
	
	public String getLoginText() {
		return getLogin().getText();
	}
	
	public boolean isDisplayedLogin() {
		return getLogin().isDisplayed();
	}
	
	// register
		public WebElement getRegister() {
			return register;
		}
		
		public void clickRegister() {
			getRegister().click();
		}
		
		public String getRegisterText() {
			return getRegister().getText();
		}
		
		public boolean isDisplayedRegister() {
			return getRegister().isDisplayed();
		}
	
		// Functional
		
		// Business Logic
}
