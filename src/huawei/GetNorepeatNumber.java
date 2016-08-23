/**   
* @Title: GetNorepeatNumber.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 下午2:04:00
* @version V1.0   
*/
package huawei;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
* @ClassName: GetNorepeatNumber
* @Description: 题目描述:提取不重复的整数
* 
* 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
* 
* 输入描述:
* 输入一个int型整数
* 
* 输出描述:
* 照从右向左的阅读顺序，返回一个不含重复数字的新的整数
* 
* 输入例子:
* 9876673
* 
* 输出例子:
* 37689
* 
* @author Huaigui
*/
public class GetNorepeatNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number=0;
		int n =0;
		while(sc.hasNext()){
			number = sc.nextInt();
			LinkedHashSet<Integer> nums = new LinkedHashSet<Integer>();
			while (number!=0) {
				int mod = number%10;
				if(!nums.contains(mod)){
					nums.add(mod);
					n = n*10+mod;	
				}
				number = number/10;
			}
			System.out.println(n);
		}
	}
}
