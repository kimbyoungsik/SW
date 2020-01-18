import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {
	
	static int[] coin;
	static int[] D;
	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			coin = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			D = new int[M+1];
			
			D[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					D[j] += D[j-coin[i]];
				}
			}
			
			System.out.println(D[M]);
			
		}
		
		
	
		
		
	}

}
