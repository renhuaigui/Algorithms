/**   
* @Title: NumberOfCharInString.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年5月31日 下午9:14:54
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: NumberOfCharInString
 * @see: 题目描述: 计算字符个数
 *       写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 
 *       输入描述: 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * 
 *       输出描述: 输出输入字符串中含有该字符的个数。
 * 
 *       输入例子: ABCDEF A 输出例子: 1
 * 
 * 
 * @author Huaigui
 */
public class NumberOfCharInString {
	public static void main(String[] args) {
		int length = 0;
		int number = 0;
		char c;
		String str;
		Scanner sca = new Scanner(System.in);
		while (sca.hasNext()) {
			str = sca.nextLine();
			c = sca.nextLine().charAt(0);

			length = str.length();
			for (int i = 0; i < length - 1; i++) {
				if (str.charAt(i) == c) {
					number++;
				} else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' && c >= 'A' && c <= 'Z') {
					if (str.charAt(i) == c - 32)
						number++;
				} else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && c >= 'a' && c <= 'z') {
					if (str.charAt(i) == c + 32)
						number++;
				}
			}

			System.out.println(number);
		}

	}
}
