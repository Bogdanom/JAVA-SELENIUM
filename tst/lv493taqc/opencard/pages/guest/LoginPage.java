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
		submit = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
		
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
	
	public void setEmail(String email) {
		getEmail().sendKeys(email);
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
	
	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}
	
	public String getPasswordText() {
		return getPassword().getText();
	}

	// submit
	public WebElement getSubmit() {
		return submit;
	}

	public void clickSubmit() {
		getSubmit().click();
	}

	public String getSubmitText() {
		return getSubmit().getText();
	}

	public boolean isDisplayedSubmit() {
		return getSubmit().isDisplayed();
	}
	
}
