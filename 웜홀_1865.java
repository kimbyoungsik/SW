import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;





public class ¿úÈ¦_1865 {
	
	static int T,N,M,W;
	static Edge[] edges;
	static int[] dist;
	static final int INIT_VAL = Integer.MAX_VALUE;
	
	
	public static class Edge{
		int from;
		int to ;
		int cost;
		
		Edge(){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			edges = new Edge[M*2+W+1];
			dist = new int[N+1];
			
			for (int i = 1; i <= N; i++) dist[i] = INIT_VAL;
				
			int lastM = 1;
			for (int i = 1; i <= 2*M; i+=2) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge();
				edges[i+1] = new Edge();
				
				edges[i].from = from;
				edges[i].to = to;
				edges[i].cost = cost;
				
				edges[i+1].from = to;
				edges[i+1].to = from;
				edges[i+1].cost = cost;
				lastM = i;
			}
			
			
			for ( int i = lastM+2; i < lastM+2+W; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edges[i] = new Edge();
				
				edges[i].from = from;
				edges[i].to = to;
				edges[i].cost = -cost;

			}
			
			
			
			dist[1] = 0 ;
			boolean isCycle = false;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= 2*M+W; j++) {
					int from = edges[j].from;
					int to = edges[j].to;
					int cost = edges[j].cost;
					
					
					if(dist[from] != INIT_VAL && dist[to] > dist[from] + cost){
						dist[to] = dist[from] + cost;
						if(i == N){
							isCycle = true;
						}
					}
				}
			}
			
			if(isCycle){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			
			
			
		}
		
		
		
		
		
	}

}
