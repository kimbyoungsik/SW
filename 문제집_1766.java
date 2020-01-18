import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집_1766 {

	
	static int N,M;
	static ArrayList[] edge;
	static int[] indegree;
	static PriorityQueue pq;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) edge[i] = new ArrayList();
		indegree = new int[N+1];
		pq = new PriorityQueue( new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
			
		
		
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			edge[a].add(b);
			indegree[b]++;
		}
		
		
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0){
				pq.add(i);  // 조건 3 , 작은숫자 ,indegree = 0 
			}
		}
		
		
		while(!pq.isEmpty()){
			int here = (Integer)pq.poll();
			System.out.print(here + " ");
			
			for (int i = 0; i < edge[here].size(); i++) {
				int there = (Integer)edge[here].get(i);
				
				indegree[there]--;
				
				if(indegree[there] == 0) pq.add(there);
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
