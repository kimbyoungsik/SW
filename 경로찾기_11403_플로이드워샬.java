import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기_11403_플로이드워샬 {

	static int N;
	static int[][] dist;
	static int[][] path;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N+1][N+1];
		path = new int[N+1][N+1];
		

		
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				
				int number = Integer.parseInt(st.nextToken());
				
				dist[i][j] = number;
				
				if(dist[i][j] == 0) dist[i][j] = Integer.MAX_VALUE;
		
			}
		}
		
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
						if(dist[i][j] > dist[i][k] + dist[k][j]){
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
		}
		
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(dist[i][j] == Integer.MAX_VALUE ){
					System.out.print("0 ");
				}else{
					System.out.print("1 ");
				}
				

			}
			System.out.println();
		}
		
		
	}
}
