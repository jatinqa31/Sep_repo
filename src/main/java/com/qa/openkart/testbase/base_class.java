package com.qa.openkart.testbase;
import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.qa.openkart.factory.PlaywrightFactory;
import com.qa.openkart.pages.Homepage;
import com.qa.openkart.pages.Loginpage;
import com.qa.openkart.utilities.Utilities;
import com.aventstack.extentreports.service.ExtentTestManager;

public class base_class {

	public PlaywrightFactory pf;
	public static Page page;
	public Homepage homepage;
	public Loginpage loginpage;;
	
	//-----------------------------------
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
	
	
    @BeforeSuite(alwaysRun = true)
    public void setup() 
	{ 	
    	//counter=counter+1;
		pf = new PlaywrightFactory(); 
		page = pf.InitBrowser("chrome"); 
		loginpage = new Loginpage(page);
		//System.out.println("Counter = "+counter);
	}

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        // Stop tracing and export the trace
        page.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
   
   
   @BeforeTest
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos")).setRecordVideoSize(1280, 720));
    }
   
//    @AfterTest
//    public static void tearDown() {
//        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
//        browser.close();
//        playwright.close();
//    }
	  
}
 