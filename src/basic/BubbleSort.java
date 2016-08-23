/**   
* @Title: BubbleSort.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年5月10日 下午7:56:52
* @version V1.0   
*/
package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
* @ClassName: BubbleSort
* @Description: 冒泡排序
* @author Huaigui
* @date 2016年5月10日 下午7:56:52
* 
*/
public class BubbleSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i<N-1;i++){
			for(int j = 0; j<N-1-i;j++){
				if(less(a[j+1],a[j]))
				{
					exch(a, j, j+1);
				}
					
			}
		}
	}
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable []a,int i,int j) {
		Comparable t = a[i];a[i]=a[j];a[j]=t;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean isSorted(Comparable[]a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer []str = new Integer[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(str));
		sort(str);
		//assert isSorted(str);
		show(str);
	}
}
