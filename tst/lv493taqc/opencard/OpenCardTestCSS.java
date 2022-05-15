package lv493taqc.opencard;

import java.util.List;

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

public class OpenCardTestCSS {

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
	    public void f1() throws InterruptedException {
	    	
	    	driver.get("http://taqc-opencart.epizy.com/");
	    	
	    	driver.findElement(By.xpath("//span[contains(text(),'Currency')]")).click();
	    	driver.findElement(By.xpath("//button[contains(text(),'$ US Dollar')]")).click();
	    	Thread.sleep(1000);//for presentation only
	    	
	    	driver.findElement(By.cssSelector("#search > input")).click();
	    	driver.findElement(By.cssSelector("#search > input")).clear();
	    	driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
	    	driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
	    	Thread.sleep(1000);//for presentation only
	    	
	    	WebElement price = getElementByName("MacBook").findElement(By.cssSelector("p.price"));
	    	Assert.assertTrue(price.getText().contains("$602.00"));
	    	Thread.sleep(1000);//for presentation only
	    	
	    	driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();//click on logo
	    	//Thread.sleep(1000);//for presentation only
	    	System.out.println("\t\t\t\t@Test f1()");
	    }
	    
	    private WebElement getElementByName(String name) {
    		
    		WebElement result = null;
    		
    		List<WebElement> containers = driver.findElements(By.cssSelector("div.product-layout.product-grid")); 
    		for(WebElement current : containers) {
    			if(current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
    				result = current;
    				break;
    			}
    		}
    		if(result==null) {
    			throw new RuntimeException("WebElement by title/name: "+name+" not found");
    		}
    		return result;
    	}
	    
	    //@Test
	    public void f2() {
	        System.out.println("\t\t\t\t@Test f2()");
	    }
	
}
