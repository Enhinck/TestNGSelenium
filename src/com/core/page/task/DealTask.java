package com.core.page.task;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class DealTask extends AbstractPage {

	// 区县职能办登录，把任务进行分派给镇街
	String fenpaizj_loc = "//*[@id=\"zjTr\"]/td[2]/label[13]/input";
	
	public void fenPaiZhenJie() {
		clickByXpath(fenpaizj_loc);
	}

	// 区县职能办登录，把任务进行分派给镇街后，点击提交
	String qxznbtj_loc = "//*[@id=\"bgsclForm\"]/div[2]/div/div/input[3]";

	public void clickFenPaiZhenJieTiJiao() {
		clickByXpath(qxznbtj_loc);
	}

	// 区县职能办登录，把任务进行分派给镇街提交后，出现提示信息。
	String qxznbqueren_loc = "/html/body/div[4]/div[2]/div[4]/a[1]/span/span";

	public void clickqxznbtjQueRenXinXi() {
		clickByXpath(qxznbqueren_loc);
	}

	// 区县中心登录，处理任务之后，点击提交
	String qxzxtijiao_loc = "btnSubmit";

	public void qxzxTiJiao() {
		clickByClassName(qxzxtijiao_loc);
	}

	// 区县中心登录，处理任务提交提交，出现提示信息。
	String qxzxqueren_loc = "/html/body/div[4]/div[2]/div[4]/a[1]";

	public void clickqxzxtjQueRenXinXi() {
		clickByXpath(qxzxqueren_loc);
	}

	// 镇街中心登录，在反馈说明模块中，上传附件
	String zjscfj_loc = "//*[@id=\"fksmDiv\"]/table/tbody/tr[2]/td[1]/div/form/input";

	public void putInFanKuiFuJian(String fankuifujian) {
		setInputByXpath(zjscfj_loc, fankuifujian);
	}

	// 镇街中心登录，在反馈说明模块中，反馈
	String zjfankui_loc = "//*[@id=\"fksmDiv\"]/table/tbody/tr[1]/td[3]/input";

	public void clickzjfankui() {
		clickByXpath(zjfankui_loc);
	}

	// 镇街中心登录，处理反馈任务提交提交，出现提示信息。
	String zjzxqueren_loc = "/html/body/div[2]/div[2]/div[4]/a[1]";

	public void clickzjzxtjQueRenXinXi() {
		clickByXpath(zjzxqueren_loc);
	}

	// 区县领导登录，点击审核，对反馈问题进行处理。
	String fankuichuli_loc = "//*[@id=\"winSecondMainDiv\"]/div[1]/div/div/div[2]/div/div/div/div[2]/div[1]/table/tbody/tr/td[4]/a";

	public void clickQxldFanKuiChuLi() {
		clickByXpath(fankuichuli_loc);
	}

	// 区县领导登录，点击审核，对反馈问题进行处理提交。
	String fankuichulitj_loc = "//*[@id=\"zzshPqForm\"]/table/tbody/tr[2]/td[3]/input";

	public void clickQxldFanKuiChuLiTiJiao() {
		clickByXpath(fankuichulitj_loc);
	}

	// 区县领导登录，对反馈问题处理提交，出现提示信息。
	String qxldfkclqueren_loc = "/html/body/div[2]/div[2]/div[4]/a[1]";

	public void clickqxldfktjQueRenXinXi() {
		clickByXpath(qxldfkclqueren_loc);
	}

	// 区县领导登录，对反馈问题进行处理之后，点击结案。
	String qxldJieAn_loc = "btnJa";

	public void clickQxldJieAn() {
		clickById(qxldJieAn_loc);
	}

	// 区县领导登录，对反馈问题进行处理后，结案，弹出结案确认框。
	String qxldConfirmTiJiao_loc = "btnSubmit";

	public void clickConfirmTiJiao() {
		clickByClassName(qxldConfirmTiJiao_loc);
	}

	// 镇街中心登录，对任务进行分派给网格。
	String fenpaiwg_loc = "//*[@id=\"wgTr\"]/td[2]/span/span/span";
	String fenpaiwg_loc2 = "//*[@id=\"_easyui_tree_1\"]/span[1]";
	String fenpaiwg_loc3 = "//*[@id=\"_easyui_tree_2\"]/span[4]";

	public void fenPaiWangGe() {
		clickByXpath(fenpaiwg_loc);
		clickByXpath(fenpaiwg_loc2);
		clickByXpath(fenpaiwg_loc3);
		clickByXpath(fenpaiwg_loc);
	}

	// 镇街中心登录，处理任务分派网格，点击提交，出现提示信息。
	String chulitijiao_loc = "btnSubmit";

	public void clickclTiJiao() {
		clickByClassName(chulitijiao_loc);
	}

	String zjzxqueren_loc2 = "/html/body/div[5]/div[2]/div[4]/a[1]";

	public void clickzjzxtjQueRenXinXi2() {
		clickByXpath(zjzxqueren_loc2);
	}

	// 镇街职能办登录，对任务进行审核，结案
	String shenhetab_loc = "//*[@id=\"myTabs\"]/div[1]/div[3]/ul/li[2]/a";

	public void clickShenHeTab() {
		clickByXpath(shenhetab_loc);
	}

	String shenhe_loc = "//*[@id=\"datagrid-row-r2-2-0\"]/td[6]/div/a";

	public void clickShenHe() {
		clickByXpath(shenhe_loc);
	}

	String shenhetijiao_loc = "//*[@id=\"zzshShDetailForm\"]/table/tbody/tr[2]/td[3]/input";

	public void clickShenHeTiJiao() {
		clickByXpath(shenhetijiao_loc);
	}

	// 镇街职能办登录，对问题审核提交，出现提示信息。
	String zjznbshenhetjqueren_loc = "/html/body/div[2]/div[2]/div[4]/a[1]";

	public void clickzjznbshtjQueRenXinXi() {
		clickByXpath(zjznbshenhetjqueren_loc);
	}

	// 片区长登录，对任务审核提交，出现提示信息。
	String pqzshenhetjqueren_loc = "/html/body/div[2]/div[2]/div[4]/a[1]";

	public void clickpqzshtjQueRenXinXi() {
		clickByXpath(pqzshenhetjqueren_loc);
	}

	// 片区长登录，对任务审核完成后，点击提交，
	String pqztijiao_loc = "btnTj";

	public void clickpqzTiJiao() {
		clickById(pqztijiao_loc);
	}

	// 片区长登录，对任务进行审核
	String pqzshenhe_loc = "//*[@id=\"winSecondMainDiv\"]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[1]/table/tbody/tr/td[4]/a";

	public void clickpqzShenHe() {
		clickByXpath(pqzshenhe_loc);
	}

	// 片区长登录，对任务进行审核提交
	String pqzshenhetijiao_loc = "//*[@id=\"pqshWgForm\"]/table/tbody/tr[2]/td[3]/input";

	public void clickpqzShenHeTiJiao() {
		clickByXpath(pqzshenhetijiao_loc);
	}

	// 镇街中心登录，对任务进行处理，分派片区
	String fenpaipq_loc = "pqUid";

	public void fenPaiPianQu() {
		clickByName(fenpaipq_loc);
	}

	// 镇街中心登录，处理任务分派片区，点击提交，出现提示信息。
	String zjzxqueren_loc3 = "/html/body/div[5]/div[2]/div[4]/a[1]";

	public void clickzjzxtjQueRenXinXi3() {
		clickByXpath(zjzxqueren_loc3);
	}

	// 片区长登录，分派网格
	String fenpaiwg2_loc = "wgUid";

	public void fenPaiWangGe2() {
		clickByName(fenpaiwg2_loc);
	}

	// 片区长登录，分派网格提交，出现的提示信息
	String pqztjqrxx_loc = "/html/body/div[2]/div[2]/div[4]/a[1]";

	public void clickpqztjQueRenXinXi() {
		clickByXpath(pqztjqrxx_loc);
	}

	// 镇街中心登录，对任务下发页面，进行提交
	String xftijiao_loc = "btnSubmit";

	public void clickXiaFaTiJiao() {
		clickByClassName(xftijiao_loc);
	}

	// 镇街中心登录，对任务下发页面，进行提交确认信息
	String zjzxXiaFaQueren_loc = "/html/body/div[5]/div[2]/div[4]/a[1]";

	public void clickzjzxXiaFaQueren() {
		clickByXpath(zjzxXiaFaQueren_loc);
	}

	/**
	 * 区县职能办登录，进行处理任务
	 */
	public void qxZhiNengBanChuLi() {
		switchTo("bgsclWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[2].scrollTop=1000");
		BrowserUtil.sleep(1);
		fenPaiZhenJie();
		BrowserUtil.sleep(1);
		clickFenPaiZhenJieTiJiao();
		BrowserUtil.sleep(1);
		// 确认信息
		clickqxznbtjQueRenXinXi();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 区县中心登录，进行处理任务
	 */
	public void qxzxChuLi() {
		switchTo("zzclWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[2].scrollTop=1000");
		BrowserUtil.sleep(1);
		qxzxTiJiao();
		BrowserUtil.sleep(1);
		clickqxzxtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(3);
		switchTodefaultContent();
	}

	/**
	 * 镇街中心登录，进行任务处理
	 */
	public void zjzxChuLi(String scfankuifujian) {
		switchTo("zjclWinWindowFrame");
		BrowserUtil.sleep(1);
		putInFanKuiFuJian(scfankuifujian);
		BrowserUtil.sleep(1);
		clickzjfankui();
		BrowserUtil.sleep(1);
		clickzjzxtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(3);
		switchTodefaultContent();
	}

	/**
	 * 镇街中心登录，进行任务处理，直派网格
	 */
	public void zjzxChuLi2() {
		switchTo("zxclWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[2].scrollTop=1000");
		BrowserUtil.sleep(1);
		fenPaiWangGe();// 分派网格
		BrowserUtil.sleep(1);
		clickclTiJiao();
		BrowserUtil.sleep(1);
		clickzjzxtjQueRenXinXi2();// 确认信息
		BrowserUtil.sleep(3);
		switchTodefaultContent();
	}

	/**
	 * 镇街中心登录，进行任务处理，分派给片区
	 * 
	 * @param shangchuanfankuifujian
	 */
	public void zjzxChuLi3() {
		switchTo("zxclWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[2].scrollTop=1000");
		BrowserUtil.sleep(1);
		fenPaiPianQu();// 分派给片区
		BrowserUtil.sleep(1);
		clickclTiJiao();
		BrowserUtil.sleep(1);
		clickzjzxtjQueRenXinXi3();// 确认信息
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 区县领导登录，对任务进行审核。
	 */
	public void qxldShenHe() {
		switchTo("zzshWinWindowFrame");
		BrowserUtil.sleep(1);
		clickQxldFanKuiChuLi();
		BrowserUtil.sleep(1);
		clickQxldFanKuiChuLiTiJiao();
		BrowserUtil.sleep(1);
		clickqxldfktjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(1);
		clickQxldJieAn();
		BrowserUtil.sleep(3);
		// switchTodefaultContent();
		switchTo("zzshConfirmYWinWindowFrame");
		clickConfirmTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街职能办登录，对任务进行审核并且结案
	 */
	public void zjznbShenHe() {
		switchTo("zzshWinWindowFrame");
		BrowserUtil.sleep(1);
		clickShenHeTab();
		clickShenHe();
		// switchTodefaultContent();
		switchTo("shDetailWinWindowFrame");
		clickShenHeTiJiao();
		BrowserUtil.sleep(1);
		clickzjznbshtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		switchTo("zzshWinWindowFrame");
		clickQxldJieAn();
		BrowserUtil.sleep(1);
		// switchTodefaultContent();
		switchTo("zzshConfirmYWinWindowFrame");
		clickConfirmTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 网格长登录，对任务进行处理，反馈
	 * 
	 * @param shangchuanfankuifujian
	 */
	public void wgzChuLi(String shangchuanfankuifujian) {
		switchTo("wgclWinWindowFrame");
		BrowserUtil.sleep(1);
		putInFanKuiFuJian(shangchuanfankuifujian);
		BrowserUtil.sleep(1);
		clickzjfankui();
		BrowserUtil.sleep(1);
		clickzjzxtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 片区长登录，对任务进行审核
	 */
	public void pqzShenHe() {
		switchTo("pqshWinWindowFrame");
		BrowserUtil.sleep(1);
		clickpqzShenHe();
		BrowserUtil.sleep(1);
		clickpqzShenHeTiJiao();
		BrowserUtil.sleep(1);
		clickpqzshtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(1);
		clickpqzTiJiao();
		BrowserUtil.sleep(1);
		switchTo("pqshConfirmYWinWindowFrame");
		clickConfirmTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 片区长处理，并分派网格
	 */
	public void pqzChuLi() {
		switchTo("pqclWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[2].scrollTop=1000");
		BrowserUtil.sleep(1);
		fenPaiWangGe2();// 片区长分派网格
		BrowserUtil.sleep(1);
		clickclTiJiao();
		BrowserUtil.sleep(1);
		clickpqztjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街中心登录，对任务进行审核并且结案
	 */
	public void zjzxShenHe() {
		switchTo("zzshWinWindowFrame");
		BrowserUtil.sleep(1);
		clickShenHeTab();
		clickShenHe();
		// switchTodefaultContent();
		switchTo("shDetailWinWindowFrame");
		clickShenHeTiJiao();
		BrowserUtil.sleep(1);
		clickzjznbshtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		switchTo("zzshWinWindowFrame");
		clickQxldJieAn();
		BrowserUtil.sleep(1);
		// switchTodefaultContent();
		switchTo("zzshConfirmYWinWindowFrame");
		clickConfirmTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 片区长登录，对任务进行审核并且结案
	 */
	public void pqzJieAnShenHe() {
		switchTo("zzshWinWindowFrame");
		BrowserUtil.sleep(1);
		clickShenHeTab();
		clickShenHe();
		// switchTodefaultContent();
		switchTo("shDetailWinWindowFrame");
		clickShenHeTiJiao();
		BrowserUtil.sleep(1);
		clickzjznbshtjQueRenXinXi();// 确认信息
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		switchTo("zzshWinWindowFrame");
		clickQxldJieAn();
		BrowserUtil.sleep(1);
		// switchTodefaultContent();
		switchTo("zzshConfirmYWinWindowFrame");
		clickConfirmTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街中心登录，进行任务下发
	 */
	public void zjzxXiaFa() {
		switchTo("addTaskWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript("document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		fenPaiWangGe();
		BrowserUtil.sleep(1);
		clickXiaFaTiJiao();
		BrowserUtil.sleep(1);
		// 确认信息
		clickzjzxXiaFaQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

}
