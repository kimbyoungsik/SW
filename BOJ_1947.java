import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1947 {

	
	    //완전 순열. N, N에서 자기를 제외한 나머지를 나눠주는 경우의 수, 모자를 벗어서 자기것이 아닌것을 쓰는 경우의 수 
	    //DP[N] = (n-1)(dp[n-2] + dp[n-1)
		static long[] dp ;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			
			dp = new long[N+1];
			
			dp[1] = 0;
			
			for (int i = 2; i <= N; i++) {
				if( i == 2) {
					dp[2] = 1;
					continue;
				}
				dp[i] = ((i-1) * (dp[i-2] + dp[i-1]))%1000000000;
			}
			
			
			System.out.println(dp[N]%1000000000);
			
			
			
		}
}
