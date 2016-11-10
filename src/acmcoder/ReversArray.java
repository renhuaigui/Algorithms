/**   
* @Title: ReversArray.java
* @Package acmcoder
* @Description: TODO
* @author Huaigui   
* @date 2016年9月5日 下午3:10:17
* @version V1.0   
*/
package acmcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: ReversArray
 * @idea: 翻转数组
 *  题目描述
 *        给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。其中数组片段[l,r]
 *        表示序列a[l], a[l+1], ..., a[r]。原始数组为 a[1], a[2], ..., a[l-2], a[l-1],
 *        a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
 *        将片段[l,r]反序后的数组是 a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ...,
 *        a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。 输入 第一行数据是一个整数：n
 *        (1≤n≤105)，表示数组长度。 第二行数据是n个整数a[1], a[2], ..., a[n] (1≤a[i]≤109)。 样例输入 4
 *        2 1 3 4 输出 输出“yes”，如果存在；否则输出“no”，不用输出引号。 样例输出 yes
 * @author Huaigui
 */
public class ReversArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] copy = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				copy[i] = arr[i];
			}
			Arrays.sort(copy);
			int l = 0;
			int r = n - 1;
			while (l < n && copy[l] == arr[l])
				l++;
			while (r >= 0 && copy[r] == arr[r])
				r--;
			int j;
			for (j = 0; j <= r - l; j++) {
				if (copy[l + j] != arr[r - j])
					break;
			}
			if (j > r - l)
				System.out.println("yes");
			else {
				System.out.println("no");
			}

		}
		sc.close();
	}
}
