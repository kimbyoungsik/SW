import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 최소비용구하기_11779_다이엑스트라 {

	static int N,M;
	static ArrayList[] adj;
	static int dist[];
	static final int INIT_VAL = Integer.MAX_VALUE;
	static int[] par;
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList();
		par = new int[N+1];
		
		dist = new int[N+1];
		
		for (int i = 1; i <= N; i++) dist[i] = INIT_VAL;
			
		
			
		
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new int[]{b,c});
			
		}
		
		PriorityQueue pq = new PriorityQueue(new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		pq.add(new int[]{start,0});
		
		while(!pq.isEmpty()){
			int[] here = (int[])pq.poll();
			
			for (int i = 0; i < adj[here[0]].size(); i++) {
				int[] there = (int[])adj[here[0]].get(i);
				
				if(dist[here[0]] != INIT_VAL && dist[there[0]] > dist[here[0]] + there[1]){
					dist[there[0]] = dist[here[0]] + there[1];
					pq.add(new int[]{there[0],dist[there[0]]});
					par[there[0]] = here[0];
				}
			}
		}
		
		
		Stack ans = new Stack();
		
		int last = end;
		int cnt = 1;
		ans.add(last);
		
		while(par[last] != 0){
			cnt++;
			ans.add(par[last]);
			last = par[last];
		}
		
		System.out.println(dist[end]);
		System.out.println(cnt);
		
		while(!ans.isEmpty()){
			System.out.print(ans.pop() +" ");
		}
		
		
	
		
		
		
		
		
		
	}
}
