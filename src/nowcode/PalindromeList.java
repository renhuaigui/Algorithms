/**   
* @Title: PalindromeList.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年4月15日 下午10:21:10
* @version V1.0   
*/
package nowcode;

/**
 * @ClassName: PalindromeList
 * @see:
 * 
 * 		对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *      给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。 测试样例： 1->2->2->1
 *      返回：true
 * 
 * 
 * @author Huaigui
 * @date 2016年4月15日 下午10:21:10
 * 
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class PalindromeList {
	public static boolean chkPalindrome(ListNode A) {
		/*
		 * 思路：设置两个指针，一个快，一个慢，循环一次，找到中间的位置（奇偶都可以）
		 * 然后逆序后半部分的列表，生成一另一个列表，循环后半部分直到空，判断两个列表的对应元素是否相等
		 */
		// write code here
		ListNode slow = A;
		ListNode fast = A;
		if (A == null) // 列表为空 false
			return false;
		if (A.next == null) // 列表只有一个元素 true
			return true;
		while ((fast.next != null) && fast.next.next != null) { // 找到中间位置
			System.out.print(slow.val + " ");
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode p = slow.next;
		// System.out.print(p.val+" ");
		ListNode B = null;
		while (p != null) { // 逆序后面部分列表
			ListNode temp = p.next;
			System.out.print(p.val + " ");
			p.next = B;
			B = p;
			p = temp;
		}
		while (B != null) {
			// System.out.println(B.val+" ");
			if (B.val != A.val) // 判断没个元素是否相等
				return false;
			else {
				B = B.next; // 指针后移
				A = A.next;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// 421,305,13,425,222,609,100,131,579,579,131,100,609,222,425,13,305,421

		ListNode listNode = new ListNode(421);
		ListNode listNode2 = new ListNode(305);
		ListNode listNode3 = new ListNode(13);
		ListNode listNode4 = new ListNode(425);
		ListNode listNode5 = new ListNode(222);
		ListNode listNode6 = new ListNode(609);
		ListNode listNode7 = new ListNode(100);
		ListNode listNode8 = new ListNode(131);
		ListNode listNode9 = new ListNode(579);
		ListNode listNode10 = new ListNode(579);
		ListNode listNode11 = new ListNode(131);
		ListNode listNode12 = new ListNode(100);
		ListNode listNode13 = new ListNode(609);
		ListNode listNode14 = new ListNode(222);
		ListNode listNode15 = new ListNode(425);
		ListNode listNode16 = new ListNode(13);
		ListNode listNode17 = new ListNode(305);
		ListNode listNode18 = new ListNode(421);
		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		listNode7.next = listNode8;
		listNode8.next = listNode9;
		listNode9.next = listNode10;
		listNode10.next = listNode11;
		listNode11.next = listNode12;
		listNode12.next = listNode13;
		listNode13.next = listNode14;
		listNode14.next = listNode15;
		listNode15.next = listNode16;
		listNode16.next = listNode17;
		listNode17.next = listNode18;
		listNode18.next = null;
		if (chkPalindrome(listNode))
			System.out.print("true");
		else
			System.out.print("false");
	}
}
