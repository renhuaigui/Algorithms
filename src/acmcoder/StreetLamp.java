/**   

* @Title: StreetLamp.java
* @Package acmcoder
* @Description:路灯
* @author Huaigui   
* @date 2016年9月5日 下午3:55:18
* @version V1.0   
*/
package acmcoder;

import java.util.Arrays;

import java.util.Scanner;

/**
 * @ClassName: StreetLamp
 * @题目描述:
 * 		  V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。 假设这条街起点为0，终点为l，第i个路灯坐标为ai。
 *        路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，
 *        所有路灯发光能力相同。为了让V先生看清回家的路，路灯必须照亮整条街道 ，又为了节省电力希望找到最小的d是多少？ 输入
 *        输入两行数据，第一行是两个整数：路灯数目n (1≤n≤1000)，街道长度l (1 ≤l≤109)。 第二行有n个整数ai (0 ≤ ai≤
 *        l)，表示路灯坐标，多个路灯可以在同一个点，也可以安放在终点位置。 样例输入 7 15 15 5 3 7 9 14 0
 * 
 *        输出 输出能够照亮整个街道的最小d，保留两位小数。 样例输出 2.50
 */
public class StreetLamp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			int max = a[0] > l - a[n - 1] ? a[0] * 2 : (l - a[n - 1]) * 2;
			for (int i = 1; i < n; i++) {
				if (max < a[i] - a[i - 1])
					max = a[i] - a[i - 1];
			}
			java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
			System.out.println(df.format(max / 2.0));
		}
		sc.close();
	}
}
