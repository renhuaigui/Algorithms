/**   
* @Title: MergeSort.java
* @Package basic
* @Description: 归并排序
* @author Huaigui   
* @date 2016年5月15日 下午9:59:05
* @version V1.0   
*/
package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
* @ClassName: MergeSort
* @Description: 归并排序类
* @author Huaigui
*/
public class MergeSort {
	private static Comparable[] atemp;
	/** 
	* @Title: sort 
	* @Description: 排序入口
	* @throws  
	*/ 
	public static void sort(Comparable[] a) {
		int N = a.length;
		atemp = new Comparable[N];//依次分配数组
		//sort(a, 0, N-1);//自顶向下的方法   递归方法
		//自底向上的方法（非递归方法）
		for (int sz = 1; sz < N; sz=sz+sz) {
			for(int low = 0; low<N-sz;low += sz+sz){
				merge(a, low, low+sz-1, Math.min(low+sz+sz-1, N-1));
			}
		}
		
	}
	/** 
	* @Title: sort 
	* @Description: 归并的核心 
	* @throws  
	*/ 
	public static void sort(Comparable[] a,int low,int high){
		if(high<= low) return;
		int mid = low + (high - low)/2;
		sort(a,low,mid);
		sort(a, mid+1, high);
		merge(a, low, mid, high);
	}
	/** 
	* @Title: merge 
	* @Description: 将a[low...mid] 和a[mid...high]归并
	* @param a 归并的元素集
	* @param low 归并的开始位置
	* @param high 归并的终止位置
	* @throws  
	*/ 
	public static void merge(Comparable []a, int low, int mid,int high){
		int i = low;
		int j = high;
		
		//Comparable []atemp = new Comparable[a.length]; 
		for(int k = low;k<=high;k++)
			atemp[k] = a[k];//将a中的类容复制到atemp中
		for(int k = low;k<= high;k++){
			if(i>mid)a[k]=atemp[j++];
			if(j>high) a[k] = atemp[i++];
			if(less(atemp[j], atemp[i])) a[k]=atemp[j++];
			else a[k] = atemp[i++];
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
