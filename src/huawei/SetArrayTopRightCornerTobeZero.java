/**   
* @Title: SetArrayTopRightCornerTobeZero.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月17日 下午12:30:55
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: SetArrayTopRightCornerTobeZero
 * @see: 数组右上三角置0 描述:
 *       定义了3×3的二维数组，并在主函数中自动赋值。请编写函数SetArrayTopRightCornerTobeZero(int
 *       a[][3])，该函数的功能是：使数组右上半三角元素中的值全部置成0（对角线元素也为0，特别注意：由于矩阵显示的特殊性，此处输入/输出格式，
 *       具体格式见样例）。
 * 
 *       运行时间限制: 无限制 内存限制: 128 MByte 输入:
 *       3×3二维数组（特别注意：由于矩阵显示的特殊性，此处输入/输出格式，具体格式见样例）
 * 
 *       输出: 右上半三角元素中的值全部置成0的3×3二维数组（特别注意：由于矩阵显示的特殊性，此处输入/输出格式，具体格式见样例）
 * 
 *       样例输入: 1 1 1 1 1 1 1 1 1 样例输出: 000100110 答案提示:
 *       嵌套循环实现数组右上半三角元素中的值全部为0（对角线元素也为0）。（特别注意：由于矩阵显示的特殊性，此处输入/输出格式，具体格式见样例）
 * @author Huaigui
 */
public class SetArrayTopRightCornerTobeZero {
	public static void SetArrayTopRightCornerTobeZero(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				// arr[i][j] = sc.nextInt();
				if (i - j <= 0)
					arr[i][j] = 0;

			}
		}

	}

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = sc.nextInt();
					// if(i-j<=0) arr[i][j] = 0;

				}
			}
			SetArrayTopRightCornerTobeZero(arr);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.err.print(arr[i][j]);
				}
			}
		}
		sc.close();
	}
}
