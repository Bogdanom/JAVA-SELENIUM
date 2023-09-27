package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessLoginPage {
	private WebDriver driver;

	private WebElement account;

	public SuccessLoginPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {

		account = driver.findElement(
				By.xpath("//body/div[@id='account-account']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]"));

	}

	// Page Object

	// account
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
		return driver.findElement(By.xpath(
				"//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"));
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
