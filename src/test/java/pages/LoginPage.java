package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;

	ExtentTest test = BaseClass.test;

	// ====================== WebElements ===========================

	@FindBy(className = "login") // find by annnotationn is used by PageFactory
	WebElement Loginlink;

	@FindBy(name = "user_login")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(name = "btn_login")
	WebElement LoginButton;

	@FindBy(className = "rememberMe")
	WebElement remember;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// ====================== Functions ===========================

	public void LoginFuction(String Usrname, String Pwd) {

		Loginlink.click();
		test.log(LogStatus.PASS, "Click the login link", "Login click successfull");
		UserName.sendKeys(Usrname);
		test.log(LogStatus.PASS, "Enter UserName", "Accepted the data");
		Password.sendKeys(Pwd);
		test.log(LogStatus.PASS, "Enter password", "Accepted the data");
		remember.click();
		test.log(LogStatus.PASS, "Click on Remember Me", "Click successful");
		LoginButton.click();
		test.log(LogStatus.PASS, "Click on Login button", "Login button click successful");

	}

	public void UIChech() {

		WebElement UserName = driver.findElement(By.name("user_login"));
		Assert.assertTrue(UserName.isDisplayed());

	}
}
