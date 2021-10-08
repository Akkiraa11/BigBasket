package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import base.Base;

public class DealsOffer extends Base 
{
	By deals=By.xpath("(//img[@class='img-responsive'])[23]");
	By sort=By.id("sel1");
	By allproducts=By.xpath("//div[@qa='product_name']");
	By off = By.xpath("//div[@ng-if=\"vm.selectedProduct.dis_t == 'P' && vm.selectedProduct.dis_val != '0.00'\"]");
	
	public void navigateToDoW() throws Exception
	{
		driver.findElement(deals).click();
		Thread.sleep(5000);
		
		testlog = report.createTest("Deals of the week");
		testlog.log(Status.INFO, "Deals of the Week page is displayed");
		takeSS("dow.png");
		
		 driver.findElement(By.xpath("(//button[@qa='add'])[3]")).click();
		 Thread.sleep(1000);
		 System.out.println("Item added from deals of the week");
		 testlog.log(Status.INFO, "Item added from deals of the week");
	}

   public void popularity() throws Exception
   {
        new Select(driver.findElement(sort)).selectByValue("string:popularity");
        Thread.sleep(5000);
        takeSS("sortPop.png");
        List <WebElement> pop= driver.findElements(allproducts);
        
        testlog = report.createTest("Sort By Popularity");
		testlog.log(Status.INFO, "Items sorted by Popularity --> : ");
        //System.out.println("Items sorted by Popularity --> : ");
        for (int i=0; i<5;i++)
        {
        	//System.out.println(i+1+" : "+pop.get(i).getText());
        	testlog.log(Status.INFO, i+1+" : "+pop.get(i).getText());
        } 
    }  
            
    public void pricelth() throws Exception
    {
    	new Select(driver.findElement(sort)).selectByValue("string:pricelth");
        Thread.sleep(5000);
        takeSS("sortPlth.png");
        List <WebElement> pricelth= driver.findElements(allproducts);
        
        testlog = report.createTest("Sort By Price Low to High");
        testlog.log(Status.INFO, "Items sorted by Price Low to High --> : ");
//        System.out.println("Items sorted by Price Low to High --> : ");
        for (int i=0; i<5;i++)
        {
            
//            System.out.println(i+1+" : "+pricelth.get(i).getText());
        	testlog.log(Status.INFO, i+1+" : "+pricelth.get(i).getText());
        }
    }

    public void pricehtl() throws Exception
    {
        new Select(driver.findElement(sort)).selectByValue("string:pricehtl");
        Thread.sleep(5000);
        takeSS("sortPhtl.png");
        List <WebElement> pricehtl= driver.findElements(allproducts);
        
        testlog = report.createTest("Sort By Price Low to High");
        testlog.log(Status.INFO, "Items sorted by Price High to Low --> : ");
//        System.out.println("Items sorted by Price High to Low--> : ");
        
        for (int i=0; i<5;i++)
    	{
//          System.out.println(i+1+" : "+pricehtl.get(i).getText()); 
            testlog.log(Status.INFO, i+1+" : "+pricehtl.get(i).getText());
    	}
    }

     public void alpha() throws Exception
     {
         new Select(driver.findElement(sort)).selectByValue("string:alpha");
         Thread.sleep(5000);
         takeSS("sortAlpha.png");
         List <WebElement>alpha= driver.findElements(allproducts);
//         System.out.println("Items sorted by Alphabetical order --> : ");
         
         testlog = report.createTest("Sort By Alphabetical order");
         testlog.log(Status.INFO, "Items sorted by Alphabetical order --> : ");
         
         for (int i=0; i<5;i++)
         {
//            System.out.println(i+1+" : "+alpha.get(i).getText());
              testlog.log(Status.INFO, i+1+" : "+alpha.get(i).getText());
         }
     }

    public void savinghtl() throws Exception
    {
    	 new Select(driver.findElement( sort)).selectByValue("string:savinghtl");
    	 Thread.sleep(5000);
    	 takeSS("sortPhtl.png");
    	 List <WebElement> savinghtl= driver.findElements(allproducts);
//    	 System.out.println("Items sorted by Saving Rupee High to Low --> : ");
    	 testlog = report.createTest("Sort By Saving Rupee High to Low");
         testlog.log(Status.INFO, "Items sorted by Saving Rupee High to Low --> : ");
         
    	 for (int i=0; i<5;i++)
    	 {
//    		 System.out.println(i+1+" : "+savinghtl.get(i).getText());
    		 testlog.log(Status.INFO, i+1+" : "+savinghtl.get(i).getText());
    	 }
    }
   
    public void  savinglth () throws Exception
    {
    	new Select(driver.findElement(sort)).selectByValue("string:savinglth");
    	Thread.sleep(5000);
    	 takeSS("sortPlth.png");
    	List <WebElement> savinglth= driver.findElements(allproducts);
//    	System.out.println("Items sorted by Saving Rupee Low to High --> : ");
    	testlog = report.createTest("Sort By Saving Rupee Low to High");
        testlog.log(Status.INFO, "Items sorted by Saving Rupee Low to High --> : ");
        
    	for (int i=0; i<5;i++)
    	{
//    		System.out.println(i+1+" : "+savinglth.get(i).getText());
    		testlog.log(Status.INFO, i+1+" : "+savinglth.get(i).getText());
    	}
    }


    public void offers() throws Exception
    {
    	new Select(driver.findElement(sort)).selectByValue("string:offers");
    	Thread.sleep(5000);
    	 takeSS("sortoffers.png");
    	List <WebElement> offers= driver.findElements(allproducts);
//    	System.out.println("Items sorted by Offers --> : ");
    	
    	testlog = report.createTest("Sort By Saving Rupee Low to High");
        testlog.log(Status.INFO, "Items sorted by Saving Rupee Low to High --> : ");
    	
    	for (int i=0; i<5;i++)
    	{
//    		System.out.println(i+1+" : "+offers.get(i).getText());
    		testlog.log(Status.INFO, i+1+" : "+offers.get(i).getText());
        }
     }
    
    public void sort() throws Exception
    {
    	popularity();
    	Thread.sleep(2000);
    	pricehtl();
    	Thread.sleep(2000);
    	pricehtl();
    	Thread.sleep(2000);
    	alpha();
    	Thread.sleep(2000);
//    	driver.findElement(By.xpath("(//button[@qa='add'])[5]")).click();
    	savinglth();
    	Thread.sleep(2000);
    	savinghtl();
    	Thread.sleep(2000);
    	offers();
    	Thread.sleep(2000);
    }
    
    public void navigateToOffers() throws Exception
	{
    	testlog = report.createTest("View Offers");
    	
    	 driver.findElement(By.xpath("//a[@class='bb-offers-link']")).click();
	     Thread.sleep(5000);   
	     takeSS("offers.png");
	     driver.findElement(By.xpath("(//button[@qa='add'])[2]")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("(//button[@qa='add'])[7]")).click();
	     Thread.sleep(1000);
	     System.out.println("item added");
	}
    
    public void getOffers() throws Exception
    {
    	List <WebElement> proList= driver.findElements(allproducts);
    	List <WebElement> offer= driver.findElements(off);
//    	System.out.println("Offers on the items --> : ");
    	
        testlog.log(Status.INFO, "Offers on the items --> : ");
    	
    	for (int i=0; i<5;i++)
    	{
//    		System.out.println((i+1)+" - "+proList.get(i).getText()+" :  "+offer.get(i).getText());
    		testlog.log(Status.INFO,(i+1)+" - "+proList.get(i).getText()+" :  "+offer.get(i).getText());
    	}
    	Thread.sleep(5000);
    }
    
	public void offer_itemAdded()
	{
//		System.out.println("User is in Home page.");
		testlog.log(Status.INFO, "User is in home page");
	}
	public void itemAdded()
	{
//		System.out.println("User is in Home page.");
		testlog.log(Status.INFO, "User is in home page");
	}
	
	public void displayList()
	{
//		System.out.println("User is in Home page.");
		testlog.log(Status.INFO, "List of item are displayed as per sorting order.");
	}
}
