package com.core.jichuxxcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.data.AccountRead;
import com.core.data.CommonRandUtil;
import com.core.data.TelNumber;
import com.core.page.FrontPage;
import com.core.page.LoginPage;
import com.core.page.base.Account;
import com.core.page.jichuxinxi.JiaZhengShangJia;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class JiaZhengShangJiaCase02 {
	/**
	 * 测试用例： 基础信息>>家政商家>>家政商家，新增提交；编辑提交；删除
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;

	FrontPage frontPage;
	JiaZhengShangJia jiazhengshangjia;

	String shangjiamingcheng;// 商家名称
	String faren;// 法人
	String lianxiren;// 联系人
	String telphone;// 手机
	String shangjiadizhi;// 商家地址
	String ywmiaoshu;// 业务描述
	String shangjiamingcheng02;// 编辑商家名称

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
		jiazhengshangjia = new JiaZhengShangJia();

		shangjiamingcheng = "商家名称自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		faren = "法人test" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		lianxiren = "联系人自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		telphone = TelNumber.getTel();
		shangjiadizhi = "商家地址自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		ywmiaoshu = "业务描述自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shangjiamingcheng02 = "商家名称自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();

	}

	@Test
	public void editJiaZhengShangJia() {
		/**
		 * 网格长登录，新增家政商家，提交，通过根据商家名称查询，验证是否新增成功。
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 基础信息>>“家政商家”
		frontPage.waitJiaZhengShangJia();
		frontPage.clickJiaZhengShangJia();
		// 进入页面首页，点击左侧的 基础信息>>“家政商家”>>“家政商家”
		frontPage.waitJiaZhengShangJia2();
		frontPage.clickJiaZhengShangJia2();
		frontPage.switchPage(jiazhengshangjia);

		// 家政商家，点击新增
		jiazhengshangjia.clickAddJiaZhengShangJia();
		jiazhengshangjia.add(shangjiamingcheng, faren, lianxiren, telphone, shangjiadizhi, ywmiaoshu);
		// 验证是否新增成功
		String newshangjiamingcheng = jiazhengshangjia.findByShangJiaMingCheng(shangjiamingcheng);
		assertEquals(shangjiamingcheng, newshangjiamingcheng, "家政商家新增失败");
		
		//家政商家，点击编辑
		jiazhengshangjia.clickEditJiaZhengShangJia();
		jiazhengshangjia.edit(shangjiamingcheng02);
		// 验证是否编辑成功
		String newshangjiamingcheng2 = jiazhengshangjia.findByShangJiaMingCheng(shangjiamingcheng02);
		assertEquals(shangjiamingcheng02, newshangjiamingcheng2, "家政商家更新失败");
		
		//家政商家，点击删除
		jiazhengshangjia.clickDeleteJiaZhengShangJia();
		jiazhengshangjia.delete();
		// 验证是否删除成功
		String newshangjiamingcheng22 = jiazhengshangjia.findByShangJiaMingCheng(shangjiamingcheng02);
		assertNull(newshangjiamingcheng22,"家政商家删除失败");
		
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
