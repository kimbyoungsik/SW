import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업_2056 {

	
	//cost[i] : i Node 시간
	//sum[i] : ~i Node iNoe까지 수행(선행작업포함)
	//sum[there] <  cost[there] + sum[here]  then update
	//모든 node에 대해 sum중에서 max치
	
	static int N;
	static int[] cost;
	static ArrayList[] adj;
	static int[] indegree;
	static Queue que;
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		cost = new int[N+1];
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		que = new LinkedList();
		sum = new int[N+1];
		
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList();
			
		
		
		for (int node = 1; node <= N;node++) {
			st = new StringTokenizer(br.readLine());
			cost[node] = Integer.parseInt(st.nextToken());
			sum[node] = cost[node];
			int preSize = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j <= preSize; j++) {
				int preNode = Integer.parseInt(st.nextToken());
				
				adj[preNode].add(node);
				
				indegree[node]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0)
				que.add(i);
		}
		
		
		
		while(!que.isEmpty()){
			int here = (Integer)que.poll();
			
			
			for (int i = 0; i < adj[here].size(); i++) {
				int there = (Integer)adj[here].get(i);
				
				--indegree[there];
				
				if(sum[there] < cost[there] + sum[here]){
					sum[there] = cost[there] + sum[here];
				}
				
				if(indegree[there] == 0 ){
					que.add(there);
				}
				
			}
			
		}
		
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans,sum[i]);
		}
		
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
	}
	
	
	
}
