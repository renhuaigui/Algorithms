/**   
* @Title: QuickSort.java
* @Package basic
* @Description: 快速排序
* @author Huaigui   
* @date 2016年5月16日 下午9:23:33
* @version V1.0   
*/
package basic;

import java.util.Arrays;
import java.util.Scanner;


/**
* @ClassName: QuickSort
* @Description: 快速排序
* 是一种分治思想，将一个数组分成两个子数组，两部分独立排序，若两个子数组都有序则数组有序
* 关键是切分，这个过程满足三个条件
* 1、对于某个j，a[j]已经排定
* 2、a[low]到a[j-1]中的所有元素都小于a[i]
* 3、a[j+1]到a[high]中的所有元素均大于a[j]
* 
* @author Huaigui
*/
public class QuickSort {
	/** 
	* @Title: sort 
	* @Description: 排序的核心算法
	*/ 
	public static void sort(Comparable[] a) {
		int N= a.length;
		//sort(a,0,N-1);//算法书提供
		sort2(a,0,N-1);
	
	}
	
	/** 
	* @Title: sort 
	* @Description: 切分数组，排序
	*/ 
	public static void sort2(Comparable[] a,int low, int high){
		if(low>=high)  return;
		int i = low;
		int j = high;
		Comparable atemp = a[low];
		while(i<j){/*控制在当前组内寻找一遍*/
			
			while(i<j && !less(a[j],atemp)) j--; //向前找
			/*而寻找结束的条件就是，1，找到一个小于或者大于key的数（大于或小于取决于你想升
	       	序还是降序）2，没有符合条件1的，并且i与j的大小没有反转*/ 
			/*找到一个这样的数后就把它赋给前面的被拿走的i的值（如果第一次循环且key是
	        a[left]，那么就是给key）*/
			a[i] = a[j];
			/*这是i在当前组内向前寻找，同上，不过注意与key的大小关系停止循环和上面相反，
	        	因为排序思想是把数往两边扔，所以左右两边的数大小与key的关系相反*/
			while(i<j && !less(atemp,a[i])) i++;
			a[j] = a[i];
		}
		a[i] = atemp;/*当在当组内找完一遍以后就把中间数key回归*/
		sort2(a, low, i-1);/*最后用同样的方式对分出来的左边的小组进行同上的做法*/
		sort2(a, i+1, high);/*用同样的方式对分出来的右边的小组进行同上的做法*/
		/*当然最后可能会出现很多分左右，直到每一组的i = j 为止*/
	}	
	/** 
	* @Title: sort 
	* @Description: 先切分数组，排序
	*/ 
	public static void sort(Comparable[] a,int low, int high){
		if(low>=high) return;
		int mid = partition(a,low,high);
		sort(a, low, mid-1);
		sort(a, mid+1, high);
		
	}
	
	/** 
	* @Title: partition 
	* @Description: 切分数组，
	* 
	*/ 
	public static int partition(Comparable[] a,int low, int high){
		int i = low;
		int j = high+1;
		Comparable v = a[low];
		while (true) {
			while(less(a[++i], v)) if(i==high) break;
			while(less(v, a[--j])) if(j==low) break;
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
	}
	/** 
	* @Title: less 
	* @Description: 比较两个对象的大小
	* @return boolean ifv>w ture else false
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
	*/ 
	private static void exch(Comparable []a,int i,int j) {
		Comparable t = a[i];a[i]=a[j];a[j]=t;
	}
	/** 
	* @Title: show 
	* @Description: 依次显示对象a的所有元素
	*/ 
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	/** 
	* @Title: isSorted 
	* @Description: 判断a是否有序
	* @return boolean  
	*/ 
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
