/**   
* @Title: CharCounts.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 下午2:43:55
* @version V1.0   
*/
package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
* @ClassName: CharCounts
* @Description: 题目描述
* 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
* 
* 输入描述:
* 输入N个字符，字符在ACSII码范围内(0~127)。
* 输出描述:
* 输出字符的个数。
* 
* 输入例子:  abc
* 
* 输出例子:  3
* @author Huaigui
*/
public class CharCounts {
	public static void  main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String str="";
		while(sc.hasNext()){
			int n = 0;
			Set<String>set = new HashSet<String>();
			str = sc.nextLine();
			for (int i = 0; i < str.length(); i++) {
				String c = str.substring(i,i+1);
				System.out.println(c);
				if(!set.contains(c)){
					set.add(c);
					n++;
				}
			}
			System.out.println(n);
		}
	}
}
