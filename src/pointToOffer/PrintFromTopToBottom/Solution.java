/**   
* @Title: Solution.java
* @Package pointToOffer.PrintFromTopToBottom
* @Description: TODO
* @author Huaigui   
* @date 2016年8月17日 下午4:45:42
* @version V1.0   
*/
package pointToOffer.PrintFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//import pointToOffer.TreeNode;

/**
 * @ClassName: Solution
 * @Description: 解决方法
 * @author Huaigui
 */

// 树数据结构
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}

public class Solution {
	public static ArrayList<Integer> PrintFromToTopBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return list;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			if (treeNode.left != null)
				queue.offer(treeNode.left);
			if (treeNode.right != null)
				queue.offer(treeNode.right);
			list.add(treeNode.val);
		}
		return list;
	}

	// 测试
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode rootl = new TreeNode(3);
		TreeNode rootr = new TreeNode(2);
		TreeNode rootl1 = new TreeNode(4);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootl1;
		rootl.right = null;
		rootr.left = null;
		rootr.right = null;
		System.err.println(PrintFromToTopBottom(root).toString());

	}
}
