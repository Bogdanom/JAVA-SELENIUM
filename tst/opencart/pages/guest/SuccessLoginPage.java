package opencart.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessLoginPage {
	
	private WebDriver driver;

	private WebElement account;

	public final String TITLE = "Account";
	
	public SuccessLoginPage(WebDriver driver) {
		this.driver = driver;
		initElements();

	}

	private void initElements() {
	// delay to wait page loading to have selector visible
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		account = driver.findElement(By.xpath("//h2[contains(text(),'Account')]"));
		
	}

	// Page Object

	// account TITLE
	
	public WebElement getAccount() {
		return account;
	}

	public void clickAccount() {
		getAccount().click();
	}

	public String getAccountText() {
		return getAccount().getText();
	}

	public boolean isDisplayedAccount() {
		return getAccount().isDisplayed();
	}

	// account details
	
	public WebElement getAccountDetails() {
		return driver.findElement(By.xpath("work"));
	}

	public void clickAccountDetails() {
		getAccount().click();
	}

	public String getAccountDetailsText() {
		return getAccount().getText();
	}

	public boolean isDisplayedAccountDetails() {
		return getAccount().isDisplayed();
	}

	// Functional

	// Business Logic
}
