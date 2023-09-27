package lv493taqc.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import lv493taqc.opencard.pages.guest.FailedLoginPage;
import lv493taqc.opencard.pages.guest.FailedRegisterPage;
import lv493taqc.opencard.pages.guest.HomePage;
import lv493taqc.opencard.pages.guest.MyAccDropdown;
import lv493taqc.opencard.pages.guest.RegisterPage;
import lv493taqc.opencard.pages.guest.TopPart;

public class SmokeTest extends OpenCartTestRunner {
	
	//@Test
    public void smokeTest1() throws InterruptedException {
    
	HomePage homePage = new HomePage(driver);
		
    
    Assert.assertTrue(homePage.isDisplayedLogo());
    Assert.assertTrue(homePage.isDisplayedMyAccDropdown());
    
    
    System.out.println("homePage Logo = " + homePage.getLogoText());
    System.out.println("homePage MyAccDropdown = " + homePage.getMyAccDropdownText());
    
  
    Thread.sleep(3000);//for presentation only
    homePage.ClickMyAccount();
    Thread.sleep(3000);//for presentation only
    homePage.ClickLogo();
    Thread.sleep(4000);//for presentation only
	}
	
	//@Test
    public void smokeTest2() throws InterruptedException {
    
	HomePage homePage = new HomePage(driver); 	
			
    homePage.ClickMyAccount();	
    Thread.sleep(3000);//for presentation only
    
    MyAccDropdown myAcc = new MyAccDropdown(driver); 
    
    Assert.assertTrue(myAcc.isDisplayedRegister());
    Assert.assertTrue(myAcc.isDisplayedLogin()); 
    
    System.out.println("myAcc Register = " + myAcc.getRegisterText());
    System.out.println("myAcc Login = " + myAcc.getLoginText());
    
    myAcc.ClickLogin();	
    Thread.sleep(3000);//for presentation only
     
	}
	
	@Test
		public void unsuccessfulLogin() throws InterruptedException {
	//check appropriate error message - log in with wrong Email and wrong Password
			
		TopPart topPart = new TopPart(driver); 
		    
		    topPart.getLoginPage().setEmail("wrongEmail");
			Thread.sleep(2000);//for presentation only
			
			topPart.getLoginPage().setPassword("wrongPassword");
			Thread.sleep(2000);//for presentation only
						
		    topPart.getLoginPage().clickSubmit();
		    Thread.sleep(2000);//for presentation only
			
			FailedLoginPage failedLogin = new FailedLoginPage(driver);
			
			Assert.assertEquals(failedLogin.WARNING_MESSAGE,failedLogin.getAlertText());
			Assert.assertTrue(failedLogin.getAlertText().contains(failedLogin.WARNING_MESSAGE));
			
			System.out.println(" Warning Message - " + failedLogin.getAlertText());
			Thread.sleep(2000);//for presentation only
						
			failedLogin.clickLogo();
			Thread.sleep(2000);//for presentation only
		}
	
	//@Test
	public void unsuccessfulRegister() throws InterruptedException {
//check appropriate error message - log in with wrong Email and wrong Password
		
		HomePage homePage = new HomePage(driver); 		
			
	    homePage.ClickMyAccount();	
	    Thread.sleep(1000);//for presentation only
	    
	    MyAccDropdown myAcc = new MyAccDropdown(driver);
	    
	    myAcc.clickRegister();	
	    Thread.sleep(1000);//for presentation only
		
	    RegisterPage registerPage = new RegisterPage(driver); 
	    		    
	    registerPage.setEmail("wrongEmail");
		Thread.sleep(1000);//for presentation only
		
		registerPage.setPassword("wrongPassword");
	    Thread.sleep(1000);//for presentation only
		
	    registerPage.clickSubmit();
		
		FailedRegisterPage failedRegister = new FailedRegisterPage(driver);
		
		Assert.assertEquals(failedRegister.WARNING_MESSAGE,failedRegister.getAlertText());
		Assert.assertTrue(failedRegister.getAlertText().contains(failedRegister.WARNING_MESSAGE));
		
		System.out.println(" Warning Message - " + failedRegister.getAlertText());
		Thread.sleep(2000);//for presentation only
					
		failedRegister.clickLogo();
		Thread.sleep(3000);//for presentation only
	}
	
}
