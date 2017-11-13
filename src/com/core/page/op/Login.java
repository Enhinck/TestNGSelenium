package com.core.page.op;

import java.io.File;
import java.util.List;

import com.core.data.CommonExcelUtil;
import com.core.page.LoginPage;

public class Login {
	public static void loginByExcel(String excelFile,int index,LoginPage page){
		List<Object[]> list = CommonExcelUtil.getDataFromExcel(new File(excelFile), 1);
		Object[] objects = list.get(index);// 取第几个 n-1 第二个即 2-1=1
		String username = (String) objects[0];
		String password = (String) objects[1];
		login(page, username, password);
	}
	
	
	public static void login(LoginPage page ,String username,String password){
		page.setUserName(username);
		page.setPassword(password);
		page.clickLogin();
	}

}
