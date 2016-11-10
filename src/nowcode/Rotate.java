/**   
* @Title: Rotate.java
* @Package nowcode
* @Description: TODO
* @author Huaigui   
* @date 2016年4月16日 上午9:24:11
* @version V1.0   
*/
package nowcode;

import java.util.Arrays;

/**
 * @ClassName: Rotate
 * 
 * @see: 有一个NxM整数矩阵，请编写一个算法，将矩阵顺时针旋转90度（逆时针旋转90度）。
 *       给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。 测试样例：
 *       [[1,2,3],[4,5,6],[7,8,9]],3 返回：[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 
 * @author Huaigui
 * @date 2016年4月16日 上午9:24:11
 * 
 */
public class Rotate {
	public int[][] rotateMatrix(int[][] mat, int n, int m) {

		int[][] resualt = new int[n][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				resualt[i][j] = mat[n - 1 - j][i];// 顺时针旋转数组
				// resualt[i][j] = mat[j][n-1-i];//逆时针旋转
				// System.out.print(resualt[i][n-1-j]);

			}
		return resualt;
	}

	public static void main(String[] args) {
		Rotate printer = new Rotate();
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] a = printer.rotateMatrix(mat, 3, 3);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
