package com.core.page.jichuxinxi;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class LiuDongRenKou extends AbstractPage {

	// 流动人员页查询条件：身份证号
	String cxShenfenzheng_loc = "cardNum";

	public void putInCardChaXun(String cardNO) {
		setInputByID(cxShenfenzheng_loc, cardNO);
	}

	// 流动人员页查询条件：点击查询
	String chaxun_loc = "btnSearch";

	public void clickChaXun() {
		clickByClassName(chaxun_loc);
	}

	// 流动人员页面，提取已经查询出来的身份证
	String cardnumber_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[5]/div";

	public String getCardNumber() {
		return getWebElementByXpath(cardnumber_loc).getText();
	}

	/**
	 * 流动人口：根据身份证号进行查询。
	 * 
	 * @param cardno
	 * @return
	 */
	public String findByCard(String cardno) {
		putInCardChaXun(cardno);
		BrowserUtil.sleep(1);
		clickChaXun();
		BrowserUtil.sleep(3);
		String newcard = getCardNumber();
		return newcard;
	}

}
