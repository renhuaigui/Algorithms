/**   
* @Title: Palindrome.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年8月30日 下午9:30:37
* @version V1.0   
*/
package classical;

import java.util.Stack;

/**
* @ClassName: Palindrome
* @Description: 判断一个链表是否为回文结构
* 给定一个链表的头节点head，请判断该链表是否为回文结构。

例如：

1->2->1，返回true。

1->2->2->1，返回true。

15->6->15，返回true。

1->2->3，返回false。


【要求】


如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)

快慢指针找到中间位置， 逆序后半截，  比较 ，  再次逆序后半截


* @author Huaigui
*/
class Node{
	public int value;
	public Node next;

	public Node(int var) {
		this.value = var;
	}
}
public class IsPalindromeList {
	/** 
	 * @Title: isPalindrome1 
	 * @Description: 用栈的方法判断:遍历一次，将所有的节点存储到栈里，第二次遍历是栈一次弹出比较
	 * @param head
	 * @return String
	 * @throws  
	 */ 
	private static boolean isPalindrome1(Node head) {
		if(head == null || head.next == null){
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur!=null){
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		while(cur!=null){
			if(cur.value != stack.pop().value){
				return false;
			}
			cur= cur.next;
		}
		return true;
	}
	/** 
	* @Title: isPalindrome2
	* @Description: 一半用栈. n/2的额外空间
	* @param head
	* @return String
	* @throws 
	*/ 
	private static boolean isPalindrome2(Node head) {
		if(head == null || head.next==null)
			return true;
		Node right = head;
		Node cur = head.next;
		while(right.next!=null && right.next.next!=null){
			right = right.next.next;
			cur=cur.next;
		}
		Stack<Node> stack = new Stack<>();
		while(cur!=null){
			stack.push(cur);
			cur = cur.next;
		}
		right = head;
		while(!stack.isEmpty()){
			if(stack.pop().value!= right.value)
				return false;
			right = right.next;
		}
		return true;
	}
	/** 
	 * @Title: isPalindrome3 
	 * @Description:  空间复杂度O(1) 
	 * @param head
	 * @return String
	 * @throws  
	 */ 
	private static boolean isPalindrome3(Node head) {
		if(head == null || head.next ==null)
			return true;
		Node right = head;
		Node cur= head;
		Node mid= null;
		while(right.next!=null &&right.next.next!=null){
			cur=cur.next;
			right = right.next.next;
		}
		
		right = cur.next;
		cur.next = null;
		Node temp = null;
		while(right!=null){//逆序后半截
			temp=right.next;
			right.next=cur;
			cur = right;
			right = temp;
		}
		right= cur;//cur 保存最右节点
		temp = head;
		boolean res = true;
		while(right!=null && temp!=null){// 判断是否是回文
			if(right.value!=temp.value){
				res = false;
				break;
			}
			right = right.next;
			temp = temp.next;
		}
		right= cur.next;
		cur.next = null;
		while(right!=null){
			temp = right.next;
			right.next = cur;
			cur =right;
			right = temp;
			
		}
		return res;
	}
	public static void printLinkedList(Node node){
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}
	
}
