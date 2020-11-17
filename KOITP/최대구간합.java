package KOITP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대구간합 {

    static int N;
    static int[] A;
    static long[] maxVal;
    static long[] sum;
    static long ans;
    static int maxA = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[N+1];
        maxVal = new long[N+1];
        sum = new long[N+1];

        boolean isAllMinus = true;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if( A[i] > 0 ) isAllMinus = false;

            maxA = Math.max(A[i], maxA);
        }

        sum[0] = A[0];







        for (int i = 1; i < N; i++) {

            if(sum[i-1] <= 0 ) sum[i-1] = 0;

            sum[i] +=(sum[i-1] + A[i]);

            maxVal[i] = Math.max(maxVal[i-1],sum[i] );

        }

        if(isAllMinus){
            System.out.println(maxA);
        }else{
            System.out.println(maxVal[N-1]);
        }















    }
}
