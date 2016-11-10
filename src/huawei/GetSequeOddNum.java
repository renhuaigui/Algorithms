/**   
* @Title: GetSequeOddNum.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年8月27日 下午12:59:12
* @version V1.0   
*/
package huawei;

import java.util.Scanner;

/**
 * @ClassName: GetSequeOddNum
 * @see: 尼科彻斯定理 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。 例如： 1^3=1 2^3=3+5 3^3=7+9+11
 *       4^3=13+15+17+19
 * 
 * 
 *       输入描述: 输入一个int整数
 * 
 * 
 *       输出描述: 输出分解后的string
 * 
 *       输入例子: 6
 * 
 *       输出例子: 31+33+35+37+39+41
 * @author Huaigui
 */
public class GetSequeOddNum {

	/**
	 * 功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。 原型： int GetSequeOddNum(int
	 * m,char * pcSequeOddNum); 输入参数： int m：整数(取值范围：1～100)
	 * 
	 * 返回值： m个连续奇数(格式：“7+9+11”);
	 */
	public static String getSequeOddNum(int m) {
		if (m <= 0)
			return null;
		String s = "";
		int first = m * m - m + 1;
		for (int i = 0; i < m; i++) {
			if (i != m - 1)
				s = s + first + "+";
			else
				s = s + first;
			first += 2;
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = Integer.parseInt(sc.nextLine());
			String s = getSequeOddNum(m);
			if (s != null)
				System.out.println(s);
		}
		sc.close();
	}

}
