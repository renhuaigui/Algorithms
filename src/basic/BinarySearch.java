package basic;

/**
* @ClassName: BinarySearch
* @Description: 数组二分查找(数组是排好序的) 算法的时间复杂图为lg(N)
* @author Huaigui
* @date 2016年4月8日 下午2:43:30
* 
*/
public class BinarySearch {
	
	public static int rank(int key, int[] a)
	{	
		int low=0;
		int hig = a.length - 1;
		while(low<hig)
		{
			int mid = low + (hig + low)/2;
			if(key < a[mid]) hig = mid - 1;
			else if (key>a[mid]) low = mid + 1;
			else return mid;
		}
		return -1;
	}

}
