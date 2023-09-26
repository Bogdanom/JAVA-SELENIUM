package lv493taqc.opencard.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import lv493taqc.opencard.pages.guest.FailedLoginPage;
import lv493taqc.opencard.pages.guest.HomePage;
import lv493taqc.opencard.pages.guest.LoginPage;
import lv493taqc.opencard.pages.guest.MyAccDropdown;

public class SmokeTest extends OpenCartTestRunner {
	
	//@Test
    public void smokeTest1() throws InterruptedException {
    
	HomePage homePage = new HomePage(driver);
		
    Assert.assertTrue(homePage.isDisplayedCurrency());
    Assert.assertTrue(homePage.isDisplayedLogo());
    Assert.assertTrue(homePage.isDisplayedMyAccDropdown());
    
    System.out.println("homePage Currency = " + homePage.getCurrencyText());
    System.out.println("homePage Logo = " + homePage.getLogoText());
    System.out.println("homePage MyAccDropdown = " + homePage.getMyAccDropdownText());
    
    homePage.ClickCurrency();
    Thread.sleep(3000);//for presentation only
    homePage.ClickMyAccount();
    Thread.sleep(3000);//for presentation only
    homePage.ClickLogo();
    Thread.sleep(4000);//for presentation only
	}
	
	//@Test
    public void smokeTest2() throws InterruptedException {
    
	HomePage homePage = new HomePage(driver); 	
	MyAccDropdown myAcc = new MyAccDropdown(driver); 
		
    homePage.ClickMyAccount();	
    Thread.sleep(3000);//for presentation only
    
    Assert.assertTrue(myAcc.isDisplayedRegister());
    Assert.assertTrue(myAcc.isDisplayedLogin()); 
    
    System.out.println("myAcc Register = " + myAcc.getRegisterText());
    System.out.println("myAcc Login = " + myAcc.getLoginText());
    
    myAcc.ClickLogin();	
    Thread.sleep(3000);//for presentation only
     
	}
	
	@Test
		public void unsuccessfulLoginPassword() throws InterruptedException {
	//check appropriate error message - log in with wrong Email and wrong Password
			
			HomePage homePage = new HomePage(driver); 	
			MyAccDropdown myAcc = new MyAccDropdown(driver);	
				
		    homePage.ClickMyAccount();	
		    Thread.sleep(1000);//for presentation only
		    
		    myAcc.ClickLogin();	
		    Thread.sleep(1000);//for presentation only
			
		    LoginPage loginPage = new LoginPage(driver); 
		    
		    loginPage.clickEmail();
		    loginPage.clearEmail();
//		    loginPage.setEmail("wrongEmail");
		    loginPage.getEmail().sendKeys("wrongEmail");
			Thread.sleep(1000);//for presentation only
			
			loginPage.clickPassword();
		    loginPage.clearPassword();
//		    loginPage.setPassword("wrongPassword");
		    loginPage.getPassword().sendKeys("wrongEmail");
			Thread.sleep(1000);//for presentation only
			
			loginPage.clickSubmit();
			
			FailedLoginPage failedLogin = new FailedLoginPage(driver);
			
			Assert.assertEquals(failedLogin.WARNING_MESSAGE,failedLogin.getAlertText());
			Assert.assertTrue(failedLogin.getAlertText().contains(failedLogin.WARNING_MESSAGE));
			
			System.out.println(" Warning Message - " + failedLogin.getAlertText());
			Thread.sleep(2000);//for presentation only
						
			failedLogin.clickLogo();
			Thread.sleep(3000);//for presentation only
		}
	//@Test
	public void unsuccessfulLoginPasswordNoPO() throws InterruptedException {
//check appropriate error message - log in with wrong Email and wrong Password - Not PageObject
		
		HomePage homePage = new HomePage(driver); 	
		MyAccDropdown myAcc = new MyAccDropdown(driver); 
			
	    homePage.ClickMyAccount();	
	    Thread.sleep(2000);//for presentation only
	    
	    myAcc.ClickLogin();	
	    Thread.sleep(2000);//for presentation only
		
		driver.findElement(By.xpath("//input[@id='input-email']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("wrongEmail");
		Thread.sleep(1000);//for presentation only
		driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("wrongPassword");
		Thread.sleep(1000);//for presentation only
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")).click();
		Thread.sleep(2000);//for presentation only
		WebElement  alert = driver.findElement(By.xpath("//body/div[2]/div[1]"));
		System.out.println("Message - " + alert.getText());
		Thread.sleep(2000);//for presentation only
		String expected="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(alert.getText().contains(expected));
		Thread.sleep(2000);//for presentation only
		
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		Thread.sleep(3000);//for presentation only
	}
}
