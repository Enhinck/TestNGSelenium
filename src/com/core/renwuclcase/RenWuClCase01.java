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
import com.core.page.task.JiaoBanTask;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class RenWuClCase01 {
	/**
	 * 测试用例： 1、义乌市领导发起非紧急任务，选择办公室，点击暂存。
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;
	FrontPage frontPage;
	DclTask dcltask;
	JiaoBanTask jiaobantask;

	String tasktitle;
	String taskmiaoshu;
	String shangchuanfujian;

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

		tasktitle = "ywld任务标题-暂存自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		taskmiaoshu = "ywld任务描述-暂存自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shangchuanfujian = "D:\\uplode_file.jpg";
	}

	@Test
	public void ywldTaskJiaoBanzc_JinJi() {
		// 义乌领导登录
		page.login(accounts.get(6));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 “待处理任务”，在待任务处理页面，点击“任务交办”。
		frontPage.waitDclRenWu();
		frontPage.clickDclRenWu();
		frontPage.switchPage(dcltask);
		dcltask.clickTaskJiaoBan();
		// 进入任务交办任务
		dcltask.switchPage(jiaobantask);
		jiaobantask.qxldzanCunTask(tasktitle, taskmiaoshu, shangchuanfujian);
		// 验证是否暂存成功，即在待处理任务页面，找到记录。
		jiaobantask.switchPage(dcltask);
		String newbiaoti = dcltask.findbybiaoti(tasktitle);
		assertEquals(tasktitle, newbiaoti, "任务暂存不成功");
		// 点击退出按钮，即退出页面。
		dcltask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}
}
