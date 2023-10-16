package opencart.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopPart {
	
	protected WebDriver driver;
	
	private WebElement login;
	private WebElement register;
	

	public TopPart(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {

		login = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]"));
		register = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[2]"));

	}
	// Page Object
	
	// login link
	
	public WebElement getLogin() {
		return login;
	}

	public LoginPage clickLogin() {
		getLogin().click();
		return new LoginPage(driver);
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public boolean isDisplayedLogin() {
		return getLogin().isDisplayed();
	}

	// register link
	
	public WebElement getRegister() {
		return register;
	}

	public RegisterPage clickRegister() {
		getRegister().click();
		return new RegisterPage(driver);
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
