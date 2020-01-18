import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 스마트팩토리_2911 {

static int T,N,M,K;
static char[][] inputChar;
static char[] k ;
static int[][][] dp;
static int[][] cnt;
static boolean[][][] visited;
static HashMap<Integer, String> hmap ;
static String[] power;
static int[] powerN;



public static void main(String[] args) throws NumberFormatException, IOException {

	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	T = Integer.parseInt(br.readLine());
	
	hmap = new HashMap<Integer,String>();
	
	for (int i = 0; i < 32; i++) {
		hmap.put(i, String.format("%05d", Integer.parseInt(Integer.toBinaryString(i))) );
	}
	
	power = new String[32];
	powerN = new int[5];
	
	for (int i = 0; i < 32; i++) {
		power[i] = (String)hmap.get(i);
	}
	
	for (int i = 0; i < 5; i++) {
		powerN[i] = (int)Math.pow(2, i);
	}
	
	
	
	
	for (int t = 1; t <= T; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		int maxK = (int)Math.pow(2,K);
		inputChar = new char[N][M];
		k = br.readLine().toCharArray();
		dp = new int[N][K][maxK];  
		cnt = new int[N][K];
		visited = new boolean[N][K][maxK];
		 
	
	for (int i = 0; i < M; i++) {
		inputChar[i] = br.readLine().toCharArray();
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < K; j2++) {
				if(inputChar[i][j] == k[j2]){
					cnt[j][j2]++;
				}
			}
		}
	}
	
	
	for (int i = 0; i < K; i++) {
		dp[0][i][powerN[i]] = cnt[0][i];
		visited[0][i][powerN[i]] = true;
	}
	
	for (int i = 0; i < N-1; i++) {
		for (int j = 0; j < K; j++) {
		
		for (int j2 = 0; j2 < maxK; j2++) { //32
		
			if(!visited[i][j][j2]) continue;
		
		
			dp[i+1][j][j2] = Math.max(dp[i+1][j][j2], dp[i][j][j2] + cnt[i+1][j]);  // 처음꺼 그대로 쓰는 경우 
			visited[i+1][j][j2] = true;
			
			for (int k = 0; k < K; k++) {  // 처음과 달리 쓰는 경우 
					if( power[j2].charAt(4-k) == '0'){
						dp[i+1][k][j2+ powerN[k]] = Math.max(dp[i+1][k][j2+powerN[k]], dp[i][j][j2]+cnt[i+1][k]);
						visited[i+1][k][j2+powerN[k]] = true;
					}
			}
		}
	}
}
	
	
	long ans = 0 ;
	for (int i = 0; i < K; i++) {
		for (int j = 0; j < maxK; j++) {
			ans = Math.max(dp[N-1][i][j], ans);
		}
	}
	
	System.out.println(ans);
	
	}
	
	
	
	}
}
