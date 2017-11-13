package com.core.webdriver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.page.base.Page;

public class CoreBrowser implements WebDriver {
	
	private WebDriver webDriver;

	public CoreBrowser(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		webDriver.close();

	}
	
	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return webDriver.findElement(arg0);
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return webDriver.findElements(arg0);
	}

	@Override
	public void get(String arg0) {
		// TODO Auto-generated method stub
		webDriver.get(arg0);
		webDriver.manage().window().maximize();
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return webDriver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return webDriver.getPageSource();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return webDriver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return webDriver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return webDriver.getWindowHandles();
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return webDriver.manage();
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return webDriver.navigate();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		webDriver.quit();
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return webDriver.switchTo();
	}

	public void open(Page page) {
		page.setCoreBrowser(this);
		webDriver.get(page.getUrl());
		webDriver.manage().window().maximize();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

}
