import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class °íÃþºôµù_1328 {

	
	static int N,L,R;
	static long[][][] dp;
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		dp = new long[101][101][101];
		
		dp[1][1][1] = 1;
		
		for (int n = 2; n <= 100; n++) {
			for (int l = 1; l <= n; l++) {
				for (int r = 1; r <= n; r++) {
					dp[n][l][r] = (dp[n-1][l-1][r]%MOD + dp[n-1][l][r-1]%MOD + dp[n-1][l][r]*(n-2)%MOD)%MOD;
				}
				
			}
		}
		
		
		System.out.println(dp[2][1][1]%MOD);
		System.out.println(dp[2][2][0]%MOD);
		System.out.println(dp[2][2][1]%MOD);
		
	}
}

