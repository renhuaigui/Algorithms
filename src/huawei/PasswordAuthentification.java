/**   
* @Title: PasswordAuthentification.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月12日 下午8:51:09
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: PasswordAuthentification
* @Description: 密码验证合格程序
*  
1.长度超过8位
 
 
 
2.包括大小写字母.数字.其它符号,以上四种至少三种
 
 
 
3.不能有相同长度超2的子串重复
 
 
 
说明:长度超过2的子串


输入描述:
一组或多组长度超过2的子符串。每组占一行


输出描述:
如果符合要求输出：OK，否则输出NG

输入例子:
021Abc9000
021Abc9Abc1
021ABC9000
021$bc9000

输出例子:
OK
NG
NG
OK
* @author Huaigui
*/
public class PasswordAuthentification 
{
	public static boolean checkLength(String str){
		return str.length()<=8?false:true;
	}
	public static boolean checkCharKinds(String str){
		int digit=0;
		int lowercase=0;
		int uppercase=0;
		int other=0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if (c>='0'&&c<='9') {
				digit=1;
				continue;
			}
			else if (c>='a'&&c<='z') {
				lowercase=1;
				continue;
			} 
			else if (c>='A'&&c<='Z') {
				uppercase=1;
				continue;
			}
			else {
				other=1;
				continue;
			}
		}
		return (digit+lowercase+uppercase+other)>=3 ? true : false;
	}
	public static boolean checkRepeatSubString(String str){
		for (int i = 0; i < str.length()-2; i++) {
			String subOldStr = str.substring(i,i+3); 
			for (int j = i+1; j < str.length()-2; j++) {
				if(subOldStr.equals(str.substring(j,j+3)))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			if(checkLength(str)&&checkCharKinds(str)&&checkRepeatSubString(str))
				System.out.println("OK");
			else {
				System.out.println("NG");
			}
		}
		
	}
}
