/**   
* @Title: BagWithRelyOn.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月6日 下午11:05:42
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
* @ClassName: BagWithRelyOn
* @Description: 题目描述

王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
主件			附件
电脑			打印机，扫描仪
书柜			图书
书桌			台灯，文具
工作椅		无
如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
    设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
    请你帮助王强设计一个满足要求的购物单。
 


输入描述:
输入的第 1 行，为两个正整数，用一个空格隔开：N m
（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）

从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q

（其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 



输出描述:
 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。

输入例子:
1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

输出例子:
2200
* @author Huaigui
*/
public class BagWithRelyOn {
	    /** 
	    * @Title: 思路：
	    * @Description: 
	    * 考虑到每个主件最多只有两个附件，因此我们可以通过转化，把原问题转化为01背包问题来解决，
	    * 在用01背包之前我们需要对输入数据进行处理，把每一种物品归类，即：把每一个主件和它的附件看作一类物品。
	    * 处理好之后，我们就可以使用01背包算法了。在取某件物品时，我们只需要从以下四种方案中取最大的那种方案：
	    * 只取主件、取主件＋附件1、取主件＋附件2、既主件＋附件1＋附件2。很容易得到如下状态转移方程：
	    * 
	    * f[i,j]=max{f[i-1,j]，
	    * f[i-1,j-a[i,0]]+a[i,0]*b[i,0]，
	    * f[i-1,j-a[i,0]-a[i,1]]+a[i,0]*b[i,0]+a[i,1]*b[i,1]，
	    * f[i-1,j-a[i,0]-a[i,2]]+a[i,0]*b[i,0]+a[i,2]*b[i,2]，
	    * f[i-1,j-a[i,0]-a[i,1]-a[i,2]]+a[i,0]*b[i,0]+a[i,1]*b[i,1]+a[i,2]*b[i,2]}
	    * 其中，f[i,j]表示用j元钱，买前i类物品，所得的最大值，a[i,0]表示第i类物品主件的价格，
	    * a[i,1]表示第i类物品第1个附件的价格，a[i,2]表示第i类物品第2个附件的价格，
	    * b[i,0],b[i,1],b[i,2]分别表示主件、第1个附件和第2个附件的重要度。
	    * 
	    * 
	    * 即变成了分组背包问题
	    */ 
	
    public static int getMaxValue(int[] val, int[] weight, int[] q, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (q[i-1] == 0) {  // 主件
                    if (weight[i - 1] <= j) // 用j这么多钱去买 i 件商品 可以获得最大价值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- weight[i - 1]]+ val[i - 1]);
                }
                else { //附件
                    if (weight[i - 1] + weight[q[i - 1]] <= j) //附件的话 加上主件一起算
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- weight[i - 1]]+ val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt()/10; // 总钱数  除以10减少计算量
            int m = input.nextInt(); // 商品个数
            int[] p = new int[m];
            int[] w = new int[m];
            int[] q = new int[m];
            for (int i = 0; i < m; i++) {
                p[i] = input.nextInt()/10;        // 价格
                w[i] = input.nextInt() * p[i]; // 价值
                q[i] = input.nextInt();        // 主or附件
            }
            System.out.println(getMaxValue(w, p, q, m, n)*10);
        }
    }
}