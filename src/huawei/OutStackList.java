/**   
* @Title: OutStackList.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年8月10日 下午3:14:44
* @version V1.0   
*/
package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
* @ClassName: OutStackList
* @Description: 
给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
 
题目类别: 栈 
难度: 高级 
分数:  
运行时间限制: 10 Sec 
内存限制: 128 MByte 
阶段: 招聘管理 
输入: 
有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 
输出: 
输出以字典序排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 
样例输入: 3
1 2 3
 
样例输出: 1 2 3
1 3 2
2 1 3
2 3 1
3 2 1
 

* @author Huaigui
*/
public class OutStackList {
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while (sc.hasNext()) {
			int n = sc.nextInt();
	        int total = 0;
	        int [][] save = new int [300][];
	        int stack[] = new int [n];
	        for (int i = 0; i < stack.length; i++) {
	            stack[i]=sc.nextInt();
	        }
	        for (int i = 0; i < 300; i++) {
	            save[i] = new int [stack.length+1];
	
	        }
	        InnArr(stack,save);
	        //System.out.println("The result is: ");
	        for (; save[total][0] != 0; total++) {
	            for (int j = 0; j < save[total].length-2; j++) {
	                System.out.print(save[total][j]+" ");
	
	            }
	            System.out.println(save[total][save[total].length-2]);
	
	        }
	        //System.out.println("Total: "+total);
		}
        sc.close();
    }

    public static void InnArr(int [] stack,int [][]save){
        int k = 1;
        int p = 1;
        
        save[0][0] = stack[0];
        while(k<stack.length){
            p = inset(stack,save,k,p);
            k++;
        }
    }

    public static int inset(int [] stack,int [][] save,int k,int p){
        int f=p;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < k; j++) {
                if (save[i][j]==stack[k-1]) {
                    int temp [] = new int [save[i].length];
                    System.arraycopy(save[i], 0, temp, 0, save[i].length);
                    set(save[i],j+1,stack[k],temp);
                    set(save[f],j,stack[k],temp);
                    f++;
                    for (int m = j+2; m <= k; m++) {
                        set(save[f],m,stack[k],temp);
                        f++;
                    }
                    break;
                }
            }
        }
        return  f;
    }

    public static void set(int [] save,int m,int k,int [] arr){
        System.arraycopy(arr, 0, save, 0, save.length);
        for (int i = save.length-2; i >= m; i--) {
            save[i+1]=save[i];
        }
        save[m]=k;
    }*/
	
	
	
	public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
//      Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
      while (scanner.hasNext()) {
          int n = scanner.nextInt();
          String[] ss = new String[n];
          for (int i = 0; i < n; i++) {
              ss[i] = scanner.next();
          }

          System.out.println(trainOut(ss));
      }

      scanner.close();
  }

  /**
   * 此处所谓字典序排序的意思是这n辆火车有多少种出站的可能顺序（也就是数据结构中的栈有多少种出栈顺序）。
   * 思路为用三个变量分别存储待进站火车，站中火车和已出站火车，其中待进站火车用Queue（队列）存储和站中
   * 火车采用stack（栈）存储，已出站火车采用StringBuilder来存储，具体实现是采用递归的方法，递归函数
   * 的参数为当前待进站火车、站中火车、已出站火车的值所组成的三元组，递归结束条件是，未进站火车和站中火
   * 车均为空，此时输出已出站火车即为所有出站的一种可能，递推关系为对于当前情况有让下一辆火车进站或让站
   * 中的一辆火车出站两种可能，对于两种可能分别调用递归函数，即可得出问题的解。
   *
   * @param ss
   * @return
   */
  private static String trainOut(String[] ss) {

//      Arrays.sort(ss);

      List<List<String>> result = new ArrayList<>();
      List<String> out = new ArrayList<>(ss.length);
      List<String> unout = new ArrayList<>(ss.length);
      trainOut(0, ss, out, unout, result);

      Collections.sort(result, new Comparator<List<String>>() {

          @Override
          public int compare(List<String> a, List<String> b) {

              int min = a.size() < b.size() ? a.size() : b.size();


              for (int i = 0; i < min; i++) {
                  String as = a.get(i);
                  String bs = b.get(i);
                  if (as.compareTo(bs) != 0) {
                      return as.compareTo(bs);
                  }
              }
              return a.size() - b.size();
          }
      });

      StringBuilder builder = new StringBuilder(256);
      for (List<String> list : result) {
          StringBuilder b = new StringBuilder(64);
          for (String s : list) {
              b.append(s).append(' ');
          }
          b.setCharAt(b.length() - 1, '\n');

          builder.append(b);
      }

      return builder.toString();
  }

  /**
   * 火车进站
   *
   * @param i      火车编号
   * @param ss     所有的火车
   * @param out    火车已经出站的序列
   * @param unout  火车还未出站的序列
   * @param result 保存所有可能的结果
   */
  private static void trainOut(int i, String[] ss, List<String> out, List<String> unout, List<List<String>> result) {

      // 所有的火车已经进站
      if (i >= ss.length) {
          List<String> list = new ArrayList<>();
          for (String s : out) {
              list.add(s);
          }

          // 先进后出
          for (int j = unout.size() - 1; j >= 0; j--) {
              list.add(unout.get(j));
          }

          result.add(list);

          return;
      }

      // 第i辆车进来就出去了
      out.add(ss[i]);
      trainOut(i + 1, ss, out, unout, result);
      // 还原
      out.remove(out.size() - 1);

      // 第i辆车进来没有出去
      unout.add(ss[i]);
      trainOut(i + 1, ss, out, unout, result);
      // 还原
      unout.remove(unout.size() - 1);
  }
}