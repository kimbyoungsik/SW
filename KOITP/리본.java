package KOITP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¸®º» {

    static int K, N, sum;
    static int A[], count[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new int[K];
        count = new int[K];

        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right =  (int) Math.pow(2, 31) - 1;
        //int right =  200000;
        int mid ;
        int cnt;

        cnt = parametricSearch(left,right);



        System.out.println(cnt);
    }


    public static int parametricSearch(int l, int r){

        int cnt = 0 ;

        while ( l < r){
            cnt = 0;
            int mid = (l+r)/2+1;
            for (int i = 0; i < K; i++) {
                cnt += (A[i] / mid);
            }

            if( cnt > N ){
                l = mid+1;
            }else if (cnt < N){
                r = mid -1;
            }else {
                l = mid;
            }
        }


        return l;



    }
}




