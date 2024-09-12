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
public class LoginPageTest extends base_class{
 
//    private static ExtentReports extent;
//    private static ExtentTest test;
	
//	PlaywrightFactory pf;
//	Page page;
	Loginpage loginpage;
	
//	@BeforeTest 
//	public void setup_2() { 
//		pf = new PlaywrightFactory(); 
//		page = pf.InitBrowser("chrome");   
//		homepage = new Homepage(page);
//		} 

    //private static ExtentReports extentReports;
//    private ExtentTest test;
//    Loginpage loginpage = new Loginpage(page);


//	   @BeforeClass
//	    public void setupClass() {
//		   
//	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("USER.DIR")+"//Results//PLaywright_POM_extent-report.html");
//	        extentReports = new ExtentReports();
//	        extentReports.attachReporter(htmlReporter);
//	    }

//	    @BeforeMethod
//	    public void setup() {
//	        test = extentReports.createTest("Example Test");
//	    }
	 
		@Test(priority =0, description ="Get Title of Login Page") 
		public void Fetch_title() { 
//			loginpage = new Loginpage(page);
			loginpage = new Loginpage(page);
			System.out.println("Title of page "+ loginpage.getHomePageTitle());
		}
 
		@Test(priority =1,dependsOnMethods="Fetch_title", description ="Login with Valid Credentials")
		public void Login() { 
//			loginpage = new Loginpage(page);
//			System.out.println("Page =  "+page);
			loginpage = new Loginpage(page);
			loginpage.SignIn("admin", "admin");
			//ExtentTestManager.getTest();
			//OLD TECHNIQUE USED EARLIER IN BIG_FRAMEWORK ExtentTestManager.getTest().log(Status.PASS, "Entered text: \"" + " "  + "\" in " +" " + " field");
		}      
}
