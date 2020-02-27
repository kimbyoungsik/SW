import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2133 {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        dp = new int[31];
        dp[0] = 1 ; dp[1] = 0 ;  dp[2] = 3;

        if(N%2 == 0 ) {
            for (int i = 4; i <= N; i = i + 2) {
                dp[i] += dp[i - 2] * 3;
                for (int j = 4; i-j >=0 ; j = j+2) {
                    dp[i] += dp[i-j] *2;
                }
            }
        }

        System.out.println(dp[N]);



    }
}
