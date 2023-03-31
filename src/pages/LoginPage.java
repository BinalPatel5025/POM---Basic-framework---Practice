package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;
	//WebElement email = driver.findElement(By.id("usernameInput-input"));
	//WebElement passowrd = driver.findElement(By.id("password-input"));
	//WebElement signIn = driver.findElement(By.id("signIn"));
	//WebElement globalErr = driver.findElement(By.id("globalError"));
	//WebElement usernameErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	//WebElement passErr = driver.findElement(By.id("PasswordTextField__errors-password"));
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement passowrd;
	
	@FindBy(id = "signIn")
    public WebElement signIn;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement usernameErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passErr;

	
	public void openBrowser() throws IOException {
		FileInputStream f= new FileInputStream("C:\\testing\\frameworkProp.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);

	}

	public void openLoginPage() {
		driver.get(
				"https://auth.scotiaonline.scotiabank.com/online?oauth_key=mZBRj75wigI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoibVpCUmo3NXdpZ0kiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0OTAxNDk1MSwiaWF0IjoxNjQ5MDEzNzUxLCJqdGkiOiJmMDhkYmQ1MS02Njg4LTQ3OTEtYjE2MS0xNjVkMzJiZGIwYmYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.Wz42g7ZommCWho511Xf2Urbm29QKaouiWOuxTbXJkKJMXEKnSxrH7ifwhEbu0hZGYw3UukWKTSCjpQvZNFNn6GkxZ2-wPMjXDZOalMP6CaIJ1z59yJQYTfvY8nSuvzbELSoqoUxTHj9B2JhBI_FjJIQfewFbjHeoWYNMSE9-9Xr6kxloEO0nshJOQlperjgQMB2FkO4z4cR3lfgyx8cZUsVOyCEX8Cl2MJlHCKk5nZ-nK-zGrVXIjY0kNYpPWQ2A-2YZa84_EWVWTgsDw59GersR2iyIIZT2ZDvY9LzKlfteFiYRwg1RIe9PABS2KjZsOri2va8_wts7MZL9iURwqw&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void login(String a , String b) throws InterruptedException {
		email.sendKeys(a);
		passowrd.sendKeys(b);
		signIn.click();
	}

	public String readglobalErr() {
		String actualErr = globalErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}

	public String readEmailErr() {
		String actualErr = usernameErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}

	public String readPasswordErr() {
		String actualErr =passErr.getText();
		System.out.println(actualErr);
		return actualErr;
//
	}

}
