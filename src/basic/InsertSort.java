/**   
* @Title: InsertSort.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年5月10日 下午9:14:04
* @version V1.0   
*/
package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: InsertSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huaigui
 * @date 2016年5月10日 下午9:14:04
 * 
 */
public class InsertSort {
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			int j = i;
			Comparable tComparable = a[i];
			while (j > 0 && less(tComparable, a[j])) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = tComparable;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		show(str);
		sort(str);
		// assert isSorted(str);
		show(str);
	}
}
