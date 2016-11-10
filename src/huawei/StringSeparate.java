/**   
* @Title: StringSeparate.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月2日 下午9:17:13
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: StringSeparate
 * @see: 字符串分隔
 * 
 *       题目描述： •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组； •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 
 *       输入描述: 连续输入字符串(输入2次,每个字符串长度小于100)
 * 
 *       输出描述: 输出到长度为8的新字符串数组
 * 
 *       输入例子: abc 123456789
 * 
 *       输出例子: abc00000 12345678 90000000
 * 
 * 
 * @author Huaigui
 */
public class StringSeparate {
	/*
	 * public static void main(String[] args) {
	 * 
	 * Scanner sc = new Scanner(System.in); while (sc.hasNext()) {
	 * ArrayList<String> strs= new ArrayList<String>(); String s; int length=0;
	 * s = sc.nextLine(); if (s.length()!=0) { length=s.length(); int num =
	 * length/8; for (int i = 0; i <=num; i++) { if(i==num && s.length()%8!=0){
	 * String str; str= s.substring(8*i, s.length()); for(;str.length()<8;)
	 * str=str+"0"; strs.add(str); } else if(i<num) { strs.add(s.substring(i*8,
	 * i*8+8)); } } } for (int i = 0; i < strs.size(); i++) {
	 * System.out.println(strs.get(i)); } }
	 * 
	 * }
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int count = sc.nextInt();
			while (count > -1) {
				String s = sc.nextLine();
				StringBuffer sb = new StringBuffer(s);
				if (s.length() % 8 != 0) {
					int n = 8 - s.length() % 8;
					for (int i = 0; i < n; i++) {
						sb.append("0");
					}
				}
				while (sb.length() >= 8) {
					System.out.println(sb.substring(0, 8));
					sb = sb.delete(0, 8);
				}
				count--;
			}
		}
	}
}
