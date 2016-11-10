/**   
* @Title: jifujunzheng.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月23日 下午6:52:22
* @version V1.0   
*/
package huawei;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @ClassName: jifujunzheng
* @Description:记负均正II
* 
* 题目描述

从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值

输入描述:
输入任意个整数


输出描述:
输出负数个数以及所有非负数的平均值

输入例子:
-13
-4
-7

输出例子:
3
0.0
* @author Huaigui
*/
public class Jifujunzheng {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		List<Integer> intArr = new ArrayList<Integer>();
		float sum=0;
		int count = 0;
		while(sc.hasNextInt()){
			intArr.add(sc.nextInt());
		}
		for(int n:intArr){
			if(n<0){
				count++;
			}
			else {
				sum += n;
			}
		}
		DecimalFormat df = new DecimalFormat("#.0");
		if(count == intArr.size()){
			System.out.println(count);
			System.out.println(sum);
		}
		else {
			System.out.println(count);
			System.out.println(df.format(sum/(intArr.size()-count)));
		}
	}
}
