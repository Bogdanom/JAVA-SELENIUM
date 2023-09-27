package lv493taqc.opencard.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FailedLoginPage {

	private WebDriver driver;

	private WebElement alert;
	private WebElement logo;
	
	public final String WARNING_MESSAGE = "No match for E-Mail and/or Password.";

	public FailedLoginPage(WebDriver driver) {
		this.driver=driver;
		initElements();
	}

	private void initElements() {
		
		alert = driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]"));
		logo = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]/img[1]"));

	}
	
	// Page Object
	
	// alert
			public WebElement getAlert() {
				return alert;
			}

			public void clickAlert() {
				getAlert().click();
			}

			public String getAlertText() {
				return getAlert().getText();
			}

			public boolean isDisplayedAlert() {
				return getAlert().isDisplayed();
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
}
