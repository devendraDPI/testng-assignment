package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.LoginPage;

public class LoginTest extends Baseclass {
	
	@Parameters({"UserName", "Password"})
	@Test
	public void NegativeLogin(String UserNameVal, String PasswordVal) {
		
		test = report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameVal, PasswordVal);
		report.endTest(test);
		
	}
	
	@Parameters({"UserName", "CorrectPassword"})
	@Test
	public void PositiveLogin(String UserNameVal, String PasswordVal) {
		
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameVal, PasswordVal);
		report.endTest(test);
		
	}
	
}
