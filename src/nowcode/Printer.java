/**   
* @Title: Printer.java
* @Package nowcode
* @Description: TODO
* @author Huaigui   
* @date 2016年4月15日 下午11:03:45
* @version V1.0   
*/
package nowcode;

import java.util.Arrays;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * @ClassName: Printer
 * @see: 
 * 		  对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 *       给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。 测试样例： [[1,2],[3,4]],2,2
 *       返回：[1,2,4,3]
 * 
 * @author Huaigui
 * @date 2016年4月15日 下午11:03:45
 * 
 */
public class Printer {
	public int[] clockwisePrint(int[][] mat, int n, int m) {
		// write code here
		int[] resualt = new int[n * m];
		int[][] flag = new int[n][m];
		int k = 0, i = 0, j = 0;
		// System.out.println(flag[0][0]);
		// while(k<n*m){
		// while(j<m&&flag[i][j]==0) {flag[i][j] =1;System.out.print(mat[i][j]+"
		// "); resualt[k++]=mat[i][j++];} //右走
		// j=j-1;
		// i=i+1;
		// while(i<n&&flag[i][j]==0) {flag[i][j] =1;
		// System.out.print(mat[i][j]+" ");resualt[k++]=mat[i++][j];} //下走
		// i=i-1;
		// j=j-1;
		// while(j>=0&&flag[i][j]==0) {flag[i][j]
		// =1;System.out.print(mat[i][j]+" "); resualt[k++]=mat[i][j--];} //左走
		// j=j+1;
		// i=i-1;
		// while(i>=0&&flag[i][j]==0) {flag[i][j] =1;
		// System.out.print(mat[i][j]+" ");resualt[k++]=mat[i--][j];} //右走
		// i=i+1;
		// j=j+1;
		// }

		flag[0][0] = 1;
		resualt[0] = mat[0][0];
		while (k < n * m - 1) {
			while (j + 1 < m && flag[i][j + 1] == 0) {
				resualt[++k] = mat[i][++j];
				flag[i][j] = 1;
			} // 右走

			while (i + 1 < n && flag[i + 1][j] == 0) {
				resualt[++k] = mat[++i][j];
				flag[i][j] = 1;
			} // 下走

			while (j - 1 >= 0 && flag[i][j - 1] == 0) {
				resualt[++k] = mat[i][--j];
				flag[i][j] = 1;
			} // 左走

			while (i - 1 >= 0 && flag[i - 1][j] == 0) {
				resualt[++k] = mat[--i][j];
				flag[i][j] = 1;
			} // 右走
		}

		return resualt;
	}

	public static void main(String[] args) {
		Printer printer = new Printer();
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[] a = printer.clockwisePrint(mat, 3, 3);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
