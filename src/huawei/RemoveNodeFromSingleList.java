/**   
* @Title: RemoveNodeFromSingleList.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月25日 下午8:40:19
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: RemoveNodeFromSingleList
 * @see: 从单向链表中删除指定值的节点
 * 
 *       题目描述
 * 
 *       输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。 链表结点定义如下：
 *       struct  ListNode { 
 *       	int m_nKey; 
 *       	ListNode* m_pNext; 
 *       }; 
 *       详细描述： 本题为考察链表的插入和删除知识。
 *       链表的值不能重复 构造过程，例如 1 -> 2 3 -> 2 5 -> 1 4 -> 5 7 -> 2 最后的链表的顺序为 2 7 3 1 5
 *       4 删除 结点 2 则结果为 7 3 1 5 4
 * 
 * 
 * 
 *       输入描述: 1 输入链表结点个数 2 输入头结点的值 3 按照格式插入各个结点 4 输入要删除的结点的值
 * 
 * 
 *       输出描述: 输出删除结点后的序列
 * 
 *       输入例子: 5 2 3 2 4 3 5 2 1 4 3
 * 
 *       输出例子: 2 1 5 4
 * @author Huaigui
 */
class Node {
	public int val;
	public Node next;

	public Node(int val) {
		this.val = val;
		this.next = null;
	}
}

public class RemoveNodeFromSingleList {
	public static void insert(Node head, int preVal, int nextVal) {
		Node pNext = new Node(nextVal);
		Node pCurrent = head;
		if (head == null) {
			return;
		}
		while (pCurrent != null) {
			// System.err.println(nextVal);
			if (pCurrent.val == preVal) {
				pNext.next = pCurrent.next;
				pCurrent.next = pNext;
				break;
			}
			pCurrent = pCurrent.next;
		}

	}

	public static Node remove(Node head, int val) {
		if (head == null)
			return null;
		Node result = null;
		if (head.val == val) {
			head = head.next;
		} else {
			Node preNode = head;
			while (preNode != null && preNode.next != null) {
				if (preNode.next.val == val) {
					result = preNode.next;
					preNode.next = preNode.next.next;
					break;
				}
				preNode = preNode.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int headval = sc.nextInt();
			Node head = new Node(headval);
			for (int i = 0; i < n - 1; i++) {
				int nextVal = sc.nextInt();// 当前的节点
				int preVal = sc.nextInt();// 当前的节点的前一个节点
				// System.err.println(nextVal);
				insert(head, preVal, nextVal);
			}
			int delet = sc.nextInt();
			// System.err.println(delet);
			head = remove(head, delet);
			Node pNode = head;
			while (pNode != null) {
				if (pNode.next != null) {
					System.out.print(pNode.val + " ");
				} else {
					System.out.println(pNode.val + " ");
				}
				pNode = pNode.next;
			}
		}
		sc.close();
	}
}
