/**   
* @Title: FourOperations.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年9月9日 下午3:43:18
* @version V1.0   
*/
package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
* @ClassName: FourOperations
* @Description: 四则运算
* 题目描述


约束：
pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
pucExpression算术表达式的有效性由调用者保证; 
 


输入描述:
输入一个算术表达式


输出描述:
得到计算结果

输入例子:
3+2*{1+2*[-4/(8-6)+7]}

输出例子:
25
* @author Huaigui
*/
public class FourOperations {
	/**
	 * 功能：四则运算 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
	 * 返回：算术表达式的计算结果
	 */
	public static int calculate(String str) {
		int res = 0;
		char[] ch = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		int temp = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				temp = temp + ch[i] - '0';
				while (i + 1 < ch.length && ch[i + 1] >= '0' && ch[i + 1] <= '9') {
					i++;
					temp = temp * 10 + ch[i] - '0';
				}
			}
			if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
				stack.push(ch[i]);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

		}
		sc.close();
	}
}
