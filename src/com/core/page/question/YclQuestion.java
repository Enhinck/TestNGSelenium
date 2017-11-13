package com.core.page.question;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class YclQuestion extends AbstractPage{

	/**
	 * 已处理问题列表：编号，标题
	 */
	String bianhao_loc="html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div";
	public String getWtBianHao(){
		return getWebElementByXpath(bianhao_loc).getText();
	}
	
	String biaoTi_loc="//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[2]/div/span";
	public String getWtBiaoTi(){
		return getWebElementByXpath(biaoTi_loc).getText();
	}
	/**
	 * 点击高级查询按钮
	 */
	String gjChaXun_loc="btnAdvanced";
	public void clickGjChaXun(){
		getWebElementByClassName(gjChaXun_loc).click();
	}
	/**
	 * 进入高级查询页面,标题文本框
	 */
	String titleGJ_loc="title";
	public void PutInTitleGJ(String title){
		setInputByID(titleGJ_loc,title);
	}
	/**
	 * 进入高级查询页面，点击提交按钮
	 */
	String tiJiaoGJ_loc="btnSubmit";
	public void clickTiJiaoGJ(){
		getWebElementByClassName(tiJiaoGJ_loc).click();
	}
	
	
	public String findYbBybiaoti(String title) {
		// TODO Auto-generated method stub
		BrowserUtil.sleep(3);
		clickGjChaXun();
		switchTo("advQueryWinWindowFrame");
		BrowserUtil.sleep(1);
		PutInTitleGJ(title);
		BrowserUtil.sleep(1);
		clickTiJiaoGJ();
		switchTodefaultContent();
		BrowserUtil.sleep(5);
		String biaoti=getWtBiaoTi();
		return biaoti;
	}
		
	
}
