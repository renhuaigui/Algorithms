/**   
* @Title: CalCubeRoot.java
* @Package huawei
* @Description: TODO
* @author Huaigui   
* @date 2016年6月22日 下午9:45:47
* @version V1.0   
*/
package huawei;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @ClassName: CalCubeRoot
 * @Description :
 * 
 * :
 * 
 *     求解立方根
 * 
 *     题目描述
 * 
 *     计算一个数字的立方根，不使用库函数 详细描述： •接口说明 原型： public static double getCubeRoot(double
 *     input) 输入:double 待求解参数 返回值:double 输入参数的立方根
 * 
 * 
 *     输入描述: 待求解参数 double类型
 * 
 * 
 *     输出描述: 输入参数的立方根 也是double类型
 * 
 *     输入例子: 216
 * 
 *     输出例子: 6.0
 * 
 * 本题要求一个数的立方根的近似值，精确到小数点后的一位。这里使用 牛顿迭代法 求近似值。

牛顿迭代法，又称为牛顿-拉夫逊（拉弗森）方法（Newton-Raphson method），它是牛顿在17世纪提出的一种在实数域和复数域上近似求解方程的方法。多数方程不存在求根公式，因此求精确根非常困难，甚至不可能，从而寻找方程的近似根就显得特别重要。方法使用函数f(x)的泰勒级数的前面几项来寻找方程f(x)=0的根。牛顿迭代法是求方程根的重要方法之一，其最大优点是在方程f(x)=0的单根附近具有平方收敛，而且该法还可以用来求方程的重根、复根，此时线性收敛，但是可通过一些方法变成超线性收敛。另外该方法广泛用于计算机编程中。

设 r 是的根，选取 x0 作为 r 的初始近似值：

过点(x[0],f(x[0]))做曲线y=f(x)的切线L，L的方程为 y=f(x[0])+f′(x[0])(x−x[0])，求出L与x轴交点的横坐标 x[1]=x[0]−f(x[0])f′(x[0])，称 x[1]为 r 的一次近似值。

过点 (x[1],f(x[1])) 做曲线 y=f(x) 的切线，并求该切线与x轴交点的横坐标 x[2]=x[1]−f(x[1])f′(x[1])，称 x[2] 为 r 的二次近似值。

重复以上过程，得 r 的近似值序列。其中， x[n+1]=x[n]−f(x[n])f′(x[n]) 称为 r 的 n+1 次近似值，上式称为牛顿迭代公式。

首先确定我们的函数 f(x)：


f(x)=x^3−m
其中 m 是一个常数，程序的输入。求导函数：


f′(x)=3x^2


则 x = x[i] - f(x[i])/f′(x[i]) = (2*x^3+m)/3*x^2
 * 
 * @author Huaigui
 */
public class CalCubeRoot {
	public static double getCubRoot(double root, double num){
		System.err.println(root);
		if ((root*root*root - num)<=0.1) {
			return root;
		}
		return getCubRoot((2*root*root*root+num)/(3*root*root), num); //牛顿迭代公式
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num = sc.nextDouble();
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println(df.format(getCubRoot(num/3, num)));
	}
}
