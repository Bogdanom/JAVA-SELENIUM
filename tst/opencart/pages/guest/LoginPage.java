package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	private WebElement email;
	private WebElement password;
	private WebElement submit;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		initElements();
	}

	private void initElements() {

		email = driver.findElement(By.xpath("//input[@id='input-email']"));
		password = driver.findElement(By.xpath("//input[@id='input-password']"));
		submit = driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]"));
	
	}

	// Page Object

	// email
	public WebElement getEmail() {
		return email;
	}

	public void clickEmail() {
		getEmail().click();
	}

	public void clearEmail() {
		getEmail().clear();
	}
	
	public LoginPage setEmail(String email) {
		clickEmail();
	    clearEmail();
		getEmail().sendKeys(email);
		return this;
	}

	public String getEmailText() {
		return getEmail().getText();
	}

	// password
	public WebElement getPassword() {
		return password;
	}

	public void clickPassword() {
		getPassword().click();
	}

	public void clearPassword() {
		getPassword().clear();
	}
	
	public LoginPage setPassword(String password) {
		clickPassword();
	    clearPassword();
		getPassword().sendKeys(password);
		return this;
	}
	
	public String getPasswordText() {
		return getPassword().getText();
	}

	// submit button
	
	public WebElement getSubmit() {
		return submit;
	}

	public void clickSubmit() {
		getSubmit().click();
	}
	
	public SuccessLoginPage clickSubmitLogin() {
		clickSubmit();
		return new SuccessLoginPage(driver);
	}
	public FailedLoginPage clickSubmitNotlogin() {
		getSubmit().click();
		return new FailedLoginPage(driver);
	}

	public String getSubmitText() {
		return getSubmit().getText();
	}

	public boolean isDisplayedSubmit() {
		return getSubmit().isDisplayed();
	}
	
}
