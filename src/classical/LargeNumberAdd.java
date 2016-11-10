/**   
* @Title: LargeNumberAdd.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年8月10日 下午2:37:12
* @version V1.0   
*/
package classical;

import java.util.Scanner;


/**
* @ClassName: LargeNumberAdd
* @Description: 给定两个非常大的正整数A和B，位数在50至100之间。求C＝A+B；
* @author Huaigui
*/
public class LargeNumberAdd {
	public static String numberAdd(String A,String B){
		String result="";
		char []StrA = A.toCharArray();
		char []StrB = B.toCharArray();
		int m = StrA.length;
		int n = StrB.length;
		int temp=0;//当前和
		int oldTemp=0;//上一次进位
		if(m<n){
			return numberAdd(B, A);
		}
		else {
			int j=0;
			for (int i = 0; i < m; i++) {
				temp =0;
				if(j<n)
					temp = temp+StrB[n-j-1]-'0';
				temp += StrA[m-i-1]-'0' +oldTemp;
				result = temp%10 +result;
				oldTemp = temp/10;
				j++;
			}
			if(oldTemp!=0)
				result =oldTemp+result;
			return result;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String StrA = sc.nextLine();
			String StrB = sc.nextLine();
			System.out.println(numberAdd(StrA, StrB));
		}
		sc.close();
	}
}
