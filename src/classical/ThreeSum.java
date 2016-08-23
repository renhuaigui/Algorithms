package classical;

import java.util.Arrays;

import basic.BinarySearch;

/**
* @ClassName: ThreeSum
* @Description:在数组中求解三个数的和为定值 的次数 复杂度为N^2*lg(N)
* @author Huaigui
* @date 2016年4月8日 下午2:41:34
* 
*/
public class ThreeSum {
	public static int count(int[] a)
	{
		Arrays.sort(a);
		int cnt = 0;
		int N = a.length;
		for(int i = 0; i<N; i++)
			for (int j = i+1; j < N; j++) 
			{
				if(BinarySearch.rank(-a[i]-a[j], a)>j)
					cnt ++;
			}
		return cnt;
	}

}
