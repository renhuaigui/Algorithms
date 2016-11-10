/**   
* @Title: ParameterAnalysis.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月27日 下午3:19:36
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: ParameterAnalysis
 * @see: 参数解析 题目描述
 * 
 *       在命令行输入如下命令： xcopy /s c:\ d:\， 各个参数如下： 参数1：命令字xcopy 参数2：字符串/s 参数3：字符串c:\
 *       参数4: 字符串d:\ 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * 
 *       解析规则： 1.参数分隔符为空格 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s
 *       “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program
 *       files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。 3.参数不定长
 *       4.输入由用例保证，不会出现不符合要求的输入
 * 
 * 
 * 
 *       输入描述: 输入一行字符串，可以有空格
 * 
 * 
 *       输出描述: 输出参数个数，分解后的参数，每个参数都独占一行
 * 
 *       输入例子: xcopy /s c:\\ d:\\
 * 
 *       输出例子: 4 xcopy /s c:\\ d:\\
 * @author Huaigui
 */
public class ParameterAnalysis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			boolean flag = false;// 是否是左引号
			List<String> list = new ArrayList<>();
			String temp = "";
			for (int i = 0; i < str.length(); i++) {
				char s = str.charAt(i);
				// 如果遇到引号，且此时左引号标志位为false，那么判断此引号为左引号
				if (s == '\"' && !flag) {//
					flag = true;
					continue;
				}
				// 如果遇到引号，且此时左引号标志位为true，那么判断此引号为右引号
				if (s == '\"' && flag) {
					flag = false;
					continue;
				}
				// 遇到引号间空格的情况
				if (s == ' ' && flag) {
					temp = temp + s;
					continue;
				}
				// 遇到正常空格的情况
				if (s == ' ') {
					list.add(temp);
					temp = "";
					continue;
				}
				temp += s;
			}
			if (temp.length() > 0) {// 处理最后一个没加到的
				list.add(temp);
				temp = "";
			}
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
		sc.close();
	}

}
