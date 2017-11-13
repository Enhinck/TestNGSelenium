package com.core.page.base;

import org.openqa.selenium.By;
import com.core.webdriver.CoreBrowser;

public interface Page {

	public String getUrl();

	public void setCoreBrowser(CoreBrowser coreBrowser);

	public void click(By id);

}
