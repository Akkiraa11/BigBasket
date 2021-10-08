package testSuiteBDD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasketandCheckout;
import pages.DealsOffer;
import pages.Home;
import pages.Search;


public class StepDef {
	
	Home h = new Home();
	DealsOffer d = new DealsOffer();
	Search s=new Search();
	BasketandCheckout b = new BasketandCheckout();
	
	    @Given("^User is on browser$")
	    public void user_is_on_browser() throws Throwable 
	    {
	    	
	    }

	    @When("^open the url$")
	    public void open_the_url() throws Throwable
	    {
	    	h.openUrl();
	    }

	    @Then("^user is in Home page$")
	    public void user_is_in_home_page() throws Throwable {
	     // h.navigateToHome();
	    	h.user_Homepage();
	    }
   
	    @Given("^user is in BBHome page$")
	    public void user_is_in_bbhome_page() throws Throwable 
	    {
	        h.navigateToHome();
	    }

// set location
	    
	    @When("^click on location and select city$")
	    public void click_on_location_and_select_city() throws Throwable 
	    {
	        h.location();
	    }

	    @Then("^location must be updated$")
	    public void location_must_be_updated() throws Throwable 
	    {
	        h.updateloc();
	    }
//login
	    @When("^click on login_Signup and enter registered \"([^\"]*)\" and otp$")
	    public void click_on_loginsignup_and_enter_registered_something_and_otp(String mobile) throws Throwable 
	    {
	    	h.signup(mobile);
	    }
	    
// searching an item
	    
	    @When("^enter item and click search button$")
	    public void enter_item_and_click_search_button() throws Throwable
	    {
	        s.search();
	    }

	    @Then("^list of items are displayed$")
	    public void list_of_items_are_displayed() throws Throwable 
	    {
	        s.srchResult();
	    }
	    
	    @When("^click on item and validate$")
	    public void click_on_item_and_validate() throws Throwable 
	    {
	        s.validateTitle();
	    }

	    @Then("^user is able to add the searched item$")
	    public void user_is_able_to_add_the_searched_item() throws Throwable 
	    {
	        s.addToBasket();
	        
	    }
// deals on the week page 
	    @When("^clicked on DealsOfTheWeek button$")
	    public void clicked_on_dealsoftheweek_button() throws Throwable
	    {
	       d.navigateToDoW();
	    }

	    @Then("^list of items are displayed accordingly  $")
	    public void list_of_items_are_displayed_accordingly() throws Throwable
	    {
	    	d.displayList();
	    }

	    @And("^user select sort item option$")
	    public void user_select_sort_item_option() throws Throwable 
	    {
	       d.sort();
	    }

//offers page
	    
	    @When("^clicked on Offers button$")
	    public void clicked_on_offers_button() throws Throwable 
	    {
	        d.navigateToOffers();
	    }

	    @Then("^list of items with offers are displayed$")
	    public void list_of_items_with_offers_are_displayed() throws Throwable
	    {
	        d.getOffers();
	    }

	  

	    @When("^validate basket items$")
	    public void validate_basket_items() throws Throwable 
	    {
	        b.validateBasket();
	    }

	    @Then("^edit items in the basket$")
	    public void edit_items_in_the_basket() throws Throwable 
	    {
	        b.editBasket();
	    }
	    
	    @Given("^User is in the basket page$")
	    public void user_is_in_the_basket_page() throws Throwable 
	    {
	    	b.user_basket_Page();
	    }

	    @When("^user clicks on checkout button$")
	    public void user_clicks_on_checkout_button() throws Throwable
	    {
	        b.user_Checkout_Page();
	    }
	    
	    @And("^user selects address$")
	    public void user_selects_address() throws Throwable
	    {
	        b.checkoutAdd();
	    }

	    @And("^click on proceed to payment $")
	    public void click_on_proceed_to_payment() throws Throwable
	    {
	        b.paybtn();
	    }
	    
	    @Then("^user is able to view payment options $")
	    public void user_is_able_to_view_payment_options() throws Throwable
	    {
	        b.payOptions();
	    }

	    @When("^user select payment mode $")
	    public void user_select_payment_mode() throws Throwable 
	    {
	        b.paymentMode();
	    }

	    @Then("^place order button is displayed$")
	    public void place_order_button_is_displayed() throws Throwable
	    {
	        b.placeorder();
	    }

	   
}
