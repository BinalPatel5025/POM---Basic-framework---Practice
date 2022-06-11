package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=mZBRj75wigI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoibVpCUmo3NXdpZ0kiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0OTAxNDk1MSwiaWF0IjoxNjQ5MDEzNzUxLCJqdGkiOiJmMDhkYmQ1MS02Njg4LTQ3OTEtYjE2MS0xNjVkMzJiZGIwYmYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.Wz42g7ZommCWho511Xf2Urbm29QKaouiWOuxTbXJkKJMXEKnSxrH7ifwhEbu0hZGYw3UukWKTSCjpQvZNFNn6GkxZ2-wPMjXDZOalMP6CaIJ1z59yJQYTfvY8nSuvzbELSoqoUxTHj9B2JhBI_FjJIQfewFbjHeoWYNMSE9-9Xr6kxloEO0nshJOQlperjgQMB2FkO4z4cR3lfgyx8cZUsVOyCEX8Cl2MJlHCKk5nZ-nK-zGrVXIjY0kNYpPWQ2A-2YZa84_EWVWTgsDw59GersR2iyIIZT2ZDvY9LzKlfteFiYRwg1RIe9PABS2KjZsOri2va8_wts7MZL9iURwqw&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginWithWrongEmailPasswordTest() throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys("sdfghnsdfgji123");
		driver.findElement(By.id("password-input")).sendKeys("12345nb##");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000);
		String expectedErr = "Please enter a username or card number without special characters.";
		String actualErr = driver.findElement(By.id("globalError")).getText();

		Assert.assertEquals(actualErr, expectedErr);

	}
	
	@Test(priority = 2)
	public void loginWithSpecialCharEmailTest() throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys("sdf@#ghnsdfgji123");
		driver.findElement(By.id("password-input")).sendKeys("12345nb##");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000);
		
		String expectedErr = "Please enter a username or card number without special characters.";
		String actualErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();

		Assert.assertEquals(actualErr, expectedErr);
		
	}
	
	@Test(priority = 3)
	public void loginWithEmptyEmailTest() throws InterruptedException {
		driver.findElement(By.id("password-input")).sendKeys("12345nb##");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000);
		
		String expectedErr = "Please enter your username or card number.";
		String actualErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();

		Assert.assertEquals(actualErr, expectedErr);
	}
	
	@Test(priority = 4)
	public void loginWithEmptyPaswordTest() throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys("sdfghnsdfgji123");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000);
		
		String expectedErr = "Please enter your password.";
		String actualErr = driver.findElement(By.id("PasswordTextField__errors-password")).getText();

		Assert.assertEquals(actualErr, expectedErr);
	}

}

//https://www.youtube.com/watch?v=kqQd6PlQtcs