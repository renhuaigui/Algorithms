/**   
* @Title: SnakeMatrix.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月25日 下午7:36:56
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: SnakeMatrix
* @Description: 蛇形矩阵
* 
* 题目描述

题目说明
蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 
 
 
样例输入
5
样例输出
1 3 6 10 15
2 5 9 14
4 8 13
7 12
11
接口说明
原型
void GetResult(int Num, char * pResult);
输入参数：
        int Num：输入的正整数N
输出参数：
        int * pResult：指向存放蛇形矩阵的字符串指针
        指针指向的内存区域保证有效
返回值：
        void
 
输入描述:
输入正整数N（N不大于100）

输出描述:
输出一个N行的蛇形矩阵。

输入例子:
4

输出例子:
1 3 6 10
2 5 9
4 8
7
* @author Huaigui
*/
public class SnakeMatrix {
	/**
	 * 思路： 
	 * 用一个二维数组把数字存起来
	 * 每次都是从左下往右上存， 则且斜线上的数字个数等于行号 斜线的下一个数整好事[row-1,col+1]位置
	 * 一个变量记录；
	 */
	public static void solution(int n){
		int [][]a = new int[n][n];
		int row;
		int col;
		int count=1;
		for(int i =0;i<n;i++){
			row=i;//行号
			col=0;//列号
			while(col<=i&&row>=0)
				a[row--][col++]=count++;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i ;j++){
				if(j!=n-i-1)
					System.out.print(a[i][j]+" ");
				else {
					System.out.println(a[i][j]);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			solution(n);
		}
		sc.close();
	}
}
