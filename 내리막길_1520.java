import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길_1520 {

	static int N,M;
	static int[][] A;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		
		System.out.println(search(N-1,M-1));
}
	
	public static int search(int x, int y){
		
		if(x == 0 && y == 0 ) return 1;
		
		
		if(dp[x][y] == -1 ){
		
			dp[x][y] = 0;
			
				if(x-1 >=0  && x-1 < N && y >= 0 && y < M){
					if(A[x][y] < A[x-1][y]){
						dp[x][y] +=search(x-1,y);
					}
				}
			
				if(x+1 >= 0 && x+1 < N && y >= 0 && y < M){
					if(A[x][y] < A[x+1][y]){
						dp[x][x] +=search(x+1,y);
					}
				}
			
			
				if(x >= 0 && x < N && y-1 >= 0 && y-1 < M ){
					if(A[x][y] < A[x][y-1]){
						dp[x][y] +=search(x,y-1);
					}
				}
		
				if(x >= 0 && x < N && y+1 >= 0 && y+1 < M){
					if(A[x][y] < A[x][y+1]){
						dp[x][y] +=search(x,y+1);
					}
				}
		}
		
		return dp[x][y];
		
	}
	
	
	
	
}

