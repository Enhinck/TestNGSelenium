package com.core.page.question;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class DealQuestion extends AbstractPage {

	/**
	 * 片区长，职能办，网格长登录，点击处理，进入处理页面，进行反馈操作。
	 */
	// 进入处理页面，点击反馈
	String fanKui_loc = "btnFk";

	public void clickFanKui() {
		getWebElementByClassName(fanKui_loc).click();
	}

	// 进入反馈页面，输入反馈说明，上传附件,提交
	String fankuiSm_loc = "content";

	public void PutInFanKuiSm(String fkuishuoming) {
		setInputByName(fankuiSm_loc, fkuishuoming);
	}

	String scFuJian_loc = "imgFile";

	public void PutInFuJian(String scfkfujian) {
		setInputByName(scFuJian_loc, scfkfujian);
	}

	String fkTiJiao_loc = "btnSubmit";

	public void clickFkTiJiao() {
		getWebElementByClassName(fkTiJiao_loc).click();
	}

	// 镇街中心登录，在片区长反馈的信息，点击“处理”
	String clPqz_loc = "//*[@id=\"disposeListDiv\"]/div[1]/div/div[2]/div[1]/table/tbody/tr/td[4]/a";

	public void clickClPqz() {
		clickByXpath(clPqz_loc);
	}

	// 镇街中心登录，在网格长反馈的信息，点击“处理”
	String clWgz_loc = "//*[@id=\"disposeListDiv\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[4]/a";

	public void clickClWgz() {
		clickByXpath(clWgz_loc);
	}

	// 镇街中心登录，在职能办反馈的信息，点击“处理”
	String clZnb_loc = "//*[@id=\"disposeListDiv\"]/div[1]/div/div[4]/div[1]/table/tbody/tr/td[4]/a";

	public void clickClZnb() {
		clickByXpath(clZnb_loc);
	}

	// 镇街中心登录，点击处理
	String cl_loc = "//*[@id=\"checkForm\"]/table/tbody/tr[2]/td[2]/input[3]";

	public void clickChuli() {
		clickByXpath(cl_loc);
	}

	// 镇街中心登录，进入处理页面，点击“结案”按钮
	String JieAn_loc = "btnJa";

	public void clickJieAn() {
		getWebElementByClassName(JieAn_loc).click();
	}

	// 镇街中心登录，进入结案页面,输入结案说明，同年哥反馈说明,提交
	String jashuoming_loc = "content";

	public void PutJaShuoMing(String jashuoming) {
		setInputByName(jashuoming_loc, jashuoming);
	}

	String tngfankui_loc = "result";

	public void PutTngFkui(String tngfankui) {
		setInputByName(tngfankui_loc, tngfankui);
	}

	String jatijiao_loc = "btnSubmit";

	public void clickJaTiJiao() {
		getWebElementByClassName(jatijiao_loc).click();
	}

	// 镇街中心，问题处理完，点击重新派发tab页
	String cxpfym_loc = "//*[@id=\"myTabs\"]/div[1]/div[3]/ul/li[3]/a/span[1]";

	public void clickCxpfym() {
		clickByXpath(cxpfym_loc);
	}

	// 镇街中心，问题重新派发给片区长
	String cxpfpqz_loc = "//*[@id=\"wtpf\"]/table/tbody/tr[3]/td[2]/input[1]";

	public void clickCxpfPQZ() {
		clickByXpath(cxpfpqz_loc);
	}

	// 镇街中心，问题重新派发给职能办
	String cxpfznb_loc01 = "//*[@id=\"wtpf\"]/table/tbody/tr[4]/td[2]/span/span/span";
	String cxpfznb_loc02 = "//*[@id=\"_easyui_tree_1\"]/span[1]";  
	String cxpfznb_loc03 = "//*[@id=\"_easyui_tree_178\"]/span[4]";

	public void clickCxpfZnb() {
		clickByXpath(cxpfznb_loc01);
		clickByXpath(cxpfznb_loc02);
		clickByXpath(cxpfznb_loc03);
		clickByXpath(cxpfznb_loc01);
	}

	// 镇街中心，问题重新派发给网格长
	String cxpfwgz_loc01 = "//*[@id=\"wtpf\"]/table/tbody/tr[5]/td[2]/span/span/span";
	String cxpfwgz_loc02 = "//*[@id=\"_easyui_tree_59\"]/span[1]";
	String cxpfwgz_loc03 = "//*[@id=\"_easyui_tree_60\"]/span[4]";

	public void clickCxpfWgz() {
		clickByXpath(cxpfwgz_loc01);
		clickByXpath(cxpfwgz_loc02);
		clickByXpath(cxpfwgz_loc03);
		clickByXpath(cxpfwgz_loc01);
	}

	// 镇街中心，问题重新派发 重设截止时间
	String csjzsj_loc = "//*[@id=\"wtpf\"]/table/tbody/tr[6]/td[2]/span/span/span";
	String sjqueding_loc = "/html/body/div[2]/div/div[3]/table/tbody/tr/td[2]/a";

	public void clickCsjzsj() {
		clickByXpath(csjzsj_loc);
		clickByXpath(sjqueding_loc);
	}

	// 镇街中心，问题重新派发 说明
	String cxpfsm_loc = "content";

	public void putCxpfShuoMing(String cxpfShuoMing) {
		setInputByName(cxpfsm_loc, cxpfShuoMing);
	}

	// 镇街中心，问题重新派发 点击派发按钮
	String cxpf_loc = "//*[@id=\"wtpf\"]/table/tbody/tr[7]/td[2]/input[2]";

	public void clickCxpf() {
		clickByXpath(cxpf_loc);
	}

	// 镇街中心，问题处理完，点击核查tab页
	String heym_loc = "//*[@id=\"myTabs\"]/div[1]/div[3]/ul/li[2]/a";

	public void clickHcym() {
		clickByXpath(heym_loc);
	}

	// 镇街中心，核查页面，核查派发给网格长
	String hcpfwgz_loc01 = "//*[@id=\"hcpf\"]/table/tbody/tr[3]/td[2]/span/span/span";
	String hcpfwgz_loc02 = "//*[@id=\"_easyui_tree_1\"]/span[1]";
	String hcpfwgz_loc03 = "//*[@id=\"_easyui_tree_2\"]/span[4]";

	public void clickHcpfWgz() {
		clickByXpath(hcpfwgz_loc01);
		clickByXpath(hcpfwgz_loc02);
		clickByXpath(hcpfwgz_loc03);
		clickByXpath(hcpfwgz_loc01);
	}

	// 镇街中心，核查页面，核查说明
	String hcsm_loc = "//*[@id=\"hcpf\"]/table/tbody/tr[5]/td[2]/textarea";

	public void putHcShuoMing(String hcShuoMing) {
		setInputByXpath(hcsm_loc, hcShuoMing);
	}

	// 镇街中心，核查页面， 点击提交按钮
	String hctj_loc = "//*[@id=\"hcpf\"]/table/tbody/tr[5]/td[2]/input[2]";
	
	public void clickHctijiao() {
		clickByXpath(hctj_loc);
	}

	// 镇街中心，处理核查
	String hccl_loc = "//*[@id=\"disposeListDiv\"]/div[1]/div/div[2]/div[1]/table/tbody/tr/td[4]/a";
	String jccl_loc = "//*[@id=\"checkForm\"]/table/tbody/tr[2]/td[2]/input[3]";

	public void clickHcChuLi() {
		clickByXpath(hccl_loc);
		BrowserUtil.sleep(1);
		clickByXpath(jccl_loc);
	}

	// 义乌中心登录，在镇街中心反馈的信息，点击“处理”
	String clZjzx_loc = "//*[@id=\"disposeListDiv\"]/div[1]/div/div[2]/div[1]/table/tbody/tr/td[4]/a";

	public void clickClZjzx() {
		clickByXpath(clZjzx_loc);
	}

	// 义乌中心登录，在区县职能办反馈的信息，点击“处理”
	String clQxznb_loc = "//*[@id=\"disposeListDiv\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[4]/a";

	public void clickClQxznb() {
		clickByXpath(clQxznb_loc);
	}

	// 义乌中心登录，在处理页面，点击“重新派发”
	String ywcxpf_loc = "// *[@id=\"myTabs\"]/div[1]/div[3]/ul/li[3]/a";

	public void clickywChongXinPaiFa() {
		clickByXpath(ywcxpf_loc);
	}

	// 义乌中心登录，在处理页面的重新派发tab页,选择镇街。
	String ywcxpfzj_loc = "// *[@id=\"wtpf\"]/table/tbody/tr[3]/td[2]/input[13]";
	
	public void clickywChongXinPaiFazj() {
		clickByXpath(ywcxpfzj_loc);
	}

	// 义乌中心登录，在处理页面的重新派发tab页,选择区县职能办。
	String ywcxpfznb_loc = "//*[@id=\"wtpf\"]/table/tbody/tr[4]/td[2]/input[1]";

	public void clickywChongXinPaiFaznb() {
		clickByXpath(ywcxpfznb_loc);
	}

	// 义乌中心登录，在处理页面的重新派发tab页,选择重设截止时间。
	String cxjzsj_loc = "//*[@id=\"wtpf\"]/table/tbody/tr[5]/td[2]/span/span/span";
	String cxjzsj_loc2 = "/html/body/div[2]/div/div[3]/table/tbody/tr/td[2]/a";

	public void clickChongSheJieZhisj() {
		clickByXpath(cxjzsj_loc);
		clickByXpath(cxjzsj_loc2);
	}

	// 义乌中心登录，在处理页面的重新派发tab页,输入重新派发说明。
	String ywcxpfsm_loc = "content";

	public void putIncxpfShuoMing(String ywchongxinpaifasm) {
		setInputByName(ywcxpfsm_loc, ywchongxinpaifasm);
	}

	// 义乌中心登录，在处理页面的重新派发tab页,点击派发按钮。
	String ywpf_loc = "//*[@id=\"wtpf\"]/table/tbody/tr[6]/td[2]/input[2]";

	public void clickcxpf() {
		clickByXpath(ywpf_loc);
	}

	/**
	 * 处理问题
	 * 
	 * @param fkuishuoming
	 * @param scfkfujian
	 */
	public void deal(String fkuishuoming, String scfkfujian) {
		switchTo("dealWinWindowFrame");
		clickFanKui();
		switchTodefaultContent();
		switchTo("fkWinWindowFrame");
		PutInFanKuiSm(fkuishuoming);
		BrowserUtil.sleep(1);
		PutInFuJian(scfkfujian);
		BrowserUtil.sleep(1);
		clickFkTiJiao();
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		BrowserUtil.sleep(2);
	}

	public void dealFkQuestion(String jashuoming) {
		/**
		 * 镇街中心处理问题，并结案
		 */
		switchTo("dealWinWindowFrame");
		clickClPqz();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClWgz();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClZnb();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickJieAn();
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		switchTo("jaWinWindowFrame");
		PutJaShuoMing(jashuoming);
		// PutTngFkui(tngfankui);
		BrowserUtil.sleep(1);
		clickJaTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	public void dealFkQuestion2(String cxpfshuoming) {
		/**
		 * 镇街中心处理问题后，重新派发
		 */
		switchTo("dealWinWindowFrame");
		clickClPqz();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClWgz();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClZnb();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(2);
		clickCxpfym();
		clickCxpfPQZ();
		BrowserUtil.sleep(1);
		clickCxpfZnb();
		BrowserUtil.sleep(1);
		clickCxpfWgz();
		BrowserUtil.sleep(1);
		clickCsjzsj();// 重新设置截止派发时间
		BrowserUtil.sleep(1);
		putCxpfShuoMing(cxpfshuoming);
		BrowserUtil.sleep(1);
		clickCxpf();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	public void dealFkQuestion3(String hcshuoming) {
		/**
		 * 镇街中心处理问题后，核查派发
		 */
		switchTo("dealWinWindowFrame");
		clickClPqz();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClWgz();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClZnb();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(2);
		clickHcym();
		BrowserUtil.sleep(2);
		clickHcpfWgz();
		BrowserUtil.sleep(1);
		putHcShuoMing(hcshuoming);
		BrowserUtil.sleep(1);
		clickHctijiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	public void dealFkQuestion4(String jashuoming) {
		/**
		 * 镇街中心处理已核查的问题，并结案
		 */
		switchTo("dealWinWindowFrame");
		clickHcChuLi();
		BrowserUtil.sleep(1);

		clickJieAn();
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		switchTo("jaWinWindowFrame");
		PutJaShuoMing(jashuoming);
		BrowserUtil.sleep(1);
		clickJaTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	public void dealYwFkQuestion(String jashuoming) {
		/**
		 * 义乌中心处理问题，并结案
		 */
		switchTo("dealWinWindowFrame");
		clickClZjzx();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClQxznb();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickJieAn();
		BrowserUtil.sleep(1);
		switchTodefaultContent();
		switchTo("jaWinWindowFrame");
		PutJaShuoMing(jashuoming);
		// PutTngFkui(tngfankui);
		BrowserUtil.sleep(1);
		clickJaTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	public void dealYwFkQuestion2(String ywchongxinpaifasm) {
		/**
		 * 义乌中心中心处理问题后，重新派发
		 */
		switchTo("dealWinWindowFrame");
		clickClZjzx();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickClQxznb();
		BrowserUtil.sleep(1);
		clickChuli();
		BrowserUtil.sleep(1);
		clickywChongXinPaiFa();
		BrowserUtil.sleep(1);
		clickywChongXinPaiFazj();
		BrowserUtil.sleep(1);
		clickywChongXinPaiFaznb();
		BrowserUtil.sleep(1);
		/*executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader layout-body')[4].scrollTop=10000");*/
		executeScript("document.getElementById(\"wtpf\").parentNode.scrollTop=10000");
		
		BrowserUtil.sleep(1);
		clickChongSheJieZhisj();// 重设截止时间
		BrowserUtil.sleep(1);
		putIncxpfShuoMing(ywchongxinpaifasm);
		BrowserUtil.sleep(1);
		clickcxpf();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}
}
