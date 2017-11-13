package com.core.page;

import org.openqa.selenium.By;

import com.core.page.base.AbstractPage;

public class FrontPage extends AbstractPage {

	/**
	 * (网格长)登录后，首页面抬头: 基础信息，事件处理
	 */
	String sjchuli_loc = "//*[@id=\"menuLiSjcl\"]/div";

	public void clickSjchuli() {
		getWebElementByXpath(sjchuli_loc).click();
	}

	/**
	 * 登录后，首页面左侧: 问题处理
	 */
	String wtchuli_loc = "html/body/div[1]/div[2]/div/div/div[1]/div/ul[2]/li[1]/div";

	public void clickWTchuli() {
		getWebElementByXpath(wtchuli_loc).click();
	}

	/**
	 * 登录后，首页面左侧: 问题处理>>待处理问题
	 */
	String dclQuestion_loc = "html/body/div[1]/div[2]/div/div/div[1]/div/ul[2]/li[2]/ul/li[1]/div";

	public void clickDclQuestion() {
		getWebElementByXpath(dclQuestion_loc).click();
	}

	public void waitSjchuli() {
		waitForLoad(By.xpath(sjchuli_loc), 10);
	}

	public void waitWTchuli() {
		waitForLoad(By.xpath(wtchuli_loc), 10);
	}

	public void waitDclQuestion() {
		waitForLoad(By.xpath(dclQuestion_loc), 10);
	}

	/**
	 * 登录后，首页面左侧: 问题处理>>已处理问题
	 */
	String yclQuestion_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[2]/li[2]/ul/li[2]/div";

	public void clickYiClQuestion() {
		getWebElementByXpath(yclQuestion_loc).click();
	}

	/**
	 * 退出
	 */
	String tuiChu_loc = "//*[@id=\"indexDiv\"]/div[1]/div/div/div/ul/li[2]/div/a";

	public void clickTuiChu() {
		getWebElementByXpath(tuiChu_loc).click();

	}

	/**
	 * 义乌登录后，点击退出
	 */
	String ywtuiChu_loc = "//*[@id=\"indexDiv\"]/div[1]/div/div/div/ul/li[3]/div/a";

	public void clickYiWuTuiChu() {
		getWebElementByXpath(ywtuiChu_loc).click();

	}

	/**
	 * 义乌领导登录，点击待处理任务
	 */

	String ywldclrw_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[1]/li[2]/ul/li[1]/div";

	public void clickDclRenWu() {
		getWebElementByXpath(ywldclrw_loc).click();

	}

	public void waitDclRenWu() {
		waitForLoad(By.xpath(ywldclrw_loc), 10);
	}

	/**
	 * 点击已处理任务
	 */
	String ywldYclTask = "//*[@id=\"mainDiv\"]/div[1]/div/ul[1]/li[2]/ul/li[2]/div";

	public void clickYiClTask() {
		getWebElementByXpath(ywldYclTask).click();

	}

	public void waitYiClTask() {
		waitForLoad(By.xpath(ywldYclTask), 10);
	}

	/**
	 * 点击基础信息
	 */
	String jcxx_loc = "//*[@id=\"menuLiDatabase\"]/div";

	public void clickJiChuXinXi() {
		getWebElementByXpath(jcxx_loc).click();

	}

	public void waitJiChuXinXi() {
		waitForLoad(By.xpath(jcxx_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的实有人口
	 */
	String shiyourenkou_loc = "//*[@id=\"ulLi_def\"]/div";

	public void clickShiYouRenKou() {
		getWebElementByXpath(shiyourenkou_loc).click();

	}

	public void waitShiYouRenKou() {
		waitForLoad(By.xpath(shiyourenkou_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的实有人口>>户籍人员
	 */
	String hujirenyuan_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[1]/li[2]/ul/li[1]/div";

	public void clickHuJiRenYuan() {
		getWebElementByXpath(hujirenyuan_loc).click();

	}

	public void waitHuJiRenYuan() {
		waitForLoad(By.xpath(hujirenyuan_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的实有人口>>流动人员
	 */
	String liudongrenyuan_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[1]/li[2]/ul/li[2]/div";

	public void clickLiuDongRenYuan() {
		getWebElementByXpath(liudongrenyuan_loc).click();

	}

	public void waitLiuDongRenYuan() {
		waitForLoad(By.xpath(liudongrenyuan_loc), 10);

	}

	/**
	 * 基础信息：点击重点人员
	 */
	String zhongdianrenyuan_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[2]/li[1]/div";

	public void clickZhongDianRenYuan() {
		getWebElementByXpath(zhongdianrenyuan_loc).click();
	}

	public void waitZhongDianRenYuan() {
		waitForLoad(By.xpath(zhongdianrenyuan_loc),10);

	}

	/**
	 * 基础信息：点击重点人员的吸毒人员
	 */
	String xidurenyuan_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[2]/li[2]/ul/li[4]/div";

	public void clickXiDuRenYuan() {
		getWebElementByXpath(xidurenyuan_loc).click();
	}

	public void waitXiDuRenYuan() {
		waitForLoad(By.xpath(xidurenyuan_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的企业
	 */
	String qiye_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[5]/li[1]/div";

	public void clickQiYe() {
		getWebElementByXpath(qiye_loc).click();
	}

	public void waitQiYe() {
		waitForLoad(By.xpath(qiye_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的企业信息
	 */
	String qiyexinxi_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[5]/li[2]/ul/li/div";

	public void clickQiYeXinXi() {
		getWebElementByXpath(qiyexinxi_loc).click();
	}

	public void waitQiYeXinXi() {
		waitForLoad(By.xpath(qiyexinxi_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的重点场所
	 */
	String zhongdianchangsuo_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[4]/li[1]/div";

	public void clickZhongDianChangSuo() {
		getWebElementByXpath(zhongdianchangsuo_loc).click();
	}

	public void waitZhongDianChangSuo() {
		waitForLoad(By.xpath(zhongdianchangsuo_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的重点场所>>重点学校
	 */
	String zhongdianxuexiao_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[4]/li[2]/ul/li[1]/div";

	public void clickZhongDianXueXiao() {
		getWebElementByXpath(zhongdianxuexiao_loc).click();
	}

	public void waitZhongDianXueXiao() {
		waitForLoad(By.xpath(zhongdianxuexiao_loc), 10);

	}

	/**
	 * 基础信息:点击左侧的家政商家
	 */
	String jiazhengshangjia_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[6]/li[1]/div";

	public void clickJiaZhengShangJia() {
		getWebElementByXpath(jiazhengshangjia_loc).click();
	}

	public void waitJiaZhengShangJia() {
		waitForLoad(By.xpath(jiazhengshangjia_loc), 10);
	}

	/**
	 * 基础信息:点击左侧的家政商家>>家政商家
	 */
	String jiazhengshangjia_loc2 = "//*[@id=\"mainDiv\"]/div[1]/div/ul[6]/li[2]/ul/li/div";

	public void clickJiaZhengShangJia2() {
		getWebElementByXpath(jiazhengshangjia_loc2).click();
	}

	public void waitJiaZhengShangJia2() {
		waitForLoad(By.xpath(jiazhengshangjia_loc2), 10);
	}

	/**
	 * 基础信息:点击左侧的房屋
	 */
	String fangwu_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[8]/li[1]/div";

	public void clickFangWu() {
		getWebElementByXpath(fangwu_loc).click();
	}

	public void waitFangWu() {
		waitForLoad(By.xpath(fangwu_loc), 10);
	}

	/**
	 * 基础信息:点击左侧的房屋>>住房管理
	 */
	String zhufangguanli_loc = "//*[@id=\"mainDiv\"]/div[1]/div/ul[8]/li[2]/ul/li[3]/div";

	public void clickZhuFangGuanLi() {
		getWebElementByXpath(zhufangguanli_loc).click();
	}

	public void waitZhuFangGuanLi() {
		waitForLoad(By.xpath(zhufangguanli_loc), 10);
	}

}