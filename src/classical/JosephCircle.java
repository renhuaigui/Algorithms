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
* 依此规律重复下去，直到圆桌周围的人全部出列。
* 通常解决这类问题时我们把编号从0~n-1，
* 最后  
* 结果+1即为原问题的解。
*/
public class JosephCircle {
	public static int n =30;//有多上个人
	public static int count =9;//计数到几出列
	public static int rest = 1;//剩下多少人 
	/** 
	* @Title: joseph 
	* @Description: 输出依次出列的编号，以及最后安全的那些编号
	* @throws  
	*/ 
	public static void joseph(){
		Boolean [] usaJapa = new Boolean[n];
		for (int i = 0; i < usaJapa.length; i++) {
			usaJapa[i] = true;
		}
		int leftCount = usaJapa.length;
		int countNum = 1;//从1开始报数
		int index = 0;
		while (leftCount>rest) {
			if(countNum==count){
				// 如果当前位置已经出列
				countNum = 1;
				usaJapa[index] = false;
				System.err.println(index+1);//位置从1开始计算
				leftCount--;
			}
			else {
				countNum++;
				index = (index+1) % n;
			}
			while(!usaJapa[index]) index = (index+1) % n;
			
		}
		
		for (int i = 0; i < usaJapa.length; i++) {
			System.out.println( i+1 + "=" +usaJapa[i]);//位置从1开始计算。所以要加1
		}
		
	}
	/**
	 * 约瑟夫最后剩下的编号简单算法：
	 * oldNo表示长度为i个数时，报数最后剩下的编号
	 * newNo表示长度为i-1个数时，报数最后剩下的编号
	 */
	public static void josephNo(){
		int oldNo = 1,newNo =1;
		for(int i =1;i<=n;i++){
			oldNo = (newNo+count-1)%i+1;
			newNo = oldNo;
		}
		System.out.println(oldNo);
	}
	public static void main(String[] args) {
		joseph();
		josephNo();
	}
}
