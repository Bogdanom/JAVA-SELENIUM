package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPartPO {
	protected WebDriver driver;
	//
	private WebElement logo;
	private WebElement login;
	private WebElement register;
	
	public TopPartPO(WebDriver driver) {
		this.driver=driver;
		initElements();
	}
	
	private void initElements() {
		
		login = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]"));
		register = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[2]"));
		logo = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]/img[1]"));
		
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
