package com.core.page.jichuxinxi;

import org.openqa.selenium.WebElement;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class ZhongDianXueXiao extends AbstractPage {

	/**
	 * 重点场所>>重点学校，点击新增
	 */
	String xinzengxuexiao_loc = "//*[@id=\"releaseDiv\"]/a/span/span[1]";

	public void clickAddZhongDianXueXiao() {
		clickByXpath(xinzengxuexiao_loc);
	}

	/**
	 * 重点场所>>重点学校，点击编辑
	 */
	String bianjixuexiao_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[6]/div/a[2]";

	public void clickEditZhongDianXueXiao() {
		clickByXpath(bianjixuexiao_loc);
	}

	/**
	 * 重点场所>>重点学校，点击删除
	 */
	String deletexuexiao_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[6]/div/a[3]";

	public void clickDeleteZhongDianXueXiao() {
		clickByXpath(deletexuexiao_loc);
	}

	// 重点场所>>重点学校，新增页面，输入学校名称
	String xuexiaomingcheng_loc = "schoolName";

	public void putInSchoolName(String schoolName) {
		setInputByName(xuexiaomingcheng_loc, schoolName);
	}

	// 重点场所>>重点学校，新增页面，输入学校地址
	String xuexiaodizhi_loc = "schoolAddress";

	public void putInSchoolAddress(String schoolAddress) {
		setInputByName(xuexiaodizhi_loc, schoolAddress);
	}

	// 重点场所>>重点学校，新增页面，选择学校性质
	String xuexiaoxingzhi_loc01 = "//*[@id=\"addForm\"]/div[2]/table/tbody/tr[4]/td[2]/span/span/span";
	String xuexiaoxingzhi_loc02 = "//*[@id=\"_easyui_combobox_i5_0\"]";

	public void xuanZeSchoolXingZhi() {
		clickByXpath(xuexiaoxingzhi_loc01);
		clickByXpath(xuexiaoxingzhi_loc02);
	}

	// 重点场所>>重点学校，新增页面，输入学校校长
	String xiaozhang_loc = "headMaster";

	public void putInSchoolXiaoZhang(String xiaozhang) {
		setInputByName(xiaozhang_loc, xiaozhang);
	}

	// 重点场所>>重点学校，新增页面，选择学校类型
	String xuexiaoleixing_loc01 = "//*[@id=\"addForm\"]/div[2]/table/tbody/tr[5]/td[2]/span/span/span";
	String xuexiaoleixing_loc02 = "//*[@id=\"_easyui_combobox_i6_0\"]";

	public void xuanZeSchoolLeiXing() {
		clickByXpath(xuexiaoleixing_loc01);
		clickByXpath(xuexiaoleixing_loc02);
	}

	// 重点场所>>重点学校，新增页面，输入学校周边情况
	String zhoubianqingkuang_loc = "around";

	public void putInSchoolZhouBianqk(String zhoubianqingkuang) {
		setInputByName(zhoubianqingkuang_loc, zhoubianqingkuang);
	}

	// 重点场所>>重点学校，新增页面，上传附件
	String shangchuanfujian_loc = "imgFile";

	public void putInShangChuanFuJian(String shangchuanfujian) {
		setInputByName(shangchuanfujian_loc, shangchuanfujian);
	}

	// 重点场所>>重点学校，新增页面，点击提交
	String tijiao_loc = "submitBtn";

	public void clickTiJiao() {
		clickByName(tijiao_loc);
	}

	// 重点场所>>重点学校，在查询条件中，输入学校名称
	String schoolnamechaxun_loc = "search_LIKE_schoolName";

	public void putInSchoolNameChaXun(String schoolName) {
		setInputByName(schoolnamechaxun_loc, schoolName);
	}

	// 重点场所>>重点学校，在查询条件中，点击查询
	String xuexiaochaxun_loc = "btnSearch";

	public void clickSchoolChaXun() {
		clickByClassName(xuexiaochaxun_loc);
	}

	// 在查询列表中，获取学校名称
	String getxuexiaomingcheng_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div";

	public String getSchooName() {
		WebElement element = null;
		try {
			element = getWebElementByXpath(getxuexiaomingcheng_loc);
			return element.getText();
		} catch (Exception e) {
			return null;
		}

	}

	// 重点场所>>重点学校，点击删除，输入删除备注。
	String shanchubeizhu_loc = "note";

	public void putInDeleteBeiZhu(String shanchubeizhu) {
		setInputByName(shanchubeizhu_loc, shanchubeizhu);
	}

	// 重点场所>>重点学校，删除提交
	String deletetijiao_loc = "btnSubmit";

	public void clickDeleteTiJiao() {
		clickByClassName(deletetijiao_loc);
	}

	/**
	 * 新增重点学校
	 * 
	 * @param schoolName
	 * @param schoolAddress
	 * @param xiaozhang
	 * @param zhoubianqingkuang
	 */
	public void add(String schoolName, String schoolAddress, String xiaozhang, String zhoubianqingkuang,
			String shangchuanfujian) {
		switchTo("addPlaceWinWindowFrame");
		BrowserUtil.sleep(1);
		putInSchoolName(schoolName);
		BrowserUtil.sleep(1);
		putInSchoolAddress(schoolAddress);
		BrowserUtil.sleep(1);
		xuanZeSchoolXingZhi();
		BrowserUtil.sleep(1);
		putInSchoolXiaoZhang(xiaozhang);
		BrowserUtil.sleep(1);
		xuanZeSchoolLeiXing();
		BrowserUtil.sleep(1);
		putInSchoolZhouBianqk(zhoubianqingkuang);
		BrowserUtil.sleep(1);
		putInShangChuanFuJian(shangchuanfujian);
		BrowserUtil.sleep(2);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	/**
	 * 重点学校页面，根据学校名称进行查询。
	 * 
	 * @param schoolName
	 * @return
	 */
	public String findBySchoolName(String schoolName) {
		putInSchoolNameChaXun(schoolName);
		BrowserUtil.sleep(1);
		clickSchoolChaXun();
		BrowserUtil.sleep(2);
		String newschoolname = getSchooName();
		return newschoolname;
	}

	/**
	 * 重点学校页面，编辑
	 * 
	 * @param schoolName2
	 */
	public void edit(String schoolName2) {
		switchTo("editPlaceWinWindowFrame");
		putInSchoolName(schoolName2);
		clickTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	/**
	 * 重点学校页面，删除
	 * 
	 * @param shanchubeizhu
	 */
	public void delete(String shanchubeizhu) {
		switchTo("deleteWinWindowFrame");
		putInDeleteBeiZhu(shanchubeizhu);
		clickDeleteTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

}
