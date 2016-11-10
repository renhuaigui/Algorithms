/**   
* @Title: FindGreateSumOfSubArray.java
* @Package classical.FindGreateSumOfSubArray
* @Description: TODO
* @author Huaigui   
* @date 2016年8月15日 下午8:22:13
* @version V1.0   
*/
package classical.FindGreateSumOfSubArray;

/**
* @ClassName: FindGreateSumOfSubArray
* @Description: 连续子数组的最大和
* @author Huaigui
*/

/**
 * 思路： 动态规划：以第i个位置结尾的最大和，表示为f(i). f(i)=[data[i] (i=0|f(i-1)<=0)
 * 
 * cur表示一i结尾的最大和 当值小于零说明前面的加上了一个负数，从i位置从新计算 result 保存最大和， 
 * 没次cur更新时，检测是否小于cur 更新
 */
public class FindGreateSumOfSubArray {
	public static int findGreateSum(int[] a) {
		if (a == null || a.length <= 0)
			return 0;
		int cur = a[0];
		int result = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (cur <= 0)
				cur = a[i];// 如果小于零，当前值开始计算
			else {
				cur += a[i];
			}
			if (cur > result) {
				result = cur;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, -5, 6, 4, -2, 7, -6, -4, 2 };
		System.out.println(findGreateSum(arr));
	}
}
