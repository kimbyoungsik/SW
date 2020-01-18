import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753_다이엑스트라 {

     static int N,M;
     static ArrayList[] adj;
     static int dist[];
     static final int INIT_VAL = Integer.MAX_VALUE;
     
	 public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList(); 
		for (int i = 1; i <= N; i++) dist[i] = INIT_VAL;
			
		
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new int[]{b,c});
			
		}
		
		
		PriorityQueue pq = new PriorityQueue(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		dist[start] = 0;
		pq.add(new int[]{start,0});
		
		
		while(!pq.isEmpty()){
			int[] here = (int[]) pq.poll();
			
			for (int i = 0; i < adj[here[0]].size(); i++) {
				int[] there = (int[]) adj[here[0]].get(i);
				
				if(dist[here[0]] != INIT_VAL && dist[there[0]] > dist[here[0]] + there[1] ){
					dist[there[0]]  = dist[here[0]] + there[1];
					pq.add(new int[]{there[0],dist[there[0]]});	
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(dist[i] != INIT_VAL){
				System.out.println(dist[i]);
			}else{
				System.out.println("INF");
			}
		}
		
		
	}

}
