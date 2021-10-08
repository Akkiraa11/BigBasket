package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import base.Base;

public class BasketandCheckout extends Base
{ 
	  By basket=By.xpath("//a[@qa='myBasket']");
	  By viewBasket = By.xpath("//button[@qa='viewBasketMB']");
	  By noOfItems=By.xpath("//span[@id='totalNumberOfCartItems']");
	  By addQ=By.xpath("(//button[@qa='incBaskQty'])[1]");
	  By reduceQ=By.xpath("(//button[@qa='decBaskQty'])[1]");
	  By remove=By.xpath("(//a[@qa='prodRemove'])[2]");
	  By check=By.xpath("//button[@id='checkout']");
	  By deliver=By.xpath("//div[@qa='addressBlogCKO']");
	  By payment = By.xpath("//button[@qa='confirmSlotBtn']");
	  By cash = By.xpath("//div[@id='512']");
	  By cod = By.xpath("//div[@id='495']");
	  By orderbtn = By.xpath("//div[@id='530']");
	  By payOpt = By.xpath("//div[@id='370']");
	  By alert= By.xpath("(//button[@class='btn btn-default'])[2]");
	
	
	
	  public void navigateToBasket()
	  {
		  driver.navigate().to("https://www.bigbasket.com/basket/?ver=1");
	  }
	  
	  public void validateBasket()
	  {	   	
		  Actions action = new Actions(driver);
		  action.moveToElement(driver.findElement(basket)).click().perform();
		  
		  WebElement count=driver.findElement(noOfItems);
		  testlog = report.createTest("Validate Basket");
			
		  if (count.getText().contains("00"))
		  {
//			  System.out.println("Your basket is empty. Start shopping now");
			  testlog.log(Status.INFO, "Your basket is empty. Start shopping now");
		  }
		  else
		  {
			  driver.findElement(viewBasket).click();
			  takeSS("Basket.png");
//				navigateToBasket();
		  }
//			System.out.println("basket is added");
		  	
	    }
		 
		public void editBasket() throws Exception
		{
			testlog = report.createTest("Edit items in Basket");
	        			
			driver.findElement(addQ).click();
			Thread.sleep(2000);
			driver.findElement(addQ).click();
			testlog.log(Status.PASS, " Item quantity increased");
			Thread.sleep(2000);
			takeSS("addQuantity.png");
			
			driver.findElement(reduceQ).click();
			testlog.log(Status.PASS, "Item quantity decreased");
			Thread.sleep(2000);
			takeSS("reduceQuantity.png");
			
			driver.findElement(remove).click();
			testlog.log(Status.PASS, "Item removed from the basket");
			Thread.sleep(2000);
			takeSS("deleteditem.png");
		}
		public void user_basket_Page()
		{
			String str = driver.getCurrentUrl();
			if(str.contains("/basket"))
			{
//				System.out.println("User is in basket page");
				testlog.log(Status.PASS, "User is in basket page");
				takeSS("userinBasket.png");
			}	 
		}
		 
		public void user_Checkout_Page()
		{
			driver.findElement(check).click();
			String str = driver.getCurrentUrl();
			if(str.contains("/checkout"))
			{
				System.out.println("User is in checkout page");
				testlog.log(Status.PASS, "User is in checkout page");
				takeSS("userinchkout.png");
			}			 
		}
		 
		public void checkoutAdd()
		{
			testlog = report.createTest("Checkout details");
			driver.findElement(deliver).click();
//			driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
//			 if(ExpectedConditions.alertIsPresent() != null)
//			 {		
//				 Alert a1 = driver.switchTo().alert();
//				 a1.accept();
//				
//			 }	
			testlog.log(Status.PASS, "Address Selected");
			takeSS("addSelected.png");
		 }
		 
		 public void payOptions()
		 {
			 if(driver.findElement(payOpt).isDisplayed())
			 {
//				 System.out.println("select payment mode.");
				 testlog.log(Status.INFO,"Payment Options are visible.");
			 }
		 }		 
		 
		 public void paybtn()
		 {
			 driver.findElement(payment).click();
			 takeSS("paymentbtn.png");
		 }
		 
		 public void paymentMode() throws InterruptedException
		 {
			 driver.findElement(cash).click();
			 Thread.sleep(1000);
			 driver.findElement(cod).click();
			 testlog.log(Status.INFO,"Payment mode selected.");
			 takeSS("paymentmode.png");
		 }
		 
		 public void placeorder()
		 {
			 if(driver.findElement(orderbtn).isDisplayed())
			 {
				 System.out.println("Order is placed!");
				 testlog = report.createTest("Order is placed!...");
				 takeSS("orderplaced.png");
			 }
		 }
}
