import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1965 {
	
	static int[] input;
	static int[] ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[1001];
		ans = new int[1001];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		ans[0] = input[0];
		int cur = 0 ;
		
		for (int i = 1; i < N; i++) {
			int lastNumber = ans[cur];
			
			if(input[i] < ans[0]){
				ans[0] = input[i];
			}else if(input[i] > lastNumber){
				ans[++cur] = input[i];
			}else if ( input[i] < lastNumber){
				//lower_bound : 자기보다 크면서 제일 작은것과 교환 
				int replace =bin(input[i],cur);
				ans[replace] = input[i];
			}else {
				continue;
			}
		}
		
		System.out.println(cur+1);
		
		
	}
	
	public static int bin(int n,int index){
		
		int left = 0; 
		int right = index;
		int mid = 0;
		
		while(left <= right){
			
			mid = (left + right)/2;
			
			if(n > ans[mid]){
				left = mid+ 1;
			}else if (n < ans[mid]){
				right = mid -1;
			}else {
				return mid;
			}
		}
		
		if(left == index && n != input[index-1]){
			return index;
		}
		
		if(right == -1 && n != input[0]){
			return 0;
		}
		
		if( n > ans[mid] && n < ans[mid+1]) return mid+1;
		
		if(n > ans[mid-1] && n < ans[mid]) return mid;
		
		if(n == ans[mid]) return mid;
		
		return mid;
	}

}
