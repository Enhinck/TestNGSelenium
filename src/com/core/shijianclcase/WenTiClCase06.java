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
import com.core.page.question.PaiFaQuestion;
import com.core.page.question.SBaoQuestion;
import com.core.page.question.YclQuestion;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class WenTiClCase06 {
	/**
	 * 问题处理测试用例：
	 * 6、网格长上报提交-镇街中心派发给职能办，片区长，网格长-职能办，片区长，网格长反馈-重新派发-网格长核查-镇街中心处理-结案。
	 */

	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;
	FrontPage frontPage;
	DclQuestion dclQuestion;
	DealQuestion dealQuestion;
	YclQuestion yclQuestion;
	PaiFaQuestion paifapage;

	String title;
	String shifadizhi;
	String wentimiaoshu;
	String scfujian;
	String jashuoming;
	String tngfankui;
	String cxpfshuoming;
	String hcshuoming;
	String scfkfujian;
	String hcfkuishuoming;

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

		title = "网格长标题-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shifadizhi = "网格长事发地址-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		wentimiaoshu = "网格长问题描述-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		scfujian = "D:\\uplode_file.jpg";
		cxpfshuoming = "镇街中心重新派发说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		hcshuoming = "镇街中心重新派发说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		hcfkuishuoming = "网格长核查反馈说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		scfkfujian = "D:\\uplode_file2.jpg";
		jashuoming = "镇街中心结案说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		tngfankui = "镇街中心同年哥反馈说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();

	}

	@Test
	public void wgzShangBao() {
		// 网格长登录
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“事件处理”
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
		frontPage.clickSjchuli();
		// 进入页面首页，点击左侧的 问题处理>>“待处理问题”
		frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		// 点击"上报"按钮，进入上报页面

		frontPage.switchPage(dclQuestion);
		dclQuestion.clickSBao();
		// 进入新增问题页面
		SBaoQuestion shangbaoxinzeng = new SBaoQuestion();
		dclQuestion.switchPage(shangbaoxinzeng);

		shangbaoxinzeng.addShangBao(title, shifadizhi, wentimiaoshu, scfujian);
		// 点击退出按钮，即退出页面。
		shangbaoxinzeng.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void zjzxPaiFa() {
		/**
		 * 镇街中心登录，进行派发操作
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
		// 点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti = dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti, "查询不成功");
		// 镇街中心，待办理问题页面，点击“派发”,进入派发页面。
		dclQuestion.clickPaiFa();
		dclQuestion.switchPage(paifapage);
		String paiFaSm = "网格长派发说明-结案自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		paifapage.paiFa(paiFaSm);
		// 镇街中心派发成功后，点击“退出”。
		paifapage.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void pqzChuLi() {
		/**
		 * 片区长登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(2));

		BrowserUtil.sleep(3);
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

	@Test
	public void znbChuLi() {
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

	@Test
	public void wgzChuLi() {
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

	@Test
	public void zjzxcxpf() {
		/**
		 * 镇街中心登录，对片区长，职能办，网格长反馈上来的问题，进行处理，处理完成，重新派发
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
		// 处理问题，重新派发
		dealQuestion.dealFkQuestion2(cxpfshuoming);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void pqzChuLi2() {
		pqzChuLi();
	}

	@Test
	public void znbChuLi2() {
		znbChuLi();
	}

	@Test
	public void wgzChuLi2() {
		wgzChuLi();
	}

	@Test
	public void zjzxhc() {
		/**
		 * 镇街中心登录，对重新派发给网格长的反馈进行处理，并且发给网格长核查
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
		// 处理问题，核查
		dealQuestion.dealFkQuestion3(hcshuoming);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void hc() {
		/**
		 * 网格长登录，进入待处理问题页面，进行核查
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
		dealQuestion.deal(hcfkuishuoming, scfkfujian);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test
	public void zjzxja() {
		/**
		 * 镇街中心登录，对网格长核查上来的问题，进行处理，处理完成，则结案。
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
		// 镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面，进行结案。
		dclQuestion.clickZjzxChuLi();
		dclQuestion.switchPage(dealQuestion);
		dealQuestion.dealFkQuestion4(jashuoming);
		// 在已处理页面，验证是否结案成功。
		dealQuestion.switchPage(frontPage);
		frontPage.clickYiClQuestion();
		frontPage.switchPage(yclQuestion);
		String ybbiaoti = yclQuestion.findYbBybiaoti(title);
		assertEquals(title, ybbiaoti, "结案不成功");
		BrowserUtil.sleep(3);
		// 退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
