/**   
* @Title: TraversalBinaryTree.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年9月7日 下午8:44:32
* @version V1.0   
*/
package basic;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
* @ClassName: TraversalBinaryTree
* @Description: 遍历二叉树（前，中，后，层）
* @author Huaigui
*/

class Node{//二叉树结构
	public int val;
	public Node left;
	public Node right;
	public Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
public class TraversalBinaryTree {
	/** 
	* 前序遍历 递归方式
	*/ 
	private static String PreorderVisitRecur(Node head) {
		if(head==null)
			return "";
		else{
			return ""+head.val+
					PreorderVisitRecur(head.left)+
					PreorderVisitRecur(head.right);
		}
	}
	
	/**  
	* 前序遍历 非递归方式
	* 根据前序遍历访问的顺序，优先访问根结点，然后再分别访问左孩子和右孩子。
	* 即对于任一结点，其可看做是根结点，因此可以直接访问，访问完之后，若其左孩子不为空，
	* 按相同规则访问它的左子树；当访问其左子树时，再访问它的右子树。因此其处理过程如下：
	* 对于任一结点P：

     1)访问结点P，并将结点P入栈;

     2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，
     	并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;

     3)直到P为NULL并且栈为空，则遍历结束。
	*/ 
	private static String PreorderVisit(Node head) {
		if (head == null) {
			return null;
		}
		else {
			String res = "";
			Stack<Node> stack = new Stack<>();
			Node p = head;
			while(p!=null||!stack.isEmpty()){
				while (p!=null) {
					res = res + p.val;
					stack.push(p);
					p=p.left;
				}
				if (!stack.isEmpty()) {
					p= stack.pop();
					p=p.right;
				}
			}
			return res;
		}
	}
	/** 
	* 中序遍历 递归方式
	*/ 
	private static String MidOrderVisitRecur(Node head) {
		if(head==null)
			return "";
		else{
			return ""+
					MidOrderVisitRecur(head.left)+
					head.val+
					MidOrderVisitRecur(head.right);
		}
	}
	
	/**  
	* 中序序遍历 非递归方式
	*  根据中序遍历的顺序，对于任一结点，优先访问其左孩子，而左孩子结点又可以看做一根结点，
	*  然后继续访问其左孩子结点，直到遇到左孩子结点为空的结点才进行访问，
	*  然后按相同的规则访问其右子树。因此其处理过程如下：
   		对于任一结点P，

  		1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，
  		然后对当前结点P再进行相同的处理；

  		2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，
  		然后将当前的P置为栈顶结点的右孩子；

  		3)直到P为NULL并且栈为空则遍历结束
	*/ 
	private static String MidOrderVisit(Node head) {
		if (head == null) {
			return null;
		}
		else {
			String res ="";
			Stack<Node> stack = new Stack<>();
			Node p = head;
			while(p!=null||!stack.isEmpty()){
				while (p!=null) {
					stack.push(p);
					p=p.left;
				}
				if(!stack.isEmpty()){
					p = stack.pop();
					res = res + p.val;
					p = p.right;
				}
			}
			return res;
		}
	}
	
	/** 
	* 后序遍历 递归方式
	*/ 
	private static String PostOrderVisitRecur(Node head) {
		if(head==null)
			return "";
		else{
			return ""+
					PostOrderVisitRecur(head.left)+
					PostOrderVisitRecur(head.right)
					+head.val;
		}
	}
	
	/**  
	* 后序遍历 非递归方式
	* 后序遍历的非递归实现是三种遍历方式中最难的一种。
	* 因为在后序遍历中，要保证左孩子和右孩子都已被访问并且左孩子在右孩子前访问才能访问根结点，
	* 这就为流程的控制带来了难题。
	* 
	*  要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，
	*  先将其入栈。如果P不存在左孩子和右孩子，则可以直接访问它；
	*  或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，
	*  则同样可以直接访问该结点。若非上述两种情况，则将P的右孩子和左孩子依次入栈，
	*  这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，
	*  左孩子和右孩子都在根结点前面被访问。
	*/ 
	private static String PostOrderVisit(Node head) {
		if (head == null) {
			return null;
		}
		else{
			String res ="";
			Node pre = null;//上一次输出的节点，  开始时为空
			Node cur = null;//当前节点
			Stack<Node> stack = new Stack<>();
			stack.push(head);
			while(!stack.isEmpty()){
				cur = stack.peek();
				if(cur.left == null && cur.right == null || 
				   (pre !=  null &&(pre == cur.left ||pre == cur.right)))
				{
					res = res + cur.val;
					pre = cur;
					stack.pop();
				}
				else {
					if(cur.right != null)
						stack.push(cur.right);
					if(cur.left != null)
						stack.push(cur.left);
				}
			}
			return res;
		}
	}
	
	/** 
	*  层序遍历  使用队列
	*/ 
	private static String LevelorderVist(Node head) {
		if(head==null)
			return null;
		else {
			String res="";
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add(head);
			while(!queue.isEmpty()){
				Node temp = queue.poll();
				res = res + temp.val;
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			
			return res;
		}
	}
	
	public static void main(String[] args){
		//二叉树结构
		//				1
		//			2		3
		//		   4  5   6   7
		
		Node head = new Node(1);
		Node l = new Node(2);
		Node r = new Node(3);
		head.left = l;
		head.right = r;
		Node ll = new Node(4);
		Node lr = new Node(5);
		l.left = ll;
		l.right = lr;
		Node rl= new Node(6);
		Node rr = new Node(7);
		r.left = rl;
		r.right = rr;
		
		System.out.println("----------------------");
		System.out.println("递归前序：");
		System.out.println(PreorderVisitRecur(head));
		System.out.println("非递归前序：");
		System.out.println(PreorderVisit(head));
		System.out.println("----------------------");
		System.out.println("递归中序：");
		System.out.println(MidOrderVisitRecur(head));
		System.out.println("非递归中序：");
		System.out.println(MidOrderVisit(head));
		System.out.println("----------------------");
		System.out.println("递归后序：");
		System.out.println(PostOrderVisitRecur(head));
		System.out.println("非递归后序：");
		System.out.println(PostOrderVisit(head));
		System.out.println("----------------------");
		System.out.println("层序遍历：");
		System.out.println(LevelorderVist(head));
		System.out.println("----------------------");
		
	}
}
