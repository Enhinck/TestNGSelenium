package com.core.page;

import com.core.page.base.AbstractPage;
import com.core.page.base.Account;

public class LoginPage extends AbstractPage {

	/**
	 * 登录页面
	 * @param username
	 */
	public void setUserName(String username) {
		setInputByName("username", username);
	}

	public void setPassword(String password) {
		setInputByName("password", password);
	}

	public void clickLogin() {
		getWebElementByClassName("login_btn").click();
	}

	public void login(Account account) {
		setUserName(account.getUsername());
		setPassword(account.getPassword());
		clickLogin();
	}

	
}
