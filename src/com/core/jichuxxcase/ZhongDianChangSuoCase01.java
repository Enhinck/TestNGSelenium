package com.core.jichuxxcase;

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
import com.core.page.jichuxinxi.ZhongDianXueXiao;
import com.core.webdriver.BrowserUtil;
import com.core.webdriver.CoreBrowser;

public class ZhongDianChangSuoCase01 {
	/**
	 * 测试用例： 基础信息>>重点场所>>重点学校，新增学校，提交。
	 */
	List<Account> accounts;
	CoreBrowser browser;
	LoginPage page;

	FrontPage frontPage;
	ZhongDianXueXiao zhongdianxuexiao;
	
	String schoolName;
	String schoolAddress;
	String xiaozhang;
	String zhoubianqingkuang;
	String shangchuanfujian;//上传附件

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
		zhongdianxuexiao=new ZhongDianXueXiao();
		
		schoolName="学校名称自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();    
		schoolAddress="学校地址自动化" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		xiaozhang="学校校长" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();        
		zhoubianqingkuang="学校周边情况" + CommonRandUtil.getDate() + "-" + CommonRandUtil.getRam();
		shangchuanfujian="D:\\uplode_file.jpg";
	}
	
	@Test
	public void addCompany() {
		/**
		 * 网格长登录，新增学校，提交;通过根据学校名称查询，验证是否新增成功。
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);
		// 进入页面首页，点击抬头“基础信息”
		page.switchPage(frontPage);
		frontPage.waitJiChuXinXi();
		frontPage.clickJiChuXinXi();
		// 进入页面首页，点击左侧的 基础信息>>“重点场所”
		frontPage.waitZhongDianChangSuo();
		frontPage.clickZhongDianChangSuo();
		// 进入页面首页，点击左侧的 基础信息>>“重点场所”>>"重点学校"
		frontPage.waitZhongDianXueXiao();
		frontPage.clickZhongDianXueXiao();
		frontPage.switchPage(zhongdianxuexiao);
		// 新增重点学校
		zhongdianxuexiao.clickAddZhongDianXueXiao();
		zhongdianxuexiao.add(schoolName,schoolAddress,xiaozhang,zhoubianqingkuang,shangchuanfujian);
		
		//验证是否新增成功
		String newschoolname=zhongdianxuexiao.findBySchoolName(schoolName);//根据学校名称进行查询。
		assertEquals(schoolName, newschoolname,"重点学校新增不成功");
		
		zhongdianxuexiao.switchPage(frontPage);
		frontPage.clickTuiChu();
	}

	@AfterTest
	public void afterTest() {
		browser.close();
	}

}
