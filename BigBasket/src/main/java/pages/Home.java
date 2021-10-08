
package pages;

import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.Base;

public class Home extends Base
{
	
	Scanner sc = new Scanner(System.in);
	
	
	By login=By.xpath("(//a[@qa='loginLink'])[2]");
	By mobile=By.xpath("//input[@id='otpEmail']");
	By otp = By.xpath("//input[@id='otp']");
	By arrow=By.xpath("//span[@class='arrow-marker']");
	By city=By.xpath("//div[@placeholder='Select your city']");
	By cityname=By.xpath("//input[@placeholder='Select your city']");
	By pin=By.xpath("//input[@placeholder='Enter your area / apartment / pincode']");
	By shop=By.xpath("//button[@class='btn btn-default btn-lg login-btn fixed-btn']");
	
			
	//Open URL
	public void openUrl()
	{
		driver.get(prop.getProperty("url"));

		testlog = report.createTest("Open Bigbasket Url");
		testlog.log(Status.PASS, "User is in BB Home page");
		takeSS("homepage.png");
	}
	
	//Change Location
	public void location() throws InterruptedException
	{
	    driver.findElement(arrow).click();
	    driver.findElement(city).click();
	    WebElement w = driver.findElement(cityname);
		w.sendKeys("Bangalore");
		Thread.sleep(1000);
		w.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		w.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	    
	    WebElement area =driver.findElement(pin);
		area.sendKeys("560001");
		Thread.sleep(1000);
		area.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		area.sendKeys(Keys.ENTER);
		area.sendKeys(Keys.ENTER); 
		Thread.sleep(2000);
		
	}
	
	public void navigateToHome()
	{
		driver.navigate().to("https://www.bigbasket.com/");
	}
	
	//SignUp_Login
	public void signup(String mobNo) throws Exception
	{
		driver.findElement(login).click();	
		WebElement lgn = driver.findElement(mobile);
		lgn.sendKeys(mobNo);
		lgn.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		takeSS("loginmobile.png");
		
		System.out.print("\nEnter otp : ");
		String OtpNo = sc.next();
		Thread.sleep(2000);
		driver.findElement(otp).sendKeys(OtpNo);
		takeSS("loginotp.png");
		driver.findElement(otp).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		
		
		testlog = report.createTest("User Login");
		testlog.log(Status.PASS, "User is logged in Successfully!");
		takeSS("login.png");
	}
	
	public void updateloc()
	{
		testlog = report.createTest("Change Location");
		testlog.log(Status.PASS, "Location is Updated");
		takeSS("location.png");	
	}
	
	
	public void user_Homepage()
	{
//		System.out.println("User is in Home page.");
		testlog.log(Status.INFO, "User is in home page");
	}
	
	
	
}
