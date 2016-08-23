/**   
* @Title: MaxTree.java
* @Package nowcode
* @Description: TODO
* @author Huaigui   
* @date 2016年4月28日 上午9:07:23
* @version V1.0   
*/
package nowcode;

import java.util.Arrays;
import java.util.Stack;  
/**
* @ClassName: MaxTree
* @Description: 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
* 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。现有一建树方法，
* 对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
* 若两边都不存在比它大的数，那么它就是树根。请证明这个方法的正确性，同时设计O(n)的算法实现这个方法。
* 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，
* 若为根则值为-1。
* 测试样例：
* [3,1,4,2],4
* 返回：[2,0,-1,2]
* @author Huaigui
* @date 2016年4月28日 上午9:07:23
* 
*/
/**
*  题目：
* 给定一个没有重复元素的数组A，定义A上的MaxTree如下：MaxTree的根节点为A中最大的数，
* 根节点的左子树为数组中最大数左边部分的MaxTree，右子树为数组中最大数右边部分的MaxTree。请根据给定的数组A，
* 设计一个算法构造这个数组的MaxTree。
* 
* 解答：
* 如果能够确定每个节点的父亲节点，则可以构造出整棵树。找出每个数往左数第一个比他大的数和往右数第一个比他大的数，
* 两者中较小的数即为该数的父亲节点。如：[3,1,2]，3没有父亲节点，1的父亲节点为2，2的父亲节为3。
* 并且可以根据与父亲的位置关系来确定是左儿子还是右儿子。接下来的问题是如何快速找出每个数往左、往右第一个比他大的数。
* 这里需要用到数据结构栈。以找每个数左边第一个比他大的数为例，从左到右遍历每个数，栈中保持递减序列，
* 新来的数不停的Pop出栈顶直到栈顶比新数大或没有数。以[3,1,2]为例，首先3入栈，接下来1比3小，无需pop出3，1入栈，
* 并且确定了1往左第一个比他大的数为3。接下来2比1大，1出栈，2比3小，2入栈。并且确定了2往左第一个比他大的数为3。
* 用同样的方法可以求得每个数往右第一个比他大的数。时间复杂度O(n)，空间复杂度也是O(n)为最优解法。
* 
* 面试官角度：
* 首先容易想到的是使用递归的方法来构造MaxTree，每一层递归用O(n)的时间找到最大数，然后将数组分为左右两个部分，
* 然后递归完成构造。这种算法在极端情况下复杂度可能达到O(n^2)，所以并不能被面试官所接受。
* 但是你首先至少要把这种暴力的方法答出，并分析出最坏时间复杂度，因为这至少也体现出了你一部分的算法能力和时间复杂度分析
* 的技巧。万一后面的正确方法答不出来，至少不会是0分。最优算法所使用到的Stack的方法，是一个非常常用的解题技巧。
* 我们在今后的面试题中也会陆续为为大家讲解涉及到这种方法的题目。
* 
*/
public class MaxTree {
	public int[] buildMaxTree(int[] A, int n) {
	        // write code here
		int [] result = new int[n];
//		result = violenceBuild(A, n);
		result = stackBuild(A, n);
		return result;
	}
	
	/** 
	* @Title: stackBuild 
	* @Description:用栈的方法解
	* 从左到右遍历每个数，栈中保持递减序列，
	* 新来的数不停的Pop出栈顶直到栈顶比新数大或没有数
	* @throws 
	*/ 
	public int[] stackBuild(int[] arr,int n){
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		if(0 == n) return result;
		Stack<Integer> sk = new Stack<Integer>();//栈保存递减序列的下标
		sk.push(0);
		for(int i = 1; i<n;++i){
			while (!sk.isEmpty()) {
				int index = sk.peek();	//peek()查看栈顶元素  但不弹出			
				if (arr[index]>arr[i]){
					result[i] = index;
                    break;
				}
				else {
					sk.pop();
				}
			}
			sk.push(i);
		}
		while(!sk.isEmpty()) sk.pop();
		sk.push(n-1);
		for(int i =n-2;i>=0;--i){
			while (!sk.isEmpty()) {
				int index = sk.peek();
				if (arr[index]>arr[i]){
					if(result[i] == -1 || arr[result[i]]> arr[index]){
                        result[i] = index;
                    }
                    break;
				}
				else {
					sk.pop();
				}
			}
			sk.push(i);
		}
		return result;
	}
	
	
	/** 
	* @Title: violenceBuild 
	* @Description: 暴力解法（O(n^2)）
	* @throws 
	*/ 
	public int[] violenceBuild(int []arr, int n){
		int [] res = new int[n];
		for(int index=0 ;index <n ;index++){
            int left=index,right=index;
            //往左边找到第一个比当前数大的。
            for(int i=index-1 ; i>=0 ;i--){
                if(arr[i]>arr[index]){
                    left=i;
                    break;
                }
            }
            //往右边找到第一个比当前数大的。
            for(int j=index+1 ;j<n ;j++){
                if(arr[j]>arr[index]){
                    right=j;
                    break;
                }
            }
            //数组中值最大者作为根节点
            if(left==index&&right==index)
                 res[index]=-1;
            else if (left==index) {
                res[index]=right;
            }else if (right==index) {
                res[index]=left;
            }
            
            
			else {
                //选left和right中较小者作为当前节点的父亲节点
                if(arr[left] < arr[right])
                    res[index]=left;
                else
                    res[index]=right;
            }
        }
		return res;
	}
	
	public static void main(String[] args) {
		MaxTree maxTree = new MaxTree();
//		int[] arr= {36,1173,934,436};
		int [] arr = {3,1,4,2};
		System.out.println(Arrays.toString(maxTree.buildMaxTree(arr, arr.length)));
	}
}
