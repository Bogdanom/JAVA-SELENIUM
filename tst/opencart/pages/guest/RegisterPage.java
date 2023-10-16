package opencart.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	private WebDriver driver;
	
	private WebElement email;
	private WebElement password;
	private WebElement logo;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		initElements();
		
	}

	private void initElements() {
		
		email = driver.findElement(By.xpath("//input[@id='input-email']"));
		password = driver.findElement(By.xpath("//input[@id='input-password']"));
		logo = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]/img[1]"));
	}
	
	// Page Object
	
	// email field
	
	public WebElement getEmail() {
		return email;
	}

	public void clickEmail() {
		getEmail().click();
	}

	public void clearEmail() {
		getEmail().clear();
	}
	
	public void setEmail(String email) {
		clickEmail();
	    clearEmail();
		getEmail().sendKeys(email);
	}

	public String getEmailText() {
		return getEmail().getAttribute("name");
	}
	
	public boolean isDisplayedEmail() {
		return getEmail().isDisplayed();
	}
	
	// password field
	
	public WebElement getPassword() {
		return password;
	}

	public void clickPassword() {
		getPassword().click();
	}

	public void clearPassword() {
		getPassword().clear();
	}
	
	public void setPassword(String password) {
		clickPassword();
	    clearPassword();
		getPassword().sendKeys(password);
	}
	
	public String getPasswordText() {
		return getPassword().getAttribute("name");
	}
	
	public boolean isDisplayedPassword() {
		return getPassword().isDisplayed();
	}	
	
	// logo
	
		public WebElement getLogo() {
			return logo;
		}

		public void clickLogo() {
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
