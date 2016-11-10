package classical.allPermutation;
/**   
* @Title: Main.java
* @Package allPermutation
* @Description: 字符串全排列
* @author Huaigui   
* @date 2016年8月11日 下午2:28:14
* @version V1.0   
*/

import java.util.Scanner;

/**
* @ClassName: Main
* @Description: 字符串全排列
* @author Huaigui 
*/
/**
 * 思路: 求整个欺负串的排列，可以看成两步： 首先、求所有可能出现在第一个位置的字符，即包第一个字符和后面的所有字符交换，
 * 第二步，固定第一个字符，求后面的所有字符的排列。 这个时候我们报后面的字符分成两个部分：后面字符的第一个字符，以及这个字符之后所有字符，
 * 则转换成递归调用子过程
 */
public class Main {
	public static void permutation(char[] str, int i) {
		// 这个判断很关键，每次递归到最后的时候，就是i到最后的时候，就是要打印出相应的全排列字符串的时候，
		if (i >= str.length)
			return;
		if (i == str.length - 1) {// 这个判断用于递归到最后的时候输出相应的字符串
			System.out.println(String.valueOf(str));
		} else {
			// 这个else块的作用有1：交换第一个位置的字符，比如第一个位置的全排列字符串全部打印后就把第一个字符和第二个交换；
			// 2：递归打印每次第一个字符串的全排列字符串；
			// 3：每次递归的时候都会传递一个字符串数组，最后三行代码就是控制这个字符串数组不变，意思就是
			// 什么样子传递出去，就什么样子传递回来，一点不能变化，因为最后三行代码不是用于改变字符串数组的
			for (int j = i; j < str.length; j++) {
				// 这三行代码用于控制第一个位置的字符 ，对应作用1
				char temp = str[j];
				str[j] = str[i];
				str[i] = temp;

				permutation(str, i + 1);// 通过start控制要被输出的字符串，对应作用2

				// 这三行是把变换后的字符串顺序进行还原,能够变换字符串顺序的，对应作用3
				temp = str[j];
				str[j] = str[i];
				str[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			permutation(str.toCharArray(), 0);
		}
		sc.close();
	}

}
