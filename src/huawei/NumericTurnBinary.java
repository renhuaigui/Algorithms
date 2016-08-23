/**   
* @Title: NumericTurnBinary.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月3日 下午4:50:14
* @version V1.0   
*/
package huawei;

import java.util.Scanner;


/**
 * @ClassName: NumericTurnBinary
 * @Description: 数字字符串转二进制 描述:
 *               输入一串整数，将每个整数转换为二进制数，如果倒数第三个Bit是“0”，则输出“0”，如果是“1”，则输出“1”。
 *               运行时间限制: 10 Sec 内存限制: 128 MByte 输入: 一串整数，长度小于1024，整数以空格隔开 输出:
 *               1/0的整数串，空格隔开 样例输入: 240 0 样例输出: 0 0
 * @author Huaigui
 */
public class NumericTurnBinary {
	public static int binnary(int x){
		int sum = 0;
		int flag =0;
		String string ="";
		while(x!=0&&sum<4){
			int t = x%10;
			switch (t) {
			case  0: 
				string = "0" +string;
				sum +=1;
				break;
			case 1:
				string ="1"+string;
				sum +=1;
				break;
			case 2:
				string ="10"+string;
				sum +=2;
				break;
			case 3:
				string ="11"+string;
				sum +=2;
				break;
			case 4:
				string ="100"+string;
				sum +=3;
				break;
			case 5:
				string ="101"+string;
				sum +=3;
				break;
			case 6:
				string ="110"+string;
				sum +=3;
				break;
			case 7:
				string ="111"+string;
				sum +=3;
				break;
			case 8:
				string ="1000"+string;
				sum +=4;
				break;
			case 9:
				string ="1001"+string;
				sum +=4;
				break;
			default:
				break;
			}
			x=x/10;
		}
		System.err.println(string);
		if(string.length()>=3&&string.substring(string.length()-3,string.length()-2).equals("1"))
			flag =1;
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] s= sc.nextLine().split(" ");
		for (int i = 0; i < s.length; i++) {
			System.out.print(binnary(Integer.valueOf(s[i]))+" ");
		}
	}
}
