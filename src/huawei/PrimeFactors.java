/**   
* @Title: PrimeFactors.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 上午10:18:42
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: PrimeFactors
* @Description: 题目描述:质数因子
* 
* 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
* 
* 详细描述：
* 函数接口说明：
*     public String getResult(long ulDataInput)
*     输入参数：
* long ulDataInput：输入的正整数返回值：
*  String
* 输入描述:
* 输入一个long型整数
* 输出描述:
* 按照从小到大的顺序输出它的所有质数的因子，以空格隔开
* 
* 输入例子:
* 180
* 输出例子:
* 2 2 3 3 5
* 
*  @author Huaigui
*/
public class PrimeFactors {
	public static String getResult(long n) {
		String string = "";
		int i =0;
		while(true){
			for(i=2;i<=n;i++){//从最小的质数开始，不是不质数会被比之小的质数分解。
				if (n%i==0) {
					string = string + i+" ";
					n = n/i;
					break;
				}
			}
			if (n==1) {
				break;
			}
		}
		System.out.println(string);
		return string;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n =0;
		String string ="";
		n = sc.nextLong();
		string = getResult(n);
	}
}
