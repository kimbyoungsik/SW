import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarsySearch {

	static int N = 0;
	static ArrayList adj = new ArrayList();
	static int[] input;
	
	public static int bin(int n){
		
		int left = 0; 
		int right = N-1;
		int mid = 0;
		
		while(left <= right){
			
			mid = (left + right)/2;
			
			if(n > input[mid]){
				left = mid+ 1;
			}else if (n < input[mid]){
				right = mid -1;
			}else {
				return mid;
			}
		}
		
		if(left == N && n != input[N-1]){
			return -1;
		}
		
		if(right == -1 && n != input[0]){
			return -2;
		}
		
		
		return mid;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		
		int c = Integer.parseInt(br.readLine());
		
		System.out.println(bin(c));
				
		
		
		
				
				
	}
}
