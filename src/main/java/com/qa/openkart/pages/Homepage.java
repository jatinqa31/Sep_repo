package com.qa.openkart.pages;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.microsoft.playwright.Page;

public class Homepage {
	
	private Page page;// is pointing to null
	//concept of Encapsulation	
	
	//remember ---> Best Practice is that never write Assertions in page classes
	
	//1.String Locators - OR[Object Repository]
	
	private String Leads="//a[text()='Leads']//parent::td[@class='tabUnSelected']";
	
	//2. page constructor: 
	
	public Homepage(Page page) // this is called-->page class reference {
	{
		 this.page = page; // initializing Page }}
		 System.out.println("page Title = "+page.title());
	} 			 
	  
	 
	//3. page actions/methods:
	public String getHomePageTitle() {
		return page.title();
	}
	
	//3. page actions/methods:
	public void Click_leads_Link() {
		page.click(Leads);
	} 


}