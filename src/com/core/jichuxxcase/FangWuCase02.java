package com.core.jichuxxcase;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.data.AccountRead;
import com.core.data.CommonRandUtil;
import com.core.page.FrontPage;
import com.core.page.LoginPage;
import com.core.page.base.Account;
import com.core.page.jichuxinxi.ZhuFangGuanLi;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class FangWuCase02 {
	/**
	 * 测试用例： 基础信息>>房屋>>住房管理，新增提交。(使用类别为自住房)
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;

	FrontPage frontPage;
	ZhuFangGuanLi zhufangguanli;
	
	String zhufangmingcheng;
	String xiangxidzhi;
	String chuzuren;

	@BeforeTest
	public void beforeTest() {
		// 获取数据
		accounts = AccountRead.getAll();
		// 打开浏览器
		browser = BrowserUtil.getChrome();

		// 打开登录页
		page = new LoginPage();
		browser.open(page);

		frontPage = new FrontPage();
		zhufangguanli=new ZhuFangGuanLi();
		
		zhufangmingcheng="住房名称自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		xiangxidzhi="详细地址test" + CommonRandUtil.getDate()+ "-" + CommonRandUtil.getRam();; 
	}

	@Test
	public void addFangWu() {
		/**
		 * 网格长登录，新增住房，提交，通过根据地址查询，验证是否新增成功。
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 基础信息>>“房屋”
		frontPage.waitFangWu();
		frontPage.clickFangWu();
		// 进入页面首页，点击左侧的 基础信息>>“房屋”>>“住房管理”
		frontPage.waitZhuFangGuanLi();
		frontPage.clickZhuFangGuanLi();
		frontPage.switchPage(zhufangguanli);

		// 住房管理菜单，点击新增
		zhufangguanli.clickAdd();
		zhufangguanli.add(zhufangmingcheng,xiangxidzhi);
		//验证是否新增成功
		String newAddress=zhufangguanli.findByAddress(xiangxidzhi);
		assertEquals(xiangxidzhi, newAddress,"住房信息自住房信息新增不成功");
		
		//退出
		zhufangguanli.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
