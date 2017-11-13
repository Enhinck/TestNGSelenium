package com.core.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.webdriver.CoreBrowser;

public abstract class AbstractPage implements Page {
	protected CoreBrowser coreBrowser;

	public AbstractPage() {
		super();
	}

	@Override
	public String getUrl() {
		//return "http://192.168.11.122:8080/grid";
		 return "http://60.191.115.33:21808/grid/login";
	}

	@Override
	public void setCoreBrowser(CoreBrowser coreBrowser) {
		this.coreBrowser = coreBrowser;
	}

	@Override
	public void click(By id) {
		WebElement webElement = coreBrowser.findElement(id);
		webElement.click();
	}

	public void clickById(String id) {
		WebElement webElement = coreBrowser.findElement(By.id(id));
		webElement.click();
	}

	public void clickByName(String name) {
		WebElement webElement = coreBrowser.findElement(By.name(name));
		webElement.click();
	}

	public void clickByXpath(String xpath) {
		WebElement webElement = coreBrowser.findElement(By.xpath(xpath));
		webElement.click();
	}
	public void clickByClassName(String className) {
		WebElement webElement = coreBrowser.findElement(By.className(className));
		webElement.click();
	}

	public WebElement getWebElementByClassName(String className) {
		return coreBrowser.findElement(By.className(className));
	}

	public WebElement getWebElementByXpath(String xpath) {
		return coreBrowser.findElement(By.xpath(xpath));
	}

	public void setInputByName(String name, String value) {
		WebElement webElement = coreBrowser.findElement(By.name(name));
		webElement.clear();
		webElement.sendKeys(value);
	}

	public void setInputByID(String id, String value) {
		WebElement webElement = coreBrowser.findElement(By.id(id));
		webElement.clear();
		webElement.sendKeys(value);
	}

	public void setInputByXpath(String xpath, String path) {
		WebElement webElement = coreBrowser.findElement(By.xpath(xpath));
		webElement.clear();
		webElement.sendKeys(path);
	}

	/**
	 * 
	 * waitForLoad 等待某个元素显示
	 * 
	 * @param locator
	 * @param timeOut
	 * @author Enhinck
	 * @date 2017年7月3日
	 */
	public void waitForLoad(final By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(coreBrowser, timeOut); // timeOut为等待时间，单位秒
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				boolean loadcomplete = d.findElement(locator).isDisplayed();
				return loadcomplete;
			}
		});
	}

	public String executeScript(String javascript) {
		return (String) ((JavascriptExecutor) coreBrowser.getWebDriver()).executeScript(javascript);
	}

	/**
	 * switchTo Select a frame by its name or ID.
	 * 
	 * @param nameOrId
	 * @author Enhinck
	 * @date 2017年7月3日
	 */
	public void switchTo(String nameOrId) {
		// TODO Auto-generated method stub
		coreBrowser.switchTo().frame(nameOrId);
	}

	/**
	 * switchTo Selects either the first frame on the page, or the main document
	 * when a page contains iframes.
	 * 
	 * @author Enhinck
	 * @date 2017年7月3日
	 */
	public void switchTodefaultContent() {
		// TODO Auto-generated method stub
		coreBrowser.switchTo().defaultContent();
	}

	public void switchPage(Page page) {
		page.setCoreBrowser(coreBrowser);
	}

	public void switchToAlert() {
		coreBrowser.switchTo().alert();
	}

}
