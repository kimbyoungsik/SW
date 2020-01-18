import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_1916_다이액스트라 {

	static int N,M;
	static ArrayList[] adj;
	static int[] edge;
	static int start, end;
	static long[] dist;
	static final long INIT_VAL = Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList();
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edge = new int[2];
			edge[0] = to;
			edge[1] = cost;
			
			adj[from].add(edge);
			
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		
		
		PriorityQueue pq = new PriorityQueue(new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		
		
		pq.add(new int[]{start,0});
		
		dist = new long[N+1];
		for (int i = 1; i <= N; i++) dist[i] = INIT_VAL;
		
		dist[start] = 0;
		
		
		while(!pq.isEmpty()){
			int[] here = (int[])pq.poll();
			
			for (int i = 0; i < adj[here[0]].size(); i++) {
				int[] there = (int[]) adj[here[0]].get(i);
				
				if( dist[here[0]] !=INIT_VAL && dist[there[0]] > dist[here[0]] + there[1]){
					dist[there[0]] = dist[here[0]] + there[1];
					pq.add(there);
				}
			}
		}
		
		
		System.out.println(dist[end]);
		
		
	}
}
