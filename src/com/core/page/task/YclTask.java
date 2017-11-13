package com.core.page.task;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class YclTask extends AbstractPage {

	// 已处理任务页面，查询条件：标题
	String ybcxtitle_loc = "title";

	public void putInTitle(String biaoti) {
		setInputByID(ybcxtitle_loc, biaoti);
	}

	// 已处理任务页面，查询条件：点击查询
	String ybtaskChaXun_loc = "btnSearch";

	public void clickYBTaskChaXun() {
		clickByClassName(ybtaskChaXun_loc);
	}

	// 已处理任务页面，列表，提取标题
	String ybbiaoti_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[2]/div/span";

	public String getYbtaskBiaoTi() {
		return getWebElementByXpath(ybbiaoti_loc).getText();
	}

	// 待处理页面，列表，提取标题文本
	String rwbh_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div";

	public String getTaskBianHao() {
		return getWebElementByXpath(rwbh_loc).getText();
	}

	/**
	 * 已处理任务页面，根据任务标题进行查询
	 * 
	 * @param tasktitle
	 */
	public String findybtaskByBiaoTi(String tasktitle) {
		putInTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickYBTaskChaXun();
		BrowserUtil.sleep(3);
		String newybbiaoti = getYbtaskBiaoTi();
		return newybbiaoti;
	}

	/**
	 * 已处理任务页面，根据任务标题进行查询,提取任务编号
	 * 
	 * @param tasktitle
	 */
	public String findybtaskByBiaoTi2(String tasktitle) {
		putInTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickYBTaskChaXun();
		BrowserUtil.sleep(3);
		String newybbianhao = getTaskBianHao();
		return newybbianhao;
	}

}
