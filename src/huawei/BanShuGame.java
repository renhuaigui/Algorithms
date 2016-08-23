/**   
* @Title: BanShuGame.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月3日 下午3:51:59
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
* @ClassName: BanShuGame
* @Description: 搬书游戏
描述:	
有N堆书围成一圈，每堆有M本书。现在想将这些书重新堆成一堆。每次只能将相邻的两堆书合并成一堆，经过N-1次合并最终完成N堆书合并成一堆。每次合并会得到一个合并得分，该得分为两堆书的书本个数之和。完成所有合并的总得分为每次合并的得分之和。请问如何最轻松的完成合并任务，即合并的总得分最小？
运行时间限制:	无限制
内存限制:	无限制
输入:	
输入若干以一个空格分隔的正整数，第一个数为书的总堆数N，后续的N个数为每堆书的数量M。其中N<=100，M<=50。
输出:	
输出搬移的最小总得分
样例输入:	
5 1 2 3 4 5
样例输出:	
33
* @author Huaigui
*/
public class BanShuGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		while(n>0){
			arr.add(sc.nextInt());	
			n--;
		}
//		if(n==1){
//			System.out.println(arr.get(0));
//		}
//		else {
			while(arr.size()>1){
				Collections.sort(arr);
				int a = arr.get(0);
				//System.out.println(arr.toString());
				arr.remove(0);
				int b = arr.get(0);
				arr.remove(0);
				sum = sum+a+b;
				arr.add(a+b);
				//System.out.println(arr.toString());
			}
			System.out.println(sum);
//		}
	}
}
