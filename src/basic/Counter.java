/**   
* @Title: Counter.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年3月17日 下午12:41:45
* @version V1.0   
*/
package basic;


import javafx.scene.layout.Background;
import stdlib.*;
/**
* @ClassName: Counter
* @Description: 计数器类
* @author Huaigui
* @date 2016年3月17日 下午12:41:45
* 
*/
public class Counter {
	private final String name;
	private int count;
	public Counter(String id) {name = id;}
	public void increment() {count ++;} // 计数器加1
	public void decrease() {count --;} // 计数器减一
	public int tally() {return count;}
	public String toString() {return count + " " + name;}
	
	/** 
	* @Title: main 
	* @Description: TODO
	* @param args   
	* @return void
	* @throws 
	*/ 
	public static void main(String[] args) {
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		heads.increment();
		heads.increment();
		tails.increment();
		StdOut.println(heads + " "+tails);
		StdOut.println(heads.tally() + tails.tally());
	}
	
	
}
