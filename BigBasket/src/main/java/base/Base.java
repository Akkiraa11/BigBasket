package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base 
{

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentHtmlReporter exthtml;
	public static ExtentReports report;
	public static ExtentTest testlog;
	
	@BeforeSuite
	public void setUp()
	{
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		prop = new Properties();
		try 
		{
			prop.load(new FileInputStream("src/main/java/config/path.properties"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		exthtml = new ExtentHtmlReporter(prop.getProperty("reportloc"));
		report = new ExtentReports();
	 	report.attachReporter(exthtml);
	 	report.setSystemInfo("Host Name", "Capgemini"); 
	 	report.setSystemInfo("Environment", "Test Env");
	 	report.setSystemInfo("Username", "Akanksha");
	 	   
	 	exthtml.config().setDocumentTitle("BigBasket");
	 	exthtml.config().setReportName("BigBasket Functional Testing");
	 	exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
	 	exthtml.config().setTheme(Theme.STANDARD);
	}
	
	
	public void takeSS(String image)
	{
		
		try 
		{	
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(prop.getProperty("imageloc")+image));
			testlog.addScreenCaptureFromPath(prop.getProperty("imageloc")+image);
		} 
		catch (IOException e) 
		{
		
			e.printStackTrace();
		}
	}
		 	
	
	@AfterSuite
	public void tearDown()
	{
		report.flush();
		driver.quit();
	}

	
}
