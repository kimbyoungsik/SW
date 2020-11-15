import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���ǿ���ȯ���� {

    static int N;
    static int[][] cost;
    static long[][] dp;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N][N];
        dp = new long[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        tsp(0,1);

    }



    public static long tsp(int cur,int visit){
        //��� ��带 �湮 �ߴٸ�
        if( (visit & (1 << N -1)) != 0 ){
            if( cost[cur][0] == 0 ) return INF;
            return cost[cur][0];
        }

        if(dp[cur][visit] != 0 ) return dp[cur][visit];


        int ans = INF;

        for (int i = 0; i < N; i++) {  // ���� ��忡�� ��� ��带 ��ü Ž�� �Ѵ�.
            int next = visit | 1 << N;

            if( cost[cur][next] != 0 &&  (visit & (1 << i))  == 0  ){
            }

        }




        return 0;
    }




}

