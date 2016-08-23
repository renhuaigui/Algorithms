/**   
* @Title: LCM.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月21日 下午9:12:58
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: LCM
* @Description:  最小公倍数
* @author Huaigui
*/
public class LCM {
	
	 public static int lcm(int m,int n)
	    {
	        return m*n/gcd1(m,n);
	    }
	     
	    public static int gcd1(int m,int n)
	    {
	        while(n!=0)
	        {
	            int temp = m%n;
	            System.out.println(temp);
	            m = n;
	            n = temp;
	        }
	        return m;
	    }
	public static int gcd(int a, int b){
		int max;
		int min;
		int t;
		if(a>b){
			max = a;
			min= b;
		}
		else {
			max= b;
			min =a;
		}
		while ((t=max%min)!=0) {
			max=min;
			min=t;
			//t=max % min;
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a*b/gcd(a, b));
		System.out.println(lcm(a, b));
	}
	
}
