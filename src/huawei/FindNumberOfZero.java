/**   
* @Title: FindNumberOfZero.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年9月9日 下午4:47:48
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: FindNumberOfZero
 * @Description: 查找输入整数二进制中1的个数 题目描述
 * 
 *               请实现如下接口 public static int findNumberOf1(intnum) {
 * 
 *               return 0; }譬如：输入5 ，5的二进制为101，输出2
 * 
 *               涉及知识点：
 * 
 * 
 *               输入描述: 输入一个整数
 * 
 * 
 *               输出描述: 计算整数二进制中1的个数
 * 
 *               输入例子: 5
 * 
 *               输出例子: 2
 * @author Huaigui
 */
public class FindNumberOfZero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int count = 0;
			while (n != 0) {
				count++;
				n = n & n - 1;
			}
			System.out.println(count);
		}
		sc.close();
	}
}
