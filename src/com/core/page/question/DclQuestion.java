package com.core.page.question;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class DclQuestion extends AbstractPage {

	/**
	 * 待处理问题页面，点击上报按钮
	 */
	String sBao_loc = "//*[@id=\"queryDiv\"]/div[1]/div/div[1]/a/span/span[1]";

	public void clickSBao() {
		getWebElementByXpath(sBao_loc).click();
	}

	/**
	 * 点击查询按钮
	 */
	String ChaXun_loc = "btnSearch";

	public void clickChaXun() {
		getWebElementByClassName(ChaXun_loc).click();
	}

	// 查询条件：问题编号
	String wtbh_loc = "number";

	public void putWenTiBiaoHao(String wentibianhao) {
		setInputByID(wtbh_loc, wentibianhao);
	}

	/**
	 * 点击高级查询按钮
	 */
	String gjChaXun_loc = "btnAdvanced";

	public void clickGjChaXun() {
		getWebElementByClassName(gjChaXun_loc).click();
	}

	/**
	 * 进入高级查询页面,标题文本框
	 */
	String titleGJ_loc = "title";

	public void PutInTitleGJ(String title) {
		setInputByID(titleGJ_loc, title);
	}

	/**
	 * 进入高级查询页面，点击提交按钮
	 */
	String tiJiaoGJ_loc = "btnSubmit";

	public void clickTiJiaoGJ() {
		getWebElementByClassName(tiJiaoGJ_loc).click();
	}

	/**
	 * 待处理问题列表：问题编号，标题，编辑
	 */
	String wtBianHao_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[2]/div";

	public String getWtBianHao() {
		return getWebElementByXpath(wtBianHao_loc).getText();
	}

	String biaoTi_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[3]/div/span";

	public String getWtBiaoTi() {
		return getWebElementByXpath(biaoTi_loc).getText();
	}

	String bianJi_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a";

	public void clickWtBianJi() {
		getWebElementByXpath(bianJi_loc).click();
	}

	/**
	 * 镇街中心登录，在待处理页面，点击“派发”按钮
	 */
	String paifa_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a[2]";

	public void clickPaiFa() {
		getWebElementByXpath(paifa_loc).click();
	}

	/**
	 * 义乌中心派发给镇街中心，由镇街中心登录，在待处理页面，点击“派发”按钮
	 */
	String paifa_loc2 = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a[1]";

	public void clickPaiFa2() {
		getWebElementByXpath(paifa_loc2).click();
	}

	/**
	 * 网格长，职能办，镇街职能办 在待处理页面，点击“处理”按钮
	 */
	String chuli_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a";

	public void clickChuLi() {
		getWebElementByXpath(chuli_loc).click();
	}

	/**
	 * 镇街中心 在待处理页面，点击“处理”按钮
	 */
	String zjzxCl_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a[2]";

	public void clickZjzxChuLi() {
		getWebElementByXpath(zjzxCl_loc).click();
	}

	/**
	 * 义乌中心派发给镇街中心，由镇街中心 登录，在待处理页面，点击“处理”按钮
	 */
	String zjzxCl_loc2 = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a";

	public void clickZjzxChuLi2() {
		getWebElementByXpath(zjzxCl_loc2).click();
	}

	/**
	 * 待处理问题页面，镇街中心，点击登记按钮
	 */
	String zjdj_loc = "//*[@id=\"queryDiv\"]/div[1]/div/div[1]/a[2]/span/span[1]";

	public void clickZJDengji() {
		getWebElementByXpath(zjdj_loc).click();
	}

	/**
	 * 待处理问题页面，义乌中心，点击登记按钮
	 */
	String ywdj_loc = "//*[@id=\"queryDiv\"]/div[1]/div/div[1]/a/span/span[1]";

	public void clickYWDengji() {
		getWebElementByXpath(ywdj_loc).click();

	}

	/**
	 * 区县职能办 在待处理页面，点击“处理”按钮
	 */
	String qxznbCl_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a";

	public void clickQuXznbChuLi() {
		getWebElementByXpath(qxznbCl_loc).click();
	}

	/**
	 * 区县职能办 在待处理页面，点击“处理”按钮
	 */
	String ywCl_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[12]/div/a[2]";

	public void clickYiWuChuLi() {
		getWebElementByXpath(ywCl_loc).click();
	}

	/**
	 * 待处理问题页面， 根据标题查询
	 * 
	 * @param title
	 */
	public String findBybiaoti(String title) {
		clickGjChaXun();
		switchTo("advQueryWinWindowFrame");
		BrowserUtil.sleep(3);
		PutInTitleGJ(title);
		BrowserUtil.sleep(3);
		clickTiJiaoGJ();
		switchTodefaultContent();
		BrowserUtil.sleep(3);
		String biaoti = getWtBiaoTi();
		return biaoti;
	}

	public String findByWenTiBianHao(String wtbiaohao) {
		putWenTiBiaoHao(wtbiaohao);
		BrowserUtil.sleep(1);
		clickChaXun();
		BrowserUtil.sleep(5);
		String number = getWtBianHao();
		return number;
	}

}
