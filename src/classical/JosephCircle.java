/**   
* @Title: JosephCircle.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年7月29日 上午10:24:20
* @version V1.0   
*/
package classical;

/**
* @ClassName: JosephCircle
* @Description: 约瑟夫环
* @author Huaigui
* 
* 约瑟夫环（约瑟夫问题）是一个数学的应用问题：已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
* 从编号为k的人开始报数，数到m的那个人出列；他的下一个人又从1开始报数，数到m的那个人又出列；
* 依此规律重复下去，直到圆桌周围的人全部出列。通常解决这类问题时我们把编号从0~n-1，最后[1]  
* 结果+1即为原问题的解。
*/
public class JosephCircle {
	public static void main(String[] args) {
		Boolean [] usaJapa = new Boolean[30];
		for (int i = 0; i < usaJapa.length; i++) {
			usaJapa[i] = true;
		}
		int leftCount = usaJapa.length;
		int countNum = 0 ;
		int index = 0;
		while (leftCount>15) {
			countNum++;
			if(countNum==9){
				while(!usaJapa[index]) index = (index+1) % 30;// 如果当前位置已经出列
				countNum = 0;
				usaJapa[index] = false;
				System.err.println(index);
				leftCount--;
			}
			else {
				index = (index+1) % 30;
			}
		}
		
		for (int i = 0; i < usaJapa.length; i++) {
			System.out.println( i + "=" +usaJapa[i] +"  ");
		}
	}
}
