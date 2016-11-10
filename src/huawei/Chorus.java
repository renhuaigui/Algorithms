/**   
* @Title: Chorus.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月24日 下午4:05:15
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: Chorus
* @see: 合唱队
* 题目描述

计算最少出列多少位同学，使得剩下的同学排成合唱队形
说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得Ti<T2<......<Ti-1<Ti>Ti+1>......>TK。 
     你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 
 


输入描述:
整数N


输出描述:
最少需要几位同学出列

输入例子:
8
186 186 150 200 160 130 197 200

输出例子:
4
* @author Huaigui
*/

/**
 * 思路： 第一遍从左往右，第二遍从右往左，然后把两遍动态规划的结果相加，取最大的那个， 比如8 186 186 150 200 160 130 197
 * 200， 第一遍dp的结果是 1 1 1 2 2 1 3 4， 第二遍dp的结果为3 3 2 3 2 1 1 1，那么相加最大是5，
 * 所以需要出列的同学个数就是8-5+1=4.代码如下：
 */
public class Chorus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] Inc = new int[n]; // 存储正向递增子序列，
			int[] Dec = new int[n]; // 存储反向递增子序列，
			int result = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// 正向遍历(左到右)，查找每个元素结尾的递增子序列的长度
			Inc[0] = 1;
			for (int i = 1; i < n; i++) {
				Inc[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && Inc[j] > Inc[i] - 1) {
						Inc[i] = Inc[j] + 1;
					}
				}
			}

			// 反向遍历（右到左）
			Dec[n - 1] = 1;
			for (int i = n - 2; i >= 0; i--) {
				Dec[i] = 1;
				for (int j = n - 1; j > i; j--) {
					if (arr[i] > arr[j] && Dec[j] > Dec[i] - 1) {
						Dec[i] = Dec[j] + 1;
					}
				}
			}

			// 合并
			for (int i = 0; i < n; i++) {
				if (result < (Inc[i] + Dec[i]))
					result = Inc[i] + Dec[i];
			}
			System.out.println(n - result + 1);
		}
		sc.close();
	}
}
