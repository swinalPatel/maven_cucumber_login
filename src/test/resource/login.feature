Feature: Logging into Guru99 banking website

In order to access bank website
As a Manager of bank 
I want to login

Scenario: Logging in Guru99 banking website

Given I go to "loginURL" on "Mozila"
And I enter "loginusername" as "mngr253411" 
And I enter "loginpassword" as "YdYsytA"
And I click on "LoginButton"
Then login should be "success"
And I click on "newcustomer"
And close the browser


	