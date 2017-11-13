package com.core.page.jichuxinxi;

import org.openqa.selenium.WebElement;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class ZhongDianPeople extends AbstractPage {

	// 重点人员>>吸毒人员页面，查询条件：身份证号
	String cxShenfenzheng_loc = "cardNum";

	public void putInCardChaXun(String cardNO) {
		setInputByID(cxShenfenzheng_loc, cardNO);
	}

	// 重点人员>>吸毒人员页面，查询条件：点击查询
	String chaxun_loc = "btnSearch";

	public void clickChaXun() {
		clickByClassName(chaxun_loc);
	}

	// 重点人员>>吸毒人员页面，获取已经查询出来的身份证
	String cardnumber_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[4]/div";

	public String getCardNumber() {
		WebElement element = null;
		try {
			element = getWebElementByXpath(cardnumber_loc);
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 重点人员>>吸毒人员，根据身份证号进行查询
	 * 
	 * @param cardno
	 * @return
	 */
	public String findbyCard(String cardno) {
		putInCardChaXun(cardno);
		BrowserUtil.sleep(1);
		clickChaXun();
		BrowserUtil.sleep(3);
		String newcard = getCardNumber();
		return newcard;

	}

}
