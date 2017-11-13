package com.core.jichuxxcase;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.data.AccountRead;
import com.core.data.CardNumber;
import com.core.data.CommonRandUtil;
import com.core.data.TelNumber;
import com.core.page.FrontPage;
import com.core.page.LoginPage;
import com.core.page.base.Account;
import com.core.page.jichuxinxi.HuJiRenKou;
import com.core.page.jichuxinxi.People;
import com.core.page.jichuxinxi.ZhongDianPeople;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class HuJiRenKouCase04 {

	/**
	 * 测试用例： 基础信息>>户籍人口，新增（完整信息）,提交之后，点击迁出，迁出网格至佛堂镇-义南工业区-1-1（傅晓康）ft010101
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;

	FrontPage frontPage;
	HuJiRenKou hujirenkou;
	People people;
	ZhongDianPeople zhongdianrenyuan;

	CardNumber cardnumber;
	String cardno;
	String name;
	String cengyongming;
	String telnumber;
	String email;
	String xianzhudizhi;
	String qitadizhi;
	String qianwangdizhi;

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
		hujirenkou = new HuJiRenKou();
		people = new People();
		cardnumber = new CardNumber();
		zhongdianrenyuan = new ZhongDianPeople();

		cardno = cardnumber.getRandomID();
		name = "姓名自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		cengyongming = "曾用名自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		telnumber = TelNumber.getTel(); // 随机生成手机号码
		email = TelNumber.getEmail(1, 15);// 随机生成email
		xianzhudizhi = "现住地址自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		qitadizhi = "其他地址自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		qianwangdizhi = "前往地址" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
	}

	@Test
	public void AddPeople() {
		/**
		 * 网格长登录，新增户籍人口(完整信息)
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 实有人口>>“户籍人口”
		// frontPage.waitHuJiRenYuan();
		// frontPage.clickHuJiRenYuan();
		frontPage.switchPage(hujirenkou);
		hujirenkou.clickAddPeople();
		hujirenkou.switchPage(people);
		people.add(cardno, name, cengyongming, telnumber, email, xianzhudizhi, qitadizhi);
		// 新增完成之后，验证在户籍人口列表,重点人员>>吸毒人员两处方向验证。
		people.switchPage(hujirenkou);
		String newcard = hujirenkou.findByCard(cardno);
		assertEquals(cardno, newcard, "户籍人口新增不成功，因为在户籍人口列表未找到");
		hujirenkou.switchPage(frontPage);
		frontPage.waitZhongDianRenYuan();
		frontPage.clickZhongDianRenYuan();// 点击重点人员
		frontPage.waitXiDuRenYuan();
		frontPage.clickXiDuRenYuan();// 点击吸毒人员
		frontPage.switchPage(zhongdianrenyuan);
		String newcard2 = zhongdianrenyuan.findbyCard(cardno);// 根据身份证号码进行查询并提取身份证号
		assertEquals(cardno, newcard2, "新增户籍人口成功，重点人员的吸毒人员不存在");
		// 点击退出按钮，即退出页面。
		zhongdianrenyuan.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@Test(dependsOnMethods = { "AddPeople" })
	public void QianChuTo() {
		/**
		 * 新增用户完成之后，提交之后，点击迁出，迁出网格至佛堂镇-义南工业区-1-1（傅晓康）ft010101
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 实有人口>>“户籍人口”
		// frontPage.waitHuJiRenYuan();
		// frontPage.clickHuJiRenYuan();
		frontPage.switchPage(hujirenkou);
		hujirenkou.findByCard(cardno);
		hujirenkou.clickQianChu();
		hujirenkou.switchPage(people);
		people.qianChu(qianwangdizhi);
		// 点击退出按钮，即退出页面。
		people.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	/**
	 * 验证：网格至佛堂镇-义南工业区-1-1（傅晓康）网格长（ft010101）登录，是否出现在基础信息中的户籍人口列表中。
	 */
	@Test(dependsOnMethods = { "QianChuTo" })
	public void QianRu() {
		page.login(accounts.get(7));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 实有人口>>“户籍人口”
		// frontPage.waitHuJiRenYuan();
		// frontPage.clickHuJiRenYuan();
		frontPage.switchPage(hujirenkou);
		String newcard = hujirenkou.findByCard(cardno);
		assertEquals(cardno, newcard, "户籍人口迁出不成功，因为在户籍人口列表未找到");
		// 点击退出按钮，即退出页面。
		hujirenkou.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}
}
