/**   
* @Title: Longest.java
* @Package classical.LCS
* @Description: TODO
* @author Huaigui   
* @date 2016年8月23日 上午11:50:27
* @version V1.0   
*/
package classical.LCS;

public class Longest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdef";
		String str2 = "gcdemf";
		int[][] re = longestCommonSubsequence(str1, str2);
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				System.out.print(re[i][j] + "   ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		print(re, str1, str2, str1.length(), str2.length());
	}

	// 假如返回两个字符串的最长公共子序列的长度
	public static int[][] longestCommonSubsequence(String str1, String str2) {
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
		// 初始化边界条件
		for (int i = 0; i <= str1.length(); i++) {
			matrix[i][0] = 0;
		}
		for (int j = 0; j <= str2.length(); j++) {
			matrix[0][j] = 0;
		}
		// 填充矩阵
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = (matrix[i - 1][j] >= matrix[i][j - 1] ? matrix[i - 1][j] : matrix[i][j - 1]);
				}
			}
		}
		return matrix;
	}

	public static void print(int[][] opt, String X, String Y, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			print(opt, X, Y, i - 1, j - 1);
			System.out.print(X.charAt(i - 1));
		} else if (opt[i - 1][j] >= opt[i][j]) {
			print(opt, X, Y, i - 1, j);
		} else {
			print(opt, X, Y, i, j - 1);
		}
	}
}