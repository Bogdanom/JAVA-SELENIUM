package basetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCardTestXPath {
	private WebDriver driver;
	
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
	    	 //driver.get("http://taqc-opencart.epizy.com/");
	        System.out.println("\t@BeforeTest");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("\t@AfterTest");
	        //logout(url/logout, delete cookies, delete cash)
	    }
	    
	    @Test
	    public void f1() throws InterruptedException {
	    	
	    	//driver.get("http://taqc-opencart.epizy.com/");
	    	//
	    	driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
	    	driver.findElement(By.xpath("//button[@name='EUR']")).click();
	    	Thread.sleep(3000);//for presentation only
	    	
	    	driver.findElement(By.xpath("//input[@name='search']")).click();
	    	driver.findElement(By.xpath("//input[@name='search']")).clear();
	    	driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mac");
	    	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	    	Thread.sleep(3000);//for presentation only
	    	
	    	WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
	    	Assert.assertTrue(price.getText().contains("472.33"));
	    	Thread.sleep(3000);//for presentation only
	    	
	    	driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();//click on logo
	    	Thread.sleep(4000);//for presentation only
	    	System.out.println("\t\t\t\t@Test f1()");
	    }

}
