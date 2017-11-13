package com.core.page.jichuxinxi;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class Company extends AbstractPage {

	// 新增企业：点击提交
	String tijiao_loc = "btnSubmit";

	public void clickTiJiao() {
		clickByClassName(tijiao_loc);
	}

	// 新增企业：点击关闭
	String guanbi_loc = "btnClose";

	public void clickClose() {
		clickByClassName(guanbi_loc);
	}

	// 新增企业：输入企业名称
	String qiyemingcheng_loc = "companyName";

	public void putInCompanyName(String qiyemingcheng) {
		setInputByID(qiyemingcheng_loc, qiyemingcheng);
	}

	// 更新企业名称
	public void putInEditCompanyName(String qiyemingcheng2) {
		setInputByID(qiyemingcheng_loc, qiyemingcheng2);
	}

	// 新增企业：输入企业地址
	String qiyedizhi_loc = "companyAddress";

	public void putInCompanyAddress(String qiyedizhi) {
		setInputByID(qiyedizhi_loc, qiyedizhi);
	}

	// 新增企业：输入法定代表人
	String fadingdaibiaoren_loc = "head";

	public void putInFaDingDaiBiaoRen(String fadingdaibiaoren) {
		setInputByID(fadingdaibiaoren_loc, fadingdaibiaoren);
	}

	// 新增企业：输入电话号码
	String telnumber_loc = "headPhone";

	public void putInTelnumber(String telnumber) {
		setInputByID(telnumber_loc, telnumber);
	}

	// 新增企业，安监信息，选择所属行业
	String suoshuhangye_loc1 = "//*[@id=\"safeTable\"]/tbody/tr[2]/td[2]/span/span/span";
	String suoshuhangye_loc2 = "//*[@id=\"_easyui_tree_1\"]/span[3]";

	public void xuanZeSuoShuHangYe() {
		clickByXpath(suoshuhangye_loc1);
		clickByXpath(suoshuhangye_loc2);
	}

	// 新增企业，安监信息，输入安全生产负责人
	String anquanshengchanfuzeren_loc = "smNameF";

	public void putInAnQuanShengChanFuZeRen(String anquanshengchanfuzeren) {
		setInputByID(anquanshengchanfuzeren_loc, anquanshengchanfuzeren);
	}

	// 新增企业，安监信息，输入移动电话
	String telnumber2_loc = "smPhoneF";

	public void putInTelnumber2(String telnumber2) {
		setInputByID(telnumber2_loc, telnumber2);
	}

	// 删除企业，输入删除备注
	String shanchubeizhu_loc = "note";

	public void putInDeleteShuoMing(String deletebeizhu) {
		setInputByID(shanchubeizhu_loc, deletebeizhu);
	}

	/**
	 * 基础信息>>企业，新增企业(必填)
	 * 
	 * @param qiyemingcheng
	 * @param qiyedizhi
	 * @param fadingdaibiaoren
	 * @param telnumber
	 */
	public void add(String qiyemingcheng, String qiyedizhi, String fadingdaibiaoren, String telnumber,
			String anquanshengchanfuzeren, String telnumber2) {
		switchTo("addCompanyWinWindowFrame");
		BrowserUtil.sleep(1);
		putInCompanyName(qiyemingcheng);
		BrowserUtil.sleep(1);
		putInCompanyAddress(qiyedizhi);
		BrowserUtil.sleep(1);
		putInFaDingDaiBiaoRen(fadingdaibiaoren);
		BrowserUtil.sleep(1);
		putInTelnumber(telnumber);
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder')[1].scrollTop=10000");
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		xuanZeSuoShuHangYe();
		BrowserUtil.sleep(1);
		putInAnQuanShengChanFuZeRen(anquanshengchanfuzeren);
		BrowserUtil.sleep(1);
		putInTelnumber2(telnumber2);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
		switchTo("editCompanyWinWindowFrame");
		clickClose();
		switchTodefaultContent();
	}

	/**
	 * 基础信息>>企业，编辑企业
	 * 
	 * @param qiyemingcheng2
	 */
	public void edit(String qiyemingcheng2) {
		switchTo("editCompanyWinWindowFrame");
		putInEditCompanyName(qiyemingcheng2);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	/**
	 * 基础信息>>企业，删除企业
	 */
	public void delete(String deletebeizhu) {
		switchTo("deleteWinWindowFrame");
		putInDeleteShuoMing(deletebeizhu);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

}
