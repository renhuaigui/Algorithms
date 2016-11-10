/**   
* @Title: MultiThread.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年9月9日 下午3:26:37
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: MultiThread
 * @Description: TODO
 * @author Huaigui
 */
public class MultiThread implements Runnable {
	private String name;
	private Object prev;
	private Object self;
	private int count;

	private MultiThread(String name, Object prev, Object self, int count) {
		this.name = name;
		this.prev = prev;
		this.self = self;
		this.count = count;
	}

	@Override
	public void run() {
		// int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.print(name);
					count--;
					self.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Object d = new Object();
		int count = new Scanner(System.in).nextInt();
		MultiThread pa = new MultiThread("A", d, a, count);
		MultiThread pb = new MultiThread("B", a, b, count);
		MultiThread pc = new MultiThread("C", b, c, count);
		MultiThread pd = new MultiThread("D", c, d, count);

		new Thread(pa).start();
		Thread.sleep(100); // 确保按顺序A、B、C执行
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
		new Thread(pd).start();
	}
}
