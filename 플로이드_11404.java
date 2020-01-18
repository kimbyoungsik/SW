import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드_11404 {

	static int N,M;
	static long INIT_VAL = Long.MAX_VALUE;
	static long dist[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new long[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i ==j ){
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
			int c = Integer.parseInt(st.nextToken());
			
			if(dist[a][b] > c){
				dist[a][b] = c;
			}
			
		}
		
		
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(dist[i][k] != INIT_VAL && dist[k][j] != INIT_VAL){
						dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
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
		
		
		
		
		
		
	}
	
}
