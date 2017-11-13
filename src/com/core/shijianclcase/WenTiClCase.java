package com.core.shijianclcase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.core.data.AccountRead;
import com.core.data.CommonExcelUtil;
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

public class WenTiClCase {
	/**
	 * 问题处理测试用例：
	 * 1、网格长登录，上报问题，完成之后，点击暂存(必填信息)。
	 * 2、网格长登录，上报问题，完成之后，点击暂存(完整信息)。
	 * 3、网格长登录，上报问题，完成之后，点击暂存(完整信息)，点击编辑，自结案，再已处理问题页面验证是否自结案成功。
	 * 4、网格长登录，上报问题，完成之后，点击“结案”。
	 * 5、网格长上报提交-镇街中心派发给职能办，片区长，网格长-职能办，片区长，网格长反馈-镇街中心处理-结案。
	 * 6、网格长上报提交-镇街中心派发给职能办，片区长，网格长-职能办，片区长，网格长反馈-重新派发-网格长核查-镇街中心处理-结案。
	 * 7、镇街中心登记-派发职能办，片区长，网格长-职能办，片区长，网格长反馈-镇街中心处理-结案。
	 * 8、市级中心登记-派发镇街，市职能办-镇街中心处理。
	 */
	String excelFile = "E:\\workspace\\ywdemo\\src\\com\\core\\data\\account.xls";
	
	@Test(enabled = false)
	public void wgz_zancun() {
		/**
		 * 1、网格长登录，上报问题，完成之后，点击暂存(必填信息)。
		 */
		List<Object[]> list = CommonExcelUtil.getDataFromExcel(new File(excelFile), 1);
		int index = 0;
		// 0 1 2 3
		Object[] objects = list.get(index);// 取第几个 n-1 第二个即 2-1=1
		String username = (String) objects[0];
		String password = (String) objects[1];
		CoreBrowser Browser = BrowserUtil.getChrome();
		LoginPage page = new LoginPage();
		Browser.open(page);
		page.setUserName(username);
		page.setPassword(password);
		page.clickLogin();
		BrowserUtil.sleep(3);		
		//进入页面首页，点击抬头“事件处理”		 
		FrontPage frontPage=new FrontPage();
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击"上报"按钮，进入上报页面
		DclQuestion dclQuestion=new DclQuestion();
		frontPage.switchPage(dclQuestion);
		dclQuestion.clickSBao();
		//进入新增问题页面
		SBaoQuestion shangbaoxinzeng=new SBaoQuestion();
		dclQuestion.switchPage(shangbaoxinzeng);
		String title="网格长标题-暂存自动化"+CommonRandUtil.getRam();
		String shifadizhi="网格长事发地址-暂存自动化"+CommonRandUtil.getRam();
		String wentimiaoshu="网格长问题描述-暂存自动化"+CommonRandUtil.getRam();
		shangbaoxinzeng.addZanCun(title,shifadizhi,wentimiaoshu);
		//验证是否暂存成功，即在待处理问题页面，找到记录。
		shangbaoxinzeng.switchPage(dclQuestion);
		String biaoti=dclQuestion.findBybiaoti(title);
		//System.out.println(biaoti);
		assertEquals(title, biaoti,"暂存不成功");
		BrowserUtil.close(Browser);
	}

	@Test(enabled = false)
	public void wgz_zancun2() {
		/**
		 * 2、网格长登录，上报问题，完成之后，点击暂存(完整信息)。
		 */
		List<Object[]> list = CommonExcelUtil.getDataFromExcel(new File(excelFile), 1);
		int index = 0;
		// 0 1 2 3
		Object[] objects = list.get(index);// 取第几个 n-1 第二个即 2-1=1
		String username = (String) objects[0];
		String password = (String) objects[1];
		CoreBrowser Browser = BrowserUtil.getChrome();
		LoginPage page = new LoginPage();
		Browser.open(page);
		page.setUserName(username);
		page.setPassword(password);
		page.clickLogin();
		BrowserUtil.sleep(3);		
		//进入页面首页，点击抬头“事件处理”		 
		FrontPage frontPage=new FrontPage();
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击"上报"按钮，进入上报页面
		DclQuestion dclQuestion=new DclQuestion();
		frontPage.switchPage(dclQuestion);
		dclQuestion.clickSBao();
		//进入新增问题页面
		SBaoQuestion shangbaoxinzeng=new SBaoQuestion();
		dclQuestion.switchPage(shangbaoxinzeng);
		String title="网格长标题-暂存自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String shifadizhi="网格长事发地址-暂存自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String wentimiaoshu="网格长问题描述-暂存自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String scfujian="D:\\uplode_file.jpg";
		shangbaoxinzeng.addZanCun2(title,shifadizhi,wentimiaoshu,scfujian);
		//验证是否暂存成功，即在待处理问题页面，找到记录。
		shangbaoxinzeng.switchPage(dclQuestion);
		String biaoti=dclQuestion.findBybiaoti(title);
		System.out.println(biaoti);
		assertEquals(title, biaoti,"暂存不成功");
		BrowserUtil.close(Browser);
	}
	
	@Test(enabled = false)
	public void wgz_zancun3() {
		/**
		 * 3、网格长登录，上报问题，完成之后，点击暂存(完整信息)，点击编辑，自结案，再已处理问题页面验证是否自结案成功。
		 */
		List<Object[]> list = CommonExcelUtil.getDataFromExcel(new File(excelFile), 1);
		int index = 0;
		// 0 1 2 3
		Object[] objects = list.get(index);// 取第几个 n-1 第二个即 2-1=1
		String username = (String) objects[0];
		String password = (String) objects[1];
		CoreBrowser Browser = BrowserUtil.getChrome();
		LoginPage page = new LoginPage();
		Browser.open(page);
		page.setUserName(username);
		page.setPassword(password);
		page.clickLogin();
		BrowserUtil.sleep(3);		
		//进入页面首页，点击抬头“事件处理”.		 
		FrontPage frontPage=new FrontPage();
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//进入页面首页，点击左侧的 问题处理>>“待处理问题”.	 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击"上报"按钮，进入上报页面
		DclQuestion dclQuestion=new DclQuestion();
		frontPage.switchPage(dclQuestion);
		dclQuestion.clickSBao();
		//进入新增问题页面
		SBaoQuestion shangbaoxinzeng=new SBaoQuestion();
		dclQuestion.switchPage(shangbaoxinzeng);
		String title="网格长标题-暂存自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String shifadizhi="网格长事发地址-暂存自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String wentimiaoshu="网格长问题描述-暂存自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String scfujian="D:\\uplode_file.jpg";
		shangbaoxinzeng.addZanCun2(title,shifadizhi,wentimiaoshu,scfujian);
		//验证是否暂存成功，即在待处理问题页面，找到记录。
		shangbaoxinzeng.switchPage(dclQuestion);
		String biaoti=dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti,"暂存不成功");
		
		//点击编辑按钮
		dclQuestion.clickWtBianJi();
		dclQuestion.switchPage(shangbaoxinzeng);
		String jieAnContent="网格长问题描述-自结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		shangbaoxinzeng.editJieAn(jieAnContent);
		//在已处理问题页面，验证是否自结案成功。
		shangbaoxinzeng.switchPage(frontPage);
		frontPage.clickYiClQuestion();
		YclQuestion yclQuestion=new YclQuestion();
		frontPage.switchPage(yclQuestion);
		String ybbiaoti=yclQuestion.findYbBybiaoti(title);//***
		assertEquals(title, ybbiaoti,"自结案不成功");
		BrowserUtil.close(Browser);
	}
		
	@Test(enabled = false)
	public void wgz_zjiean() {
		/**
		 * 4、网格长登录，上报问题，完成之后，点击“结案”。
		 */
		List<Object[]> list = CommonExcelUtil.getDataFromExcel(new File(excelFile), 1);
		int index = 0;
		// 0 1 2 3
		Object[] objects = list.get(index);// 取第几个 n-1 第二个即 2-1=1
		String username = (String) objects[0];
		String password = (String) objects[1];
		CoreBrowser Browser = BrowserUtil.getChrome();
		LoginPage page = new LoginPage();
		Browser.open(page);
		page.setUserName(username);
		page.setPassword(password);
		page.clickLogin();
		BrowserUtil.sleep(3);		
		//进入页面首页，点击抬头“事件处理”		 
		FrontPage frontPage=new FrontPage();
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击"上报"按钮，进入上报页面
		DclQuestion dclQuestion=new DclQuestion();
		frontPage.switchPage(dclQuestion);
		dclQuestion.clickSBao();
		//进入新增问题页面
		SBaoQuestion shangbaoxinzeng=new SBaoQuestion();
		dclQuestion.switchPage(shangbaoxinzeng);
		String title="网格长标题-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String shifadizhi="网格长事发地址-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String wentimiaoshu="网格长问题描述-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String scfujian="D:\\uplode_file.jpg";
		String jieAnContent="网格长问题描述-自结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		shangbaoxinzeng.addZiJieAn(title,shifadizhi,wentimiaoshu,scfujian,jieAnContent);
		//在已处理问题页面，验证是否自结案成功。
		shangbaoxinzeng.switchPage(frontPage);
		frontPage.clickYiClQuestion();
		YclQuestion yclQuestion=new YclQuestion();
		frontPage.switchPage(yclQuestion);
		String ybbiaoti=yclQuestion.findYbBybiaoti(title);
		assertEquals(title, ybbiaoti,"自结案不成功");
		BrowserUtil.close(Browser);
		
	}
	
	@Test(enabled = true)
	public void zjzx_jiean() {
		/**
		 * 5、网格长上报提交-镇街中心派发给职能办，片区长，网格长-职能办，片区长，网格长反馈-镇街中心处理-镇街中心结案。
		 */
		//获取数据
		List<Account> accounts = AccountRead.getAll();
		//打开浏览器
		CoreBrowser Browser = BrowserUtil.getChrome();
		
		//打开登录页
		LoginPage page = new LoginPage();
		Browser.open(page);
		//登录
		page.login(accounts.get(0));
		BrowserUtil.sleep(3);		
		//进入页面首页，点击抬头“事件处理”		 
		FrontPage frontPage=new FrontPage();
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击"上报"按钮，进入上报页面
		DclQuestion dclQuestion=new DclQuestion();
		frontPage.switchPage(dclQuestion);
		dclQuestion.clickSBao();
		//进入新增问题页面
		SBaoQuestion shangbaoxinzeng=new SBaoQuestion();
		dclQuestion.switchPage(shangbaoxinzeng);
		String title="网格长标题-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String shifadizhi="网格长事发地址-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String wentimiaoshu="网格长问题描述-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String scfujian="D:\\uplode_file.jpg";
		shangbaoxinzeng.addShangBao(title,shifadizhi,wentimiaoshu,scfujian);
		//点击退出按钮，即退出页面。
		BrowserUtil.sleep(2);
		shangbaoxinzeng.switchPage(frontPage);
		frontPage.clickTuiChu();
		/**
		 * 镇街中心登录，进行派发操作
		 */
		page.login(accounts.get(1));
		BrowserUtil.sleep(2);		
		//镇街中心进入页面首页，点击抬头“事件处理”		 
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//镇街中心进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti=dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti,"查询不成功");
		//镇街中心，待办理问题页面，点击“派发”,进入派发页面。
		dclQuestion.clickPaiFa();
		PaiFaQuestion paifapage=new PaiFaQuestion();
		dclQuestion.switchPage(paifapage);
		String paiFaSm="网格长派发说明-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		paifapage.paiFa(paiFaSm);
		//镇街中心派发成功后，点击“退出”。
		paifapage.switchPage(frontPage);
		frontPage.clickTuiChu();
		/**
		 * 片区长登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(2));
		BrowserUtil.sleep(2);		
		//镇街中心进入页面首页，点击抬头“事件处理”		 
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//镇街中心进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti2=dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti2,"查询不成功");
		//片区长登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickChuLi();
		DealQuestion dealQuestion=new DealQuestion();
		dclQuestion.switchPage(dealQuestion);
		String fkuishuoming="片区长反馈说明-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();;
		String scfkfujian="D:\\uplode_file2.jpg";
		dealQuestion.deal(fkuishuoming,scfkfujian);
		//退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
		/**
		 * 镇街职能办登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(3));
		BrowserUtil.sleep(2);		
		//镇街职能办进入页面首页，点击抬头“事件处理”		 
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//镇街职能办进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti3=dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti3,"查询不成功");
		//镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickChuLi();
		dclQuestion.switchPage(dealQuestion);
		String fkuishuoming2="镇街职能办反馈说明-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();;
		String scfkfujian2="D:\\uplode_file2.jpg";
		dealQuestion.deal(fkuishuoming2,scfkfujian2);
		//退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
		/**
		 * 网格长登录，进入待处理问题页面，反馈问题
		 */
		page.login(accounts.get(0));
		BrowserUtil.sleep(2);		
		//镇街职能办进入页面首页，点击抬头“事件处理”		 
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//镇街职能办进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti4=dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti4,"查询不成功");
		//镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickChuLi();
		dclQuestion.switchPage(dealQuestion);
		String fkuishuoming4="网格长反馈说明-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		String scfkfujian4="D:\\uplode_file2.jpg";
		dealQuestion.deal(fkuishuoming4,scfkfujian4);
		//退出
		dealQuestion.switchPage(frontPage);
		frontPage.clickTuiChu();
		/**
		 * 镇街中心登录，对片区长，职能办，网格长反馈上来的问题，进行处理，处理完成，则结案。
		 */
		page.login(accounts.get(1));
		BrowserUtil.sleep(2);		
		//镇街职能办进入页面首页，点击抬头“事件处理”		 
		page.switchPage(frontPage);
		frontPage.waitSjchuli();
	    frontPage.clickSjchuli();
		//镇街职能办进入页面首页，点击左侧的 问题处理>>“待处理问题”		 
	    frontPage.waitDclQuestion();
		frontPage.clickDclQuestion();
		//点击高级查询
		frontPage.switchPage(dclQuestion);
		String biaoti5=dclQuestion.findBybiaoti(title);
		assertEquals(title, biaoti5,"查询不成功");
		//镇街职能办登录，待办理问题页面，点击“处理”,进入处理页面。
		dclQuestion.clickZjzxChuLi();
		dclQuestion.switchPage(dealQuestion);
		String jashuoming="镇街中心结案说明-结案自动化"+CommonRandUtil.getDate()+"-"+CommonRandUtil.getRam();
		dealQuestion.dealFkQuestion(jashuoming);
		//在处理页面，验证是否结案成功。
	}
}
