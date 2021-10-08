@home
Feature: Bigbasket Functionalities

@openurl
Scenario: To open bigbasket url
Given User is on browser
When open the url
Then user is in Home page

@changelocation
Scenario: change location
Given user is in BBHome page
When click on location and select city
Then location must be updated

@login
Scenario Outline: Login into bigbasket account
When click on login_Signup and enter registered "<mobile>" and otp
Then user is in Home page
Examples: 
  |mobile|
  |9923594565|

@searchItem
Scenario: search for items
Given user is in BBHome page
When enter item and click search button
Then list of items are displayed

@validateItems
Scenario: validate searched items 
When click on item and validate
Then user is able to add the searched item

#@addtoBasket
#Scenario: add items in the basket
#When from the list of items click on add button
#Then item should be added in the basket

@dealsOfTheWeek
Scenario: view deals of the week
Given user is in BBHome page
When clicked on DealsOfTheWeek button
And user select sort item option
Then list of items are displayed accordingly  

@viewOffers
Scenario: view items with offers
Given user is in BBHome page
When clicked on Offers button
Then list of items with offers are displayed

@validateBasket
Scenario: edit items in the basket
Given user is in BBHome page
When validate basket items
Then edit items in the basket

@buyItem
Scenario: buy the item
Given User is in the basket page
When user clicks on checkout button
And user selects address
And click on proceed to payment 
Then user is able to view payment options 
When user select payment mode 
Then place order button is displayed