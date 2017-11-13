package com.core.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CardNumber {

	// 18位身份证号码各位的含义:
	// 1-2位省、自治区、直辖市代码；
	// 3-4位地级市、盟、自治州代码；
	// 5-6位县、县级市、区代码；
	// 7-14位出生年月日，比如19670401代表1967年4月1日；
	// 15-17位为顺序号，其中17位（倒数第二位）男为单数，女为双数；
	// 18位为校验码，0-9和X。
	// 作为尾号的校验码，是由把前十七位数字带入统一的公式计算出来的，
	// 计算的结果是0-10，如果某人的尾号是0－9，都不会出现X，但如果尾号是10，那么就得用X来代替，
	// 因为如果用10做尾号，那么此人的身份证就变成了19位。X是罗马数字的10，用X来代替10
	public static void main(String[] args) {
		CardNumber cre = new CardNumber();
		String randomID = cre.getRandomID();
		System.out.println(randomID);

	}

	/**
	 * 获取随机生成的身份证号码
	 * 
	 * @return
	 */
	public String getRandomID() {
		String id = "420222199204179999";
		// 随机生成省、自治区、直辖市代码 1-2
		String provinces[] = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37",
				"41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
				"81", "82" };
		String province = randomOne(provinces);
		// 随机生成地级市、盟、自治州代码 3-4
		String city = randomCityCode(18);
		// 随机生成县、县级市、区代码 5-6
		String county = randomCityCode(28);
		// 随机生成出生年月 7-14
		String birth = randomBirth(20, 50);
		// 随机生成顺序号 15-17(随机性别)
		String no = new Random().nextInt(899) + 100 + "";
		// 前17位
		String code17 = province + city + county + birth + no;

		char[] cArr = code17.toCharArray();
		int[] iCard = converCharToInt(cArr);
		int iSum17 = getPowerSum(iCard);
		// 获取校验位
		String val = getCheckCode18(iSum17);

		id = code17 + val;

		return id;
	}

	/**
	 * 将power和值与11取模获得余数进行校验码判断
	 * 
	 * @param iSum
	 * @return 校验位
	 */
	public static String getCheckCode18(int iSum) {
		String sCode = "";
		switch (iSum % 11) {
		case 10:
			sCode = "2";
			break;
		case 9:
			sCode = "3";
			break;
		case 8:
			sCode = "4";
			break;
		case 7:
			sCode = "5";
			break;
		case 6:
			sCode = "6";
			break;
		case 5:
			sCode = "7";
			break;
		case 4:
			sCode = "8";
			break;
		case 3:
			sCode = "9";
			break;
		case 2:
			sCode = "x";
			break;
		case 1:
			sCode = "0";
			break;
		case 0:
			sCode = "1";
			break;
		}
		return sCode;
	}

	/** 每位加权因子 */
	public static final int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	/**
	 * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
	 * 
	 * @param iArr
	 * @return 身份证编码。
	 */
	public static int getPowerSum(int[] iArr) {
		int iSum = 0;
		if (power.length == iArr.length) {
			for (int i = 0; i < iArr.length; i++) {
				for (int j = 0; j < power.length; j++) {
					if (i == j) {
						iSum = iSum + iArr[i] * power[j];
					}
				}
			}
		}
		return iSum;
	}

	/**
	 * 将字符数组转换成数字数组
	 * 
	 * @param ca
	 *            字符数组
	 * @return 数字数组
	 */
	public static int[] converCharToInt(char[] ca) {
		int len = ca.length;
		int[] iArr = new int[len];
		try {
			for (int i = 0; i < len; i++) {
				iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return iArr;
	}

	/**
	 * 从String[] 数组中随机取出其中一个String字符串
	 * 
	 * @return
	 */
	public String randomOne(String s[]) {
		return s[new Random().nextInt(s.length - 1)];
	}

	/**
	 * 随机生成两位数的字符串（01-max）,不足两位的前面补0
	 * 
	 * @param max
	 * @return
	 */
	public String randomCityCode(int max) {
		int i = new Random().nextInt(max) + 1;
		return i > 9 ? i + "" : "0" + i;
	}

	/**
	 * 随机生成minAge到maxAge年龄段的人的生日日期
	 * 
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public String randomBirth(int minAge, int maxAge) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());// 设置当前日期
		// 随机设置日期为前maxAge年到前minAge年的任意一天
		int randomDay = 365 * minAge + new Random().nextInt(365 * (maxAge - minAge));
		date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
		return dft.format(date.getTime());
	}

}
