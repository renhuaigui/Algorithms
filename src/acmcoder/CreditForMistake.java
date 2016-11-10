/**   
* @Title: CreditForMistake.java
* @Package acmcoder
* @Description: TODO
* @author Huaigui   
* @date 2016年9月5日 下午2:38:13
* @version V1.0   
*/
package acmcoder;

import java.util.Scanner;

/**
* @ClassName: CreditForMistake
* @Description: 将功赎过
* 小赛是一名幸运的程序员。
虽然他成功帮助小朋友以最快时间夺回了狼堡，但是面试官却打算和他说拜拜了。
理由是——游戏天赋太高，有不务正业、走火入魔的倾向QAQ……
尽管小赛很不能接受这个理由，可是却只能心灰意冷地吃下这个结果。
然而，在他即将走出门的时候，面试官给了幸运的小赛一个最后的机会。
原来，面试官的手机被他调皮的儿子小明用一个数字作为密码锁上了。
小明只记得这个数字的十进制范围是l~r，且这个数的二进制表示中恰有m个1，却不记得确切的数字了。
面试官可急坏了。这才有了小赛一个将功赎过的机会。
他想要让小赛算出，他最坏情况下，要试多少次密码才能确保打开手机呢？
请输出这个次数。

输入
输入仅一行，包含三个整数l,r,m，其中l,r表示这个数的十进制范围是l~r，m表示这个数的二进制表示中有m个1.
数据保证——
对于30%的测试点，0<=l<=r<=20，0<=m<=5，
对于70%的测试点，0<=l<=r<=1000，0<=m<=10，
对于100%的测试点，0<=l<=r<=2000000，0<=m<=24.
样例输入
1 4 2

输出
输出一行，包含一个整数，表示面试官最坏情况下，要试多少次密码才能确保打开手机。
如果小明记错了（也就是不存在任何一个数满足），则输出"-1"（不含引号)。
样例输出
1
* @author Huaigui
*/
public class CreditForMistake {
	public static boolean checkOne(int n, int m){
		int countOne=0;
		while(n>0){
			countOne++;
			n=n&n-1;
		}
		return (m==countOne);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int l = sc.nextInt();
			int r = sc.nextInt();
			int m = sc.nextInt();
			int count = 0;
			for(int n= l;n<=r;n++){
				if(checkOne(n, m))
					count++;
			}
			if(count>0)
				System.out.println(count);
			else
				System.out.println(-1);
		}
		sc.close();
	}
}
