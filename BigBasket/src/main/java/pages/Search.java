package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class Search extends Home
{

	By searchbox=By.xpath("(//input[@placeholder='Search for Products..'])[1]");
	By itemtitle=By.xpath("//h1[@class='GrE04']");
	By add=By.xpath("//div[@class='Cs6YO rippleEffect']");
	By item= By.xpath("(//div[@qa='product_name'])[1]");
	By searchResult = By.xpath("//h2[@qa='pageName']");	
	
	public void search() throws Exception 
	{
		WebElement p =driver.findElement(searchbox);
		p.click();
		Thread.sleep(1000);	
		p.sendKeys("Apple");
//		Thread.sleep(2000);
		p.sendKeys(Keys.ENTER);
		Thread.sleep(2000);	
	}
	
	public void srchResult() throws Exception
	{
		System.out.println("Searched Results: "+driver.findElement(searchResult).getText());
		Thread.sleep(3000);
		
		testlog = report.createTest("Search Item");
		testlog.log(Status.PASS, "Search results found");
		takeSS("searchItemResult.png");
		
		driver.findElement(item).click();	
		Thread.sleep(2000);
	}
	
	public void validateTitle() throws Exception
	{
		String iTitle = driver.findElement(itemtitle).getText();
		
		testlog = report.createTest("Validate Item");
		testlog.log(Status.INFO, "Search results found");
		
		
		if(iTitle.contains("Apple"))
		{
			//System.out.println("item found...");
			testlog.log(Status.PASS, "Item found.");
		}
		else
		{
			System.out.println("item not found");
			testlog.log(Status.FAIL, "Item not found.");
		}
		Thread.sleep(3000);
	}
		
	public void addToBasket() throws Exception
	{
		driver.findElement(add).click();
		Thread.sleep(2000);
	}
}
