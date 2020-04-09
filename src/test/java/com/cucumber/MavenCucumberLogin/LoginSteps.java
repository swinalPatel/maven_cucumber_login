package com.cucumber.MavenCucumberLogin;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginSteps {

	WebConnector Selenium = new WebConnector();

	@Given("^I go to \"([^\"]*)\" on \"([^\\\"]*)\"$")
	public void  I_go_to_(String URL, String browser) throws Exception
	{
		System.out.println("I go to "+ URL +" on "+ browser+ " ");
		Selenium.openBrowser(browser);
		Selenium.navigate(URL);
	}
	
	@And("^I enter \"([^\\\"]*)\" as \"([^\\\"]*)\"$")
	public void I_enter_username_password(String object, String text) throws Exception
	{
		System.out.println("I enter "+ object +" as "+ text +" ");
		Selenium.field(object, text);
		
	}
	
	@And("^I click on \"([^\\\"]*)\"$")
	public void I_click_on(String object) throws Exception
	{
		System.out.println("I click on "+ object +" ");
		Selenium.click(object);
	}
	
	@Then("^login should be \"([^\\\"]*)\"$")
	public void login_should_be(String expectedResult) throws Exception
	{
		System.out.println("login should be "+ expectedResult +" ");
		String actualResult = null;
		boolean result = Selenium.isElementPresent("searchText");
		if(result) 
			actualResult = "success";
		else 
			actualResult = "Unsuccess";
		Assert.assertEquals(expectedResult, actualResult);
		}
	
	@And("^close the browser$")
	public void close_the_browser() throws Exception
	{
		Selenium.close_Browser();
		System.out.println("closing the browser");
	}
}
