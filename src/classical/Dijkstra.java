/**   
* @Title: Dijkstra.java
* @Package classical
* @Description: TODO
* @author Huaigui   
* @date 2016年9月27日 上午9:56:03
* @version V1.0   
*/
package classical;

/**
 * @ClassName: Dijkstra
 * @idea: 算法思想编辑 按路径长度递增次序产生算法： 把顶点集合V分成两组： （1）S：已求出的顶点的集合（初始时只含有源点V0）
 *        （2）V-S=T：尚未确定的顶点集合 将T中顶点按递增的次序加入到S中，保证：
 *        （1）从源点V0到S中其他各顶点的长度都不大于从V0到T中任何顶点的最短路径长度 （2）每个顶点对应一个距离值
 *        S中顶点：从V0到此顶点的长度 T中顶点：从V0到此顶点的只包括S中顶点作中间顶点的最短路径长度
 *        依据：可以证明V0到T中顶点Vk的，或是从V0到Vk的直接路径的权值；或是从V0经S中顶点到Vk的路径权值之和 （反证法可证）
 *        求最短路径步骤 算法步骤如下： G={V,E} 1. 初始时令 S={V0},T=V-S={其余顶点}，T中顶点对应的距离值 若存在
 *        <V0,Vi>，d(V0,Vi)为<V0,Vi>弧上的权值 若不存在<V0,Vi>，d(V0,Vi)为∞ 2.
 *        从T中选取一个与S中顶点有关联边且权值最小的顶点W，加入到S中 3.
 *        对其余T中顶点的距离值进行修改：若加进W作中间顶点，从V0到Vi的距离值缩短，则修改此距离值
 *        重复上述步骤2、3，直到S中包含所有顶点，即W=Vi为止
 * 
 * @author Huaigui
 */
public class Dijkstra {
	public static void main(String[] args) {
		int n = 10;
		// 初始化路径，都为最大值。
		int path[][] = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++)
				path[i][j] = Integer.MAX_VALUE;
		}
		// 这里需要输入path[i][j]的具体内容，如果有重复数据的话，需要更新路径为最小值。
		int[] minLen = new int[n + 1];
		// visit初始为0，防止回溯
		int[] visit = new int[n + 1];
		// 初始化1到其他点的距离。
		for (int i = 1; i < n + 1; i++) {
			minLen[i] = path[1][i];
		}
		// void Dijkstra(){
		minLen[1] = 0;
		visit[1] = 1;
		int minj = 1;
		for (int i = 1; i < n + 1; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < n + 1; j++) {
				if (visit[j] == 0 && minLen[j] < min) {
					min = minLen[j];
					minj = j;
				}
			}
			visit[minj] = 1;
			for (int j = 1; j < n + 1; j++) {
				if (visit[j] == 0 && minLen[minj] != Integer.MAX_VALUE && path[minj][j] != Integer.MAX_VALUE
						&& minLen[j] > (minLen[minj] + path[minj][j])) {
					minLen[j] = minLen[minj] + path[minj][j];
				}
			}
			// }
		}
	}

}
