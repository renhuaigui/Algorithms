/**   
* @Title: StringSort.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月6日 下午9:25:20
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
* @ClassName: StringSort
* @Description: 题目描述:字串的连接最长路径查找

给定n个字符串，请对n个字符串按照字典序排列。 
输入描述:
输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。


输出描述:
数据输出n行，输出结果为按照字典序排列的字符串。

输入例子:
9
cap
to
cat
card
two
too
up
boat
boot

输出例子:
boat
boot
cap
card
cat
to
too
two
up
* @author Huaigui
*/
public class StringSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.parseInt(sc.nextLine());
			List<String> str = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				str.add(sc.nextLine());
			}
			Collections.sort(str);
			for (String s: str) {
				System.out.println(s);
			}
		}
	}
}
