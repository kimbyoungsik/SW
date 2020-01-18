import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
	
	
	static int N,K;
	static long[][] dp; // dp[n][k] = dp[n-1][k-1]+dp[n-1][k];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new long[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			if(i <= K ) dp[i][i] = 1;
		}
		
		
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i-1][j-1]%10007 + dp[i-1][j]%10007)%10007;
			}
		}
		
		System.out.println(dp[N][K]%10007);
		
	}

}
