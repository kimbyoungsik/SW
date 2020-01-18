import java.io.*;
import java.util.*;

public class BOJ_2167 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer nm = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(nm.nextToken());
		int M = Integer.parseInt(nm.nextToken());
		int [][] arr = new int [N+1][M+1];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = i-1;
			for (int j = 1; j <= M; j++) {
				int j1 = j-1;
				arr[i][j] = arr[i1][j] + arr[i][j1] - arr[i1][j1] + Integer.parseInt(st.nextToken());
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken())-1;
			int sc = Integer.parseInt(st.nextToken())-1;
			int fr = Integer.parseInt(st.nextToken());
			int fc = Integer.parseInt(st.nextToken());
			int res = arr[fr][fc] - arr[fr][sc] - arr[sr][fc] + arr[sr][sc];
			bw.write(res+"\n");
		}
		bw.flush();
	}
}
