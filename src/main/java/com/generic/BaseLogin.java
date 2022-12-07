package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class BaseLogin {
	
	
	public void getLogin(){
		//open a browser
		WebDriver driver =DriverManager.getBrowser("chrome");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver ,3);
		
		// go to URL
		driver.navigate().to(Constants.URL);
		
		ScreenShot.getScreenShot(driver, "Homepage");
		
		
		//explicit wait=WebDriver wait
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0),3);
		HighLighter.getColor(driver,pf.getSigninBtn().get(0),"red");
		
		//click sign in
		HighLighter.getColor(driver,pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");

		//put user
		HighLighter.getColor(driver, pf.getEmail(),"red");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		
		//put pass
		HighLighter.getColor(driver, pf.getPassword(),"red");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		
		//click second sign in
				HighLighter.getColor(driver, pf.getSecondSigninBtn());
				pf.getSecondSigninBtn().click();
				ScreenShot.getScreenShot(driver, "Login Validation");

		//validation	
				boolean status =pf.getWelcome().get(0).isDisplayed();
				//Assertion = Hard & soft
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(status);//condition =true or false
				
				sa.assertAll();//validation
		
	}
		
	}
		
	
		

		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	



	
	
