package basic;

import java.util.Arrays;
import java.util.Scanner;

import jdk.nashorn.tools.Shell;


/*************************************************
 * @Title:  Selecttion.java 
 * @Description: 选择排序
 * @author:  Ren Huaigui
 * @time:  2016年5月5日 下午9:23:30 
 * @version:  V1.0 
 ************************************************/

public class Selection {
	/** 
	* @Title: less 
	* @Description: 比较两个对象的大小
	* @param v 
	* @param w
	* @return boolean ifv>w ture else false
	* @throws  
	*/ 
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	/** 
	* @Title: exch 
	* @Description: 交换对象数组a的i,j位置的元素
	* @param a Comparable 类型
	* @param i int 类型
	* @param j int 类型
	* @throws  
	*/ 
	private static void exch(Comparable []a,int i,int j) {
		Comparable t = a[i];a[i]=a[j];a[j]=t;
	}
	/** 
	* @Title: show 
	* @Description: 依次显示对象a的所有元素
	* @param a 
	* @throws  
	*/ 
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	/** 
	* @Title: isSorted 
	* @Description: 判断是否排序
	* @param a
	* @return boolean
	* @throws  
	*/ 
	public static boolean isSorted(Comparable[]a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	/** 
	* @Title: sort 
	* @Description: 排序的核心
	* @param a void
	* @throws  
	*/ 
	public static void sort(Comparable[] a) {
		int N= a.length;
		for (int i = 0; i < N; i++) {
			int min =i;
			for (int j = i+1; j < N; j++) {
				if(less(a[j],a[min]))
					min = j;
			}
			exch(a, i, min);
		}
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
		//assert isSorted(str);
		show(str);
	}
}