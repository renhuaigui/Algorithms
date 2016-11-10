/**   
* @Title: ZhaoLingQian.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月10日 下午4:29:47
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: ZhaoLingQian
 * @see: 题目描述]
 * 我们知道人民币有1、2、5、10、20、50、100这几种面值。现在给你n(1≤n≤250)元，
 * 让你计算换成用上面这些面额表示且总数不超过100张，共有几种。比如4元，能用4张1元、
 * 2张1元和1张2元、2张2元，三种表示方法。
 * 输入：输入有多组，每组一f，为一个整合n。输入以0结束。
 * 输出：输出该面额有几种表示方法。
 * 样例输入：
 * 1
 * 4
 * 0
 * 样例输出：
 * 1
 * 3
 * @author Huaigui
 */

/**
 * 思路 找钱的面值只有7种：1，2，5，10，20，50，100；
 * 当输入一个n值介于某两个面值之间时，如n=25，则n介于20到50之间，那么所找钱的最大值为20；
 * 利用递归的思想，此时找钱的方法数可分为两类，一类是包含20面值，另一类是不包含20，
 * 利用加法原理，将两类相加即可，而对于这两类还可以继续分，对于包含20的，那么面值此时变成了n-20=5；对于不包含20的，
 * 则所找的面值最大为10块，这样递归下去；
 *
 * 递推式为：find(n,i)=find(n-RMB[i],i)+find(n,i-1)；
 *
 * 其中RMB[]={1，2，5，10，20，50，100}; i是指向第一个小于等于n值的RMB[i]的下标。
 */
public class ZhaoLingQian {
	static int money[] = { 1, 2, 5, 10, 20, 50, 100 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int input = sc.nextInt();
			if (input == 0) {
				return;
			}
			int count = money.length;
			int index = 0;
			for (int i = count - 1; i >= 0; i--) {
				if (input >= money[i]) {
					index = i;
					break;
				}
			}
			System.out.println(ChangeMoney(input, index));
		}
		sc.close();
	}

	public static int ChangeMoney(int n, int index) {
		if (n == 1 || n == 0 || index == 0) {
			return 1;
		}
		if (n < 0 || index < 0) {
			return 0;
		}
		return ChangeMoney(n - money[index], index) + ChangeMoney(n, index - 1);
	}
}
