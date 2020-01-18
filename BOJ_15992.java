import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15992 {

	static int T;
	static int N,M;
	static long[][] dp;
	static final long MOD = 1000000009; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		dp = new long[1001][1001];
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		
		
		for (int i = 4; i <= 1000; i++) {
			for (int j = 2; j <= 1000; j++) {
				dp[i][j] = (dp[i-1][j-1]%MOD + dp[i-2][j-1]%MOD + dp[i-3][j-1]%MOD)%MOD;
			}
		}
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[n][m]%MOD)	;
			
			
		}
		
		
		
				
		
		
		
	}

}


