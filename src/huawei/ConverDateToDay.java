/**   
* @Title: ConverDateToDay.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月27日 下午2:28:35
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: ConverDateToDay
* @Description: 计算日期到天数转换
* 题目描述

根据输入的日期，计算是这一年的第几天。。
详细描述：
输入某年某月某日，判断这一天是这一年的第几天？。


输入描述:
输入三行，分别是年，月，日


输出描述:
成功:返回outDay输出计算后的第几天;
                                           失败:返回-1

输入例子:
2012

12

31

输出例子:
366
* @author Huaigui
*/
public class ConverDateToDay {
	public static int[] monthDay=new int[]{31,28,31,30,31,30,31,31,30,31,30,31}; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int year = sc.nextInt();
			int month = sc.nextInt();
			int day = sc.nextInt();
			int days = getDays(year,month,day);
			System.out.println(days);
		}
		sc.close();
	}

	/** 
	* @Title: getDays 
	* @Description: TODO
	* @param year
	* @param month
	* @param day
	* @return int
	* @throws  
	*/ 
	public static int getDays(int year, int month, int day) {
		// TODO Auto-generated method stub
		if(year<0)
			return -1;
		if(month>12||month<1)
			return -1;
		if((month==2)&&isLeapYear(year)){
			if(day>29||day<1)
				return -1;
		}
		else {
			if(day>monthDay[month-1]||day<1)
				return -1;
		}
		int result = 0;
		for(int i=1;i<month;i++)
			result = result + monthDay[i-1];
		result +=day;
		if(month>2&&isLeapYear(year)){
				result++;
		}
		return result;
	}

	/** 
	* @Title: isLeapYear 
	* @Description: 判断是否是闰年
	* @throws  
	*/ 
	public static boolean isLeapYear(int year){
		if((year%4==0 && year%100!=0)||year%400==0)
			return true;
		return false;
	}
}
