package com.core.page.jichuxinxi;

import org.openqa.selenium.WebElement;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class ZhuFangGuanLi extends AbstractPage {

	// 住房管理，点击新增
	String xinzeng_loc = "//*[@id=\"queryDiv\"]/div[1]/div/div[1]/a[1]/span/span[1]";

	public void clickAdd() {
		clickByXpath(xinzeng_loc);
	}

	// 住房管理，点击编辑
	String bianji_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[4]/div/a[2]";

	public void clickEdit() {
		clickByXpath(bianji_loc);
	}

	// 住房管理，点击删除
	String shanchu_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[4]/div/a[3]";

	public void clickDelete() {
		clickByXpath(shanchu_loc);
	}

	// 住房管理，新增页面，输入建筑名称
	String jianzhumingcheng_loc = "name";

	public void putInJianZhuMingCheng(String zhufangmingcheng) {
		setInputByName(jianzhumingcheng_loc, zhufangmingcheng);
	}

	// 住房管理，新增页面，输入详细地址
	String xiangxidizhi_loc = "nmfAddress";

	public void putInXiangXiDiZhi(String xiangxidzhi) {
		setInputByName(xiangxidizhi_loc, xiangxidzhi);
	}

	// 住房管理，新增页面，点击出租信息tab页
	String chuzuxinxi_loc = "//*[@id=\"buildingTabs\"]/div[1]/div[3]/ul/li[2]/a";

	public void clickChuZuXinXi() {
		clickByXpath(chuzuxinxi_loc);
	}

	// 住房管理，新增页面，在出租信息tab页面中，输入出租人
	String chuzuren_loc = "renter";

	public void putInChuZuRen(String chuzuren) {
		setInputByName(chuzuren_loc, chuzuren);
	}

	// 住房管理，新增页面，在出租信息tab页面中，点击 提交
	String tijiao_loc = "submitBtn";

	public void clickTiJiao() {
		clickByName(tijiao_loc);
	}

	// 住房管理，删除页面点击 提交
	String shanchutijiao_loc = "btnSubmit";

	public void clickDeleteTiJiao() {
		clickByClassName(shanchutijiao_loc);
	}

	// 住房管理，新增页面，在出租信息tab页面中，点击 取消
	String quxiao_loc = "closeBtn";

	public void clickClose() {
		clickByName(quxiao_loc);
	}

	// 住房管理，在查询条件处，输入地址
	String dizhichaxun_loc = "address";

	public void putInAddressChaXun(String xiangxidzhi) {
		setInputByName(dizhichaxun_loc, xiangxidzhi);
	}

	// 住房管理，在查询条件处，点击查询
	String chaxun_loc = "btnSearch";

	public void clickChaXun() {
		clickByClassName(chaxun_loc);
	}

	// 住房管理，在列表中获取地址
	String getdizhi_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div";

	public String getAddress() {
		WebElement element = null;
		try {
			element = getWebElementByXpath(getdizhi_loc);
			return element.getText();
		} catch (Exception e) {
			return null;
		}

	}
	// 住房管理，在列表中获取编辑按钮
	String getbianji_loc="html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[4]/div/a[2]";
	public String getOption(){
		WebElement element = null;
		try {
			element = getWebElementByXpath(getbianji_loc);
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}

	// 住房管理，新增页面，在使用类别处，选择自住房
	String shiyongleibie_loc = "kind";

	public void xuanZheShiYongLeiBie() {
		clickByName(shiyongleibie_loc);
	}

	// 住房管理，删除页面，输入删除备注
	String shanchubeizhu_loc = "note";

	public void putInDeleteBeiZhu(String shanchubeizhu) {
		setInputByName(shanchubeizhu_loc, shanchubeizhu);
	}

	/**
	 * 住房管理，新增（使用类别为出租房）
	 * 
	 * @param zhufangmingcheng
	 * @param xiangxidzhi
	 * @param chuzuren
	 */
	public void add(String zhufangmingcheng, String xiangxidzhi, String chuzuren) {
		switchTo("addWinWindowFrame");
		// 使用类型 出租房
		putInJianZhuMingCheng(zhufangmingcheng);
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder')[0].scrollTop=500");
		BrowserUtil.sleep(1);
		putInXiangXiDiZhi(xiangxidzhi);
		BrowserUtil.sleep(1);
		clickChuZuXinXi();
		BrowserUtil.sleep(1);
		putInChuZuRen(chuzuren);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(1);
		switchTo("editWinWindowFrame");
		clickClose();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	/**
	 * 住房管理，根据地址来查询
	 * 
	 * @param xiangxidzhi
	 * @return
	 */
	public String findByAddress(String xiangxidzhi) {
		putInAddressChaXun(xiangxidzhi);
		BrowserUtil.sleep(1);
		clickChaXun();
		BrowserUtil.sleep(2);
		String newAddress = getAddress();
		System.out.println(newAddress);
		return newAddress;
	}
	
	/**
	 * 住房管理，根据地址来查询
	 * (删除成功之后的信息，只能进行查看)
	 * @param xiangxidzhi
	 * @return
	 */
	public String findByAddress22(String xiangxidzhi) {
		putInAddressChaXun(xiangxidzhi);
		BrowserUtil.sleep(1);
		clickChaXun();
		BrowserUtil.sleep(2);
		String newBianJi = getOption();//获取编辑按钮
		//System.out.println(newAddress);
		return newBianJi;
	}

	/**
	 * 住房管理，新增（使用类别为自住房）
	 * 
	 * @param zhufangmingcheng
	 * @param xiangxidzhi
	 */
	public void add(String zhufangmingcheng, String xiangxidzhi) {
		switchTo("addWinWindowFrame");
		// 使用类型 自住房
		xuanZheShiYongLeiBie();
		putInJianZhuMingCheng(zhufangmingcheng);
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder')[0].scrollTop=500");
		BrowserUtil.sleep(1);
		putInXiangXiDiZhi(xiangxidzhi);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	/**
	 * 住房信息，编辑详细地址
	 * 
	 * @param xiangxidzhi2
	 */
	public void edit(String xiangxidzhi2) {
		switchTo("editWinWindowFrame");
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder')[0].scrollTop=500");
		BrowserUtil.sleep(1);
		putInXiangXiDiZhi(xiangxidzhi2);
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	/**
	 * 住房管理，点击删除
	 * 
	 * @param shanchubeizhu
	 */
	public void delete(String shanchubeizhu) {
		switchTo("deleteWinWindowFrame");
		BrowserUtil.sleep(1);
		putInDeleteBeiZhu(shanchubeizhu);
		BrowserUtil.sleep(1);
		clickDeleteTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

}
