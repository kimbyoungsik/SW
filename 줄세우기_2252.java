import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



/**
 *  정렬, 두 객체의 선/후 관계만 존재 
 *  DFS
 *  Indegree
 *  2252
 */


public class 줄세우기_2252 {
	
	static int N,M;
	static int[] indegree;
	static ArrayList[] edge;
	static Queue ZeroQue;
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N+1];
		edge = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) edge[i] = new ArrayList<Integer>();
		
		ZeroQue = new LinkedList();

		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edge[a].add(b);
			indegree[b]++;
		}
		
		for (int node = 1; node <= N; node++) {
			if(indegree[node] == 0){
				ZeroQue.add(node);
			}
		}
		
		
		String ans ="";
		
		while(!ZeroQue.isEmpty()){
			int here = (Integer)ZeroQue.poll();
			ans += here + " ";
			
			for (int i = 0; i < edge[here].size(); i++) {
				int there = (Integer) edge[here].get(i);
				--indegree[there];
				
				if(indegree[there] == 0 ) ZeroQue.add(there);
				
			}
		}
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
	
	
	}
	

	
	
	
}

