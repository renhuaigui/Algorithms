/**   
* @Title: Test03.java
* @Package pointToOffer
* @Description: TODO
* @author Huaigui   
* @date 2016年8月23日 下午2:46:52
* @version V1.0   
*/
package pointToOffer;

import java.util.Scanner;

/**
* @ClassName: Test03
* @Description: 二维数组中得查找， 
* @author Huaigui/
*/

/**
 * 题目：
 * 在一个二维数组中，没一行都按照从左到右递增得顺序排序，
 * 每一列都按照从上到下得递增，清完成一个函数，
 * 输入这样得一个二维数组和一个整数，
 * 判断数组中是否含有该整数
 * 
 * 输入：
 * 1 2 8  9
 * 2 4 9  12
 * 4 7 10 13
 * 6 8 11 15   
 * 
 * 查找：7
 * 
 * 输出：
 * true
 */

/**
 * 思路：
 * 从右上角开始判断 数字等于查找得数字 ，则返回结果true；
 * 如果大于给定得数字则裁剪当前列，递归查询，或者，列号减1，向左查询判断
 * 如果小于给定得数字则裁剪当前行，递归插询，或者，行号加1 ，向下查询判断
 * 当查询到最左下角都没有找到该数字，则返回false
 */

public class Test03 {
	public static boolean Find(int [][] a,int k){
		for (int i = 0; i < a.length; ) {
			for (int j = a[0].length-1; j >=0; ) {
				if (a[i][j]==k) {
					return true;
				}
				else if(a[i][j]>k){
					j--;
				}
				else {
					i++;
				}
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m= sc.nextInt();
			int n= sc.nextInt();
			int [][]a= new int [m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j]= sc.nextInt();
				}
			}
			int k = sc.nextInt();
			if(Find(a, k))
				System.out.println("succese");
			else {
				
			}
		}
		sc.close();
	}
}
