package KOITP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장많은수 {

    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);



        int cnt = 1;
        int ans = 0;
        int tmp = 0 ;
        int result = 1;

        for (int i = 1; i < N; i++) {
            if(A[i] == A[i-1]){
                cnt++;

                if( cnt > ans){
                    result = A[i];
                }

            }else{
                tmp = cnt;

                ans = Math.max(ans,tmp);
                cnt = 1;
                tmp = 0;
            }
        }


        System.out.println(result);


    }
}
