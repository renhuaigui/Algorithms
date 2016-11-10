/**   
* @Title: KMP.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年8月4日 上午9:04:44
* @version V1.0   
*/
package classical.KMP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: KMP
 * @Description: 字符串匹配
 * 思路：
 * 暴力解：
 * 		 每次主串向前走一步,用子串和主串比较，若接下来的主串字符和子串每个对应为都相同则 匹配结束  放回成功，若遇到不相同的 ，则主串循环加一 继续之前的步骤。
 * KMP解：
 * 		当遇到不匹配的时候，主串循环不是加1  返回失配位之前的最长公共前后缀（next[]）！
 * 
j	        1	2   3	4	5	6	7	8	9	10
pattern[j]	a	b	c	a	b	c	a	c	a	b
next[j]  	0	1	1	0	1	1	0	5	0	1
 * @author Huaigui
 */
public class KMP {
	public static int [] getNext(char []t){
		int [] next = new int[t.length];
		next[0] = 0;//模板串的第一个字符的最大前后缀的长度为0
		for(int i = 1, j =0;i<t.length;i++){// 从第二个字符开始一次计算每个字符的next值
			while(j>0 && t[i] != t[j]) j = next[j-1];//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
			if(t[i]==t[j]){
				j++;  //如果相等，那么最大相同前后缀长度加1
			}
			next[i]=j;
		}
		System.out.println("next: "+ Arrays.toString(next));
		return next;
	}
	public static int kmp(char []str1, char []str2){
		int []next = getNext(str2);
		int begain =-1;
		for(int i = 0, j=0;i<str1.length;++i){
			while(j>0 && str2[j]!=str1[i]){
				j = next[j-1];  //出现不匹配时  搜索走的步数
			}
			if (str1[i]==str2[j]) {
				j++;
			}
			if(j==str2.length){
				begain = i-j+1;
				break;
			}
			System.err.println(i  +" " +j);
		}
		return begain;//返回开始匹配的下标
	}
	
	
	//思路二
	/** 
     * 获得字符串的next函数值 
     *  
     * @param t 
     *            字符串 
     * @return next函数值 
     */  
    public static int[] next(char[] t) {  
        int[] next = new int[t.length];  
        next[0] = -1;  
        int i = 0;  
        int j = -1;  
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {  
                i++;  
                j++;  
                if (t[i] != t[j]) {  
                    next[i] = j;  
                } else {  
                    next[i] = next[j];  
                }  
            } else {  
                j = next[j];  
            }  
        }  
        System.out.println("next: "+ Arrays.toString(next));
        return next;  
    } 
	
	 /** 
     * KMP匹配字符串 
     *  
     * @param s 
     *            主串 
     * @param t 
     *            模式串 
     * @return 若匹配成功，返回下标，否则返回-1 
     */  
    public static int KMP_Index(char[] s, char[] t) {  
    	if(s==null||t==null){
    		return -1;
    	}
        int[] next = next(t);  
        int i = 0;  
        int j = 0;  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } else  
            return i - t.length; // 返回模式串在主串中的头下标  
    }  
    
    
    
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			int index =kmp(s1.toCharArray(),s2.toCharArray());
			int index1 = KMP_Index(s1.toCharArray(),s2.toCharArray());
			System.out.println(index);
			System.out.println(index1);
		}
		sc.close();
	}
}
