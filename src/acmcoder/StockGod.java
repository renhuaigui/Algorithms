/**   
* @Title:  StockGod.java
* @Package acmcoder
* @Description: 股神
* @author Huaigui   
* @date 2016年9月5日 下午1:54:40
* @version V1.0   
*/
package acmcoder;

import java.util.Scanner;

/**
* @ClassName:  StockGod
* @Description: 股神
有股神吗？
有，小赛就是！
经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
* @author Huaigui
*/
public class StockGod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int inc = 1;
			int n = sc.nextInt();
			int pric = 1;
			int flag = 1;
			while(n>1){
				if(flag ==1){
					for(int i=0;i<inc&&n>1;i++){
						++pric;
						n--;
					}
					inc++;
					flag =0;
				}
				else {
					flag=1;
					--pric;
					n--;
				}
			}
			System.out.println(pric);
			
		}
		sc.close();
	}
}
