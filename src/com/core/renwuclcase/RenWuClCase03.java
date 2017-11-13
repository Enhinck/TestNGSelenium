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

public class RenWuClCase03 {
	/**
	 * 测试用例：3、义乌市领导发起紧急任务，直接分派镇街,点击提交；区县中心，镇街中心进行任务处理；区县领导审核结案。
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

		tasktitle = "ywld紧急任务标题自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		taskmiaoshu = "ywld紧急任务描述自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shangchuanfujian = "D:\\uplode_file.jpg";
		shangchuanfankuifujian = "D:\\uplode_file2.jpg";

	}

	@Test
	public void ywldRenWuJiaoBantj_JinJi() {
		// 义乌领导登录
		page.login(accounts.get(6));
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
		jiaobantask.qxldtijiaoTask(tasktitle, taskmiaoshu, shangchuanfujian);
		// 点击退出按钮，即退出页面。
		jiaobantask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void ywzxChuLi_JinJi() {
		/**
		 * 义乌中心登录，对紧急任务进行处理。
		 */
		// 义乌职能办登录
		page.login(accounts.get(4));
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
		dealtask.qxzxChuLi();
		// 点击退出按钮，即退出页面。
		dealtask.switchPage(frontPage);
		frontPage.clickYiWuTuiChu();
	}
	@Test
	public void zjzxChuLi_JinJi() {
		/**
		 * 镇街中心登录后，对紧急任务进行处理。
		 */
		// 镇街中心登录
		page.login(accounts.get(1));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”。
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 “待处理任务”。
		frontPage.waitDclRenWu();
		//frontPage.clickDclRenWu();
		// 在待处理页面，根据标题进行查询需要办理的任务。
		frontPage.switchPage(dcltask);
		dcltask.findbybiaoti(tasktitle);
		dcltask.clickChuLi2();
		dcltask.switchPage(dealtask);
		dealtask.zjzxChuLi(shangchuanfankuifujian);
		// 点击退出按钮，即退出页面。
		dealtask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}
	@Test
	public void qxldShenHe_JinJi() {
		/**
		 * 区县领导对紧急任务进行审核，结案
		 */
		// 义乌领导登录
		page.login(accounts.get(6));
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
		dealtask.qxldShenHe();
		// 在已处理任务页面，验证是否结案成功。
		dealtask.switchPage(frontPage);
		frontPage.clickYiClTask();
		frontPage.switchPage(ycltask);
		String newybbiaoti = ycltask.findybtaskByBiaoTi(tasktitle);
		assertEquals(tasktitle, newybbiaoti, "义乌领导结案失败");
		// 点击退出按钮，即退出页面。
		ycltask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}
}
