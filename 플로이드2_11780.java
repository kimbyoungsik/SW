import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 플로이드2_11780 {

	
	static int N,M;
	static long[][] dist;
	static final long INIT_VAL = Long.MAX_VALUE;
	static int via[][];
	static Stack stack;
	 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new long[N+1][N+1];
		via = new int[N+1][N+1];

		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j ){
					dist[i][j] = 0;
				}else{
					dist[i][j] = INIT_VAL;
				}
			}
		}
		
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(dist[a][b] > c){
				dist[a][b] = c;
			}
		}
		
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(dist[i][k] != INIT_VAL && dist[k][j] != INIT_VAL){
						if(dist[i][j] > dist[i][k]+dist[k][j]){
							dist[i][j] = dist[i][k]+dist[k][j];
							via[i][j] = k;
						}
					}
				}
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(dist[i][j] == INIT_VAL){
					System.out.print("0 ");
				}else{
					System.out.print(dist[i][j]+" ");
				}
			}
			System.out.println();
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				stack = new Stack();
				
				if(i == j ){
					System.out.println("0");
					continue;
				}else{
					reconstruct(i,j);
					System.out.print(stack.size()+" ");
					Stack que = new Stack();
					while(!stack.isEmpty()){
						que.add(stack.pop() + " ");
					}
					
					while(!que.isEmpty()){
						System.out.print(que.pop());
					}
					
				}
				System.out.println();
				
				
			}
		}
		
	}
	
	
	public static void reconstruct(int i, int j){
		
		if(via[i][j] == 0 ){  // 경유하는 지점이 없으면
			stack.add(i);
			stack.add(j);
			return;
		}
		
		
		int k = via[i][j];
		
		reconstruct(i,k);
		stack.pop();
		reconstruct(k,j);
	}
	
	
}

