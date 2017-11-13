package com.core.page.task;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class DclTask extends AbstractPage {
	/**
	 * 待处理页面，点击“任务交办”。
	 */
	String rwjb_loc = "//*[@id=\"taskQueryDiv\"]/div[1]/div/div[1]/a/span/span[1]";

	public void clickTaskJiaoBan() {
		clickByXpath(rwjb_loc);
	}

	// 待处理页面，查询条件：标题
	String cxbiaoti_loc = "title";

	public void cxputInTitle(String tasktitle) {
		setInputByID(cxbiaoti_loc, tasktitle);
	}

	// 待处理页面，查询条件：点击查询
	String rwcx_loc = "//*[@id=\"queryTable\"]/table/tbody/tr/td[4]/div[1]";

	public void clickTaskChaXun() {
		clickByXpath(rwcx_loc);
	}

	// 待处理页面，列表，提取标题文本
	String rwbt_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[2]/div/span";

	public String getTaskBiaoTi() {
		return getWebElementByXpath(rwbt_loc).getText();
	}

	// 待处理页面，列表，点击编辑
	String bianji_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a";

	public void clickEditTask() {
		clickByXpath(bianji_loc);
	}

	// 待处理页面，列表，点击处理
	String chuli_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a";

	public void clickChuLi() {
		clickByXpath(chuli_loc);
	}

	// 待处理页面，列表，点击处理
	String chuli_loc2 = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a[1]";

	public void clickChuLi2() {
		clickByXpath(chuli_loc2);
	}

	// 待处理页面，列表，点击审核
	String shenhe_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a";

	public void clickTaskShenHe() {
		clickByXpath(shenhe_loc);
	}

	// 待处理页面，查询条件：任务编号
	String rwbh_loc = "taskNum";

	public void cxputInBiaoHao(String renwubianhao) {
		setInputByID(rwbh_loc, renwubianhao);
	}

	// 待处理页面，列表，点击处理
	String xiafa_loc = "//*[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a[2]";

	public void clickXiaFa() {
		clickByXpath(xiafa_loc);
	}

	/**
	 * 根据标题查询
	 * 
	 * @param tasktitle
	 * @return
	 */
	public String findbybiaoti(String tasktitle) {
		cxputInTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskChaXun();
		BrowserUtil.sleep(3);
		String newBiaoti = getTaskBiaoTi();
		return newBiaoti;
	}

	/**
	 * 根据任务编号查询
	 * 
	 * @param tasktitle
	 * @return
	 */
	public String findbybianhao(String taskbianhao) {
		cxputInBiaoHao(taskbianhao);
		BrowserUtil.sleep(1);
		clickTaskChaXun();
		BrowserUtil.sleep(3);
		String newBiaoti = getTaskBiaoTi();
		return newBiaoti;
	}

}
