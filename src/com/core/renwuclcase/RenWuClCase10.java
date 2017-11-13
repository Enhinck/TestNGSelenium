package com.core.renwuclcase;

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
import com.core.page.task.DclTask;
import com.core.page.task.DealTask;
import com.core.page.task.JiaoBanTask;
import com.core.page.task.YclTask;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class RenWuClCase10 {
	/**
	 * 测试用例：
	 * 10、镇街中心发起任务，需要片区审核，直派网格，点击提交；网格长处理，片区长审核，镇街中心审核结案。
	 * 
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;
	FrontPage frontPage;
	DclTask dcltask;
	JiaoBanTask jiaobantask;
	DealTask dealtask;
	YclTask ycltask;

	String tasktitle;
	String taskmiaoshu;
	String shangchuanfujian;
	String shangchuanfankuifujian;

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
		dcltask = new DclTask();
		jiaobantask = new JiaoBanTask();
		dealtask = new DealTask();
		ycltask = new YclTask();

		tasktitle = "zjznb任务标题自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		taskmiaoshu = "zjznb任务描述自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shangchuanfujian = "D:\\uplode_file.jpg";
		shangchuanfankuifujian = "D:\\uplode_file2.jpg";

	}

	@Test
	public void zjzxRenWuJiaoBantj() {
		// 镇街中心登录
		page.login(accounts.get(1));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclRenWu();
		frontPage.switchPage(dcltask);
		dcltask.clickTaskJiaoBan();
		// 进入任务交办任务
		dcltask.switchPage(jiaobantask);
		jiaobantask.zjzxtijiaoTask2(tasktitle, taskmiaoshu, shangchuanfujian);
		// 点击退出按钮，即退出页面。
		jiaobantask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}
	
	@Test
	public void wgzChuLi() {
		/**
		 * 网格长登录后，对任务进行处理。
		 */
		// 网格长登录
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”。
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 “待处理任务”。
		frontPage.waitDclRenWu();
		// frontPage.clickDclRenWu();
		// 在待处理页面，根据标题进行查询需要办理的任务。
		frontPage.switchPage(dcltask);
		dcltask.findbybiaoti(tasktitle);
		dcltask.clickChuLi();
		dcltask.switchPage(dealtask);
		dealtask.wgzChuLi(shangchuanfankuifujian);
		// 点击退出按钮，即退出页面。
		dealtask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void pqzShenHe() {
		/**
		 * 片区长对任务进行审核
		 */
		// 片区长登录
		page.login(accounts.get(2));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 “待处理任务”，在待任务处理页面，点击审核。
		frontPage.waitDclRenWu();
		// frontPage.clickDclRenWu();
		frontPage.switchPage(dcltask);
		dcltask.findbybiaoti(tasktitle);
		dcltask.clickTaskShenHe();
		// 进入审核页面
		dcltask.switchPage(dealtask);
		dealtask.pqzShenHe();
		// 点击退出按钮，即退出页面。
		dealtask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void zjzxShenHe() {
		/**
		 * 镇街中心对任务进行审核，结案
		 */
		// 镇街中心登录
		page.login(accounts.get(1));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 “待处理任务”，在待任务处理页面，点击审核。
		frontPage.waitDclRenWu();
		//frontPage.clickDclRenWu();
		frontPage.switchPage(dcltask);
		dcltask.findbybiaoti(tasktitle);
		dcltask.clickTaskShenHe();
		// 进入审核页面
		dcltask.switchPage(dealtask);
		dealtask.zjzxShenHe();
		// 在已处理任务页面，验证是否结案成功。
		dealtask.switchPage(frontPage);
		frontPage.clickYiClTask();
		frontPage.switchPage(ycltask);
		String newybbiaoti = ycltask.findybtaskByBiaoTi(tasktitle);
		assertEquals(tasktitle, newybbiaoti, "镇街中心结案失败");
		// 点击退出按钮，即退出页面。
		ycltask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}
	
	@AfterTest
	public void afterTest() {
		browser.close();
	}
}
