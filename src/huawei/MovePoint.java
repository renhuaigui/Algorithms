/**   
* @Title: MovePoint.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月7日 下午9:55:38
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: MovePoint
* @Description: 题目描述
开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 
输入：
合法坐标为A(或者D或者W或者S) + 数字（两位以内）
坐标之间以;分隔。
非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
下面是一个简单的例子 如：
A10;S20;W10;D30;X;A1A;B10A11;;A10;
处理过程：
起点（0,0）
+   A10   =  （-10,0）
+   S20   =  (-10,-20)
+   W10  =  (-10,-10)
+   D30  =  (20,-10) 
+   x    =  无效 
+   A1A   =  无效 
+   B10A11   =  无效 
+  一个空 不影响 
+   A10  =  (10,-10) 
 
结果 （10， -10）
输入描述:
一行字符串
输出描述:最终坐标，以,分隔

输入例子:
A10;S20;W10;D30;X;A1A;B10A11;;A10;

输出例子:
10,-10
* @author Huaigui
*/
public class MovePoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			//The firt point(x,y)
			int [] point = {0,0};
			String []moveStr = str.split(";");
			//System.out.println(moveStr.length);
			for(int i=0;i<moveStr.length;i++){
				String s = moveStr[i];
				if(s.length()>1&&s.substring(1).matches("[0-9]+")){
					switch (s.substring(0, 1)) {
					case "A":
						point[0]-=Integer.parseInt(s.substring(1));
						break;
					case "W":
						point[1]+=Integer.parseInt(s.substring(1));
						break;
					case "S":
						point[1]-=Integer.parseInt(s.substring(1));
						break;
					case "D":
						point[0]+=Integer.parseInt(s.substring(1));	
						break;
					default:
						break;
					}
				}
			}
			System.out.println(point[0]+","+point[1]);
		}
	}
}
