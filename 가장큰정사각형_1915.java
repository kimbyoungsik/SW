import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰정사각형_1915 {

	static int N,M;
	static int[][] A;
	static long[][] dp;
	
	public static boolean inBound(int x, int y){
		
		if(x-1 > 0 && y-1 > 0) return true;
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N+1][M+1];
		dp = new long[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String inStr = br.readLine();
			for (int j = 1; j <= M; j++) {
				A[i][j] = (int)inStr.charAt(j-1)-48;
				if(A[i][j] == 1) dp[i][j] = 1;
			}
		}
		
		long ans = 0;
		for (int i = 1; i <= N; i++) {
			LOOP:
			for (int j = 1; j <= M; j++) {
				
				if(A[i][j] == 1){
					if(inBound(i,j)){
						if(dp[i-1][j-1] != 0 ){
							long len = dp[i-1][j-1];
							for (int k = 1; k <= len; k++) {
								if(A[i-k][j] != 1 || A[i][j-k] !=1){
									continue LOOP;
								}
							}
							
							dp[i][j] += dp[i-1][j-1] + 1;
							
						}else{
							dp[i][j] = 1;
						}
					}else{
						dp[i][j] = 1;
					}
					
					
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		
		
		System.out.println(ans*ans);
	}
}
