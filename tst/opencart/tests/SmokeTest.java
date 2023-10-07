package opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import opencart.data.repository.IUser;
import opencart.data.repository.User;
import opencart.data.repository.UserRepository;
import opencart.pages.guest.FailedLoginPage;
import opencart.pages.guest.HomePage;
import opencart.pages.guest.RegisterPage;
import opencart.pages.guest.SuccessLoginPage;

public class SmokeTest extends OpenCartTestRunner {

	//@Test
	public void smokeTest() {

		HomePage homePage = loadApplication();

		Assert.assertTrue(homePage.isDisplayedLogo());
		Assert.assertTrue(homePage.isDisplayedLogin());
		Assert.assertTrue(homePage.isDisplayedRegister());

		System.out.println("== HomePage ==");
		System.out.println("== Logo = " + homePage.getLogoText());
		System.out.println("== Register = " + homePage.getRegisterText());
		System.out.println("== Login = " + homePage.getLoginText());
		
		homePage.clickLogin();
		delay();
		
		System.out.println("=====================");
	}

	@DataProvider
	public Object[][] users() {
		return new Object[][] {
			{ UserRepository.get().wrongUser() }
		};
	}
	
	@Test(dataProvider = "users")
	public void loginPage(IUser user) {
		// check appropriate messages - log in with wrong credentials

		FailedLoginPage failedLogin = loadApplication()
		.clickLogin()
		.setEmail(user)
		.setPassword(user)
		.clickSubmitNotlogin();
		
		System.out.println("== LoginPage ==");
		
		String expected = failedLogin.WARNING_MESSAGE;
		int strLength = expected.length();
		
		String actual = failedLogin.getAlertText();
		actual = actual.substring(0, strLength);
		
		System.out.println("== Warning Message actual - " + actual);
		Assert.assertEquals(expected, actual);
		
		System.out.println("== Question Message - " + failedLogin.getQuestionText());
		Assert.assertTrue(failedLogin.getQuestionText().contains(failedLogin.QUESTION_MESSAGE));
				
		failedLogin.clickLogo();
		delay();
		
		System.out.println("=====================");
	}
	
	//@Test
	public void registerPage() {
		
        //check Register Page

		RegisterPage registerPage = loadApplication().clickRegister();
		delay(2);
		
		System.out.println("== RegisterPage ==");
		System.out.println("== Email Text - " + registerPage.getEmailText());
		System.out.println("== Password Text - " + registerPage.getPasswordText());
		
		Assert.assertTrue(registerPage.isDisplayedEmail());
		Assert.assertTrue(registerPage.isDisplayedPassword());
		
		System.out.println("=====================");
	
	}
	
	//@Test
	// work if fast pin inputting 7654 (manual)
	// task - catch page for security pin inputing
	public void SuccessfulLogin() {
		// check login feature - log in with right credentials

		SuccessLoginPage okLogin = loadApplication()
		.clickLogin()
	//	.setEmail("bomemailn@gmail.com")
	//	.setPassword("Asdfg12@")
		.clickSubmitLogin();

		delay();
		
		System.out.println("== Account Text - " + okLogin.getAccountText());
		
		Assert.assertTrue(okLogin.getAccountText().contains(okLogin.TITLE));		

		delay(2);
	}

}
