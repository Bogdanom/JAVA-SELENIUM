package lv493taqc.opencard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OpenCardTestUpdated {

	private WebDriver driver;
	
	 @BeforeClass
	    public void beforeClass() {
	        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("\t\t@BeforeClass");
	    }

	    @AfterClass
	    public void afterClass() {
	    	driver.quit();
	        System.out.println("\t\t@AfterClass");
	    }
	    
	    @BeforeTest
	    public void beforeTest() {
	    	 //driver.get("http://taqc-opencart.epizy.com/");
	        System.out.println("\t@BeforeTest");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("\t@AfterTest");
	        //logout(url/logout, delete cookies, delete cash)
	    }
	    
	    @Test
	    public void f1() {
	    	
	    	driver.get("http://taqc-opencart.epizy.com/");
	    	
	    	driver.findElement(By.xpath("//span[contains(text(),'Currency')]")).click();
	    	driver.findElement(By.xpath("//button[contains(text(),'$ US Dollar')]")).click();
	    	
	    	driver.findElement(By.cssSelector("#search > input")).click();
	    	driver.findElement(By.cssSelector("#search > input")).clear();
	    	driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
	    	driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
	    	
	        System.out.println("\t\t\t\t@Test f1()");
	    }

	    //@Test
	    public void f2() {
	        System.out.println("\t\t\t\t@Test f2()");
	    }
	
}
