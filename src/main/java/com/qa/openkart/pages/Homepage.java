package com.qa.openkart.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Homepage {
	
	private Page page;// is pointing to null
	//concept of Encapsulation	
	
	//remember ---> Best Practice is that never write Assertions in page classes
	
	//1.String Locators - OR[Object Repository]
	
	private String Leads="//a[text()='Leads']//parent::td[@class='tabUnSelected']";
	
	
	// Locator for a list of products
    private Locator lead_List_table; //=page.locator("//table[@class='lvt small']");
    private Locator lead_chk;
    private Locator lead_List_tr;
    
    
    //this is not possible in Playwright==>>	private List<String> Leads_table = Arrays.asList("0","//table[@class='lvt small']");

//	private List<String> Leads_table= Arrays.asList("Apple", "Banana", "Cherry", "Date");
	
	
	//2. page constructor: 
	//in constructor this is how locators are initialized/defined
	public Homepage(Page page) // this is called-->page class reference {
	{
		 this.page = page; // initializing Page }}
		 this.lead_List_tr = page.locator("//table[@class='lvt small']//tr");  // CSS selector for the list of products
		 this.lead_List_table=page.locator("//table[@class='lvt small']");
	} 			 
	  
	 
	//3. page actions/methods:
	public String getHomePageTitle() {
		return page.title();
	}
	
	//3. page actions/methods:
	public void Click_leads_Link() {
		//System.out.println("Leads "+Leads);
		page.click(Leads);
	}  	
	
	// Method to click on Product Name Checkbox
    public void click_ProductNames_chkbox() {
       System.out.println("ListCount = "+lead_List_tr.count());
        for (int i = 3; i < lead_List_tr.count()+2; i++) {
           
        	Locator Td = lead_List_table.locator("//tr["+i+"]//td[1]//input");
        	System.out.println(" +++ "+ Td);
        	Td.click();
        }
    }
	
	
}