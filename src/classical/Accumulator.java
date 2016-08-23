/**   
* @Title: Accumulator.java
* @Package basic
* @Description: TODO
* @author Huaigui   
* @date 2016年3月17日 下午2:06:19
* @version V1.0   
*/
package classical;

import stdlib.StdDraw;
import stdlib.StdOut;
import stdlib.StdRandom;

/**
* @ClassName: Accumulator
* @Description: 可视化计数器
* @author Huaigui
* @date 2016年3月17日 下午2:06:19
* 
*/
public class Accumulator {
	private int N;
	private double total;
	public Accumulator(int trials,double max){
		StdDraw.setXscale(0,trials);
		StdDraw.setYscale(0,max);
		StdDraw.setPenRadius(0.005);
	}
	public void addDataValue(double val)
	{
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
		
	}
	public double mean() {
		return total/N;
	}
	
	public String toString()
	{ return "Mean("+N+"vales):"+String.format("%7.5f", mean());}
	
	
	
	
	/** 
	* @Title: main 
	* @Description: TODO
	* @param args   
	* @return void
	* @throws 
	*/ 
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		Accumulator a = new Accumulator(T, 1);
		for (int t = 0; t < T; t++) {
			a.addDataValue(StdRandom.random());
			StdOut.println(a);
		}
	}
	
		
}
