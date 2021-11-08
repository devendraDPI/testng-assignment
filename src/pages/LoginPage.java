package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class LoginPage {
	
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;
	
	//======================================= WEB ELEMENTS =======================================
	@FindBy(name="user-name")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(name="login-button")
	WebElement LoginButton;
	
	@FindBy(id="msg_box")
	WebElement Error;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//========================================== METHODS =========================================
	public void Login(String UName, String Pword) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(UserName));
		
		UserName.click();
		test.log(LogStatus.PASS,"Click on Login Link", "Succesfully Clicked the Link");
		
		UserName.sendKeys(UName);
		test.log(LogStatus.PASS,"Enter Username"+  UName, "Succesfully Entered the Name");
		
		Password.sendKeys(Pword);
		test.log(LogStatus.PASS,"Enter Password"+ Pword, "Succesfully Entered Password");
		
		LoginButton.click();
		test.log(LogStatus.PASS,"Click on Login Button", "Succesfully Clicked the Login Button");
		
	}
		
	public void ErrorCheck() {

		String ActualMsg = Error.getText();
		String ExpMsg = "Epic sadface: Username and password do not match any user in this service";
		SoftAssert soft = new SoftAssert(); // Soft Assert
		soft.assertEquals(ActualMsg, ExpMsg);
		soft.assertAll();
			
	}
		
}
