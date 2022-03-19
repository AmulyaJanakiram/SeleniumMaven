package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailure() {

		// test = report.startTest("LoginFailure");
		LoginPage Login = new LoginPage();
		Login.LoginFuction("amulya.janakiram@gmail.com", "abcedeA@32");
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		Assert.assertEquals(ActualMsg, ExpMsg); // Hard assertion. Execution is stopped.
		// report.endTest(test);
	}

	@Test
	public void LoginSuccess() {

		LoginPage Login = new LoginPage();
		Login.LoginFuction("amulya.janakiram@gmail.com", "Cts-1982");

		/*
		 * WebElement ErrorMsg = driver.findElement(By.id("msg_box")); String ActualMsg
		 * = ErrorMsg.getText(); String ExpMsg =
		 * "The email or password you have entered is invalid.";
		 * Assert.assertEquals(ActualMsg, ExpMsg); // Hard assertion. Execution is
		 * stopped.
		 */

	}

	@Test
	@Parameters({ "Param1", "Param2" })
	public void Parameterized(String UserName, String Password) {

		LoginPage Login = new LoginPage();
		Login.LoginFuction(UserName, Password);

	}

	@Test
	public void ExternalDataTest() {

		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();

		LoginPage Login = new LoginPage();
		Login.LoginFuction(UserName, Password);

	}

}
