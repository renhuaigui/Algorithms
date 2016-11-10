/**   
* @Title: CountChar.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月25日 下午4:22:27
* @version V1.0   
*/
package huawei;

import java.util.Scanner;
/**
* @ClassName: CountChar
* @Description: 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
* 题目描述

输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 
输入描述:
输入一行字符串，可以有空格


输出描述:
统计其中英文字符，空格字符，数字字符，其他字符的个数

输入例子:
1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][

输出例子:
26
3
10
12
* @author Huaigui
*/
public class CountChar {
	 /**
     * 统计出英文字母字符的个数。
     * 
     * @param str 需要输入的字符串
     * @return 英文字母的个数
     */
    public static int getEnglishCharCount(String str)
    {
        if(str==null || str.length()==0)
            return -1;
        char [] ch = str.toCharArray();
        int n = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i]>='a'&& ch[i]<='z' || ch[i]>='A'&& ch[i]<='Z')
                n++;
        }
        return n;
    }
    
    /**
     * 统计出空格字符的个数。
     * 
     * @param str 需要输入的字符串
     * @return 空格的个数
     */
    public static int getBlankCharCount(String str)
    {
         if(str==null || str.length()==0)
            return -1;
        char [] ch = str.toCharArray();
        int n = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i]==' ')
                n++;
        }
        return n;
    }
    
    /**
     * 统计出数字字符的个数。
     * 
     * @param str 需要输入的字符串
     * @return 英文字母的个数
     */
    public static int getNumberCharCount(String str)
    {
       if(str==null || str.length()==0)
            return -1;
        char [] ch = str.toCharArray();
        int n = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i]>='0'&& ch[i]<='9')
                n++;
        }
        return n;
    }
    
    /**
     * 统计出其它字符的个数。
     * 
     * @param str 需要输入的字符串
     * @return 英文字母的个数
     */
    public static int getOtherCharCount(String str)
    {
        if(str==null || str.length()==0)
            return -1;
        char [] ch = str.toCharArray();
        int n = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i]>='a'&& ch[i]<='z' || ch[i]>='A'&& ch[i]<='Z'
               || ch[i]>='0'&& ch[i]<='9'
               || ch[i]==' ')
                ;
            else
                n++;
        }
        return n;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int eNum = getEnglishCharCount(str);
            int nNum = getNumberCharCount(str);
            int bNum = getBlankCharCount(str);
            int oNum = getOtherCharCount(str);
            System.out.println(eNum);
            System.out.println(bNum);
            System.out.println(nNum);
            System.out.println(oNum);
            
        }
        sc.close();
    }
}