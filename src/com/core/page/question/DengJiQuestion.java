package com.core.page.question;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class DengJiQuestion extends AbstractPage {
	/**
	 * 镇街中心登录，登记新增页面:标题
	 */
	String djtitle_loc = "title";

	public void putInDjTitle(String djtitle) {
		setInputByID(djtitle_loc, djtitle);
	}

	// 镇街中心登录，登记新增页面:一级类
	String yjl_loc01 = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[3]/td[2]/span/span/span";
	String yjl_loc02 = "//*[@id=\"_easyui_combobox_i3_1\"]";

	public void clickYiJiLei() {
		clickByXpath(yjl_loc01);
		clickByXpath(yjl_loc02);
	}

	// 镇街中心登录，登记新增页面:二级类
	String ejl_loc01 = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[3]/td[4]/span/span/span";
	String ejl_loc02 = "//*[@id=\"_easyui_combobox_i6_0\"]";

	// *[@id="AdvanceDiv"]/div[1]/div/table/tbody/tr[3]/td[4]/span/span/span
	// *[@id="_easyui_combobox_i5_0"]
	public void clickErJiLei() {
		clickByXpath(ejl_loc01);
		clickByXpath(ejl_loc02);
	}

	// 镇街中心登录，登记新增页面:事发地址
	String sfdz_loc = "address";

	public void putInShiFaDiZhi(String shifadizhi) {
		setInputByID(sfdz_loc, shifadizhi);
	}

	// 镇街中心登录，登记新增页面:问题描述
	String wtms_loc = "content";

	public void putInWenTiMiaoShu(String wentimiaoshu) {
		setInputByID(wtms_loc, wentimiaoshu);
	}

	// 镇街中心登录，登记新增页面:上传附件
	String scfj_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[10]/td[2]/div[1]/div/form/input";

	public void putInFuJian(String scfujian) {
		setInputByXpath(scfj_loc, scfujian);
	}

	// 镇街中心登录，登记新增页面:关联人
	String xzglr_loc01 = "//*[@id=\"linkedPeople\"]";
	String xzglr_loc02 = "//*[@id=\"datagrid-row-r1-2-0\"]/td[1]/div/input";
	String xzglr_loc03 = "//*[@id=\"peopleDiv\"]/div[4]/div/div/input[1]";

	public void clickXzRenYuan() {
		clickByXpath(xzglr_loc01);
	}

	public void clickRenYuan() {
		clickByXpath(xzglr_loc02);
	}

	public void clickGlryTiJiao() {
		clickByXpath(xzglr_loc03);
	}

	// 镇街中心登录，登记新增页面:关联企业
	String xzglqy_loc01 = "//*[@id=\"linkedCompany\"]";
	String xzglqy_loc02 = "//*[@id=\"datagrid-row-r1-2-0\"]/td[1]/div/input";
	String xzglqy_loc03 = "//*[@id=\"peopleDiv\"]/div[4]/div/div/input[1]";

	public void clickXzQiYe() {
		clickByXpath(xzglqy_loc01);
	}

	public void clickQiYe() {
		clickByXpath(xzglqy_loc02);
	}

	public void clickGlQiYeTiJiao() {
		clickByXpath(xzglqy_loc03);
	}

	// 镇街中心登录，登记新增页面，问题派发模块:片区
	String pfpq_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[15]/td[2]/input[1]";

	public void clickPianQu() {
		clickByXpath(pfpq_loc);
	}

	// 镇街中心登录，登记新增页面，问题派发模块:职能部门
	String pfznb01_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[16]/td[2]/span/span/span";
	String pfznb02_loc = "//*[@id=\"_easyui_tree_1\"]/span[1]";   
	String pfznb03_loc = "//*[@id=\"_easyui_tree_178\"]/span[4]"; 

	public void clickZhiNengBan() {
		clickByXpath(pfznb01_loc);
		BrowserUtil.sleep(1);
		clickByXpath(pfznb02_loc);
		BrowserUtil.sleep(1);
		clickByXpath(pfznb03_loc);
		BrowserUtil.sleep(1);
		clickByXpath(pfznb01_loc);
	}

	// 镇街中心登录，登记新增页面，问题派发模块:网格
	String pfwg01_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[17]/td[2]/span/span/span";
	String pfwg02_loc = "//*[@id=\"_easyui_tree_59\"]/span[1]";
	String pfwg03_loc = "//*[@id=\"_easyui_tree_60\"]/span[4]";

	public void clickWangGe() {
		clickByXpath(pfwg01_loc);
		BrowserUtil.sleep(1);
		clickByXpath(pfwg02_loc);
		BrowserUtil.sleep(1);
		clickByXpath(pfwg03_loc);
		BrowserUtil.sleep(1);
		clickByXpath(pfwg01_loc);
	}

	// 镇街中心登录，登记新增页面，问题派发模块:派发说明
	String pfsm_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[18]/td[2]/textarea";

	public void putInShuoMing(String pfShuoming) {
		setInputByXpath(pfsm_loc, pfShuoming);
	}

	// 镇街中心登录，登记新增页面，点击提交按钮
	String djtj_loc = "//*[@id=\"AdvanceDiv\"]/div[2]/div/div/input[2]";

	public void clickPfTiJiao() {
		clickByXpath(djtj_loc);
	}

	// 镇街中心登录，登记新增页面，点击暂存按钮
	String djzc_loc = "//*[@id=\"AdvanceDiv\"]/div[2]/div/div/input[3]";

	public void clickPfZanCun() {
		clickByXpath(djzc_loc);
	}

	// 镇街中心登录，登记新增页面，点击上报按钮，弹出确认信息窗口

	String queding_loc = "html/body/div[4]/div[2]/div[4]/a[1]";

	public void clickQueding() {
		getWebElementByXpath(queding_loc).click();
	}

	// 义乌中心登录，登记新增页面:二级类
	String ywejl_loc01 = "// *[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[3]/td[4]/span/span/span";
	String ywejl_loc02 = "// *[@id=\"_easyui_combobox_i5_0\"]";

	public void clickYiWuErJiLei() {
		clickByXpath(ywejl_loc01);
		clickByXpath(ywejl_loc02);
	}

	// 义乌中心登录，在问题派发模块，派发给某镇街中心，现派发给苏溪镇
	String sxz_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[15]/td[2]/input[13]";
	
	public void clickZhenJie() {
		clickByXpath(sxz_loc);
	}

	// 义乌中心登录，在问题派发模块，派发给某职能办，现派发给安监局
	String znb_loc = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[16]/td[2]/input[1]";

	public void clickShiZhiNengBan() {
		clickByXpath(znb_loc);
	}
	String shuoming_loc ="disContent";
	public void putInYiWuShuoMing(String shuoming){
		setInputByName(shuoming_loc,shuoming);
	}

	/**
	 * 镇街中心登录，进行登记操作
	 * 
	 * @param title
	 * @param shifadizhi
	 * @param wentimiaoshu
	 * @param scfujian
	 * @param paiFaSm
	 */
	public void zjdengJi(String title, String shifadizhi, String wentimiaoshu, String scfujian, String paiFaSm) {
		switchTo("addWinWindowFrame");
		putInDjTitle(title);
		clickYiJiLei();
		BrowserUtil.sleep(1);
		clickErJiLei();
		BrowserUtil.sleep(1);
		putInShiFaDiZhi(shifadizhi);
		BrowserUtil.sleep(1);
		putInWenTiMiaoShu(wentimiaoshu);
		BrowserUtil.sleep(1);
		putInFuJian(scfujian);
		BrowserUtil.sleep(2);
		// 关联人
		clickXzRenYuan();
		switchTodefaultContent();
		switchTo("linkedPeopleWinWindowFrame");
		clickRenYuan();
		clickGlryTiJiao();
		switchTodefaultContent();
		switchTo("addWinWindowFrame");
		// 关联企业
		clickXzQiYe();
		switchTodefaultContent();
		switchTo("linkedCompanyWinWindowFrame");
		clickQiYe();
		clickGlQiYeTiJiao();
		switchTodefaultContent();
		switchTo("addWinWindowFrame");

		// 往下拉动滚动条
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(2);
		clickPianQu();
		BrowserUtil.sleep(1);
		clickZhiNengBan();
		BrowserUtil.sleep(1);
		clickWangGe();
		BrowserUtil.sleep(1);
		putInShuoMing(paiFaSm);
		// 获取事件等级
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		System.out.println(sjdj);
		// 镇街中心在登记新增页面，点击提交按钮，若事件等级为A,B类，则弹出确认信息，若事件登记为C,D类，则不弹出。
		if ("C类".equals(sjdj) || "D类".equals(sjdj)) {
			clickPfTiJiao();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		} else {
			clickPfTiJiao();
			clickQueding();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		}

	}

	/**
	 * 义乌中心登录，进行登记操作。
	 * 
	 * @param title
	 * @param shifadizhi
	 * @param wentimiaoshu
	 * @param scfujian
	 * @param paiFaSm
	 */
	public void ywdengJi(String title, String shifadizhi, String wentimiaoshu, String scfujian, String paiFaSm) {
		switchTo("addWinWindowFrame");
		putInDjTitle(title);
		BrowserUtil.sleep(1);
		clickYiJiLei();
		BrowserUtil.sleep(1);
		clickYiWuErJiLei();
		BrowserUtil.sleep(1);
		putInShiFaDiZhi(shifadizhi);
		BrowserUtil.sleep(1);
		putInWenTiMiaoShu(wentimiaoshu);
		BrowserUtil.sleep(1);
		putInFuJian(scfujian);
		BrowserUtil.sleep(2);
		// 关联人
		clickXzRenYuan();
		switchTodefaultContent();
		switchTo("linkedPeopleWinWindowFrame");
		clickRenYuan();
		clickGlryTiJiao();
		switchTodefaultContent();
		switchTo("addWinWindowFrame");
		// 关联企业
		clickXzQiYe();
		switchTodefaultContent();
		switchTo("linkedCompanyWinWindowFrame");
		clickQiYe();
		clickGlQiYeTiJiao();
		switchTodefaultContent();
		switchTo("addWinWindowFrame");

		// 往下拉动滚动条
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=500");
		BrowserUtil.sleep(2);
		clickZhenJie();
		BrowserUtil.sleep(1);
		clickShiZhiNengBan();
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		putInYiWuShuoMing(paiFaSm);
		// 获取事件等级
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		System.out.println(sjdj);
		// 区县中心在登记新增页面，点击提交按钮，若事件等级为A,B类，则弹出确认信息，若事件登记为C,D类，则不弹出。
		if ("C类".equals(sjdj) || "D类".equals(sjdj)) {
			clickPfTiJiao();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		} else {
			clickPfTiJiao();
			clickQueding();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		}

	}

}
