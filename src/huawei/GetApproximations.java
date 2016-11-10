/**   
* @Title: GetApproximations.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 上午10:50:33
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: GetApproximations
 * @see: 题目描述： 取近似值
 * 
 *       写出一个程序，接受一个浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 
 *       输入描述: 输入一个浮点数值
 * 
 *       输出描述: 输出该数值的近似整数值
 * 
 *       输入例子: 5.5
 * 
 *       输出例子: 6
 * 
 * @author Huaigui
 */
public class GetApproximations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num = 0;
		num = sc.nextDouble() * 10;
		int n = 0;
		int mod = 0;
		mod = (int) num % 10;
		n = (int) num / 10;
		if (mod >= 5) {
			n = n + 1;
		}
		System.out.println(n);
	}
}
