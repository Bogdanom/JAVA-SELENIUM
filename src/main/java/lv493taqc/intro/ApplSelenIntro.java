package lv493taqc.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplSelenIntro {

	public static void main(String[] args) {
		
		System.out.println("selenium start");
		
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://www.opencart.com/");
		System.out.println("selenium start done");
		
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]")).click();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='input-email']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("bomemailn@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Asdfg12!");
		
		driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]")).click();
		
		driver.findElement(By.xpath("//input[@id='input-pin']")).click();
		driver.findElement(By.xpath("//input[@id='input-pin']")).clear();
		driver.findElement(By.xpath("//input[@id='input-pin']")).sendKeys("8754");
		
		driver.findElement(By.xpath("//*[@id=\"account-security\"]/div[2]/div/div[1]/form/div[2]/button")).click();
			
		System.out.print("appl done");
	}

}
