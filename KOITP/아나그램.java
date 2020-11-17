package KOITP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아나그램 {

    static char[] S1,S2;
    static int[] target,source;
    static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        S1 = br.readLine().toCharArray();
        S2 = br.readLine().toCharArray();

        target = new int[26];
        source = new int[26];


        for (int i = 0; i < S1.length; i++) {
            target[S1[i] - 'a']++;
        }

        int left = 0 ;
        int right = S1.length;

        for (int i = left; i < right ; i++) {
            source[S2[i] -'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(target[i] != source[i]) break;
            if( i == 25)  ans++;
        }

        for (int i = right; i < S2.length ; i++) {

            source[S2[right] -'a']++;
            source[S2[left] -'a']--;

            for (int j = 0; j < 26; j++) {
                if(target[j] != source[j]) break;
                if( j == 25)  ans++;
            }
            right++;
            left++;
        }

        System.out.println(ans);












    }
}
