/**   
* @Title: LCS.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年8月23日 上午9:45:18
* @version V1.0   
*/
package classical.LCS;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
* @ClassName: LCS
* @Description: 最长公共子序列
* 思路：
* @author Huaigui
*/
public class LCS {
	public static int[][] LCSLength(String[] a,String[] b){
		
		int aLen = a.length;
		int bLen = b.length;
		int i,j;
		int [][]c = new int[aLen+1][bLen+1];
		for(i=1;i<=aLen;i++)
			c[i][0]=0;
		for(j=1;j<=bLen;j++)
			c[0][j]=0;
		for(i=1;i<=aLen;i++){
			for (j = 1;  j<=bLen; j++) {
				if(a[i-1].equals(b[j-1])) {
					c[i][j] = c[i-1][j-1]+1;
				}
				else {
					if(c[i-1][j]>=c[i][j-1]){
						c[i][j] = c[i-1][j];
					}
					else {
						c[i][j] = c[i][j-1];
					}
				}
			}
		}
		return c;
	}
	
	public static void printLCS(int [][]c,String[]a,String []b,int i,int j){
		
		if(i==0||j==0)
			return;
		if(a[i-1].equals(b[j-1])){
			System.out.print(a[i-1]);
			printLCS(c, a, b, i-1, j-1);
			
			System.out.println(i+" "+j);
		}
		else if(c[i-1][j]>=c[i][j-1]){
				printLCS(c,a,b,i-1,j);
			}
			else {
				printLCS(c,a,b,i,j-1);
			}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String []str1 = sc.nextLine().split(" ");
		String []str2 = sc.nextLine().split(" ");
		//
		//

		int [][]b  = LCSLength(str1, str2);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		printLCS(b, str1, str2, str1.length, str2.length);
		sc.close();
	}
}
