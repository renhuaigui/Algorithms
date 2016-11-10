/**   
* @Title: HexToDecimal.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 上午9:09:51
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: HexToDecimal
 * @see : 题目描述: 
 * 		写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ） 输入描述:
 *      输入一个十六进制的数值字符串。
 *
 *      输出描述: 输出该数值的十进制字符串。
 *
 *
 *      输入例子: 0xA
 *
 *      输出例子: 10
 *
 * @author Huaigui
 */
public class HexToDecimal {
	public static int hexToDecimal(String s) {
		int num = 0;
		char[] str = s.toCharArray();
		// System.out.println(Integer.parseInt(s,16));
		for (int i = 0; i < str.length; i++) {

			// num = Integer.parseInt(s,16);
			if (str[i] >= 'A' && str[i] <= 'F') {
				num = num + (str[i] - 'A' + 10) * (int) Math.pow(16, str.length - 1 - i);
			} else {
				num = num + (str[i] - '0') * (int) Math.pow(16, str.length - 1 - i);
			}
		}
		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> strs = new ArrayList<String>();
		while (sc.hasNext()) {
			// strs.add(sc.nextLine());
			System.out.println(hexToDecimal(sc.nextLine().substring(2)));
		}
		// for (int i = 0; i < strs.size(); i++) {
		// if (strs.get(i).substring(0, 2).equals("0x") &&
		// strs.get(i).length()>2) {
		// System.out.println(hexToDecimal(strs.get(i).substring(2)));
		// }
		// }
	}
}
