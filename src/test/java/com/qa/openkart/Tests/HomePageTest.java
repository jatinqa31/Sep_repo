package com.qa.openkart.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.qa.openkart.factory.PlaywrightFactory;
import com.qa.openkart.pages.Homepage;
import com.qa.openkart.pages.Loginpage;
import com.qa.openkart.testbase.base_class;
import com.aventstack.extentreports.ExtentReports;

@Listeners(com.qa.openkart.utilities.ExtentReportsListener.class)
public class HomePageTest extends base_class{
 
//	PlaywrightFactory pf;
//	Page page;
	Homepage homepage;
	

//    private ExtentTest test;
//    Homepage homepage = new Homepage(page);
	
		@Test(priority =2, enabled=false,description ="Get Title of Home Page") 
		public void Operations_2() throws InterruptedException { 
			Thread.sleep(1000);
			homepage = new Homepage(page);
			System.out.println("Title of Home page "+ homepage.getHomePageTitle());
		} 
 
		@Test(priority =3,enabled=true, description ="Click on Leads Link on Home Page")
		public void Click_Leads() 
		{  
			homepage = new Homepage(page);
			page.waitForTimeout(3000); // Wait for 3 seconds
			homepage.Click_leads_Link();
			//ExtentTestManager.getTest();
			//OLD TECHNIQUE USED EARLIER IN BIG_FRAMEWORK ExtentTestManager.getTest().log(Status.PASS, "Entered text: \"" + " "  + "\" in " +" " + " field");
		}       
}
