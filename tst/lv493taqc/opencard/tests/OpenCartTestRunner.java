package lv493taqc.opencard.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import lv493taqc.opencard.pages.guest.HomePage;

public abstract class OpenCartTestRunner {

	private static final Long ONE_SECOND_DELAY = 1000L;
	
	protected WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(480, 640)); // mobile screen
		driver.get("https://www.opencart.com/");
		System.out.println("\t\t@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("\t\t@AfterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\t@BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\t@AfterTest");
		// logout(url/logout, delete cookies, delete cash)
	}
	
	public HomePage loadApplication() {
		return new HomePage(driver);
		}

	protected void delay() {
		delay(1);
	}
	protected void delay(int seconds) {
		try {
			Thread.sleep(seconds*ONE_SECOND_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
