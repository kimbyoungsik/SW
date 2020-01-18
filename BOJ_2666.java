import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2666 {

	static int N,A,B,M;
	static int[] target;
	static int[][][] dp; //dp[K][N][M]  열려 있는 N,M 벽장에서 K를 열려고 할때의 최소 횟수
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		target = new int[M];
		
		for (int i = 0; i < M; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[M][N+1][N+1] ;//dp
		
		
		System.out.println(open(0,A,B));
		
		
		
		
		
		
	}
	
	public static int open(int step,int x , int y){
		
		if(step >= M ) return 0;
		
		if(dp[step][x][y] != 0 ) return dp[step][x][y];
		
		
		
		return dp[step][x][y] = Math.min(Math.abs(y-target[step]) + open(step+1,x,target[step]),
				Math.abs(x-target[step])+open(step+1,target[step],y));
		
		
	}
	
	
	
}
