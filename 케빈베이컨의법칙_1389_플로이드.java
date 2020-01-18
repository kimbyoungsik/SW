import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의법칙_1389_플로이드 {
	
	
	static int N,M;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i != j){
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b] = 1;
			dist[b][a] = 1;
			
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
						dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
					}
				}
			}
		}
		
		
		
		int[] sum =new int[N+1];
		int result = Integer.MAX_VALUE;
		int ans = 0 ;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++){
				sum[i] +=dist[i][j];
			}
			if(result > sum[i]){
				result = sum[i];
				ans = i; 
			}
			
		}
		
		System.out.println(ans);
		
		
		
		
		
		
	}

}
