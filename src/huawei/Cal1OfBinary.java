/**   
* @Title: Cal1OfBinary.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月6日 下午9:51:08
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: Cal1OfBinary
* @Description: TODO
* @author Huaigui
*/
public class Cal1OfBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num=0;
		while(n!=0){
			if(n%2==1) num++;
			n=n/2;
		}
		
		
		/*System.out.println(num);
		int num = sc.nextInt();
	    String s = Integer.toBinaryString(num);
	    num=0;
	    for (int i = 0; i < s.length(); i++) {
	    	if(s.charAt(i)=='1'){
	    		num++;
	    	}
	    }
	    System.out.println(num);*/
	}
}
