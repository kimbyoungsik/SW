import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ÿ�Ӹӽ�_11657_�������� {

	
	/**
	 * 
	 * �������� : ��� ������ ���� ����(N-1)��ŭ relax
	 * �� �������� �ٸ� ���������� �ּ�(�ִ�) �Ÿ�, ���� ��  ok , ���� cycle x , 
	 * N�� relax ������ ���ŵǴ� ���� ������ ���� cycle 
	 * VE
	 * @throws IOException 
	 */
	
	static int N,M;
	static int[][] edge;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		edge = new int[M+1][3];
		dist = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge[i][0] = a;
			edge[i][1] = b;
			edge[i][2] = c;
			
		}
		
		
		dist[1] = 0;
		
		int ans = 0 ;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int here = edge[j][0];
				int there = edge[j][1];
				int cost = edge[j][2];
				
				if((dist[here] != Integer.MAX_VALUE) && (dist[there] > dist[here] + cost)){
					if(i == N ) ans = -1;
					dist[there] = dist[here] + cost;
					
				}
			}
		}
		
		if(ans == -1){
			System.out.println(-1);
		}else{
			for (int i = 2; i <= N; i++) {
				if(dist[i] == Integer.MAX_VALUE){
					System.out.println(-1);
				}else{
					System.out.println(dist[i]);
				}
			}
		}
		
		
		
		
		
		
		
	}
}
