/**   
* @Title: FoldPaper.java
* @Package nowcode
* @Description: TODO
* @author Huaigui   
* @date 2016年4月27日 下午10:38:59
* @version V1.0   
*/
package nowcode;

import java.util.Arrays;

/**
* @ClassName: FoldPaper
* @Description: 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。
* 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。
* 如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
* 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
* 测试样例：
* 1
* 返回：["down"]
* 2
* 返回：["down","down","up"]
* @author Huaigui
* @date 2016年4月27日 下午10:38:59
* 
*/
public class FoldPaper {
	/**
	 * 折痕其实是二叉树结构。该二叉树的特点是：根节点是下，每一个节点的左节点是下，右节点是上。
	 * 该二叉树的中序遍历即为答案，但不需要构造一颗二叉树，用递归方法可打印出来。
	 */
	public String[] foldPaper(int n) {
		/**
		 * 首先，第一次折叠后，序列是d。
		 * 第二次折叠后，序列是ddu。
		 * 第三次折叠后，序列是ddudduu。
		 * 经过分析发现，每次的序列，是在前一次的每个间隔中，以dudu。。。的顺序插入的。
		 * 比如：第一次的是d，它有左右两个空位，分别插入d u后就变为了ddu。          
		 * 第二次是ddu，从第一个d左边到第三个位置的u右边，共有四个空位，分别插入dudu后，结果是ddudduu 
		 */
        // write code here
		String []result = new String[(int)(Math.pow(2, n)-1)] ;
		result = inserfold(result,0,result.length-1,"down");
		return result;
		
    }


	public String[] inserfold(String[] result,int low,int hight,String s){
		if (low == hight){
			result[low] = s;
			return result;
		}
		int mid = (low+hight)/2;
		result = inserfold(result,low,mid-1,"down");
		result[mid] = s;
		result = inserfold(result,mid+1,hight,"up");
		return result;
	}
	public static void main(String[] args) {
		FoldPaper foldPaper  = new FoldPaper();
		System.out.println(Arrays.toString(foldPaper.foldPaper(4)));
	}
}
