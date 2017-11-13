package com.core.jichuxxcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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

public class FangWuCase03 {
	/**
	 * 测试用例： 基础信息>>房屋>>住房管理，新增提交(使用类别为出租房)；编辑后，提交；点击删除
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;

	FrontPage frontPage;
	ZhuFangGuanLi zhufangguanli;
	
	String zhufangmingcheng;
	String xiangxidzhi;
	String chuzuren;
	String xiangxidzhi2;//变更详细地址
	String shanchubeizhu;//删除备注

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
		xiangxidzhi="详细地址test" + CommonRandUtil.getDate()+ "-" + CommonRandUtil.getRam(); 
		chuzuren="出租人test" + CommonRandUtil.getDate(); 
		xiangxidzhi2="详细地址test2" + CommonRandUtil.getDate()+ "-" + CommonRandUtil.getRam();
		shanchubeizhu="删除备注" + CommonRandUtil.getDate()+ "-" + CommonRandUtil.getRam();
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
		zhufangguanli.add(zhufangmingcheng,xiangxidzhi,chuzuren);
		//验证是否新增成功
		String newAddress=zhufangguanli.findByAddress(xiangxidzhi);
		assertEquals(xiangxidzhi, newAddress,"住房信息出租房信息新增不成功");
		
		//退出
		zhufangguanli.switchPage(frontPage);
		frontPage.clickTuiChu();
	}
	
	@Test(dependsOnMethods={"addFangWu"})
	public void editFangWu() {
		/**
		 * 网格长登录，编辑后，提交；
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
		zhufangguanli.findByAddress(xiangxidzhi);
		
		// 住房管理菜单，点击新增
		zhufangguanli.clickEdit();
		zhufangguanli.edit(xiangxidzhi2);
		//验证是否新增成功
		String newAddress=zhufangguanli.findByAddress(xiangxidzhi2);
		assertEquals(xiangxidzhi2, newAddress,"住房信息出租房信息编辑不成功");
		
		//退出
		zhufangguanli.switchPage(frontPage);
		frontPage.clickTuiChu();
	}
	@Test(dependsOnMethods={"editFangWu"})
	public void deleteFangWu() {
		/**
		 * 网格长登录，对编辑过的进行删除；
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
		zhufangguanli.findByAddress(xiangxidzhi2);
		// 住房管理菜单，点击删除
		zhufangguanli.clickDelete();
		zhufangguanli.delete(shanchubeizhu);
		//验证是否删除成功(删除成功之后的信息，只能进行查看)
		String newBianJi=zhufangguanli.findByAddress22(xiangxidzhi2);
		assertNull(newBianJi,"住房信息出租房信息删除不成功");
		
		//退出
		zhufangguanli.switchPage(frontPage);
		frontPage.clickTuiChu();
	}


	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
