package com.core.data;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonRandUtil {
	
	/**
	 * 生成一个随机数
	 */
	public static int getRam(){
		//Random r = new Random();
		int ran = (int) (Math.random()*1000);
		return ran;
	}
	
	public static String getDate(){
		Date d = new Date();  
       // System.out.println(d);  
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);  
        return dateNowStr;
	}
	public static String getDate2(){
		Date d = new Date();  
       // System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);  
        return dateNowStr;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(getRam());
		System.out.println(getDate2());	
	}
	
}



