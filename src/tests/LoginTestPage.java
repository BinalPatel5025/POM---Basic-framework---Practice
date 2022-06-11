package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.io.IOException;
import org.testng.annotations.AfterMethod;

public class LoginTestPage {

	LoginPage lp = new LoginPage();
	DataFile dp = new DataFile();
	
	/* copy this to datafile class - we keep all data in datafile
	Xls_Reader readXL = new Xls_Reader("C:\\testing\\frameworkExcel.xlsx");
	
	String wrongEmail =readXL.getCellData("Sheet1", "WrongEmail", 2);
	String wrongPassword = readXL.getCellData("Sheet1", 1, 2) ;
	String emailWithSpeacialChar = readXL.getCellData("Sheet1", 2, 2) ;
	String globalErr = readXL.getCellData("Sheet1", 3, 2) ;
	String specialCharEmailErr = readXL.getCellData("Sheet1", 4, 2) ;
	String emptyEmailErr =readXL.getCellData("Sheet1", 5, 2) ;
	String emptyPasswordErr =readXL.getCellData("Sheet1", 6, 2) ;
	*/

	@BeforeMethod
	public void beforeMethod() throws IOException {
		lp.openBrowser();
		lp.openLoginPage();
		
	}

	@AfterMethod
	public void afterMethod() {
		lp.closeBrowser();
	}

	@Test(priority = 1)
	public void loginWithWrongEmailPasswordTest() throws InterruptedException {
		//System.out.println(wrongEmail);
		//System.out.println(wrongPassword);
		//System.out.println(emailWithSpeacialChar);
		//System.out.println(globalErr);
		//System.out.println(specialCharEmailErr);
		//System.out.println(emptyEmailErr);
		//System.out.println(emptyPasswordErr);
		lp.login(dp.wrongEmail,dp.wrongPassword);
		//String expectedErr = dp.globalErr;
		//String actualErr = lp.readglobalErr();
		Assert.assertEquals(lp.readglobalErr(), dp.globalErr);

	}

	@Test(priority = 2)
	public void loginWithSpecialCharEmailTest() throws InterruptedException {
		
		System.out.println(dp.emailWithSpeacialChar);
		System.out.println(dp.wrongPassword);
		lp.login(dp.emailWithSpeacialChar,dp.wrongPassword);

		//String expectedErr = dp.specialCharEmailErr;
		//String actualErr = lp.readEmailErr();

		Assert.assertEquals(lp.readEmailErr(), dp.specialCharEmailErr);

	}

	@Test(priority = 3)
	public void loginWithEmptyEmailTest() throws InterruptedException {
		lp.login("",dp.wrongPassword);
		//String expectedErr = dp.emptyEmailErr;
		//String actualErr = lp.readEmailErr();

		Assert.assertEquals(lp.readEmailErr(), dp.emptyEmailErr);
	}

	@Test(priority = 4)
	public void loginWithEmptyPaswordTest() throws InterruptedException {
		lp.login(dp.emailWithSpeacialChar,"");

		//String expectedErr = dp.emptyPasswordErr;
		//String actualErr = lp.readPasswordErr();

		Assert.assertEquals(dp.emptyPasswordErr, lp.readPasswordErr());
	}

}
