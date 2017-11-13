package com.core.page.question;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class SBaoQuestion extends AbstractPage {

	/**
	 * 网格长登录，上报新增页面:标题
	 */
	String title_loc = "title";

	public void putInTitle(String title) {
		setInputByID(title_loc, title);
	}

	/**
	 * 网格长登录，上报新增页面:一级类，二级类
	 */
	String yjl_loc1 = "html/body/form/div/div[1]/div/table/tbody/tr[3]/td[2]/span/span/span";
	String yjl_loc2 = "_easyui_combobox_i3_0";

	public void clickYjlei() {
		clickByXpath(yjl_loc1);
		BrowserUtil.sleep(1);
		clickById(yjl_loc2);
	}

	String ejl_loc1 = "html/body/form/div/div[1]/div/table/tbody/tr[3]/td[4]/span/span/span";
	String ejl_loc2 = "_easyui_combobox_i6_1";

	public void clickEjlei() {
		clickByXpath(ejl_loc1);
		BrowserUtil.sleep(1);
		clickById(ejl_loc2);
	}

	/**
	 * 网格长登录，上报新增页面:事发地点
	 */
	String Sfdd_loc = "address";

	public void putInSfdd(String shifadizhi) {
		setInputByID(Sfdd_loc, shifadizhi);
	}

	/**
	 * 网格长登录，上报新增页面:问题描述
	 */
	String wtmiaoshu_loc = "content";

	public void putInWtmiaoshu(String wentimiaoshu) {
		setInputByID(wtmiaoshu_loc, wentimiaoshu);
	}

	/**
	 * 网格长登录，上报新增页面:结案，提交，暂存，关闭
	 */
	String jieAn_loc = "//*[@id=\"AdvanceDiv\"]/div[2]/div/div/input[2]";
	String tiJiao_loc = "btnSubmit";
	String zanCun_loc = "btnZc";
	String guanBi_loc = "btnClose";

	public void clickJieAn() {
		clickByXpath(jieAn_loc);
	}

	public void clickTiJiao() {
		getWebElementByClassName(tiJiao_loc).click();
	}

	public void clickZanCun() {
		getWebElementByClassName(zanCun_loc).click();
	}

	public void clickGuanBi() {
		getWebElementByClassName(guanBi_loc).click();
	}

	/**
	 * 网格长登录，上报新增页面暂存之后，弹出确认信息
	 */
	String queding_loc = "html/body/div[4]/div[2]/div[4]/a[1]";

	public void clickQueding() {
		getWebElementByXpath(queding_loc).click();
	}

	/**
	 * 网格长登录，上报新增页面：上传附件
	 */
	String fujian_loc = "imgFile";

	public void putInScFuJian(String scfujian) {
		setInputByName(fujian_loc, scfujian);
	}

	/**
	 * 网格长登录，上报新增页面,关联人员
	 */
	String xzry_loc = "//*[@id=\"linkedPeople\"]";

	public void clickXzRenYuan() {
		clickByXpath(xzry_loc);
	}

	String glrenyuan_loc = "//*[@id=\"datagrid-row-r1-2-0\"]/td[1]/div/input";

	public void clickRenYuan() {
		getWebElementByXpath(glrenyuan_loc).click();
	}

	String glryTiJiao_loc = "submitBtn";

	public void clickGlryTiJiao() {
		clickByName(glryTiJiao_loc);
	}

	/**
	 * 网格长登录，上报新增页面,关联企业
	 */
	String xzqy_loc = "//*[@id=\"linkedCompany\"]";

	public void clickXzQiYe() {
		clickByXpath(xzqy_loc);
	}

	String glQiYe_loc = "//*[@id=\"datagrid-row-r1-2-0\"]/td[1]/div/input";

	public void clickQiYe() {
		getWebElementByXpath(glQiYe_loc).click();
	}

	String glQiYeTiJiao_loc = "submitBtn";

	public void clickGlQiYeTiJiao() {
		clickByName(glQiYeTiJiao_loc);
	}

	/**
	 * 结案文本框说明，提交
	 */
	String putInJieAn_loc = "pdContent";

	public void putInJieAn(String jieAnContent) {
		setInputByName(putInJieAn_loc, jieAnContent);
	}

	String jaTiJiao_loc = "btnSubmit";

	public void clickJaTiJiao() {
		getWebElementByClassName(jaTiJiao_loc).click();
	}

	/**
	 * 网格长上报，暂存操作（必填信息）
	 * 
	 * @param title
	 * @param shifadizhi
	 * @param wentimiaoshu
	 */
	public void addZanCun(String title, String shifadizhi, String wentimiaoshu) {
		switchTo("addWinWindowFrame");
		putInTitle(title);
		BrowserUtil.sleep(1);
		clickYjlei();
		BrowserUtil.sleep(1);
		clickEjlei();
		BrowserUtil.sleep(1);
		putInSfdd(shifadizhi);
		BrowserUtil.sleep(1);
		putInWtmiaoshu(wentimiaoshu);
		BrowserUtil.sleep(1);
		/**
		 * 获取事件等级
		 */
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		System.out.println(sjdj);

		/**
		 * 网格长在上报新增页面，点击暂存按钮，若事件等级为A,B,C类，则弹出确认信息，若事件登记为D类，则不弹出。
		 */
		if ("D类".equals(sjdj)) {
			clickZanCun();
			switchTodefaultContent();
		} else {
			clickZanCun();
			clickQueding();
			BrowserUtil.sleep(2);
			switchTodefaultContent();
		}
	}

	/**
	 * 网格长上报，暂存操作（完整信息）
	 * 
	 * @param title
	 * @param shifadizhi
	 * @param wentimiaoshu
	 * @param scfujian
	 */
	public void addZanCun2(String title, String shifadizhi, String wentimiaoshu, String scfujian) {
		switchTo("addWinWindowFrame");
		putInTitle(title);
		BrowserUtil.sleep(1);
		clickYjlei();
		BrowserUtil.sleep(1);
		clickEjlei();
		BrowserUtil.sleep(1);
		putInSfdd(shifadizhi);
		BrowserUtil.sleep(1);
		putInWtmiaoshu(wentimiaoshu);
		BrowserUtil.sleep(2);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		// 上传附件
		putInScFuJian(scfujian);
		BrowserUtil.sleep(3);
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
		/**
		 * 获取事件等级
		 */
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		//System.out.println(sjdj);

		/**
		 * 网格长在上报新增页面，点击暂存按钮，若事件等级为A,B,C类，则弹出确认信息，若事件登记为D类，则不弹出。
		 */
		if ("D类".equals(sjdj)) {
			clickZanCun();
			switchTodefaultContent();
		} else {
			clickZanCun();
			clickQueding();
			BrowserUtil.sleep(2);
			switchTodefaultContent();
		}
	}

	/**
	 * 网格长暂存，点击编辑按钮，后结案。
	 */
	public void editJieAn(String jieAnContent) {
		switchTo("editWinWindowFrame");
		BrowserUtil.sleep(2);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		// 获取事件等级
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		// System.out.println(sjdj);
		/**
		 * 网格长在上报新增页面，点击暂存按钮，若事件等级为A,B,C类，则弹出确认信息，若事件登记为D类，则不弹出。
		 */
		if ("D类".equals(sjdj)) {
			clickJieAn();
			switchTodefaultContent();
			switchTo("jaWinWindowFrame");
			putInJieAn(jieAnContent);
			clickJaTiJiao();
			switchTodefaultContent();
		} else {
			clickJieAn();
			clickQueding();
			BrowserUtil.sleep(2);
			switchTodefaultContent();
			switchTo("jaWinWindowFrame");
			putInJieAn(jieAnContent);
			clickJaTiJiao();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		}

	}

	/**
	 * 网格长上报，自结案。
	 * 
	 * @param title
	 * @param shifadizhi
	 * @param wentimiaoshu
	 * @param scfujian
	 */

	public void addZiJieAn(String title, String shifadizhi, String wentimiaoshu, String scfujian, String jieAnContent) {
		switchTo("addWinWindowFrame");
		putInTitle(title);
		BrowserUtil.sleep(1);
		clickYjlei();
		BrowserUtil.sleep(1);
		clickEjlei();
		BrowserUtil.sleep(1);
		putInSfdd(shifadizhi);
		BrowserUtil.sleep(1);
		putInWtmiaoshu(wentimiaoshu);
		BrowserUtil.sleep(2);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");

		BrowserUtil.sleep(1);
		// 上传附件
		putInScFuJian(scfujian);
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
		/**
		 * 获取事件等级
		 */
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		System.out.println(sjdj);

		/**
		 * 网格长在上报新增页面，点击暂存按钮，若事件等级为A,B,C类，则弹出确认信息，若事件登记为D类，则不弹出。
		 */
		if ("D类".equals(sjdj)) {
			clickJieAn();
			switchTodefaultContent();
			switchTo("jaWinWindowFrame");
			putInJieAn(jieAnContent);
			clickJaTiJiao();
			switchTodefaultContent();
		} else {
			clickJieAn();
			clickQueding();
			BrowserUtil.sleep(2);
			switchTodefaultContent();
			switchTo("jaWinWindowFrame");
			putInJieAn(jieAnContent);
			clickJaTiJiao();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		}
	}

	/**
	 * 网格长上报，提交
	 * 
	 * @param title
	 * @param shifadizhi
	 * @param wentimiaoshu
	 * @param scfujian
	 */
	public void addShangBao(String title, String shifadizhi, String wentimiaoshu, String scfujian) {
		switchTo("addWinWindowFrame");
		putInTitle(title);
		BrowserUtil.sleep(1);
		clickYjlei();
		BrowserUtil.sleep(1);
		clickEjlei();
		BrowserUtil.sleep(1);
		putInSfdd(shifadizhi);
		BrowserUtil.sleep(1);
		putInWtmiaoshu(wentimiaoshu);
		BrowserUtil.sleep(2);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		// 上传附件
		putInScFuJian(scfujian);
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
		// 获取事件等级
		String sjdj = executeScript("return document.getElementsByName(\"level\")[0].value");
		System.out.println(sjdj);
		// 网格长在上报新增页面，点击暂存按钮，若事件等级为A,B,C类，则弹出确认信息，若事件登记为D类，则不弹出。
		if ("D类".equals(sjdj)) {
			clickTiJiao();
			switchTodefaultContent();
		} else {
			clickTiJiao();
			clickQueding();
			BrowserUtil.sleep(3);
			switchTodefaultContent();
		}
	}

}
