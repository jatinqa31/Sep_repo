package com.qa.openkart.pages;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.microsoft.playwright.Page;

public class Loginpage {
	
	private Page page;// is pointing to null
	//concept of Encapsulation	
	
	//remember ---> Best Practice is that never write Assertions in page classes
	
	//1.String Locators - OR[Object Repository]
	
//	private String search = "input[name='search']";// using cs selector
//	private String search_icon = "div#search button";// using cs selector
//	private String searchPageHeader = "div# content h1";
//	private String search_box = "//textarea[@name='q']";// Xpath Locator
	private String username = "//input[@name='user_name']";// Xpath Locator
	private String password = "//input[@name='user_password']";// Xpath Locator
	private String signin_btn = "//input[@id='submitButton']";// Xpath Locator
	
	
	//2. page constructor: 
	
	public Loginpage(Page page) // this is called-->page class reference {
   	{
	  this.page = page; //initializing Page }}
   	} 			 
	  
	//3. page actions/methods:
	public String getHomePageTitle() {
		return page.title();
	}
	 
	//3. page actions/methods:
	public String getHomePageURL() {
		return page.url();
	}
	
	public void SignIn(String str1, String str2) 
	{ 
		try {
//		page.fill(search, productName);
//		page.click(search_icon);
//		return page.textContent(searchPageHeader);
//		//page.locator(searchPageHeader)
		page.fill(username, str1); 
		page.fill(password, str2);
		//page.textContent(username);//textContent method  of playwright is equal to text() method in selenium
		page.click(signin_btn);
			//ExtentTestManager.getTest().log(Status.PASS, "Entered text: \"" + str1 + "\" in " + username + " field");
		}	 
		catch(Exception e) {
			e.printStackTrace();
			//ExtentTestManager.getTest().log(Status.FAIL, "Entered text: \"" + " " + "\" in " + "" + " field");
		}
	} 
		
//	public void Enter_password(String productName) {
//		page.fill(search_box, "hello Jatin");
//		page.textContent(search_box);//textContent method  of playwright is equal to text() method in selenium
//		System.out.println("Title "+page.title());
//	}		
	 
	
	// page actions/methods:
	public void doSearch(String productName) {
//		page.fill(search, productName);
//		page.click(search_icon);
//		return page.textContent(searchPageHeader);
//		page.locator(searchPageHeader)
//		page.fill(search_box, "hello Jatin");
//		page.textContent(search_box);//textContent method  of playwright is equal to text() method in selenium
		System.out.println("Title "+page.title());
	}	
}