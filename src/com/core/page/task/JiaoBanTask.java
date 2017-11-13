package com.core.page.task;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class JiaoBanTask extends AbstractPage {

	/**
	 * 义乌领导登录，任务交办页面：标题
	 */
	String biaoti_loc = "title";

	public void putInTaskTitle(String title) {
		setInputByID(biaoti_loc, title);
	}

	// 义乌领导登录，任务交办页面：工作类型
	String gzlx_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[4]/td[2]/span/span/span";
	String gzlx_loc2 = "//*[@id=\"_easyui_combobox_i2_4\"]";

	public void clickTaskLeiXing() {
		clickByXpath(gzlx_loc);
		clickByXpath(gzlx_loc2);
	}

	// 义乌领导登录，任务交办页面：截止时间
	String jzsj_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[4]/td[4]/span/span/span";
	String jzsj_loc2 = "/html/body/div[2]/div/div[3]/table/tbody/tr/td[2]/a";

	public void clickTaskjzsj() {
		clickByXpath(jzsj_loc);
		clickByXpath(jzsj_loc2);

	}

	// 义乌领导登录，任务交办页面：任务描述
	String taskms_loc = "des";

	public void putInTaskMiaoShu(String taskmiaoshu) {
		setInputByID(taskms_loc, taskmiaoshu);
	}

	// 义乌领导登录，任务交办页面：上传附件
	String scfj_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[9]/td[1]/div/form/input";

	public void putInShangChuanfj(String shangchuanfujian) {
		setInputByXpath(scfj_loc, shangchuanfujian);
	}

	// 义乌领导登录，任务交办页面：选择办公室
	String xzbgs_loc = "//*[@id=\"bgsTd2\"]/span/span/span";
	String xzbgs_loc2 = "//*[@id=\"_easyui_combobox_i1_0\"]";

	public void clickXuanZebgs() {
		clickByXpath(xzbgs_loc);
		clickByXpath(xzbgs_loc2);
	}

	// 义乌领导登录，任务交办页面：点击暂存
	String rwzancun_loc = "btnZc";

	public void clickZanCun() {
		clickByClassName(rwzancun_loc);
	}

	// 义乌领导登录，任务交办页面：点击提交
	String rwtijiao_loc = "btnSubmit";

	public void clickTiJiao() {
		clickByClassName(rwtijiao_loc);
	}

	// 义乌领导登录，任务交办页面：提交之后，弹出确认信息
	String rwqueren_loc = "/html/body/div[5]/div[2]/div[4]/a[1]";

	public void clickQueren() {
		clickByXpath(rwqueren_loc);
	}

	// 义乌领导登录，任务交办页面：选择为紧急任务
	String xzJinJi_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[12]/td[2]/label[1]/input";

	public void clickJinJiTask() {
		clickByXpath(xzJinJi_loc);
	}

	// 义乌领导登录，任务交办页面,选择为紧急任务后，分派镇街
	String fenpai_loc = "//*[@id=\"zjTr\"]/td[2]/label[2]/input";

	public void clickFenPaiZhenJie() {
		clickByXpath(fenpai_loc);
	}

	// 义乌职能办登录，任务交办页面：工作类型
	String znbgzlx_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[4]/td[2]/span/span/span";
	String znbgzlx_loc2 = "//*[@id=\"_easyui_combobox_i1_4\"]";

	public void clickTaskZnbLeiXing() {
		clickByXpath(znbgzlx_loc);
		clickByXpath(znbgzlx_loc2);
	}

	// 义乌职能办登录，任务交办页面：提交之后，弹出确认信息
	String rwqxznbqueren_loc = "/html/body/div[4]/div[2]/div[4]/a[1]";

	public void clickqxznbQueren() {
		clickByXpath(rwqxznbqueren_loc);
	}

	// 义乌职能办登录，需要片区长审核
	String pqzShenHe_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[13]/td[2]/label[1]/input";

	public void clickTopqzShenHe() {
		clickByXpath(pqzShenHe_loc);
	}

	// 义乌职能办登录，不直派网格
	String notTozpwg_loc = "//*[@id=\"addTaskForm\"]/div[1]/div/table/tbody/tr[13]/td[4]/label[2]/input";

	public void clickNotTozpWangGe() {
		clickByXpath(notTozpwg_loc);
	}

	// 镇街中心登录，提交任务前，进行分派给网格。
	String fenpaiwg_loc = "//*[@id=\"wgTr\"]/td[2]/span/span/span";
	String fenpaiwg_loc2 = "//*[@id=\"_easyui_tree_1\"]/span[1]";
	String fenpaiwg_loc3 = "//*[@id=\"_easyui_tree_2\"]/span[4]";

	public void zjzxfenPaiWangGe() {
		clickByXpath(fenpaiwg_loc);
		clickByXpath(fenpaiwg_loc2);
		clickByXpath(fenpaiwg_loc3);
		clickByXpath(fenpaiwg_loc);
	}

	// 镇街中心登录，提交任务，出现的提示信息
	String qxzxqr_loc = "/html/body/div[5]/div[2]/div[4]/a[1]";

	public void clickqxzxQueren() {
		clickByXpath(qxzxqr_loc);
	}

	//镇街中心登录，处理任务，分派片区
	String fenpaipq_loc = "pqUid";

	public void fenPaiPianQu() {
		clickByName(fenpaipq_loc);
	}
	//片区长登录，提交任务时的确认信息
	String pqzqueren_loc="/html/body/div[4]/div[2]/div[4]/a[1]";
	public void clickpqzQueren(){
		clickByXpath(pqzqueren_loc);
	}
	
	//片区长登录，分派网格
	String pqzfpwg_loc="wgUid";
	public void pqzfenPaiWangGe(){
		clickByName(pqzfpwg_loc);
	}

	/**
	 * 义乌领导登录，暂存任务
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 */
	public void qxldzanCunTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickXuanZebgs();
		BrowserUtil.sleep(1);
		clickZanCun();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 待处理任务页面，点击编辑页面，点击提交
	 */
	public void clickEditTiJiao() {
		switchTo("editTaskWinWindowFrame");
		BrowserUtil.sleep(1);
		clickTiJiao();
		BrowserUtil.sleep(1);
		// 提交之后，点击确认信息
		clickQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();
	}

	/**
	 * 义乌领导登录，提交紧急任务
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void qxldtijiaoTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickJinJiTask();
		clickFenPaiZhenJie();
		BrowserUtil.sleep(1);
		clickTiJiao();
		// 确认信息
		clickQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 义乌职能办登录，提交任务
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void qxznbtijiaoTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickFenPaiZhenJie();
		BrowserUtil.sleep(1);
		clickTiJiao();
		// 确认信息
		clickqxznbQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 义乌中心登录，提交任务
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void qxzxtijiaoTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=150");
		BrowserUtil.sleep(1);
		clickFenPaiZhenJie();
		BrowserUtil.sleep(1);
		executeScript(
				"document.getElementsByClassName('panel-body panel-body-noheader panel-body-noborder layout-body')[0].scrollTop=500");
		BrowserUtil.sleep(1);
		clickTiJiao();
		// 确认信息
		clickqxznbQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街职能办登录，提交任务(不需要片区审核，直接派发网格)
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void zjznbtijiaoTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickTiJiao();
		// 确认信息
		clickqxznbQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街职能办登录，提交任务(需要片区审核，直接派发网格)
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void zjznbtijiaoTask2(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickTopqzShenHe();// 需要片区长审核
		BrowserUtil.sleep(1);
		clickTiJiao();
		// 确认信息
		clickqxznbQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街职能办登录，提交任务(需要片区审核，不直接派发网格)
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void zjznbtijiaoTask3(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickTopqzShenHe();// 需要片区长审核
		BrowserUtil.sleep(1);
		clickNotTozpWangGe();// 不直派网格
		clickTiJiao();
		// 确认信息
		clickqxznbQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街中心登录，提交任务（不需要片区审核，直接派发网格）
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void zjzxtijiaoTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		zjzxfenPaiWangGe();
		clickTiJiao();
		// 确认信息
		clickqxzxQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街中心登录，提交任务（需要片区审核，直接派发网格）
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void zjzxtijiaoTask2(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickTopqzShenHe();// 需要片区长审核
		BrowserUtil.sleep(1);
		zjzxfenPaiWangGe();
		clickTiJiao();
		// 确认信息
		clickqxzxQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 镇街中心登录，提交任务（需要片区审核，不直接派发网格）
	 * 
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void zjzxtijiaoTask3(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		clickTopqzShenHe();// 需要片区长审核
		BrowserUtil.sleep(1);
		clickNotTozpWangGe();// 不直接派发网格
		BrowserUtil.sleep(1);
		fenPaiPianQu();//分派片区
		BrowserUtil.sleep(1);
		clickTiJiao();
		// 确认信息
		clickqxzxQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();

	}

	/**
	 * 片区长登录，提交任务
	 * @param tasktitle
	 * @param taskmiaoshu
	 * @param shangchuanfujian
	 */
	public void pqztijiaoTask(String tasktitle, String taskmiaoshu, String shangchuanfujian) {
		switchTo("addTaskWinWindowFrame");
		putInTaskTitle(tasktitle);
		BrowserUtil.sleep(1);
		clickTaskZnbLeiXing();
		BrowserUtil.sleep(1);
		clickTaskjzsj();
		BrowserUtil.sleep(1);
		putInTaskMiaoShu(taskmiaoshu);
		BrowserUtil.sleep(1);
		putInShangChuanfj(shangchuanfujian);
		BrowserUtil.sleep(1);
		pqzfenPaiWangGe();
		clickTiJiao();
		// 确认信息
		clickpqzQueren();
		BrowserUtil.sleep(3);
		switchTodefaultContent();
		
	}

}
