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
import com.core.page.jichuxinxi.Company;
import com.core.page.jichuxinxi.CompanyXinXi;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class CompanyCase02 {
	/**
	 * 测试用例： 基础信息>>企业，新增企业(必填)，提交之后;点击编辑，再次提交；点击删除，验证是否删除成功。
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;

	FrontPage frontPage;
	CompanyXinXi companyxinxi;
	Company company;

	String qiyemingcheng;
	String qiyedizhi;
	String fadingdaibiaoren;
	String telnumber;
	String anquanshengchanfuzeren;
	String telnumber2;// 安监信息内的移动电话
	String qiyemingcheng2;
	String deletebeizhu;//删除备注

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
		companyxinxi = new CompanyXinXi();
		company = new Company();

		qiyemingcheng = "企业名称自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		qiyedizhi = "企业地址自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		fadingdaibiaoren = "法定代表人" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		telnumber = TelNumber.getTel(); // 随机生成手机号码
		anquanshengchanfuzeren = "安全生产负责人" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		telnumber2 = TelNumber.getTel(); // 随机生成手机号码
		qiyemingcheng2 = "企业名称编辑自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		deletebeizhu="企业删除自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
	}

	@Test
	public void editCompany() {
		/**
		 * 网格长登录，新增企业(必填)，提交之后;通过根据企业名称查询，验证是否新增成功。
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 基础信息>>“企业”
		frontPage.waitQiYe();
		frontPage.clickQiYe();
		// 进入页面首页，点击左侧的 基础信息>>“企业”>>"企业信息"
		frontPage.waitQiYeXinXi();
		frontPage.clickQiYeXinXi();

		frontPage.switchPage(companyxinxi);
		// 新增企业信息
		companyxinxi.clickAddCompany();
		companyxinxi.switchPage(company);
		company.add(qiyemingcheng, qiyedizhi, fadingdaibiaoren, telnumber, anquanshengchanfuzeren, telnumber2);
		// 验证是否企业新增成功。
		company.switchPage(companyxinxi);
		String companyName = companyxinxi.findByQiYeMingCheng(qiyemingcheng);// 根据企业名称进行查询。
		assertEquals(qiyemingcheng, companyName, "企业新增不成功");

		// 编辑企业信息
		companyxinxi.clickEditCompany();
		companyxinxi.switchPage(company);
		company.edit(qiyemingcheng2);
		// 验证是否企业新增成功。
		company.switchPage(companyxinxi);
		String companyName2 = companyxinxi.findByQiYeMingCheng(qiyemingcheng2);// 根据企业名称进行查询。
		assertEquals(qiyemingcheng2, companyName2, "企业编辑不成功");

		// 删除企业
		companyxinxi.clickShanChuCompany();
		companyxinxi.switchPage(company);
		company.delete(deletebeizhu);
		// 验证是否企业新增成功。
		company.switchPage(companyxinxi);
		String companyName22 = companyxinxi.findByQiYeMingCheng(qiyemingcheng2);// 根据企业名称进行查询。
		assertNull(companyName22);
		// 点击退出按钮，即退出页面。
		companyxinxi.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
