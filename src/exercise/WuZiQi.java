/**   
* @Title: WuZiQi.java
* @Package exercise
* @Description: TODO
* @author Huaigui   
* @date 2016年7月26日 下午2:44:56
* @version V1.0   
*/
package exercise;

import java.util.Scanner;

/**
* @ClassName: WuZiQi
* @Description: （粤港澳补充题）五子棋
描述:	
此题目限定的五子棋规则：
1、棋盘大小：15*15
2、分为黑棋和白棋，一种颜色棋子不论横、竖、斜连成5个或大于5个算赢
3、黑白交替下，也就是说一方不能连续2次成功落子。
要求：根据双方落子，进行有效性判断和胜负判断。
运行时间限制:	无限制
内存限制:	无限制
输入:	
输入一行或多行，每行包括三个整数，分别是棋子类型，棋子的横坐标，棋子的纵坐标，以空格隔开
棋子类型：0  黑棋，1 白棋
棋子坐标从0开始，小于15。
输出:	
针对每行输入，如果：
黑方胜，输出1；
白方胜，输出2；
落子失败，比如坐标错误，或顺序错，输出-1；
其他情况：落字成功，不输出；
胜负一旦确定，测试用例就结束。
样例输入:	
0 7 7
1 7 8
0 7 7
1 7 5
0 8 8
1 9 9
0 6 6
1 8 9
0 5 5
1 7 9
0 4 4
样例输出:	
-1
-1
1
* @author Huaigui
*/
public class WuZiQi {
	 /* 
     * 判赢方法 
     */  
  
    /* 
     * 判定横向五个相连 
     */  
    public static boolean winRow(int[][] array_win,int row, int column) {  
        int count = 1;  
        for (int i = column + 1; i < 15; i++) {// 向右查找  
            if (array_win[row][column] == array_win[row][i]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = column - 1; i >= 0; i--) {// 向左查找  
            if (array_win[row][column] == array_win[row][i]) {  
                count++;  
            } else  
                break;  
        }  
  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    /* 
     * 判定竖向五个相连 
     */  
    public static boolean winColumn(int[][] array_win,int row, int column) {  
        int count = 1;  
        for (int i = row + 1; i < 15; i++) {// 向右查找  
            if (array_win[row][column] == array_win[i][column]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = row - 1; i >= 0; i--) {// 向左查找  
            if (array_win[row][column] == array_win[i][column]) {  
                count++;  
            } else  
                break;  
        }  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    /* 
     * 判定斜向右下五个相连 
     */  
    public static boolean winRightDown(int[][] array_win,int row, int column) {  
        int count = 1;  
        for (int i = column + 1, j = row + 1; i < 15 && j < 15; i++, j++) {// 向右查找  
            if (array_win[row][column] == array_win[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {// 向左查找  
            if (array_win[row][column] == array_win[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    /* 
     * 判定斜向左下五个相连 
     */  
    public static boolean winLeftDown(int[][] array_win,int row, int column) {  
        int count = 1;  
        for (int i = column - 1, j = row + 1; i >=0 && j < 15; i--, j++) {// 向右查找  
            if (array_win[row][column] == array_win[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = column + 1, j = row - 1; i <15 && j >= 0; i++, j--) {// 向左查找  
            if (array_win[row][column] == array_win[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
	public static void main(String[] args) {
		boolean over = false;
		Scanner sc = new Scanner(System.in);
		int [][] a = new int[15][15];
		for(int i = 0;i<a.length;i++){
			for(int j = 0 ; j<a[0].length;j++){
				a[i][j]=2;
			}
		}
		String [] s = sc.nextLine().split(" ");
		int[] b= new int[3];
		b[0] = Integer.parseInt(s[0]);
		b[1] = Integer.parseInt(s[1]);
		b[2] = Integer.parseInt(s[2]);
		/*System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);*/
		int flag = b[0];
		a[b[1]][b[2]] = b[0];
		while(!over&sc.hasNext()){
			s = sc.nextLine().split(" ");
			b[0] = Integer.parseInt(s[0]);
			b[1] = Integer.parseInt(s[1]);
			b[2] = Integer.parseInt(s[2]);
			/*System.out.println(flag);
			System.out.println(b[0]);
			System.out.println(b[1]);
			System.out.println(b[2]);*/
			if(flag!=b[0]&&b[1]<15&b[1]>-1&&b[2]<15&&b[2]>-1 && a[b[1]][b[2]]==2){
				flag = b[0];
				a[b[1]][b[2]] = b[0];
				if(winRow(a,b[1], b[2]) || winColumn(a,b[1], b[2])  
		                || winRightDown(a,b[1], b[2]) || winLeftDown(a,b[1], b[2])){
					over = true;
					if(b[0]==0)
						System.out.println(1);
					else if(b[0]==1)
						System.out.println(2);
				}
			}
			else{
				System.out.println(-1);
			}
		}
	}
}
