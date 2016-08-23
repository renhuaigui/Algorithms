/**   
* @Title: test.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年3月17日 下午7:41:56
* @version V1.0   
*/
package classical;


import java.util.Iterator;
import java.util.Stack;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import stdlib.StdOut;

/**
* @ClassName: test
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Huaigui
* @date 2016年3月17日 下午7:41:56
* 
*/
public class test {
	public void Reverse (int [] a){
		//用栈的方式实现数组逆转
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		while(i<a.length)
		{
			s.push(a[i++]);
		}
		while(!s.isEmpty())
			StdOut.println(s.pop());
	}
	public static void main(String[] args) {
		test test = new test();
		String string1 = "hello";
		String s2 = string1;
		string1 = "world";
		StdOut.println(string1);
		StdOut.println(s2);
		
		int []a = {2,3,4,5,6,7};
		test.Reverse(a);
	}
}
