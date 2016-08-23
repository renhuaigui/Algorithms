/**   
* @Title: exercise_1_3.java
* @Package exercise
* @Description: TODO
* @author Huaigui   
* @date 2016年3月23日 下午3:42:56
* @version V1.0   
*/
package exercise;

import java.util.Scanner;
import java.util.Stack;



/**
* @ClassName: exercise_1_3
* @Description: 练习1.3
* @author Huaigui
* @date 2016年3月23日 下午3:42:56
* 
*/
public class exercise_1_3 {
	
	/** 算法4 练习1.3.9
	* 编写一个程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
	* 例如，给定输入：
	* 1+2)*3-4)*5-6)))
	* 程序应该输出
	* ((1+2)*((3-4)*(5-6)))
	* 输入的表达式只考虑标准情况
	* 每个操作符都对应一个右括号
	*/
	public String ParenthesisPatch(String str)
	{	
		Stack<String> exp = new Stack<String>(); //用下压栈实现
		for(int i = 0; i< str.length();i++) //依次读取字符串的每位值
		{
			String temp = str.charAt(i) +"";
			String tempexp;
			if(temp.equals(")")) //遇到右括号 进行补全左括号
			{
				String val2 = exp.pop(); //第二个操作数
				String op =exp.pop(); // 运算符
				String val1 = exp.pop(); // 第一个操作数
				tempexp = "("+val1+op+val2+")";
				exp.push(tempexp); //入栈
			}
			else {
				exp.push(temp); //入栈
			}
		}
		return exp.pop();
	}

	public int Properties(String s)
	{	//比较运算符的大小（优先级）
		if(s.equals("+")||s.equals("-")) return 1;
		if(s.equals("*")||s.equals("/")||s.equals("%")) return 2;
		return 0;
	}
	/** 练习1.3.10
	* 实现算术表达式由中序转为后序表达式(只能接受正确的表达式[字符串的格式]) 
	*/ 
	public String InfixToPostfix(String str)
	{
		String exp = "";//存储后缀表达式
		Stack<String> op = new Stack<String>();
		for(int i = 0;i<str.length();i++)
		{
			System.out.println("读取的元素： "+str.charAt(i));

			if(str.charAt(i)>='0'&&str.charAt(i)<='9'||str.charAt(i)=='.')
			{
				String num=""+str.charAt(i);
				while(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9'||str.charAt(i+1)=='.')
				{	
					i=i+1;
					num = num+str.charAt(i);//取出所有数字
				}
				exp = exp+num;
			}
			else if(str.charAt(i)=='(') 
			{
				System.out.println("入栈： "+str.charAt(i));
				op.push(str.charAt(i)+"");
			}
			else if(str.charAt(i)==')')
			{	//如果是’）‘则把运算符栈中的所有“（”加到表达式中
				String opout ="";
				while((!op.empty())&&(!(opout=op.pop()).equals("(")))
				{
					System.out.println("出栈："+op.peek());
					exp = exp + opout;	
				}
			}
			else
			{
				//System.out.print(str.charAt(i));
				if(op.empty())
				{	//栈顶为空有操作没完成
					System.out.println("入栈： "+str.charAt(i));
					op.push(str.charAt(i)+"");
				}
				else if(Properties(str.charAt(i)+"")>Properties(op.peek()+""))
				{
					System.out.println("入栈： "+str.charAt(i));
					op.push(str.charAt(i)+"");
				}
				else{
					while((!op.empty())&&(Properties(str.charAt(i)+"")<=Properties(op.peek()+"")))
					{	
						System.out.println("出栈："+op.peek());
						exp = exp + op.pop();
					}
					System.out.println("入栈： "+str.charAt(i));
					op.push(str.charAt(i)+"");	
				}
			}
			System.out.println("表达式： "+exp);
			if(!op.empty()) System.out.println("栈顶： "+op.peek());	
		}
		while(!op.empty())
		{	//弹出其余的符号
			System.out.println("出栈："+op.peek());
			exp = exp + op.pop();
		}
		return exp;
	}
	
	
	
	public static void main(String[] args) {
		exercise_1_3 test = new exercise_1_3();
		
		System.out.println(test.ParenthesisPatch("1+2)*3-4)*5-6)))"));
		System.out.print(test.InfixToPostfix("2*3/(2-1)+3*(4-1)"));
	}
}
