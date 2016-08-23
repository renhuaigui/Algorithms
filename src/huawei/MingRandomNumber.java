/**   
* @Title: MingRandomNumber.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年5月31日 下午9:49:43
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* @ClassName: MingRandomNumber
* @Description:题目描述: 明明的随机数
* 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
* 
* Input Param 
*    n               输入随机数的个数     
* inputArray      n个随机整数组成的数组 
* 
* Return Value
* OutputArray    输出处理后的随机整数
* 
* 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
* 
* 输入描述:
* 输入多行，先输入随机整数的个数，再输入相应个数的整数
* 
* 输出描述：
* 返回多行，处理后的结果
* 输入例子:
11
10
20
40
32
67
40
20
89
300
400
15

*输出例子:
10
15
20
32
40
67
89
300
400


* @author Huaigui
*/
public class MingRandomNumber {
	public static ArrayList<Integer> sortAndDuplicate(Integer []a) {
		Arrays.sort(a); //先排序
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(a[0]);
		for (int i = 1; i < a.length; i++) {
			if(a[i]!=a[i-1]){  //去重
				temp.add(a[i]);
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner sca= new Scanner(System.in);
		while (sca.hasNext()) {
			int N=0;
			N=sca.nextInt();
			Integer[] arr= new Integer[N];
			if(N>0){
				for (int i = 0; i < N; i++) {
					arr[i]= sca.nextInt();
				}
				ArrayList<Integer> atemp= sortAndDuplicate(arr);
				for(int i=0; i<atemp.size();i++)
					System.out.println(atemp.get(i));
			}
		}
	}
}
