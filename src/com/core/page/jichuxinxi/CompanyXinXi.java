package com.core.page.jichuxinxi;

import org.openqa.selenium.WebElement;

import com.core.page.base.AbstractPage;
import com.core.webdriver.BrowserUtil;

public class CompanyXinXi extends AbstractPage {

	/**
	 * 企业>>企业信息，点击新增
	 */
	String qiyexinzeng_loc = "//*[@id=\"queryDiv\"]/div[1]/div/div[1]/a[1]/span/span[1]";

	public void clickAddCompany() {
		clickByXpath(qiyexinzeng_loc);
	}

	/**
	 * 企业>>企业信息，点击编辑
	 */
	String qiyebianji_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a[2]";

	public void clickEditCompany() {
		clickByXpath(qiyebianji_loc);
	}

	/**
	 * 企业>>企业信息，点击删除
	 */
	String qiyeshanchu_loc = "//table[@class=\"datagrid-btable\"]/tbody/tr[1]/td[9]/div/a[3]";

	public void clickShanChuCompany() {
		clickByXpath(qiyeshanchu_loc);
	}

	/**
	 * 企业>>企业信息，点击查询
	 */
	String qiyechaxun_loc = "btnSearch";

	public void clickQiYeChaXun() {
		clickByClassName(qiyechaxun_loc);
	}

	/**
	 * 企业>>企业信息,在查询条件处，在企业名称处，输入企业名称
	 */
	String qiyemingcheng_loc = "companyName";

	public void putInQiYeMingCheng(String qiyemingcheng) {
		setInputByID(qiyemingcheng_loc, qiyemingcheng);
	}

	/**
	 * 
	 */
	String getqymc_loc = "html/body/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div";

	public String getCompanyName() {
		WebElement element = null;
		try {
			element = getWebElementByXpath(getqymc_loc);
			return element.getText();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 企业>>企业信息,根据企业名称查询。
	 * 
	 * @param qiyemingcheng
	 */
	public String findByQiYeMingCheng(String qiyemingcheng) {
		putInQiYeMingCheng(qiyemingcheng);
		BrowserUtil.sleep(1);
		clickQiYeChaXun();
		BrowserUtil.sleep(2);
		String companyName = getCompanyName();
		// System.out.println(companyName);
		BrowserUtil.sleep(2);
		return companyName;
	}
}
