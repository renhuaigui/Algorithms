/**   
* @Title: FixedCapacityStack.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年3月21日 下午10:04:22
* @version V1.0   
*/
package basic;

import java.util.Scanner;


/**
* @ClassName: FixedCapacityStack
* @Description: 用数组实现栈(可变栈)
* @author Huaigui
* @date 2016年3月21日 下午10:04:22
* 
*/
public class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;
	public FixedCapacityStack(int cap)
	{ a = (Item[]) new Object[cap];}
	public boolean isEmpty(){ return N==0;}//栈空
	public int size(){ return N;} //栈的大小
	public boolean isFull(){return N==a.length;}// 栈满
	/** 
	* @Title: peek 
	* @Description: 返回栈顶元素
	* @return Item 栈顶元素
	* @throws  
	*/ 
	public Item peek(){return a[N-1];	}
	/** 
	* @Title: resize 
	* @Description: 变化栈的大小
	* @param max 栈的最大长度
	* @throws  
	*/ 
	private void resize(int max)
	{
		Item [] temp = (Item[]) new Object[max];
		for (int i = 0 ;i<N;i++)
			temp[i] = a[i];
		a = temp;
	}
	/** 
	* @Title: push 
	* @Description: 压入一个元素（入栈）
	* @param item 
	* @throws  
	*/ 
	public void push(Item item)
	{ 	
		if(isFull()) resize(2*a.length);
		a[N++] = item;
	}
	/** 
	* @Title: pop 
	* @Description: 弹出一个元素
	* @return Item
	* @throws  
	*/ 
	public Item pop()
	{ 
		Item item = a[--N];
		a[N] =null;
		if(N>0 && N==a.length/4) resize(a.length/2);
		return item;
	}
	
	
	public static void main(String[] args) {
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		Scanner sc = new Scanner(System.in);
		//sc.useDelimiter(" ");
		String [] st = sc.nextLine().split(" ");
		for(int i= 0 ; i< st.length; i++)
		{
			String item = st[i];
			if(!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) 
				System.out.print(s.pop()+" ");
		}
		System.out.println("("+s.size()+" left on stack)");
		System.out.println("end!");
		
	}
	
}
