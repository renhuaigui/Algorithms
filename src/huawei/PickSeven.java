/**   
* @Title: PickSeven.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年9月9日 下午4:40:19
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: PickSeven
 * @see: 挑7 题目描述
 * 
 *       输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 * 
 *       输入描述: 一个正整数N。(N不大于30000)
 * 
 * 
 *       输出描述: 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 * 
 *       输入例子: 20
 * 
 *       输出例子: 3
 * @author Huaigui
 */
public class PickSeven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int count = 0;
			for (int i = 7; i <= n; i++) {
				String s = i + "";
				if (i % 7 == 0 || s.indexOf("7") != -1) {
					count++;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}
