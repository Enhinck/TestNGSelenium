package com.core.page.jichuxinxi;

import org.openqa.selenium.WebElement;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class HuJiRenKou extends AbstractPage {

	/**
	 * 户籍人员页面，点击“新增”
	 */
	String xinzeng_loc = "//*[@id=\"queryDiv\"]/div[1]/div/div[1]/a[1]/span";

	public void clickAddPeople() {
		clickByXpath(xinzeng_loc);
	}

	/**
	 * 户籍人员页面，点击“查看”
	 */
	String chakan_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr/td[9]/div/a[1]";

	public void clickChaKanPeople() {
		clickByXpath(chakan_loc);
	}

	/**
	 * 户籍人员页面，点击“编辑”
	 */
	String bianji_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr/td[9]/div/a[2]";

	public void clickEditPeople() {
		clickByXpath(bianji_loc);
	}

	// 户籍人员页查询条件：点击迁出
	String qianchu_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr/td[9]/div/a[3]";

	public void clickQianChu() {
		clickByXpath(qianchu_loc);
	}

	/**
	 * 户籍人员页面，点击“常转流”
	 */
	String changzhuanliu_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr/td[9]/div/a[5]";

	public void clickChangZhuanLiu() {
		clickByXpath(changzhuanliu_loc);
	}

	/**
	 * 户籍人员页面，点击“删除”
	 */
	String shanchu_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr/td[9]/div/a[6]";

	public void clickShanChu() {
		clickByXpath(shanchu_loc);
	}

	// 户籍人员页查询条件：身份证号
	String cxShenfenzheng_loc = "cardNum";

	public void putInCardChaXun(String cardNO) {
		setInputByID(cxShenfenzheng_loc, cardNO);
	}

	// 户籍人员页查询条件：点击查询
	String chaxun_loc = "btnSearch";

	public void clickChaXun() {
		clickByClassName(chaxun_loc);
	}

	// 户籍人员页面，提取已经查询出来的身份证
	String cardnumber_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[4]/div";

	/*
	 * public String getCardNumber() { return
	 * getWebElementByXpath(cardnumber_loc).getText(); }
	 */

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
	 * 户籍人员页面，根据身份证号进行查询。
	 * 
	 * @param cardno
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
