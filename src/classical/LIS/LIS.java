/**   
* @Title: LIS.java
* @Package classical.LIS
* @Description: TODO
* @author Huaigui   
* @date 2016年8月24日 下午2:40:38
* @version V1.0   
*/
package classical.LIS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
* @ClassName: LIS
* @Description:Longest increasing subsequences
* @author Huaigui
*/
public class LIS {
	//时间复杂度为n^2
	public static int [] lis(int []a){
		if(a==null||a.length<=0)
			return null;
		int len = a.length;
		int []f = new int[len+1]; //f[0...len-1]存储当前元素为结尾的最长递增子序列长度, f[len] 最大值
		int []s = new int[len+1] ;// s[0...len-1]以当前元素为结尾的递增子序列的前一个元素的下标，初始的时候为-1;s[len] 最长子序列的最后一个元素的下标
		for(int i = 0;i<len;i++)
			s[i]=-1;
		f[0]=f[len]=1;
		
		for(int i = 1; i<len; i++){
			f[i]=1;
			for(int j=0;j<i;j++){
				if(a[j]<a[i] && f[j]>f[i]-1){
					f[i] = f[j]+1;
					s[i] = j;
				}
			}
			if(f[i]>f[len]){
				s[len] = i;
				f[len] = f[i];
			}
		}
		return s;
	}
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int [] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = sc.nextInt();
			}
			int [] re = lis(a);
			System.out.println(Arrays.toString(re));
			for(int i = re[re.length-1];i!=-1;i=re[i]){//打印出来是逆序的
				System.out.print(a[i]+" ");
			}
			
		}
		sc.close();
	}
	
	
}
