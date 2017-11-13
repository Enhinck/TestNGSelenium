package com.core.shijianclcase;

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
import com.core.page.question.DclQuestion;
import com.core.page.question.DealQuestion;
import com.core.page.question.DengJiQuestion;
import com.core.page.question.PaiFaQuestion;
import com.core.page.question.YclQuestion;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class WenTiClCase07 {
	/**
	 * 问题处理测试用例：
	 * 7、镇街中心登记-派发职能办，片区长，网格长-职能办，片区长，网格长反馈-镇街中心处理-结案。
	 */
	
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;
	FrontPage frontPage;
	DclQuestion dclQuestion;
	DealQuestion dealQuestion;
	YclQuestion yclQuestion;
	PaiFaQuestion paifapage;
	DengJiQuestion dengjipage;

	String title;
	String shifadizhi;
	String wentimiaoshu;
	String scfujian;
	String jashuoming;
	String tngfankui;
	String paiFaSm;

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
		dclQuestion = new DclQuestion();
		dealQuestion = new DealQuestion();
		yclQuestion = new YclQuestion();
		paifapage = new PaiFaQuestion();
		dengjipage =new DengJiQuestion();
		
		title = "zj登记标题-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shifadizhi = "zj登记事发地址-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		wentimiaoshu = "zj登记问题描述-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		scfujian = "D:\\uplode_file.jpg";
		paiFaSm = "镇街中心派发说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		
		jashuoming = "镇街中心结案说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		tngfankui = "镇街中心同年哥反馈说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();

	}
	@Test
	public void zjzxDj() {
		/**
		 * 镇街中心登录，进行登记操作。
		 */
		page.login(accounts.get(1));
		BrowserUtil.sleep(2);
		// 镇街中心进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 镇街中心进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		// 镇街中心，待办理问题页面，点击“登记”,进入新增。
		frontPage.switchPage(dclQuestion);
		dclQuestion.clickZJDengji();
		dclQuestion.switchPage(dengjipage);
		dengjipage.zjdengJi(title,shifadizhi,wentimiaoshu,scfujian,paiFaSm);
		// 镇街中心派发成功后，点击“退出”。
		dengjipage.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test(dependsOnMethods = { "zjzxDj" })
	public void pqz1() {
		/**
		 * 片区长登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(2));

		BrowserUtil.sleep(2);
		// 镇街中心进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 镇街中心进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		// 点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti2 = dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti2, "查询不成功");
		// 片区长登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickChuLi();
		dclQuestion.switchPage(dealQuestion);
		String fkuishuoming = "片区长反馈说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		String scfkfujian = "D:\\uplode_file2.jpg";
		dealQuestion.deal(fkuishuoming, scfkfujian);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test(dependsOnMethods = { "pqz1" })
	public void znb1() {
		/**
		 * 镇街职能办登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(3));

		BrowserUtil.sleep(2);
		// 镇街职能办进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 镇街职能办进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		// 点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti3 = dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti3, "查询不成功");
		// 镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickChuLi();
		dclQuestion.switchPage(dealQuestion);
		String fkuishuoming2 = "镇街职能办反馈说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		String scfkfujian2 = "D:\\uplode_file2.jpg";
		dealQuestion.deal(fkuishuoming2, scfkfujian2);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test(dependsOnMethods = { "znb1" })
	public void wgz2() {
		/**
		 * 网格长登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(0));

		BrowserUtil.sleep(2);
		// 镇街职能办进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 镇街职能办进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		// 点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti4 = dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti4, "查询不成功");
		// 镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickChuLi();
		dclQuestion.switchPage(dealQuestion);
		String fkuishuoming4 = "网格长反馈说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		String scfkfujian4 = "D:\\uplode_file2.jpg";
		dealQuestion.deal(fkuishuoming4, scfkfujian4);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test(dependsOnMethods = { "wgz2" })
	public void zjzx2() {
		/**
		 * 镇街中心登录，对片区长，职能办，网格长反馈上来的问题，进行处理，处理完成，则结案。
		 */
		page.login(accounts.get(1));
		BrowserUtil.sleep(2);
		// 镇街职能办进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 镇街职能办进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		// 点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti5 = dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti5, "查询不成功");
		// 镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickZjzxChuLi();
		dclQuestion.switchPage(dealQuestion);
		dealQuestion.dealFkQuestion(jashuoming);
		// 在处理页面，验证是否结案成功。
		dealQuestion.switchPage(frontPage);
		frontPage.clickYiClQuestion();
		frontPage.switchPage(yclQuestion);
		String ybbiaoti = yclQuestion.findYbBybiaoti(title);
		assertEquals(title, ybbiaoti, "结案不成功");
		BrowserUtil.sleep(3);
		// 退出
		yclQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
