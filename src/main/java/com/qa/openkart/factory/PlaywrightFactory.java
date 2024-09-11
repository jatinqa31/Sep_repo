package com.qa.openkart.factory;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightFactory {

	Playwright playwright; //these Lines are playwright reference, so that we can use this anywhere in playwrightfactory class 
	Browser browser; //reference
	BrowserContext browserContext; //reference
	Page page;
	 
	public Page InitBrowser(String Browsername) {
			LaunchOptions lp = new LaunchOptions();

			playwright = Playwright.create();
			
			switch(Browsername.toLowerCase()) {
				case "chromium":
					lp.setChannel("chromium");
					lp.setHeadless(false);
					//1.					
					browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
					//2. this is another way
					//Browser browser = playwright.chromium().launch(lp); 
					break;
				case "chrome":
					lp.setChannel("chrome");
					lp.setHeadless(false);
					browser = playwright.chromium().launch(lp);
//					BrowserContext Browser_contxt2 = browser2.newContext();
//					Browser_contxt2.newPage();
//					Page page=Browser_contxt2.newPage();
//					page.navigate("https://www.flipkart");
					break;
				case "safari":
					lp.setChannel("safari");
					lp.setHeadless(false);
					Playwright playwright2 = Playwright.create();
					Browser browser2 = playwright2.webkit().launch(lp);
					BrowserContext Browser_contxt = browser2.newContext();
					break;
				default:
					System.out.println("enter valid browser name :..");
					break;
			} 
			browserContext = browser.newContext();
			page = browserContext.newPage();
			page.navigate("http://localhost:8888/");
			return page;
		}
}