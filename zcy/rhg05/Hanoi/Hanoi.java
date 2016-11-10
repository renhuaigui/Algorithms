/**   
* @Title: Hanoi.java
* @Package rhg05.Hanoi
* @Description: TODO
* @author Huaigui   
* @date 2016年8月20日 下午9:37:47
* @version V1.0   
*/
package rhg05.Hanoi;

import java.util.Stack;

/**
 * @ClassName: Hanoi
 * @Description:汉诺塔问题 （改进版）
 * @author Huaigui
 */

public class Hanoi {

	public static int hanoiProblem1(int num, String left, String mid, String right) {
		if (num < 1) {
			return 0;
		}
		return process(num, left, mid, right, left, right);// 开始的时候从最左到最右，后面两参数表示，
	}

	public static int process(int num, String left, String mid, String right, String from, String to) {
		// num 是移动的那个盘子， from 是从哪个塔移到哪个塔 to, 中间三个参数是打印用的

		if (num == 1) {
			if (from.equals(mid) || to.equals(mid)) {
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 2;
			}
		}
		if (from.equals(mid) || to.equals(mid)) {// 两种有一个是mid. ,即不是夸中间操作
			String another = (from.equals(left) || to.equals(left)) ? right : left;// 俩个中一个是mid或者left
																					// ,则另一个是right
																					// ,f否则是left
			int part1 = process(num - 1, left, mid, right, from, another);// 把1到num-1移到另外一个上，
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);// 把第num移到确定的位置，
			int part3 = process(num - 1, left, mid, right, another, to);// 把1到num-1移动到目标位置上
			return part1 + part2 + part3;
		} else {// 跨中间的操作
			int part1 = process(num - 1, left, mid, right, from, to);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + mid);
			int part3 = process(num - 1, left, mid, right, to, from);
			int part4 = 1;
			System.out.println("Move " + num + " from " + mid + " to " + to);// 把第num移到确定的位置，
			int part5 = process(num - 1, left, mid, right, from, to);
			return part1 + part2 + part3 + part4 + part5;
		}
	}

	public static enum Action {
		No, LToM, MToL, MToR, RToM// 五中动作
	}

	public static int hanoiProblem2(int num, String left, String mid, String right) {
		Stack<Integer> lS = new Stack<Integer>();
		Stack<Integer> mS = new Stack<Integer>();
		Stack<Integer> rS = new Stack<Integer>();
		// 三个栈中压入最大的数，不用判断栈是否为空
		lS.push(Integer.MAX_VALUE);
		mS.push(Integer.MAX_VALUE);
		rS.push(Integer.MAX_VALUE);
		for (int i = num; i > 0; i--) {
			lS.push(i);
		}
		Action[] record = { Action.No };
		int step = 0;
		while (rS.size() != num + 1) {// 如果，没有完成则查询如下四个动作能不能做，能做则做了
			// 四个动作只可能有一个动作可以做： 因为 1.只能小压大，2.
			step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
			step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
			step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
			step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
		}
		return step;
	}

	/**
	 * @Title: fStackTotStack @Description: @param record 记录上一个动作 @param
	 * preNoAct 上一个不能做的动作 @param nowAct 当前动作 @param fStack 从哪个找操作 @param tStack
	 * 到哪个栈 @param from 打印用的从哪个栈 @param to 打印到哪个栈 @return int 总共走的步数 @throws
	 */
	public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack,
			Stack<Integer> tStack, String from, String to) {
		// 检查这个动作能不能做，能做则做了

		if (record[0] == preNoAct || fStack.peek() >= tStack.peek()) {// 满足，之前不能发生的动作，满足没有小压大
			return 0;
		}
		tStack.push(fStack.pop());
		System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
		record[0] = nowAct;
		return 1;
	}

	public static void main(String[] args) {
		int num = 4;

		// solution 1
		int steps1 = hanoiProblem1(num, "left", "mid", "right");
		System.out.println("It will move " + steps1 + " steps.");
		System.out.println("===================================");

		// solution 2
		int steps2 = hanoiProblem2(num, "left", "mid", "right");
		System.out.println("It will move " + steps2 + " steps.");
		System.out.println("===================================");

	}

}