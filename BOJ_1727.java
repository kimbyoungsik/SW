import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  GIT COMMIT TEST
 */

public class BOJ_1727 {

	static int[] male;
	static int[] female;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println("abctest");

		male = new int[N+1];
		female = new int[M+1];
		dp = new long[N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			male[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			female[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(male);
		Arrays.sort(female);
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				
				dp[i][j] = dp[i-1][j-1] + Math.abs(male[i]- female[j]);
				
				if(i > j) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
				
				if(i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
				
			}
		}
		
		System.out.println(dp[N][M]);
		
		
		
		
		
	}

}

