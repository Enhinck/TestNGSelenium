package com.core.page.jichuxinxi;

import static org.testng.Assert.assertEquals;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class People extends AbstractPage {

	// 新增户籍人员：身份证
	String shengfenzheng_loc = "cardNum";

	public void putInCard(String cardno) {
		setInputByID(shengfenzheng_loc, cardno);
	}

	// 新增户籍人员：姓名
	String xingming_loc = "name";

	public void putInName(String name) {
		setInputByID(xingming_loc, name);
	}

	public void clickName() {
		clickById(xingming_loc);
	}

	// 新增户籍人员：提交
	String hjtijiao_loc = "btnSubmit";

	public void clickHjTiJiao() {
		clickByClassName(hjtijiao_loc);
	}

	// 编辑户籍人员：关闭
	String quxiao_loc = "btnClose";

	public void clickClose() {
		clickByClassName(quxiao_loc);
	}

	// 编辑户籍人员：填写曾用名
	String cengyongming_loc = "oldName";

	public void putInCengYongMing(String cengyongming) {
		setInputByName(cengyongming_loc, cengyongming);
	}

	// 选择重点类型，民政残联，民族，政治面貌，文化程度，血型，宗教信仰，婚姻状态
	String zhongdianlx_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[7]/td[2]/span/span/span";
	String zhongdianlx_loc2 = "//*[@id=\"_easyui_tree_8\"]/span[3]";

	public void xuanZeZhongDianLeiXing() {
		clickByXpath(zhongdianlx_loc);
		BrowserUtil.sleep(1);
		clickByXpath(zhongdianlx_loc2);
		BrowserUtil.sleep(1);
		clickByXpath(zhongdianlx_loc);
	}

	String minzhengcl_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[8]/td[2]/span/span/span";
	String minzhengcl_loc2 = "//*[@id=\"_easyui_tree_1\"]/span[3]";

	public void xuanZeMinZhengCanLian() {
		clickByXpath(minzhengcl_loc);
		BrowserUtil.sleep(1);
		clickByXpath(minzhengcl_loc2);
		BrowserUtil.sleep(1);
		clickByXpath(minzhengcl_loc);
	}

	String mingzu_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[9]/td[4]/span/span/span";
	String mingzu_loc2 = "//*[@id=\"_easyui_combobox_i4_0\"]";

	public void xuanZeMingZu() {
		clickByXpath(mingzu_loc);
		BrowserUtil.sleep(1);
		clickByXpath(mingzu_loc2);
	}

	String mingzu_loc3 = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[9]/td[4]/span/span/span";
	String mingzu_loc4 = "//*[@id=\"_easyui_combobox_i8_0\"]";

	public void xuanZeMingZu2() {
		clickByXpath(mingzu_loc3);
		BrowserUtil.sleep(1);
		clickByXpath(mingzu_loc4);
	}

	String zhengzhimianmao_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[10]/td[2]/span/span/span";
	String zhengzhimianmao_loc2 = "//*[@id=\"_easyui_combobox_i5_4\"]";

	public void xuanZeZhengZhiMianMao() {
		clickByXpath(zhengzhimianmao_loc);
		BrowserUtil.sleep(1);
		clickByXpath(zhengzhimianmao_loc2);
	}

	String zhengzhimianmao_loc3 = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[10]/td[2]/span/span/span";
	String zhengzhimianmao_loc4 = "//*[@id=\"_easyui_combobox_i9_4\"]";

	public void xuanZeZhengZhiMianMao2() {
		clickByXpath(zhengzhimianmao_loc3);
		BrowserUtil.sleep(1);
		clickByXpath(zhengzhimianmao_loc4);
	}

	String wenhuachengdu_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[10]/td[4]/span/span/span";
	String wenhuachengdu_loc2 = "//*[@id=\"_easyui_combobox_i6_2\"]";

	public void xuanZeWenHuaChengDu() {
		clickByXpath(wenhuachengdu_loc);
		BrowserUtil.sleep(1);
		clickByXpath(wenhuachengdu_loc2);
	}

	String wenhuachengdu_loc3 = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[10]/td[4]/span/span/span";
	String wenhuachengdu_loc4 = "//*[@id=\"_easyui_combobox_i10_2\"]";

	public void xuanZeWenHuaChengDu2() {
		clickByXpath(wenhuachengdu_loc3);
		BrowserUtil.sleep(1);
		clickByXpath(wenhuachengdu_loc4);
	}

	String xuexing_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[11]/td[2]/span/span/span";
	String xuexing_loc2 = "//*[@id=\"_easyui_combobox_i7_8\"]";

	public void xuanZeXueXing() {
		clickByXpath(xuexing_loc);
		BrowserUtil.sleep(1);
		clickByXpath(xuexing_loc2);
	}

	String xuexing_loc3 = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[11]/td[2]/span/span/span";
	String xuexing_loc4 = "//*[@id=\"_easyui_combobox_i11_8\"]";

	public void xuanZeXueXing2() {
		clickByXpath(xuexing_loc3);
		clickByXpath(xuexing_loc4);
	}

	String xinyang_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[12]/td[2]/span/span/span";
	String xinyang_loc2 = "//*[@id=\"_easyui_combobox_i8_0\"]";

	public void xuanZeXinYang() {
		clickByXpath(xinyang_loc);
		BrowserUtil.sleep(1);
		clickByXpath(xinyang_loc2);
	}

	String xinyang_loc3 = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[12]/td[2]/span/span/span";
	String xinyang_loc4 = "//*[@id=\"_easyui_combobox_i12_6\"]";

	public void xuanZeXinYang2() {
		clickByXpath(xinyang_loc3);
		BrowserUtil.sleep(1);
		clickByXpath(xinyang_loc4);
	}

	String hunyinzt_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[12]/td[4]/span/span/span";
	String hunyinzt_loc2 = "//*[@id=\"_easyui_combobox_i9_4\"]";

	public void xuanZeHunYinZhuangTai() {
		clickByXpath(hunyinzt_loc);
		BrowserUtil.sleep(1);
		clickByXpath(hunyinzt_loc2);
	}

	String hunyinzt_loc3 = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[12]/td[4]/span/span/span";
	String hunyinzt_loc4 = "//*[@id=\"_easyui_combobox_i13_4\"]";

	public void xuanZeHunYinZhuangTai2() {
		clickByXpath(hunyinzt_loc3);
		BrowserUtil.sleep(1);
		clickByXpath(hunyinzt_loc4);
	}

	// 输入手机号码，输入email
	String telnumber_loc = "cellphone";

	public void putInTelNumber(String telnumber) {
		setInputByID(telnumber_loc, telnumber);
	}

	String email_loc = "email";

	public void putInEmail(String email) {
		setInputByID(email_loc, email);
	}

	// 输入现住地址，其他地址
	String xianzhudizhi_loc = "currentAddress";

	public void putInXianZhuDiZhi(String xianzhudizhi) {
		setInputByID(xianzhudizhi_loc, xianzhudizhi);
	}

	String qitadizhi_loc = "otherAddress";

	public void putInQiTaDiZhi(String qitadizhi) {
		setInputByID(qitadizhi_loc, qitadizhi);
	}

	// 输入相同的身份证号时，弹出提示信息：该人员已经存在，将跳转至编辑页面！
	String tishixinxi_loc = "/html/body/div[25]/div[2]/div[2]";

	public String getTiShiXinXi() {
		return getWebElementByXpath(tishixinxi_loc).getText();
	}

	String tishiqueding_loc = "/html/body/div[25]/div[2]/div[4]/a";

	public void clickTiShiQueDing() {
		clickByXpath(tishiqueding_loc);
	}

	// 户籍人员，点击迁出：迁出时间
	String qianchushijian_loc = "//*[@id=\"columnForm\"]/table/tbody/tr[2]/td[2]/span/span/span";
	String qianchushijian_loc2 = "/html/body/div[6]/div/div[2]/table/tbody/tr/td[1]/a";

	public void clickQianChuTime() {
		clickByXpath(qianchushijian_loc);
		clickByXpath(qianchushijian_loc2);
	}

	// 户籍人员，点击迁出：选择前往网格
	String qianwangwangge_loc = "//*[@id=\"targetOrgTr\"]/td[2]/span[1]/span/span";
	String qianwangwangge_loc2 = "//*[@id=\"_easyui_combobox_i1_0\"]";
	String qianwangwangge_loc3 = "//*[@id=\"targetOrgTr\"]/td[2]/span[2]/span/span";
	String qianwangwangge_loc4 = "//*[@id=\"_easyui_combobox_i2_0\"]";
	String qianwangwangge_loc5 = "//*[@id=\"targetOrgTr\"]/td[2]/span[3]/span/span";
	String qianwangwangge_loc6 = "//*[@id=\"_easyui_combobox_i3_0\"]";
	String qianwangwangge_loc7 = "//*[@id=\"targetOrgTr\"]/td[2]/span[4]/span/span";
	String qianwangwangge_loc8 = "//*[@id=\"_easyui_combobox_i4_0\"]";

	public void xuanZeQianWangWangGe() {
		clickByXpath(qianwangwangge_loc);
		clickByXpath(qianwangwangge_loc2);
		clickByXpath(qianwangwangge_loc3);
		clickByXpath(qianwangwangge_loc4);
		clickByXpath(qianwangwangge_loc5);
		clickByXpath(qianwangwangge_loc6);
		clickByXpath(qianwangwangge_loc7);
		clickByXpath(qianwangwangge_loc8);

	}

	// 户籍人员，点击迁出：输入前往地址
	String qianwangdizhi_loc = "targetAddress";

	public void putInQianWangDiZhi(String qianwangdizhi) {
		setInputByID(qianwangdizhi_loc, qianwangdizhi);
	}

	// 户籍人员，点击迁出：点击提交
	String qianchutijiao_loc = "submitBtn";

	public void clickQianChuTiJiao() {
		clickById(qianchutijiao_loc);
	}

	// 户籍人员，点击常转流：点击暂住信息tab页
	String zanzhuxinxi_loc = "";

	public void clickZanZhuXinXi() {

	}

	// 户籍人员，点击常转流：选择流入原因
	String liudongyuanyin_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/span/span/span";
	String liudongyuanyin_loc2 = "//*[@id=\"_easyui_combobox_i18_0\"]";

	public void xuanZeLiuRuYuanYin() {
		clickByXpath(liudongyuanyin_loc);
		clickByXpath(liudongyuanyin_loc2);
	}

	// 户籍人员，点击常转流：选择流入时间
	String liurushijian_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[2]/div/table/tbody/tr[2]/td[4]/span/span/span";
	String liurushijian_loc2 = "/html/body/div[28]/div/div[2]/table/tbody/tr/td[1]/a";

	public void xuanZeLiuRuShiJian() {
		clickByXpath(liurushijian_loc);
		clickByXpath(liurushijian_loc2);
	}
	//户籍人员，点击删除：输入删除备注
	String shanchubeizhu_loc="note";
	public void putInShanChuBeiZhu(String shanchubeizhu){
		setInputByID(shanchubeizhu_loc,shanchubeizhu);
	}
	//户籍人员，点击删除：提交
	String shanchutijiao_loc="btnSubmit";
	public void clickShanChuTiJiao(){
		clickByClassName(shanchutijiao_loc);
	}

	/**
	 * 新增户籍人员（必填项）。
	 * 
	 * @param cardno
	 * @param name
	 */
	public void add(String cardno, String name) {
		switchTo("addPeopleWinWindowFrame");
		putInCard(cardno);
		BrowserUtil.sleep(1);
		putInName(name);
		BrowserUtil.sleep(1);
		clickHjTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
		switchTo("editPeopleWinWindowFrame");
		clickClose();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	/**
	 * 针对add(String cardno, String name)方法提交的户籍人口，对户籍人口进行编辑，对其信息进行补充
	 */
	public void edit(String cengyongming, String telnumber, String email, String xianzhudizhi, String qitadizhi) {
		switchTo("editPeopleWinWindowFrame");
		BrowserUtil.sleep(1);
		putInCengYongMing(cengyongming);
		BrowserUtil.sleep(1);
		xuanZeZhongDianLeiXing();// 选择重点类型：吸毒人员
		BrowserUtil.sleep(1);
		xuanZeMinZhengCanLian();// 选择民政残联：低保户
		BrowserUtil.sleep(1);
		xuanZeMingZu();// 选择民族：汉族
		BrowserUtil.sleep(1);
		xuanZeZhengZhiMianMao();// 选择政治面貌：群众
		BrowserUtil.sleep(1);
		xuanZeWenHuaChengDu();// 选择文化程度：大学本科
		BrowserUtil.sleep(1);
		xuanZeXueXing();// 选择血型：其他
		BrowserUtil.sleep(1);
		xuanZeXinYang();// 选择信仰：无
		BrowserUtil.sleep(1);
		xuanZeHunYinZhuangTai();// 选择婚姻状态：其他
		BrowserUtil.sleep(1);
		putInTelNumber(telnumber);// 输入电话号码
		BrowserUtil.sleep(1);
		putInEmail(email);// 输入email地址
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder')[0].scrollTop=10000");
		BrowserUtil.sleep(1);
		putInXianZhuDiZhi(xianzhudizhi);// 输入现状地址
		BrowserUtil.sleep(1);
		putInQiTaDiZhi(qitadizhi);// 输入其他地址
		BrowserUtil.sleep(1);
		clickHjTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 在户籍页面的查看人员页面，提取身份证号
	 * 
	 * @return
	 */
	String cardnumber_loc = "//*[@id=\"peopleTabs\"]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]";

	public String getCardNumber() {
		return getWebElementByXpath(cardnumber_loc).getText();
	}

	public String getCardNumberFromChaKanYeMian() {
		switchTo("peopleWinWindowFrame");
		String cardnumberfromckym = getCardNumber();
		clickClose();
		switchTodefaultContent();
		return cardnumberfromckym;
	}

	/**
	 * 新增户籍人员（完整项）。
	 * 
	 * @param cardno
	 * @param name
	 * @param cengyongming
	 * @param telnumber
	 * @param email
	 * @param xianzhudizhi
	 * @param qitadizhi
	 */
	public void add(String cardno, String name, String cengyongming, String telnumber, String email,
			String xianzhudizhi, String qitadizhi) {
		switchTo("addPeopleWinWindowFrame");
		putInCard(cardno);
		BrowserUtil.sleep(1);
		putInName(name);
		BrowserUtil.sleep(1);
		putInCengYongMing(cengyongming);
		BrowserUtil.sleep(1);
		xuanZeZhongDianLeiXing();// 选择重点类型：吸毒人员
		BrowserUtil.sleep(1);
		xuanZeMinZhengCanLian();// 选择民政残联：低保户
		BrowserUtil.sleep(1);
		xuanZeMingZu2();// 选择民族：汉族
		BrowserUtil.sleep(1);
		xuanZeZhengZhiMianMao2();// 选择政治面貌：群众
		BrowserUtil.sleep(1);
		xuanZeWenHuaChengDu2();// 选择文化程度：大学本科
		BrowserUtil.sleep(1);
		xuanZeXueXing2();// 选择血型：其他
		BrowserUtil.sleep(1);
		xuanZeXinYang2();// 选择信仰：无
		BrowserUtil.sleep(1);
		xuanZeHunYinZhuangTai2();// 选择婚姻状态：其他
		BrowserUtil.sleep(1);
		putInTelNumber(telnumber);// 输入电话号码
		BrowserUtil.sleep(1);
		putInEmail(email);// 输入email地址
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder')[0].scrollTop=10000");
		BrowserUtil.sleep(1);
		putInXianZhuDiZhi(xianzhudizhi);// 输入现状地址
		BrowserUtil.sleep(1);
		putInQiTaDiZhi(qitadizhi);// 输入其他地址
		BrowserUtil.sleep(1);

		clickHjTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
		switchTo("editPeopleWinWindowFrame");
		clickClose();
		BrowserUtil.sleep(2);
		switchTodefaultContent();

	}

	/**
	 * 新增，输入相同的身份证号
	 * 
	 * @param cardno
	 */
	public void add(String cardno) {
		switchTo("addPeopleWinWindowFrame");
		putInCard(cardno);
		BrowserUtil.sleep(1);
		clickName();
		BrowserUtil.sleep(1);
		String tishixinxi = getTiShiXinXi();
		// System.out.println(tishixinxi);
		assertEquals(tishixinxi, "该人员已经存在，将跳转至编辑页面!");
		clickTiShiQueDing();
		switchTodefaultContent();
		switchTo("editPeopleWinWindowFrame");
		clickHjTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	/**
	 * 户籍人员 ，迁出
	 * 
	 * @param qianwangdizhi
	 */
	public void qianChu(String qianwangdizhi) {
		switchTo("peopleWinWindowFrame");
		clickQianChuTime();
		BrowserUtil.sleep(1);
		xuanZeQianWangWangGe();
		BrowserUtil.sleep(2);
		putInQianWangDiZhi(qianwangdizhi);
		BrowserUtil.sleep(1);
		clickQianChuTiJiao();
		BrowserUtil.sleep(3);
		switchTodefaultContent();
	}

	/**
	 * 户籍人员 ，常转流
	 */
	public void changZhuanLiu() {
		switchTo("editPeopleWinWindowFrame");
		BrowserUtil.sleep(1);
		clickHjTiJiao();
		BrowserUtil.sleep(2);
		//clickZanZhuXinXi();// 点击暂住信息tab页
		xuanZeLiuRuYuanYin();// 选择流入原因
		BrowserUtil.sleep(1);
		xuanZeLiuRuShiJian();// 选择流入时间
		BrowserUtil.sleep(1);
		clickHjTiJiao();
		BrowserUtil.sleep(2);
		switchTodefaultContent();
	}

	/**
	 * 户籍人口，删除
	 * @param shanchubeizhu
	 */
	public void shanchu(String shanchubeizhu) {
		switchTo("deleteWinWindowFrame");
		BrowserUtil.sleep(1);
		putInShanChuBeiZhu(shanchubeizhu);
		clickShanChuTiJiao();
		switchTodefaultContent();
	}

}
