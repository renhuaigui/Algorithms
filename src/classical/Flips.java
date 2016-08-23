/**   
* @Title: Flips.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年3月17日 下午1:45:15
* @version V1.0   
*/
package classical;

import basic.Counter;
import stdlib.StdOut;
import stdlib.StdRandom;

/**
* @ClassName: Flips
* @Description: 抛硬币模拟
* @author Huaigui
* @date 2016年3月17日 下午1:45:15
* 
*/
public class Flips {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		for(int t = 0;t<T;t++){
			if(StdRandom.bernoulli(0.5))
				heads.increment();
			else 
				tails.increment();
		}
		StdOut.println(heads);
		StdOut.println(tails);
		StdOut.println("delta:"+Math.abs(heads.tally()-tails.tally()));
	}
}
