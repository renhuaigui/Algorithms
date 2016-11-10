/**   
 * @Title: ReverseString.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 下午5:17:25
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: ReverseString
 * @see: 题目描述: 字符串颠倒
 * 
 *       描述： 输入一个整数，将这个整数以字符串的形式逆序输出 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 
 * 
 *       输入描述: 输入一个int整数
 * 
 * 
 *       输出描述: 将这个整数以字符串的形式逆序输出
 * 
 *       输入例子: 1516000
 * 
 *       输出例子: 0006151
 * @author Huaigui
 */
public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String newStr = "";
			while (!str.equals("")) {
				newStr = str.substring(0, 1) + newStr;
				str = str.substring(1);
			}
			System.out.println(newStr);
		}
	}
}
