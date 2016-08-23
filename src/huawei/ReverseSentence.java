/**   
* @Title: ReverseSentence.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 下午5:38:11
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: ReverseSentence
 * @Description:句子逆序 题目描述
 * 
 *                   将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *                   所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 
 *                   接口说明
 * 
 *                   反转句子
 * 
 * @param sentence
 *            原句子
 * @return 反转后的句子
 * 
 *         public String reverse(String sentence);
 * 
 * 
 * 
 * 
 *         输入描述: 将一个英文语句以单词为单位逆序排放。
 * 
 * 
 *         输出描述: 得到逆序的句子
 * 
 *         输入例子: I am a boy
 * 
 *         输出例子: boy a am I
 * 
 * @author Huaigui
 */
public class ReverseSentence {
	public static String reverse(String str) {
		String newStr = "";
		String[] stemp = str.split(" ");
		for (int i = stemp.length - 1; i >= 0; i--) {
			if (i != 0)
				newStr = newStr + stemp[i] + " ";
			else
				newStr += stemp[i];
		}
		return newStr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String newStr = "";
			newStr = reverse(str);
			System.out.println(newStr);
		}
	}
}
