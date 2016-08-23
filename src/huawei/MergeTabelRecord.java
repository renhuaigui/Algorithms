/**   
* @Title: MergeTabelRecord.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月3日 上午11:16:22
* @version V1.0   
*/
package huawei;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
* @ClassName: MergeTabelRecord
* @Description: 题目描述:合并表记录
* 
* 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
* 
* 输入描述:
* 先输入键值对的个数
* 然后输入成对的index和value值，以空格隔开
* 
* 
* 输出描述:
* 输出合并后的键值对（多行）
* 
* 输入例子:
* 4
* 0 1
* 0 2
* 1 2
* 3 4
* 
* 输出例子:
* 0 3
* 1 2
* 3 4
* 
* 
* @author Huaigui
*/
public class MergeTabelRecord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			Map<Integer, Integer> dic = new TreeMap<Integer, Integer>();
			int n = sc.nextInt();
			int key;
			int value;
			for (int i = 0; i < n; i++) {
				key = sc.nextInt();
				value  =  sc.nextInt();
				if(dic.containsKey(key)){
					dic.put(key, dic.get(key)+value);
				}
				else {
					dic.put(key, value);
				}
			}
			for(Integer k : dic.keySet()){
				System.out.println(k+" "+dic.get(k));
			}
		}
	}
}



