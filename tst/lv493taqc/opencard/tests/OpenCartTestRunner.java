package lv493taqc.opencard.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public abstract class OpenCartTestRunner {

	protected WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://taqc-opencart.epizy.com/");
		System.out.println("\t\t@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("\t\t@AfterClass");
	}

	@BeforeTest
	public void beforeTest() {
		// driver.get("http://taqc-opencart.epizy.com/");
		System.out.println("\t@BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\t@AfterTest");
		// logout(url/logout, delete cookies, delete cash)
	}

}
