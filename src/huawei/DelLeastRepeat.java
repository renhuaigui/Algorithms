/**   
* @Title: DelLeastRepeat.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月13日 上午10:11:39
* @version V1.0   
*/
package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ClassName: DelLeastRepeat
 * @see: 删除字符串中出现次数最少的字符
 * 
 *       实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。 
 *       输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *       输入描述: 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *       输出描述: 删除字符串中出现次数最少的字符后的字符串。
 *       输入例子: abcdd
 *       输出例子: dd
 * @author Huaigui
 */
public class DelLeastRepeat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String newStr = "";
			Map<String, Integer> map = new TreeMap<String, Integer>();
			for (int i = 0; i < str.length(); i++) {
				String c = str.substring(i, i + 1);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			int least = str.length();
			for (String s : map.keySet()) {
				if (map.get(s) < least)
					least = map.get(s);
			}

			for (int i = 0; i < str.length(); i++) {
				String c = str.substring(i, i + 1);
				if (map.get(c) != least) {
					newStr = newStr + c;
				}
			}
			System.out.println(newStr);
		}
	}
}
