package opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import opencart.data.repository.IUser;
import opencart.data.repository.UserRepository;
import opencart.pages.guest.FailedLoginPage;
import opencart.pages.guest.HomePage;
import opencart.pages.guest.RegisterPage;
import opencart.pages.guest.SuccessLoginPage;

public class SmokeTest extends OpenCartTestRunner {

	// @Test
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
	public Object[][] wrongUsers() {
		return new Object[][] { 
			{ UserRepository.get().wrongCreds() }, 
			{ UserRepository.get().wrongEmail() },
			{ UserRepository.get().wrongPassword() }, 
			{ UserRepository.get().emptyCreds() }
	   };
	}

	@Test(dataProvider = "wrongUsers")
	public void loginPage(IUser wrongUser) {
		// check appropriate messages - log in with wrong credentials
		
		FailedLoginPage failedLogin = loadApplication()
				.clickLogin()
				.fillFields(wrongUser)
				.clickSubmitNotlogin();

		System.out.print("== LoginPage == ");
		System.out.print("Credentials: email = " + wrongUser.getEmail());
		System.out.println(", password = " + wrongUser.getPassword());

		String expected = failedLogin.WARNING_MESSAGE;
		int strLength = expected.length();

		String actual = failedLogin.getAlertText();
		actual = actual.substring(0, strLength);

		System.out.println("== Warning Message actual - " + actual);
		
		if (!actual.contains("Your account has exceeded allowed nu")) {
		Assert.assertEquals(actual, expected);
		} else {
			System.out.print("!!! These credentials has blocked by the site for 1 hour. Run it later");
		}

		System.out.println("== Question Message - " + failedLogin.getQuestionText());
		Assert.assertTrue(failedLogin.getQuestionText().contains(failedLogin.QUESTION_MESSAGE));

		failedLogin.clickLogo();
		delay();

		System.out.println("=====================");
	}

	// @Test
	public void registerPage() {

		// check Register Page

		RegisterPage registerPage = loadApplication().clickRegister();
		delay(2);

		System.out.println("== RegisterPage ==");
		System.out.println("== Email Text - " + registerPage.getEmailText());
		System.out.println("== Password Text - " + registerPage.getPasswordText());

		Assert.assertTrue(registerPage.isDisplayedEmail());
		Assert.assertTrue(registerPage.isDisplayedPassword());

		System.out.println("=====================");

	}
	
	@DataProvider
	public Object[][] correctUsers() {
		return new Object[][] { { 
			UserRepository.get().correctUser() 
	  } };
	}
	//@Test(dataProvider = "correctUsers")
	// work if fast pin inputting 7654 (manual)
	public void SuccessfulLogin(IUser correctUser) {
		// check login feature - log in with right credentials

		SuccessLoginPage okLogin = loadApplication().clickLogin()
				.fillFields(correctUser)
				.clickSubmitLogin();

		System.out.print("== LoginPage == ");
		System.out.print("Credentials: email = " + correctUser.getEmail());
		System.out.println(", password = " + correctUser.getPassword());
		
		delay();

		System.out.println("== Account Text - " + okLogin.getAccountText());

		Assert.assertTrue(okLogin.getAccountText().contains(okLogin.TITLE));

		delay(2);
	}

}
