/**   
* @Title: ShellSort.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年5月10日 下午9:42:00
* @version V1.0   
*/
package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
* @ClassName: ShellSort
* @Description: 希尔排序，：使数组间隔为h的元素都是有序的，当h减小到1的时候整个数组就有序了。 
* 先将数组分为H个子数组 使其有序，
* @author Huaigui
* @date 2016年5月10日 下午9:42:00
* 
*/
public class ShellSort 
{
	public static void sort(Comparable[] a) 
	{
		int N= a.length;
		int h = 1;
		while(h<N/3) h = h*3+1;//1,4,13,40,121,364,1093
		while(h>=1)
		{
			for (int i = h; i <N; i++) {
				for(int j = i;j >h&less(a[j], a[j-h]);j-=h){
					exch(a, j, j-h);
				}
			}
			h= h/3;
		}
		/**
		for (h = N/2; h>0; h/=2) {
			for (int i = h; i < N; i++) {
				for (int j = i-h;  j>=0 && less(a[j], a[j+h]); j-=h) {
					exch(a, j, j+h);
				}
			}
		}
		*/
	}
	private static boolean less(Comparable v,Comparable w) 
	{
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable []a,int i,int j) 
	{
		Comparable t = a[i];a[i]=a[j];a[j]=t;
	}
	private static void show(Comparable[] a) 
	{
		for (int i = 0; i < a.length; i++) 
		{
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
		String []str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		System.out.println(Arrays.toString(str));
		sort(str);
		assert isSorted(str);
		show(str);
	}
}
