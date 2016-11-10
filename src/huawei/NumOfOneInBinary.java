/**   
* @Title: Cal1OfBinary.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月6日 下午9:51:08
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

import jdk.management.resource.internal.UnassignedContext;

/**
 * @ClassName: Cal1OfBinary
 * @author Huaigui
 * @see: 求int型正整数在内存中存储时1的个数 题目描述
 * 
 *       输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 
 *       输入描述: 输入一个整数（int类型）
 * 
 * 
 *       输出描述: 这个数转换成2进制后，输出1的个数
 * 
 */
public class NumOfOneInBinary {
	public static void main(String[] args) {
		int[] u = { 1, 2, 3, 4 };
		int a, b, c, x, y, z;
		a = u[0] + u[1] + u[2] + u[3] - 5;
		b = u[0] * (u[1] - u[2] / u[3] + 8);
		c = u[0] * u[1] / u[2] * u[3];
		x = (a + b + 2) * 3 - u[(c + 3) % 4];
		y = (c * 100 - 13) / a / (u[b % 3] * 5);

		z = (a + b + c - x - y) * 2;
		System.out.println(x + y - z);
		Scanner sc = new Scanner(System.in);
		// 创新解法（）
		// 为什么n &= (n – 1)能清除最右边的1呢？因为从二进制的角度讲，
		// n相当于在n - 1的最低位加上1。举个例子，8（1000）= 7（0111）+ 1（0001），
		// 所以8 & 7 = （1000）&（0111）= 0（0000），清除了8最右边的1
		// （其实就是最高位的1，因为8的二进制中只有一个1）。
		// 再比如7（0111）= 6（0110）+ 1（0001），所以7 & 6 = （0111）&（0110）= 6（0110），
		// 清除了7的二进制表示中最右边的1（也就是最低位的1）。
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int num = 0;
			while (n != 0) {
				++num;
				n = (n - 1 & n);
			}
			System.out.println(num);
		}

		// 常规解法：
		/*
		 * while(sc.hasNext()){ int n = sc.nextInt(); int count = 0; int flag
		 * =1; while(flag!=0){ if((n&flag)!=0) count++; flag= flag<<1; }
		 * System.out.println(count); }
		 */
		sc.close();
	}
}
