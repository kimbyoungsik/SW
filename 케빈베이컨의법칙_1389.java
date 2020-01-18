import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 케빈베이컨의법칙_1389 {

	static int N,M;
	static ArrayList[] adj;
	static boolean[] visited;
	static int[][] depth;
	static final int INIT_VAL = Integer.MAX_VALUE;
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		depth = new int[N+1][N+1];
		sum = new int[N+1];
		
		
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			int start = i;
			depth[start][i] = 0;
			visited = new boolean[N+1];
			dfs(start,i);
		}
		
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum[i] +=depth[i][j];
			}
			
		}
		
		
		PriorityQueue pq = new PriorityQueue( new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}
		});
		
		
		for (int i = 1; i <= N; i++) {
			
			pq.add(new int[]{i,sum[i]});
		}
			
			System.out.println(((int[])pq.poll())[0]);
		
		
	}
	
	
	public static void dfs(int start,int here){
		
		visited[here] = true;
		
		for (int i = 0; i < adj[here].size(); i++) {
			int there = (Integer)adj[here].get(i);

			if(!visited[there]){
				
				if(depth[start][there] !=0 && depth[start][there] > depth[start][here]+1){
					depth[start][there] = depth[start][here] +1;
				}else if(depth[start][there] == 0){
					depth[start][there] = depth[start][here] +1;
				}
				
				
				dfs(start,there);
				visited[there] = false;
			}		
			
		}
		
		
		
		
	}
	
	
}
