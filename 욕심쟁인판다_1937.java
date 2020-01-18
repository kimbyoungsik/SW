import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class øÂΩ…¿Ô¿Œ∆«¥Ÿ_1937 {
	
	static int N;
	static int[][] A;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans[][] = new int[N+1][N+1];
		int result = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans[i][j] = dfs(i,j,A[i][j]);
				result = Math.max(result, ans[i][j]);
			}
		}
		
		System.out.println(result+1);
		
	}
	
	
	public static int dfs(int x, int y, int val){
		
		if(dp[x][y] != 0 ) return dp[x][y];
		
		
		boolean lPossible = isPossible(x,y-1,val);;
		boolean rPossible = isPossible(x,y+1,val);;
		boolean upPossible = isPossible(x-1,y,val);;
		boolean downPossible = isPossible(x+1,y,val);;

		if(!lPossible && !rPossible && !upPossible && !downPossible){
			return 0;
		}
		
		int a =0, b = 0,c = 0,d = 0 ;
		
		if(lPossible){
			dp[x][y] = dfs(x,y-1,A[x][y-1])+1;
			a = dp[x][y];
		}
		
		if(rPossible){
			dp[x][y] = dfs(x,y+1,A[x][y+1])+1;
			b = dp[x][y];
		}
		
		if(upPossible){
			dp[x][y] = dfs(x-1,y,A[x-1][y])+1;
			c = dp[x][y];
		}
		
		if(downPossible){
			dp[x][y] = dfs(x+1,y,A[x+1][y])+1;
			d = dp[x][y];;
		}
		
		dp[x][y] = Math.max(Math.max(Math.max(a, b),c),d);
		
		return dp[x][y];
	}
	
	
	public static boolean isPossible(int x, int y,int val){
		
		if(x > 0 && y > 0  && x <=N && y <=N) 
			if(val > A[x][y]){
				return true;
		}
		
		return false;
	}
	

}
