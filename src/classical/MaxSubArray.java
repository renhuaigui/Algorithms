/**   
    * @Title: MaxSubArray.java
* @Package classical
* @Description: 
* @author Huaigui   
* @date 2016年4月19日 下午7:09:29
* @version V1.0   
*/
package classical;

import java.util.Arrays;


/**
* @ClassName: MaxSubArray
* @Description: 关于如何查找数组中和最大的子序列
* 问题：给定一个数组，如{-1,3,6,-9,2,-5,-1,9,3,-3}，求该数组中的和最大的子序列。
* 思路：最简单的方法，以每个元素作为起点，再考虑1~n所有的子序列元素个数的情况，这样的复杂度就为O(n*n). 
* 之后我们讨论了如何简化数组，比如相邻的正数可以将其绑定，两端的负数可以直接排除，最后数组可以被简化为两端为正数，
* 中间没有相邻正数的形式。然而，这样并没有从根本上降低算法的复杂度，
* 分治策略的复杂度为O(nlogn),
* 动态规划算法的复杂度为O(n).
* @author Huaigui
* @date 2016年4月19日 下午7:09:29
* 
*/
public class MaxSubArray {
	
	/**
	 *先从第一个元素开始向后累加，
	 *每次累加后与之前的和比较，保留最大值，
	 *再从第二个元素开始向后累加，以此类推。
	 */
	public int [] ViolenceSolve(int []a){
		int [] result  = new int[3];
		result[0] = a[0];
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum = sum+a[j];
				if(sum>result[0]){
					result[0] = sum;
					result[1] = i;
					result[2] = j;
				}
			}
		}
		return result;
	}
	public int[] DivideConquer(int []a,int left,int right){
		/**
		 * 分治法O(NlgN)
		 *  1、完全位于左边的数组中。
		 *  2、完全位于右边的数组中。
		 *  3、跨越中点，包含左右数组中靠近中点的部分。
		 *  递归将左右子数组再分别分成两个数组，直到子数组中只含有一个元素，退出每层递归前，返回上面三种情况中的最大值。
		 */
		int []result = new int[3];
		if(left == right){
			result[0] = a[left]>0?a[left]:0;
			result[1] = result[2] = right;
		}
		else{
			int center = (left+right)/2;
			int [] resultl = DivideConquer(a, left, center);
			int [] resultr = DivideConquer(a, center+1, right);
			int s1 = 0; int lefts = 0;
			for(int i = center;i>=left;i--){
				lefts += a[i];
				if(lefts>s1){
					s1 = lefts;
					result[1] = i;//记录开始位置
				}
			}
			int s2=0;int rights=0;
			for(int i=center+1;i<=right;i++){
				rights +=a[i];
				if(rights>s2){
					s2=rights;
					result[2] =i;//记录结束位置
				}
			}
			result[0] = s1+s2;
			if(result[0]<resultl[0]){
				result = resultl;

			}
			if(result[0]<resultr[0])
			{
				result =result;
			}
		}
		//System.out.println(Arrays.toString(result));
		return result;
	}
	public int[] MaxSubSum(int []a){
		/**
		 * 动态规划法：
		 * b[i]保存以a[i]结尾的最大子序列的和，
		 * 则b[i]=max(b[i-1]+a[i],a[i]),但是对于b[i]只有b[i-1]>0时b[i]=b[i-1]+a[i]  else b[i]=a[i] 重新开始累加
		 */
		int [] result  = new int[3];
		int maxsum = a[0];
		int b =0,start=0,end=0;
		int tempsum=0;
		for (int i = 0; i < a.length; i++) {
			if(b>0)
				b=b+a[i];
			else{
				b=a[i];
				start = i;
			}
			if(b>maxsum)
			{
				maxsum = b;
				end = i;
			}
		}
		result[0] = maxsum;
		result[1] = start;
		result[2] = end;
		return result;
	}
	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		int[] a = {1,2,-1,5,-2};
		int[] b=  maxSubArray.ViolenceSolve(a);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(maxSubArray.MaxSubSum(a)));
		System.out.println(Arrays.toString(maxSubArray.DivideConquer(a,0,a.length-1)));
	}
}
