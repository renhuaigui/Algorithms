/**   
* @Title: LastWordLength.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年5月31日 下午7:38:07
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: LastWordLength
 * @see: 题目描述:字符串最后一个单词的长度 计算字符串最后一个单词的长度，单词以空格隔开。
 * 
 *       输入描述: 一行字符串。
 * 
 *       输出描述: 整数N，最后一个单词的长度。
 * 
 *       输入例子:hello world 输出例子:5
 * 
 * @author Huaigui
 */
public class LastWordLength {
	public static int lengthOfLast(String str) {
		/*
		 * String []s= str.split(" "); return s[s.length-1].length();
		 */

		int lenght = 0;
		int flag = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (flag == 1 && str.charAt(i) == ' ') {
				i--;
			} else if (str.charAt(i) != ' ') {
				lenght++;
				flag = 0;
			} else {
				break;
			}
		}
		return lenght;
	}

	public static void main(String[] args) {
		String string;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			string = scanner.nextLine();
			System.out.println(lengthOfLast(string));
		}
	}
}
