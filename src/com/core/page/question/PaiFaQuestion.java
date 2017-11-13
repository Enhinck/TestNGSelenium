package com.core.page.question;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class PaiFaQuestion extends AbstractPage {

	/**
	 * 镇街中心登录，在待办理问题页面，点击“派发”按钮，进入派发页面
	 */
	// 派发页面：问题派发模块，选择片区长，职能部门，网格长
	String pqz_loc = "//*[@id=\"wtpf\"]/div[1]/div/table/tbody/tr[3]/td[2]/input[1]";

	// *[@id="AdvanceDiv"]/div[1]/div/table/tbody/tr[15]/td[2]/input[1]
	public void xuanZePqz() {
		clickByXpath(pqz_loc);
	}
	                   
	String znb_loc1 = "//*[@id=\"wtpf\"]/div[1]/div/table/tbody/tr[4]/td[2]/span/span/span";
	String znb_loc2 = "//*[@id=\"_easyui_tree_1\"]/span[1]";
	String znb_loc3 = "//*[@id=\"_easyui_tree_178\"]/span[4]";

	public void xuanZeZnb() {
		clickByXpath(znb_loc1);
		clickByXpath(znb_loc2);
		clickByXpath(znb_loc3);
		clickByXpath(znb_loc1);
	}
	                      
	String wgz_loc1 = "//*[@id=\"wtpf\"]/div[1]/div/table/tbody/tr[5]/td[2]/span/span/span";
	String wgz_loc2 = "//*[@id=\"_easyui_tree_59\"]/span[1]";
	String wgz_loc3 = "//*[@id=\"_easyui_tree_60\"]/span[4]";

	public void xuanZeWgz() {
		clickByXpath(wgz_loc1);
		clickByXpath(wgz_loc2);
		clickByXpath(wgz_loc3);
		clickByXpath(wgz_loc1);
	}

	/**
	 * 义乌中心派发给镇街中心，由镇街中心登录，在待办理问题页面，点击“派发”按钮，进入派发页面
	 */
	// 派发页面：问题派发模块，选择片区长，职能部门，网格长
	String pqz_loc2 = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[15]/td[2]/input[1]";

	public void xuanZePqz2() {
		clickByXpath(pqz_loc2);
	}

	String znb_loc11 = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[16]/td[2]/span/span/span";
	String znb_loc22 = "//*[@id=\"_easyui_tree_1\"]/span[1]";  
	String znb_loc33 = "//*[@id=\"_easyui_tree_178\"]/span[4]";

	public void xuanZeZnb2() {
		clickByXpath(znb_loc11);
		clickByXpath(znb_loc22);
		clickByXpath(znb_loc33);
		clickByXpath(znb_loc11);
	}

	String wgz_loc11 = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[17]/td[2]/span/span/span";
	String wgz_loc22 = "//*[@id=\"_easyui_tree_59\"]/span[1]";
	String wgz_loc33 = "//*[@id=\"_easyui_tree_60\"]/span[4]";

	public void xuanZeWgz2() {
		clickByXpath(wgz_loc11);
		clickByXpath(wgz_loc22);
		clickByXpath(wgz_loc33);
		clickByXpath(wgz_loc11);
	}

	// 派发页面：点击“提交”按钮，“废弃”按钮
	String paifaTiJiao_loc = "submitBtn";

	public void clickPaiFaTiJiao() {
		clickByName(paifaTiJiao_loc);
	}

	String paifaFeiQi_loc = "fqBtn";

	public void clickPaiFaFeiQi() {
		clickByName(paifaFeiQi_loc);
	}

	// 派发页面：派发说明
	String paifaSm_loc = "//*[@id=\"wtpf\"]/div[1]/div/table/tbody/tr[7]/td[2]/textarea";

	public void setPaiFaShuomMing(String paiFaSm) {
		setInputByXpath(paifaSm_loc, paiFaSm);
	}

	// 义乌中心派发给镇街中心，镇街中心登录，派发页面：派发说明
	String paifaSm_loc2 = "//*[@id=\"AdvanceDiv\"]/div[1]/div/table/tbody/tr[18]/td[2]/textarea";

	public void setPaiFaShuomMing2(String paiFaSm) {
		setInputByXpath(paifaSm_loc2, paiFaSm);
	}

	/**
	 * 镇街中心登录，进行派发操作。
	 * 
	 * @param paiFaSm
	 */
	public void paiFa(String paiFaSm) {
		switchTo("dealWinWindowFrame");
		BrowserUtil.sleep(2);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		xuanZePqz();
		BrowserUtil.sleep(1);
		xuanZeZnb();
		BrowserUtil.sleep(1);
		xuanZeWgz();
		BrowserUtil.sleep(1);
		setPaiFaShuomMing(paiFaSm);
		BrowserUtil.sleep(1);
		clickPaiFaTiJiao();
		switchTodefaultContent();
		BrowserUtil.sleep(3);
	}

	/**
	 * 义乌中心派发给镇街中心，镇街中心的派发功能
	 * 
	 * @param paiFaSm
	 */
	public void paiFa2(String paiFaSm2) {
		switchTo("addWinWindowFrame");
		BrowserUtil.sleep(2);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=1000");
		BrowserUtil.sleep(1);
		xuanZePqz2();
		BrowserUtil.sleep(1);
		xuanZeZnb2();
		BrowserUtil.sleep(1);
		xuanZeWgz2();
		BrowserUtil.sleep(1);
		setPaiFaShuomMing2(paiFaSm2);
		BrowserUtil.sleep(1);
		clickPaiFaTiJiao();
		switchTodefaultContent();
		BrowserUtil.sleep(2);
	}

}
