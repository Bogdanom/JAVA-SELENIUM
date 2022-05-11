package lv493taqc.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplSelenIntro {

	public static void main(String[] args) {
		
		//System.out.println("selenium start");
		
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://softserve.academy/");
		driver.findElement(By.linkText("Log in")).click();
		System.out.print("selenium done");
	}

}
