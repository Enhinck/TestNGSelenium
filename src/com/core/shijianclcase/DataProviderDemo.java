package com.core.shijianclcase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@DataProvider(name="testData") 
	public Object[][] dataProvider() {
		return new Object[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
	}

	
	@DataProvider(name="data2") 
	public Iterator<Object[]> data2() {
		 List<Object> item = new ArrayList<Object>();
		 item.add("222");
		 item.add("333");
		 
		 List<Object[]> users = new ArrayList<Object[]>();

	        for (Object u : item) {
	            //做一个形式转换
	            users.add(new Object[] { u });
	        }
	        return users.iterator();
		
	}

	
	//数据驱动调用原理
	public static void main(String[] args) {
		DataProviderDemo d = new DataProviderDemo();
		
		Iterator<Object[]> it = d.data2();
		while ( it.hasNext()) {
			String type = (String) it.next()[0];
			
			//区别在这里  数据驱动 采用反射调用
			 d.testDataDriven(type);
		}
	}
	
	@Test(dataProvider="testData")
	public void testDataDriven(int a, int b) {
		
		System.out.println("this is : " + (a + b));
	}
	
	
	@Test(dataProvider="data2")
	public void testDataDriven(String string) {
		
		
		System.out.println("this is : "+string );
	}

}
