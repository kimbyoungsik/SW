import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_1977_MST {

	
	static int N,M;
	static int[][] edge;
	static PriorityQueue pq;
	static int[] par;
	static int[] rank;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new int[M+1][3];
		par = new int[N+1];
		rank = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			par[i] = i;
			rank[i] = 0;
		}
			
		
		
		
		pq = new PriorityQueue(new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
			
		});
		
		
		
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge[i][0] = a;
			edge[i][1] = b;
			edge[i][2] = c;
			
			pq.add(new int[]{a,b,c});
			
		}
		
		while(!pq.isEmpty()){
			int[] here = (int[]) pq.poll();
			
			if(find(here[0]) != find(here[1])){
				union(here[0],here[1]);
				ans += here[2];
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static int find(int a){
		if(a == par[a]) return a;
		
		return par[a] = find(par[a]);
	}
	
	public static void union(int a, int b){
		int Pa = find(a);
		int Pb = find(b);
		
		if(Pa == Pb ) return;
		
		if(rank[Pa] < rank[Pb]){
			par[Pa] = Pb;
		} else{
			par[Pb] = Pa;
		}
		
		
		if(rank[Pa] == rank[Pb]){
			rank[Pa]++;
		}
	}
	
}
