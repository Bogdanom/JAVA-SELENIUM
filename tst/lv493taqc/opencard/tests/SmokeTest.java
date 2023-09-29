package lv493taqc.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import lv493taqc.opencard.pages.guest.FailedLoginPage;
import lv493taqc.opencard.pages.guest.FailedRegisterPage;
import lv493taqc.opencard.pages.guest.HomePage;
import lv493taqc.opencard.pages.guest.MyAccDropdown;
import lv493taqc.opencard.pages.guest.RegisterPage;

public class SmokeTest extends OpenCartTestRunner {

	 //@Test
	public void smokeTest() throws InterruptedException {

		HomePage homePage = loadApplication();

		Assert.assertTrue(homePage.isDisplayedLogo());
		Assert.assertTrue(homePage.isDisplayedLogin());
		Assert.assertTrue(homePage.isDisplayedRegister());

		System.out.println("homePage Logo = " + homePage.getLogoText());
		System.out.println("homePage Register = " + homePage.getRegisterText());
		System.out.println("homePage Login = " + homePage.getLoginText());
		
		homePage.ClickLogin();
		delay(2);
		
	}

	@Test
	public void UnsuccessfulLogin() throws InterruptedException {
		// check appropriate error message - log in with wrong Email and/or wrong Password

		FailedLoginPage failedLogin = loadApplication()
		.ClickLogin()
		.setEmail("wrongEmail")
		.setPassword("wrongPassword")
		.clickSubmitNotlogin();
		
		delay(2);
		
		System.out.println(" Warning Message - " + failedLogin.WARNING_MESSAGE);
		System.out.println(" Warning Message - " + failedLogin.getAlertText());
		//Assert.assertEquals(failedLogin.WARNING_MESSAGE, failedLogin.getAlertText());
		//Assert.assertTrue(failedLogin.getAlertText().contains(failedLogin.WARNING_MESSAGE));

		failedLogin.clickLogo();
		delay(2);
	}
	
	//@Test
	public void SuccessfulLogin() throws InterruptedException {
		// check appropriate error message - log in with wrong Email and/or wrong Password

		FailedLoginPage failedLogin = loadApplication()
		.ClickLogin()
		.setEmail("wrongEmail")
		.setPassword("wrongPassword")
		.clickSubmitNotlogin();

		Assert.assertEquals(failedLogin.WARNING_MESSAGE, failedLogin.getAlertText());
		Assert.assertTrue(failedLogin.getAlertText().contains(failedLogin.WARNING_MESSAGE));

		System.out.println(" Warning Message - " + failedLogin.getAlertText());

		failedLogin.clickLogo();
		delay(2);
	}

	// @Test
	public void unsuccessfulRegister() throws InterruptedException {
		// not work yet
//check appropriate error message - log in with wrong Email and wrong Password

		HomePage homePage = new HomePage(driver);

		//homePage.ClickMyAccount();
		Thread.sleep(1000);// for presentation only

		MyAccDropdown myAcc = new MyAccDropdown(driver);

		myAcc.clickRegister();
		Thread.sleep(1000);// for presentation only

		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.setEmail("wrongEmail");
		Thread.sleep(1000);// for presentation only

		registerPage.setPassword("wrongPassword");
		Thread.sleep(1000);// for presentation only

		registerPage.clickSubmit();

		FailedRegisterPage failedRegister = new FailedRegisterPage(driver);

		Assert.assertEquals(failedRegister.WARNING_MESSAGE, failedRegister.getAlertText());
		Assert.assertTrue(failedRegister.getAlertText().contains(failedRegister.WARNING_MESSAGE));

		System.out.println(" Warning Message - " + failedRegister.getAlertText());
		Thread.sleep(2000);// for presentation only

		failedRegister.clickLogo();
		Thread.sleep(3000);// for presentation only
	}

}
