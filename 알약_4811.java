import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¾Ë¾à_4811 {

	static long[][] dp;
	
	public static long DFS(int w, int h){
		
		
		if(dp[w][h] > 0 ){
			return dp[w][h];
		}
		
		if(w == 0 && h == 0 ){
			return 1;
		}
		
		if(w > 0 ){
			dp[w][h] +=DFS(w-1,h+1);
		}
		
		if( h > 0 ){
			dp[w][h] +=DFS(w,h-1);
		}
		
		
		return dp[w][h];
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[N+1][N+1];
		while( N !=0 ){
			System.out.println(DFS(N,0));
				
			N = Integer.parseInt(br.readLine());
			dp = new long[N+1][N+1];
		}
	}
}
