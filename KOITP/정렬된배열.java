package KOITP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된배열 {

    static int n,m,X,ans;
    static int[] A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[n];
        B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int aPos = 0 ;
        int bPos = B.length-1;

        while (aPos < A.length && bPos >=0 ){

            if(A[aPos] + B[bPos] == X){
                ans ++;
                aPos++;
                bPos--;
            }else if(A[aPos] + B[bPos] > X) {
                bPos--;
            }else if(A[aPos] + B[bPos] < X) {
                aPos++;
            }

        }

        System.out.println(ans);







        






    }
}
