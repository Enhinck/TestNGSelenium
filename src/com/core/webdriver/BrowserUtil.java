package com.core.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtil {

	public static CoreBrowser getChrome(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver webDriver = new ChromeDriver();
		//等待页面加载时间 2秒
		//webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		//全局等待元素加载 3秒
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		CoreBrowser  coreBrowser=new CoreBrowser(webDriver);
		return coreBrowser;
	}
	
	public static void close(CoreBrowser  coreBrowser){
		coreBrowser.close();
	}
	
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
