package lv493taqc.opencard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCardTest {
	
	@Test
	public void unsuccessfulLogi() {
		
// test check if we have appropriate error message in case of log in with wrong credentials
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://www.opencart.com/");
		
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]")).click();
		
		//login
		//driver.findElement(By.xpath("//input[@id='input-email']")).click();
		driver.findElement(By.id("input-email")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("wrongEmail");
		
		//driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Asdfg12@");
		
		driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]")).click();
		
		/* works(print the message) if login/password is/are wrong*/
		WebElement  alert = driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]"));
		System.out.println("Message - " + alert.getText());

		String expected="No match for E-Mail and/or Password.";
		Assert.assertTrue(alert.getText().contains(expected));
		
		driver.quit();// close browser and stop web driver in memory
	}

}
