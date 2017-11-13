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

public class RenWuClCase02 {
	/**
	 * 测试用例： 2、义乌市领导发起非紧急任务，选择办公室，暂存后，点击提交；区县职能办，区县中心，镇街中心进行任务处理；区县领导审核结案。
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

		tasktitle = "ywld非任务标题-暂存自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		taskmiaoshu = "ywld非任务描述-暂存自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shangchuanfujian = "D:\\uplode_file.jpg";
		shangchuanfankuifujian = "D:\\uplode_file2.jpg";
	}

	@Test
	public void ywldRenWuJiaoBanzc_feiJinJi() {
		/**
		 * 义乌领导任务交办给义乌职能办（非紧急）。
		 */
		// 义乌领导登录
		page.login(accounts.get(6));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 “待处理任务”，在待任务处理页面，点击“任务交办”。
		frontPage.waitDclRenWu();
		//frontPage.clickDclRenWu();
		frontPage.switchPage(dcltask);
		dcltask.clickTaskJiaoBan();
		// 进入任务交办任务
		dcltask.switchPage(jiaobantask);
		jiaobantask.qxldzanCunTask(tasktitle, taskmiaoshu, shangchuanfujian);
		// 搜索到暂存任务，点击“编辑”，提交
		jiaobantask.switchPage(dcltask);
		dcltask.findbybiaoti(tasktitle);
		dcltask.clickEditTask();
		dcltask.switchPage(jiaobantask);
		jiaobantask.clickEditTiJiao();
		// 点击退出按钮，即退出页面。
		jiaobantask.switchPage(frontPage);
		frontPage.clickTuiChu();

	}

	@Test
	public void ywbgsChuLi_feiJinJi() {
		/**
		 * 义乌职能办对任务进行处理。
		 */
		// 义乌职能办登录
		page.login(accounts.get(8));
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
		dcltask.clickChuLi();
		dcltask.switchPage(dealtask);
		dealtask.qxZhiNengBanChuLi();
		// 点击退出按钮，即退出页面。
		dealtask.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void ywzxChuLi_feiJinJi() {
		/**
		 * 义乌职能办处理之后，义乌中心对任务进行处理。
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
		//frontPage.clickDclRenWu();
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
	public void zjzxChuLi_feiJinJi() {
		/**
		 * 义乌中心处理之后，镇街中心对任务进行处理。
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
	public void qxldShenHe_feiJinJi() {
		/**
		 * 区县领导进行审核，结案
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
