/**   
* @Title: Weight.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年9月9日 下午3:00:40
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
* @ClassName: Weight
* @Description: 称砝码
* 题目描述

现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量，问能称出多少中不同的重量。
 
注：
称重重量包括0
 
方法原型：public static int fama(int n, int[] weight, int[] nums)


输入描述:
输入包含多组测试数据。

对于每组测试数据：

第一行：n --- 砝码数(范围[1,10])

第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])

第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])


输出描述:
利用给定的砝码可以称出的不同的重量数

输入例子:
2
1 2
2 1

输出例子:
5
* @author Huaigui
*/
public class Weight {
	public static int fama(int n,int[] weights,int []nums){
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i=0;i<n;i++){
			int size = list.size();
			for(int j=0;j<size;j++){
				for(int k=1;k<=nums[i];k++){
					int temp = k*weights[i]+list.get(j);
					if(!list.contains(temp)){
						list.add(temp);
					}
				}
			}
		}

		return list.size();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int [] w = new int[n];
			int [] wn = new int[n];
			for(int i = 0; i < n;i++){
				w[i] = sc.nextInt();
			}
			for(int i = 0; i < n;i++){
				wn[i] = sc.nextInt();
			}
			System.out.println(fama(n,w,wn));
		}
		sc.close();
	}
}
