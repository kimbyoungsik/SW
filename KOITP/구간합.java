package KOITP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ±¸°£ÇÕ {

    static int N,Q;
    static int[] A;
    static long[] tree;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Q = Integer.parseInt(br.readLine());


        A = new int[N+1];
        tree = new long[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = i;
            update(i,A[i]);
        }


        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            result = 0;
            if(type == 1) {
                result = sum(y) - sum(x-1);
                System.out.println(result);
            }else{
                int diff =  y - A[x];
                A[x] = y;
                update(x, diff);
            }

        }
    }


    public static void update(int x, int diff){

        while( x <= N ){
            tree[x] += diff;
            x += (x & -x);
        }


    }






    public static long sum(int pos){
        long ans = 0;

        while( pos > 0 ){

            ans += tree[pos];
            pos -= (pos & -pos);
        }

        return ans ;
    }




}
