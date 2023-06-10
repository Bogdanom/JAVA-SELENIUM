package lv493taqc.opencard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplSelenIntro {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("selenium start");
		
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://www.opencart.com/");
		Thread.sleep(2000);
		
		System.out.println("selenium start done, page title is - "+driver.getTitle());
		Thread.sleep(2000);
		
		// click login button
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(2000);
		
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // deprecated 
		
		//login - put email into user field
		//driver.findElement(By.xpath("//input[@id='input-email']")).click();
		driver.findElement(By.id("input-email")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("bomemailn@gmail.com");
		Thread.sleep(2000);
		
		//login - put password into password field
		//driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Asdfg12@", Keys.ENTER);
		Thread.sleep(2000);
		
		//next line(click on the login button) is substituted by Keys.ENTER
		//driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]")).click();
		
		/* works(print the message) if login/password is/are wrong
		WebElement  alert1 = driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]"));
		System.out.println("Message - " + alert1.getText());
		*/
		// put pin-code into pin-code field
		driver.findElement(By.xpath("//input[@id='input-pin']")).click();
		driver.findElement(By.xpath("//input[@id='input-pin']")).clear();
		driver.findElement(By.xpath("//input[@id='input-pin']")).sendKeys("7654", Keys.ENTER);
		Thread.sleep(2000);
		
		
		//next line(click on the login button) is substituted by Keys.ENTER
		//driver.findElement(By.xpath("//*[@id=\"account-security\"]/div[2]/div/div[1]/form/div[2]/button")).click();
		
		//
		/* works(print the message) if the pin is wrong
		WebElement  alert2 = driver.findElement(By.xpath("//*[@id=\"account-security\"]/div[2]/div/div[1]/div"));
		System.out.println("Message - " + alert2.getText());
		*/

		// click logout button
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[2]")).click();//logout
		Thread.sleep(2000); //pause to see result, don't use in work
		
		//driver.close(); //close browser only, but not stop web driver in memory
		driver.quit();// close browser and stop web driver in memory
		System.out.print("appl done");
	}

}
