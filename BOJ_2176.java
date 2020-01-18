import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2176 {
	
	static int N,M;
	static int[][] input;
	static int[][] question;
	static long[][] dp;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N+1][M+1];
		dp = new long[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		question = new int[q][4];
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());

			question[i][0] = Integer.parseInt(st.nextToken()); 
			question[i][1] = Integer.parseInt(st.nextToken());
			question[i][2] = Integer.parseInt(st.nextToken());
			question[i][3] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				
				if(i == 1 && j == 1){
					dp[i][j] = input[i][j];
				}else if(i >= 2 && j == 1){
					dp[i][j] = dp[i-1][M] +  input[i][j];
				}else{
					dp[i][j] = dp[i][j-1] + input[i][j];
				}
			}
		}
		
		
		for (int i = 0; i < q; i++) {
			System.out.println(dp[question[i][2]][question[i][3]] - dp[question[i][0]][question[i][1]-1]);
		}
		
		
		
	}

}
