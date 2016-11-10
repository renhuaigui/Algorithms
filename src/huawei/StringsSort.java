/**   
* @Title: StringsSort.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月18日 下午7:45:36
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: StringsSort
 * @see: 题目描述: 字符串排序
 * 
 *       编写一个程序，将输入字符串中的字符按如下规则排序。 规则1：英文字母从A到Z排列，不区分大小写。 如，输入：Type 输出：epTy
 *       规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。 如，输入：BabA 输出：aABb 规则3：非英文字母的其它字符保持原来的位置。
 *       如， 输入：By?e 输出：Be?y 样例： 输入： A Famous Saying: Much Ado About
 *       Nothing(2012/8). 输出： A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * 
 * 
 *       输入描述:
 * 
 * 
 * 
 *       输出描述:
 * 
 * 
 *       输入例子: A Famous Saying: Much Ado About Nothing (2012/8)
 * 
 *       输出例子: A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * @author Huaigui
 */
public class StringsSort {
	public static void shunXu(String str) {
		int n = 0;
		StringBuilder builder = new StringBuilder();
		StringBuilder result = new StringBuilder();
		// 先对字母排序
		// 共有26个字母所以最外层的循环是26，每次循环从字符串中只选择一个字母到队列中，
		// 这样经过26次循环字符串中a-z就按顺序入队列了，再从头到尾输出即可了。
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < str.length(); j++) {
				int tmpChar = (int) str.charAt(j);
				if (tmpChar == 'a' + i || tmpChar == 'A' + i)
					builder.append(str.charAt(j));
			}
		}

		for (int k = 0; k < str.length(); k++) {
			if (!isLetter(str.charAt(k)))
				result.append(str.charAt(k));
			else {
				result.append(builder.charAt(n));
				n++;
			}
		}

		System.out.println(result.toString());
	}

	public static boolean isLetter(char ch) {
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String inPut = sc.nextLine();
			shunXu(inPut);
		}
		sc.close();
	}

}
