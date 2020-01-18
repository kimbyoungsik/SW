import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋아하는배열_12911 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MOD = 1000000007;
		
		long[][] dp = new long[N+1][K+1]; 
		long[] sum = new long[N+1];
		 
		for (int i = 1; i <=K; i++) dp[1][i] = 1;
		
		sum[1] = K;
		
		
		//dp[i][j]  : 길이가 i,첫수가 j인 경우의 수
		
		for (int i = 2; i <= N; i++) {
			
			sum[i-1] += MOD;
			
			for (int j = 1; j <=  K; j++) {
				
				long temp = 0;
				for (int k = j+j ; k <= K; k+=j) {
					temp += dp[i-1][k];
					temp %= MOD;
					
				}
				
				dp[i][j] = sum[i-1] - temp;
				
				dp[i][j] %= MOD;
				
				sum[i] += dp[i][j];
				
				sum[i] %= MOD;
				
			}
			
		}
		
	System.out.println(sum[N]);
		
		
			

		
		
		
		
		
		
		
		
		
	}

}
