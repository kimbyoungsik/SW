

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 막대자르기 {

    static int T,N;
    static int[] L,D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T ; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = new int[N+1];
            D = new int[N+1];


            for (int i = 1; i <= N ; i++) {
                L[i] = Integer.parseInt(st.nextToken());
            }

            D[1] = L[1];

            for (int n= 2 ; n <= N; n++) {
                for (int i = 1; i <= n/2+1 ; i++) {
                    D[n] = Math.max(L[n], D[i]+D[n-i]);
                }
            }


            System.out.println("#"+ tc +" " + D[N]);







        }




    }

}
