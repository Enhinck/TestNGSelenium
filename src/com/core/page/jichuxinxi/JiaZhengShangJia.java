package com.core.page.jichuxinxi;

import org.openqa.selenium.WebElement;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class JiaZhengShangJia extends AbstractPage {

	// 基础信息>>家政商家>>家政商家，新增
	String xinzeng_loc = "//*[@id=\"releaseDiv\"]/a/span/span[1]";

	public void clickAddJiaZhengShangJia() {
		clickByXpath(xinzeng_loc);
	}

	// 基础信息>>家政商家>>家政商家，编辑
	String bianji_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[7]/div/a[2]";

	public void clickEditJiaZhengShangJia() {
		clickByXpath(bianji_loc);
	}

	// 基础信息>>家政商家>>家政商家，编辑
	String shanchu_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[7]/div/a[3]";

	public void clickDeleteJiaZhengShangJia() {
		clickByXpath(shanchu_loc);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：商家名称
	String shangjiamingcheng_loc = "name";

	public void putInShangJiaMingCheng(String shangjiamingcheng) {
		setInputByName(shangjiamingcheng_loc, shangjiamingcheng);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：法人
	String faren_loc = "head";

	public void putInFaRen(String faren) {
		setInputByName(faren_loc, faren);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：联系人
	String lianxiren_loc = "contact";

	public void putInLianXiRen(String lianxiren) {
		setInputByName(lianxiren_loc, lianxiren);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：手机
	String shouji_loc = "phone";

	public void putInTelphone(String telphone) {
		setInputByName(shouji_loc, telphone);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：选择服务类别 >家庭服务>家庭教师
	String fuwuleibie_loc01 = "//*[@id=\"homeCompanyForm\"]/div/table/tbody/tr[5]/td[2]/span/span/span";
	String fuwuleibie_loc02 = "//*[@id=\"_easyui_tree_1\"]/span[1]";
	String fuwuleibie_loc03 = "//*[@id=\"_easyui_tree_2\"]/span[4]";

	public void xuanZeFuWuLeiBie() {
		clickByXpath(fuwuleibie_loc01);
		clickByXpath(fuwuleibie_loc02);
		clickByXpath(fuwuleibie_loc03);
		clickByXpath(fuwuleibie_loc01);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：商家地址
	String shangjiadizhi_loc = "address";

	public void putInShangJiaDiZhi(String shangjiadizhi) {
		setInputByName(shangjiadizhi_loc, shangjiadizhi);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：业务描述
	String ywmiaoshu_loc = "operDesc";

	public void putInYwMiaoShu(String ywmiaoshu) {
		setInputByName(ywmiaoshu_loc, ywmiaoshu);
	}

	// 基础信息>>家政商家>>家政商家，新增页面：点击提交
	String tijiao_loc = "submitBtn";

	public void clickTiJiao() {
		clickByName(tijiao_loc);
	}

	// 基础信息>>家政商家>>家政商家，在查询条件处，输入家政名称
	String shangjiamingchengchaxun_loc = "search_LIKE_name";

	public void putInShangJiaMingChengChaXun(String shangjiamingcheng) {
		setInputByName(shangjiamingchengchaxun_loc, shangjiamingcheng);
	}

	// 基础信息>>家政商家>>家政商家，在查询条件处，点击查询
	String chaxun_loc = "btnSearch";

	public void clickChaXun() {
		clickByClassName(chaxun_loc);
	}

	// 基础信息>>家政商家>>家政商家列表中，提取商家名称
	String getshangjiamingcheng_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div";

	public String getShangJiaMingCheng() {
		WebElement element = null;
		try {
			element = getWebElementByXpath(getshangjiamingcheng_loc);
			return element.getText();
		} catch (Exception e) {
			return null;
		}

	}
	
	//基础信息>>家政商家>>家政商家,点击删除，提示删除确认框
	String shangchuqueding_loc="/html/body/div[3]/div[2]/div[4]/a[1]";
	public void clickQueDing(){
		clickByXpath(shangchuqueding_loc);
	}

	/**
	 * 新增家政商家
	 * 
	 * @param shangjiamingcheng
	 * @param faren
	 * @param lianxiren
	 * @param telphone
	 * @param shangjiadizhi
	 * @param ywmiaoshu
	 */
	public void add(String shangjiamingcheng, String faren, String lianxiren, String telphone, String shangjiadizhi,
			String ywmiaoshu) {
		switchTo("homeCompanyWinWindowFrame");
		BrowserUtil.sleep(1);
		putInShangJiaMingCheng(shangjiamingcheng);
		BrowserUtil.sleep(1);
		putInFaRen(faren);
		BrowserUtil.sleep(1);
		putInLianXiRen(lianxiren);
		BrowserUtil.sleep(1);
		putInTelphone(telphone);
		BrowserUtil.sleep(1);
		xuanZeFuWuLeiBie();
		BrowserUtil.sleep(1);
		putInShangJiaDiZhi(shangjiadizhi);
		BrowserUtil.sleep(1);
		putInYwMiaoShu(ywmiaoshu);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	/**
	 * 根据家政商家名称进行查询
	 * 
	 * @param shangjiamingcheng
	 * @return
	 */
	public String findByShangJiaMingCheng(String shangjiamingcheng) {
		putInShangJiaMingChengChaXun(shangjiamingcheng);
		BrowserUtil.sleep(1);
		clickChaXun();
		BrowserUtil.sleep(2);
		String newshangjiamingcheng = getShangJiaMingCheng();
		// System.out.println(newshangjiamingcheng);
		return newshangjiamingcheng;
	}

	/**
	 * 家政商家，编辑
	 * @param shangjiamingcheng02
	 */
	public void edit(String shangjiamingcheng02) {
		switchTo("homeCompanyWinWindowFrame");
		BrowserUtil.sleep(1);
		putInShangJiaMingCheng(shangjiamingcheng02);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	/**
	 * 家政商家，删除
	 */
	public void delete() {
		clickQueDing();
		BrowserUtil.sleep(2);
	}

}
